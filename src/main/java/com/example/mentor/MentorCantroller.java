package com.example.mentor;

import com.example.sutdent.StudentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mentors")

public class MentorCantroller {
    private final MentorDao mentorDao;
    private final StudentDao studentDao;

    @GetMapping
    public String show_mentor(Model model) {
        List<Mentor> allmentor = mentorDao.getAllmentor();
        System.out.println(allmentor);
        model.addAttribute("mentor", allmentor);
        return "show_mentor";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        List<Mentor> mentorById = mentorDao.getMentorById(id);

        model.addAttribute("mentor", mentorById.get(0));

        return "edit_mentor";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        mentorDao.delte(id);
        return "redirect:/mentors";
    }

    @PostMapping
    public String save(Mentor mentor) {
        mentorDao.addMentor(mentor);
        return "redirect:/mentors";
    }

    @GetMapping("/add_mentor")
    public String add_mentor() {

        return "add_mentor";
    }
    @PostMapping("/edit_save")
    public String edit_save(Mentor mentor){
        mentorDao.editSave(mentor);
        return "redirect:/mentors";
    }
}
