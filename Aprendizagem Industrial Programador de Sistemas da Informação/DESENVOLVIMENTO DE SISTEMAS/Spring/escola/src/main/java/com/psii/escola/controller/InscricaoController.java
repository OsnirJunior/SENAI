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

    // Exibe a lista de inscrições
    @GetMapping
    public String listInscricoes(Model model) {
        List<Inscricao> inscricoes = inscricaoService.getAllInscricoes();
        model.addAttribute("inscricoes", inscricoes);
        return "list/list-inscricoes"; // Página de listagem das inscrições
    }

    // Exibe o formulário para adicionar ou editar uma inscrição
    @GetMapping("/novo")
    public String novoFormInscricao(Model model) {
        List<Estudante> estudantes = estudanteService.getAllEstudantes();
        List<Disciplina> disciplinas = disciplinaService.getAllDisciplinas();
        model.addAttribute("estudantes", estudantes);
        model.addAttribute("disciplinas", disciplinas);
        model.addAttribute("inscricao", new Inscricao());
        return "form/form-inscricao"; // Página do formulário para adicionar uma inscrição
    }

    // Exibe o formulário para editar uma inscrição existente
    @GetMapping("/editar/{id}")
    public String editarFormInscricao(@PathVariable Long id, Model model) {
        Inscricao inscricao = inscricaoService.getInscricaoById(id);
        if (inscricao == null) {
            model.addAttribute("erro", "Inscrição não encontrada.");
            return "redirect:/inscricoes"; // Redireciona caso a inscrição não seja encontrada
        }
        List<Estudante> estudantes = estudanteService.getAllEstudantes();
        List<Disciplina> disciplinas = disciplinaService.getAllDisciplinas();
        model.addAttribute("inscricao", inscricao);
        model.addAttribute("estudantes", estudantes);
        model.addAttribute("disciplinas", disciplinas);
        return "form/form-inscricao"; // Página para editar a inscrição
    }

    // Adiciona ou atualiza uma inscrição
    @PostMapping
    public String salvarInscricao(@ModelAttribute Inscricao inscricao) {
        inscricaoService.saveInscricao(inscricao);
        return "redirect:/inscricoes"; // Redireciona para a lista de inscrições
    }

    // Exclui uma inscrição
    @GetMapping("/excluir/{id}")
    public String excluirInscricao(@PathVariable Long id, Model model) {
        try {
            inscricaoService.deleteInscricao(id);
        } catch (IllegalStateException e) {
            model.addAttribute("erro", e.getMessage());
        }
        return "redirect:/inscricoes"; // Redireciona para a lista de inscrições
    }
}
