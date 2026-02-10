package com.vinicius.mi78.lista_contatos.repository;

import com.vinicius.mi78.lista_contatos.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
