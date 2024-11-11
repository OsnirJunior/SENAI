package com.psii.escola.controller;

import com.psii.escola.model.Disciplina;
import com.psii.escola.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    // Método para listar todas as disciplinas
    @GetMapping
    public String listarDisciplinas(Model model) {
        List<Disciplina> disciplinas = disciplinaService.getAllDisciplinas();
        model.addAttribute("disciplinas", disciplinas);
        return "list/list-disciplinas";
    }

    // Método para exibir o formulário de criação de nova disciplina
    @GetMapping("/nova")
    public String formNovaDisciplina(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        return "form/form-disciplina";
    }

    // Método para salvar a nova disciplina
    @PostMapping("/nova")
    public String salvarDisciplina(@ModelAttribute Disciplina disciplina) {
        disciplinaService.saveDisciplina(disciplina);
        return "redirect:/disciplinas";
    }

    // Método para exibir os detalhes de uma disciplina
    @GetMapping("/{id}")
    public String detalhesDisciplina(@PathVariable Long id, Model model) {
        Disciplina disciplina = disciplinaService.getDisciplinaById(id);
        model.addAttribute("disciplina", disciplina);
        return "detalhes-disciplina";
    }

    // (Opcional) Método para editar uma disciplina existente
    @GetMapping("/editar/{id}")
    public String formEditarDisciplina(@PathVariable Long id, Model model) {
        Disciplina disciplina = disciplinaService.getDisciplinaById(id);
        model.addAttribute("disciplina", disciplina);
        return "form/form-disciplina";
    }

    // (Opcional) Método para excluir uma disciplina
    @GetMapping("/excluir/{id}")
    public String excluirDisciplina(@PathVariable Long id) {
        disciplinaService.deleteDisciplina(id);
        return "redirect:/disciplinas";
    }
}
