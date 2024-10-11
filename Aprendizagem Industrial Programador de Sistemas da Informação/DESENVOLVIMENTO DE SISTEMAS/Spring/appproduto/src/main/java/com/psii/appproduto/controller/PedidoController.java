package com.psii.appproduto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psii.appproduto.model.Pedido;
import com.psii.appproduto.repository.PedidoRepository;

@Controller
@RequestMapping("/")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "pedidoForm"; // Certifique-se de que este arquivo HTML exista
    }

    @PostMapping("/savePedido")
    public String savePedido(@ModelAttribute Pedido pedido) {
        pedidoRepository.save(pedido);
        return "redirect:/"; // Redireciona para o formulário de novo pedido
    }
}
