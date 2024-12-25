package pl.edu.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.student_management_system.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
