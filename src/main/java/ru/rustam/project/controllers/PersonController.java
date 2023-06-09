package ru.rustam.project.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.rustam.project.dao.PersonDAO;
import ru.rustam.project.model.Person;

@Controller
@RequestMapping("/people")
public class PersonController {
   private PersonDAO personDAO;

    @Autowired
    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("people", personDAO.showAll());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String showPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.getPersonForId(id));
        model.addAttribute("books", personDAO.getBooksByPersonId(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String CreatePerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping
    public String PostCreatePerson(@ModelAttribute("person") @Valid Person person,
                                   BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "people/new";
        personDAO.createPerson(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String EditPerson(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDAO.getPersonForId(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String PatchEditPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult , @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "people/edit";
        personDAO.updatePerson(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String DeletePerson(@PathVariable("id") int id){
        personDAO.deletePerson(id);
        return "redirect:/people";
    }

}
