package pl.edu.student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.student_management_system.model.Student;
import pl.edu.student_management_system.service.StudentManager;

@Controller
@RequestMapping("/")
public class StudentController {

    private final StudentManager studentManager;

    @Autowired
    public StudentController(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentManager.getAllStudents());
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentManager.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentManager.deleteStudent(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentManager.getAllStudents()
                .stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
        studentManager.updateStudent(id, student);
        return "redirect:/";
    }

    @GetMapping("/average")
    public String calculateAverage(Model model) {
        double average = studentManager.calculateAverageGrade();
        model.addAttribute("students", studentManager.getAllStudents());
        model.addAttribute("average", average);
        return "list";
    }
}
