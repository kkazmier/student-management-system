package pl.edu.student_management_system.service;

import pl.edu.student_management_system.model.Student;

import java.util.List;

public interface StudentManager {

    Student addStudent(Student student);

    void deleteStudent(Long id);

    Student updateStudent(Long id, Student student);

    List<Student> getAllStudents();

    double calculateAverageGrade();
}
