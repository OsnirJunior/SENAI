package com.psii.escola.controller;

import com.psii.escola.model.Disciplina;
import com.psii.escola.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public String listarDisciplinas(Model model) {
        model.addAttribute("disciplinas", disciplinaService.getAllDisciplinas());
        return "list/list-disciplinas";
    }

    @GetMapping("/nova")
    public String novaDisciplinaForm(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        return "form/form-disciplina";
    }

    @PostMapping("/nova")
    public String salvarDisciplina(@ModelAttribute Disciplina disciplina) {
        disciplinaService.saveDisciplina(disciplina);
        return "redirect:/disciplinas";
    }

    @GetMapping("/editar/{id}")
    public String editarDisciplinaForm(@PathVariable Long id, Model model) {
        Disciplina disciplina = disciplinaService.getDisciplinaById(id);
        model.addAttribute("disciplina", disciplina);
        return "form/form-disciplina";
    }

    @PostMapping("/editar/{id}")
    public String editarDisciplina(@PathVariable Long id, @ModelAttribute Disciplina disciplina) {
        disciplina.setId(id);
        disciplinaService.saveDisciplina(disciplina);
        return "redirect:/disciplinas"; 
    }

    @GetMapping("/excluir/{id}")
    public String excluirDisciplina(@PathVariable Long id, Model model) {
        try {
            disciplinaService.excluirDisciplina(id);
        } catch (DataIntegrityViolationException e) {
            return "erro/erro-exclusao";
        }
        return "redirect:/disciplinas";
    }
}
