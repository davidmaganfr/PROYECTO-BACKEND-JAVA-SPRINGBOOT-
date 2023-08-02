package com.springrenovables.springrenovables_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.springrenovables.springrenovables_app.dao.CentralRepository;
import com.springrenovables.springrenovables_app.model.MedicionForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/mediciones")
public class MedicionController {
    @Autowired
    private CentralRepository repo;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("mediciones", repo.findAll());
        return "Mediciones/index";
    }

    @GetMapping("/find/{id:\\d+}")
    public String buscar(Model model, @PathVariable("id") long id) {
        model.addAttribute("medicion", repo.findById(id));
        return "Mediciones/find";
    }

    @GetMapping("/insert")
    public String agregar(Model model) {
        model.addAttribute("medicion", new MedicionForm());
        return "Mediciones/insert";
    }

    @PostMapping("/insert")
    public String agregar(Model model, @Valid @ModelAttribute("medicion") MedicionForm med, BindingResult errors) {
        if (errors.hasErrors()) {
            model.addAttribute("medicion", med);
            return "Mediciones/insert";
        }
        repo.save(med.toMedicionDTO());
        return "redirect:/mediciones/index";
    }

    @GetMapping(path = "/update", params = { "id" })
    public String editar(Model model, @RequestParam("id") long id) {
        var med = repo.findById(id);
        model.addAttribute("id", id);
        model.addAttribute("medicion", MedicionForm.from(med));
        return "Mediciones/update";
    }

    @PostMapping("/update")
    public String editar(Model model, @Valid @ModelAttribute("medicion") MedicionForm med, BindingResult errors) {
        repo.save(med.toMedicionDTO());
        model.addAttribute("medicion", med);
        return "redirect:/mediciones/index";
    }

    @GetMapping("/delete/{id:\\d+}")
    public String delete(Model model, @PathVariable("id") long id) {
        try{
            repo.delete(repo.findById(id));
        } catch(Exception ex){
            throw new ResponseStatusException(
                HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()), "Mala solicitud", ex);
        }
        return "redirect:/mediciones/index";
    }

}
