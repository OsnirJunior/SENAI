package com.psii.escola.controller;

import com.psii.escola.model.Estudante;
import com.psii.escola.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping("/estudantes")
    public String listEstudantes(Model model) {
        List<Estudante> estudantes = estudanteService.getAllEstudantes();
        model.addAttribute("estudantes", estudantes);
        return "list/list-estudantes";
    }

    @GetMapping("/estudantes/novo")
    public String novoEstudanteForm(Model model) {
        model.addAttribute("estudante", new Estudante());
        return "form/form-estudante";
    }

    @PostMapping("/estudantes")
    public String addEstudante(@ModelAttribute Estudante estudante) {
        estudanteService.saveEstudante(estudante);
        return "redirect:/estudantes";
    }

    @GetMapping("/estudantes/editar/{id}")
    public String editarEstudante(@PathVariable Long id, Model model) {
        Estudante estudante = estudanteService.getEstudanteById(id);
        model.addAttribute("estudante", estudante);
        return "form/form-estudante";
    }

    @PostMapping("/estudantes/editar/{id}")
    public String atualizarEstudante(@PathVariable Long id, @ModelAttribute Estudante estudante) {
        estudante.setId(id);
        estudanteService.saveEstudante(estudante);
        return "redirect:/estudantes";
    }

    @GetMapping("/estudantes/excluir/{id}")
    public String excluirEstudante(@PathVariable Long id, Model model) {
        try {
            estudanteService.excluirEstudante(id);
        } catch (DataIntegrityViolationException e) {

            return "erro/erro-exclusao";
        }
        return "redirect:/estudantes";
    }

}
