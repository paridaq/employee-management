package project.employee.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.employee.entity.Employee;
import project.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;
     @PostMapping("/employee")
    public Employee postEmployee(@RequestBody Employee employee){

         return employeeService.postEmployee(employee);
    }
    @GetMapping("/employees")
    public ResponseEntity<Employee> getEmployee(){
         return  new ResponseEntity<>(Employee, HttpHeaders.EXPECT)
    }
}
