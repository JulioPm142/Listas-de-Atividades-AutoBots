package com.autobots.automanager.modelo.email;

import java.util.Set;

import com.autobots.automanager.entidades.Email;


public class EmailAtualizador {

    public void atualizar(Email email, Email atualizacao) {
        if (atualizacao.getEndereco() != null) {
            email.setEndereco(atualizacao.getEndereco());
        }
    }

    public void atualizar(Set<Email> emails, Set<Email> atualizacoes) {
        for (Email atualizacao : atualizacoes) {
            for (Email email : emails) {
                if (atualizacao.getId() != null && atualizacao.getId().equals(email.getId())) {
                    atualizar(email, atualizacao);
                }
            }
        }
    }
}
