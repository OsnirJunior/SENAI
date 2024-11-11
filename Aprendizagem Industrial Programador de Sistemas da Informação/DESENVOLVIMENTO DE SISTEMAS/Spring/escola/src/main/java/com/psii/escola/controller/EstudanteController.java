package com.psii.escola.controller;

import com.psii.escola.model.Estudante;
import com.psii.escola.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public String listarEstudantes(Model model) {
        List<Estudante> estudantes = estudanteService.getAllEstudantes();
        model.addAttribute("estudantes", estudantes);
        return "list/list-estudantes";
    }

    @GetMapping("/novo")
    public String formNovoEstudante(Model model) {
        model.addAttribute("estudante", new Estudante());
        return "form/form-estudante";
    }

    @PostMapping("/novo")
    public String salvarEstudante(@ModelAttribute Estudante estudante) {
        estudanteService.saveEstudante(estudante);
        return "redirect:/estudantes";
    }

    @GetMapping("/{id}")
    public String detalhesEstudante(@PathVariable Long id, Model model) {
        Estudante estudante = estudanteService.getEstudanteById(id);
        model.addAttribute("estudante", estudante);
        return "detalhes-estudante";
    }
}
