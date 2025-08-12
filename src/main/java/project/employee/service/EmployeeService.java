package project.employee.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.employee.entity.Employee;
import project.employee.repositry.EmployeeRepositry;

@Service
@RequiredArgsConstructor
public class EmployeeService {
   private final EmployeeRepositry employeeRepositry;

//    public EmployeeService(EmployeeRepositry employeeRepositry) {
//        this.employeeRepositry = employeeRepositry;
//    }

    public Employee postEmployee(Employee employee){
       return  employeeRepositry.save(employee);
   }

}
