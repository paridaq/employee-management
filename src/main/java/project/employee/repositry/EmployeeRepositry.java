package project.employee.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.employee.entity.Employee;

@Repository
//so the genrics are for the maping first is the entity and the second is the id data type
public interface EmployeeRepositry extends JpaRepository<Employee,Long> {



}
