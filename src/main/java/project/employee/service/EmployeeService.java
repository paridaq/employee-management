package project.employee.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.employee.entity.Employee;
import project.employee.repositry.EmployeeRepositry;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
   private final EmployeeRepositry employeeRepositry;

//    public EmployeeService(EmployeeRepositry employeeRepositry) {
//        this.employeeRepositry = employeeRepositry;
//    }

//    public EmployeeService(EmployeeRepositry employeeRepositry) {
//        this.employeeRepositry = employeeRepositry;
//    }

    public Employee postEmployee(Employee employee){
       return  employeeRepositry.save(employee);
   }
   public List<Employee> getAllEmployee(){
        return employeeRepositry.findAll();
   }
   public void deleteEmpoyee( Long id){
       if(!employeeRepositry.existsById(id)){
           throw new EntityNotFoundException("Employee with Id "+id + "not found");
       }
       employeeRepositry.deleteById(id);
   }
    public Employee getEmployeeById(Long id){
        return employeeRepositry.findById(id).orElse(null);

    }
}
