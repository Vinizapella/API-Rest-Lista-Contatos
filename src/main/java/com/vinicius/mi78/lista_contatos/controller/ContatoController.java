package com.vinicius.mi78.lista_contatos.controller;

import com.vinicius.mi78.lista_contatos.model.Contato;
import com.vinicius.mi78.lista_contatos.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository repository;

    @GetMapping
    public List<Contato> listar(){
        return repository.findAll();
    }
    @PostMapping
    public Contato salvar(@RequestBody Contato contato){
        return repository.save(contato);
    }
}
