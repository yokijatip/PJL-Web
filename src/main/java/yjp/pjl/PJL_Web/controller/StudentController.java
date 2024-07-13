package yjp.pjl.PJL_Web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import yjp.pjl.PJL_Web.model.Student;
import yjp.pjl.PJL_Web.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

//    Show list of students
    @GetMapping("/")
    public String viewHomPage(Model model) {
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
//        Create model attribute to bind form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @PostMapping("/saveStudent")
    public String saveEmployee(@ModelAttribute("student") Student student) {
        // save employee to database
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get student from the service
        Student student = studentService.getStudentById(id);

        // set student as a model attribute to pre-populate the form
        model.addAttribute("student", student);
        return "update_student";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete student method
        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }
}
