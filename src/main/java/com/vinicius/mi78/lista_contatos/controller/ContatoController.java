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

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Contato atualizar(@PathVariable Long id, @RequestBody Contato contatoAtualizado) {
        return repository.findById(id).map(contato -> {
            contato.setNome(contatoAtualizado.getNome());
            contato.setTelefone(contatoAtualizado.getTelefone());
            return repository.save(contato);
        }).orElseThrow(() -> new RuntimeException("Contato não encontrado!"));
    }
}
