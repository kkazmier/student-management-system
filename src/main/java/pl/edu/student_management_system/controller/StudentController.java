package pl.edu.student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.student_management_system.model.Student;
import pl.edu.student_management_system.service.StudentService;

@Controller
@RequestMapping("/") // Ustawienie głównej ścieżki
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Wyświetlenie listy studentów
    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "list"; // Ścieżka do list.html w folderze templates
    }

    // Wyświetlenie formularza dodawania studenta
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add"; // Ścieżka do add.html w folderze templates
    }

    // Dodanie nowego studenta
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "redirect:/"; // Powrót na stronę główną
    }

    // Usuwanie studenta
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/"; // Powrót na stronę główną
    }

    // Wyświetlenie formularza edycji studenta
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getAllStudents()
                .stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null));
        return "edit"; // Ścieżka do edit.html w folderze templates
    }

    // Aktualizacja danych studenta
    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
        studentService.updateStudent(id, student);
        return "redirect:/"; // Powrót na stronę główną
    }
}
