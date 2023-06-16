package com.autobots.automanager.modelo.credencialcodigobarra;

import java.util.Set;

import com.autobots.automanager.entidades.CredencialUsuarioSenha;
import com.autobots.automanager.modelo.DateVerificadorNulo;

public class CredencialUsuarioSenhaAtualizador {
    private DateVerificadorNulo verificador = new DateVerificadorNulo();

    public void atualizar(CredencialUsuarioSenha credencial, CredencialUsuarioSenha atualizacao) {
        if (atualizacao != null) {
            if (!verificador.verificar(atualizacao.getCriacao())) {
                credencial.setCriacao(atualizacao.getCriacao());
            }
            if (!verificador.verificar(atualizacao.getUltimoAcesso())) {
                credencial.setUltimoAcesso(atualizacao.getUltimoAcesso());
            }
        }
    }

    public void atualizar(Set<CredencialUsuarioSenha> credenciais, Set<CredencialUsuarioSenha> atualizacoes) {
        for (CredencialUsuarioSenha atualizacao : atualizacoes) {
            for (CredencialUsuarioSenha credencial : credenciais) {
                if (atualizacao.getId() != null && atualizacao.getId().equals(credencial.getId())) {
                    atualizar(credencial, atualizacao);
                }
            }
        }
    }
}
