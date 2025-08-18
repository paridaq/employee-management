package project.employee.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.employee.entity.Employee;
import project.employee.service.EmployeeService;

@RestController
//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin("*")
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

}
