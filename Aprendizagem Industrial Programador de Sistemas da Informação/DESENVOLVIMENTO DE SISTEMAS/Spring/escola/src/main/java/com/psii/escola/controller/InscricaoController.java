package com.psii.escola.controller;

import com.psii.escola.model.Disciplina;
import com.psii.escola.model.Estudante;
import com.psii.escola.model.Inscricao;
import com.psii.escola.service.DisciplinaService;
import com.psii.escola.service.EstudanteService;
import com.psii.escola.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @Autowired
    private EstudanteService estudanteService;

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public String listInscricoes(Model model) {
        List<Inscricao> inscricoes = inscricaoService.getAllInscricoes();
        model.addAttribute("inscricoes", inscricoes);
        return "list/list-inscricoes";
    }

    @GetMapping("/novo")
    public String novoFormInscricao(Model model) {
        List<Estudante> estudantes = estudanteService.getAllEstudantes();
        List<Disciplina> disciplinas = disciplinaService.getAllDisciplinas();
        model.addAttribute("estudantes", estudantes);
        model.addAttribute("disciplinas", disciplinas);
        model.addAttribute("inscricao", new Inscricao());
        return "form/form-inscricao";
    }

    @GetMapping("/editar/{id}")
    public String editarFormInscricao(@PathVariable Long id, Model model) {
        Inscricao inscricao = inscricaoService.getInscricaoById(id);
        if (inscricao == null) {
            model.addAttribute("erro", "Inscrição não encontrada.");
            return "redirect:/inscricoes";
        }
        List<Estudante> estudantes = estudanteService.getAllEstudantes();
        List<Disciplina> disciplinas = disciplinaService.getAllDisciplinas();
        model.addAttribute("inscricao", inscricao);
        model.addAttribute("estudantes", estudantes);
        model.addAttribute("disciplinas", disciplinas);
        return "form/form-inscricao";
    }

    // Adiciona ou atualiza uma inscrição
    @PostMapping
    public String salvarInscricao(@ModelAttribute Inscricao inscricao) {
        inscricaoService.saveInscricao(inscricao);
        return "redirect:/inscricoes";
    }

    @GetMapping("/excluir/{id}")
    public String excluirInscricao(@PathVariable Long id, Model model) {
        try {
            inscricaoService.deleteInscricao(id);
        } catch (IllegalStateException e) {
            model.addAttribute("erro", e.getMessage());
        }
        return "redirect:/inscricoes";
    }
}
