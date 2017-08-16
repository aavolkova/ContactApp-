package me.anna.contactapp.controllers;

import me.anna.contactapp.PersonRepository;
import me.anna.contactapp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String listCourses(Model model){
        model.addAttribute("persons", personRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String courseForm(Model model){
        model.addAttribute("person", new Person());
        return "personForm";
    }

    @PostMapping("/process")
    public String processForm(@Valid Person person, BindingResult result){
        if (result.hasErrors()){
            return "personForm";
        }
        personRepository.save(person);
        return "redirect:/";
    }


    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("person", personRepository.findOne(id));
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("person", personRepository.findOne(id));
        return "personForm";
    }

    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") long id){
        personRepository.delete(id);
        return "redirect:/";
    }


}
