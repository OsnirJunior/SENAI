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

    // Mostrar a lista de inscrições
    @GetMapping
    public String listarInscricoes(Model model) {
        List<Inscricao> inscricoes = inscricaoService.getAllInscricoes();
        model.addAttribute("inscricoes", inscricoes);
        return "list/list-inscricoes"; // Exibe a lista de inscrições
    }

    // Exibir o formulário para nova inscrição
    @GetMapping("/nova")
    public String formNovaInscricao(Model model) {
        // Carregar listas de estudantes e disciplinas
        List<Estudante> estudantes = estudanteService.getAllEstudantes();
        List<Disciplina> disciplinas = disciplinaService.getAllDisciplinas();
        model.addAttribute("estudantes", estudantes);
        model.addAttribute("disciplinas", disciplinas);

        // Novo objeto de inscrição
        model.addAttribute("inscricao", new Inscricao());

        return "form/form-inscricao"; // Exibe o formulário para criar nova inscrição
    }

    // Salvar nova inscrição
    @PostMapping("/nova")
    public String salvarInscricao(@ModelAttribute Inscricao inscricao) {
        inscricaoService.saveInscricao(inscricao); // Salva a nova inscrição
        return "redirect:/inscricoes"; // Redireciona para a lista de inscrições
    }

    // Exibir o formulário de edição de inscrição
    @GetMapping("/editar/{id}")
    public String formEditarInscricao(@PathVariable Long id, Model model) {
        Inscricao inscricao = inscricaoService.getInscricaoById(id);
        model.addAttribute("inscricao", inscricao);

        List<Estudante> estudantes = estudanteService.getAllEstudantes();
        List<Disciplina> disciplinas = disciplinaService.getAllDisciplinas();
        model.addAttribute("estudantes", estudantes);
        model.addAttribute("disciplinas", disciplinas);

        return "form/form-inscricao"; // Exibe o formulário de edição
    }

    // Salvar alterações da inscrição
    @PostMapping("/editar/{id}")
    public String editarInscricao(@PathVariable Long id, @ModelAttribute Inscricao inscricao) {
        inscricao.setId(id); // Mantém o ID correto
        inscricaoService.saveInscricao(inscricao); // Salva a edição

        return "redirect:/inscricoes"; // Redireciona para a lista de inscrições
    }

    // Excluir inscrição
    @GetMapping("/excluir/{id}")
    public String excluirInscricao(@PathVariable Long id) {
        inscricaoService.deleteInscricao(id); // Exclui a inscrição
        return "redirect:/inscricoes"; // Redireciona para a lista de inscrições
    }
}
