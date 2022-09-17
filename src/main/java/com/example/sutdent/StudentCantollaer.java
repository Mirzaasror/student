package com.example.sutdent;

import com.example.mentor.MentorDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentCantollaer {
    private final StudentDao studentDao;
    private final MentorDao mentorDao;
    @GetMapping
    public String AllSutdent(Model model){
        model.addAttribute("studentlar",studentDao.allstudent()) ;
        return "show_student";}

    @GetMapping("/add-student")
    public String addStudent(Model model){
        model.addAttribute("mentor",mentorDao.getAllmentor());
        return "add_student";
    }
    @PostMapping
    private String save(Student student){
        studentDao.save(student);

    return "redirect:/students";}

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
studentDao.delete(id);
    return "redirect:/students";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id ,Model model){
        model.addAttribute("mentor",mentorDao.getAllmentor());

        List<Student> studentById = studentDao.getStudentById(id);
    model.addAttribute("student",studentById.get(0));

    return "edit_student";}
    @PostMapping("/edit_save")
    public String editsave(Student student){
        System.out.println(student  );
   studentDao.editsave(student);
        return "redirect:/students";
    }

}
