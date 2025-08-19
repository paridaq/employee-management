package project.employee.controller;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.employee.entity.Employee;
import project.employee.service.EmployeeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin("*")
// so when we use * in crossorigin anotation we can acces this api from any url or domain
// so we can be specic with url like above
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;
     @PostMapping("/employee")
    public Employee postEmployee(@RequestBody Employee employee){

         return employeeService.postEmployee(employee);
    }
   @GetMapping("/employees")
    public List<Employee>getAllEmployees(){
         return employeeService.getAllEmployee();
    }

     @DeleteMapping("employee/{id}")
     //soo the ? is for like the respose can be any type
    public ResponseEntity<?>deleteEmployee(@PathVariable Long id){
         try{
             employeeService.deleteEmpoyee(id);
             return new ResponseEntity<>("empoyee with id "+id+"deleted succesfully",HttpStatus.OK);
         }catch (EntityNotFoundException e){
             return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
         }
     }
     @GetMapping("employee/{id}")
    public    ResponseEntity<?>getEmployeeById( @PathVariable Long id){
         Employee employee = employeeService.getEmployeeById(id);
         if(employee== null) return ResponseEntity.notFound().build();
         //build creates the final responsentity object to return
         return ResponseEntity.ok(employee);
     }

   @PatchMapping("employee/{id}")
     public  ResponseEntity<?>updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
         Employee updatedEmployee = employeeService.updateEmployee(id,employee);
         if(updatedEmployee==null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
         return ResponseEntity.ok(updatedEmployee);
     }

}
