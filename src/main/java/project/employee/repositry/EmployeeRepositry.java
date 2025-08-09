package project.employee.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.employee.entity.Empoyee;

@Repository
public class EmployeeRepositry extends JpaRepository<Empoyee,Long> {

}
