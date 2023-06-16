package com.autobots.automanager.modelo.mercadoria;

import com.autobots.automanager.entidades.Mercadoria;
import com.autobots.automanager.modelo.StringVerificadorNulo;

public class MercadoriaAtualizador {
    private StringVerificadorNulo verificador = new StringVerificadorNulo();

    private void atualizarDados(Mercadoria mercadoria, Mercadoria atualizacao) {
        if (atualizacao.getValidade() != null) {
            mercadoria.setValidade(atualizacao.getValidade());
        }
        if (atualizacao.getFabricao() != null) {
            mercadoria.setFabricao(atualizacao.getFabricao());
        }
        if (atualizacao.getCadastro() != null) {
            mercadoria.setCadastro(atualizacao.getCadastro());
        }
        if (!verificador.verificar(atualizacao.getNome())) {
            mercadoria.setNome(atualizacao.getNome());
        }
        if (atualizacao.getQuantidade() > 0) {
            mercadoria.setQuantidade(atualizacao.getQuantidade());
        }
        if (atualizacao.getValor() > 0) {
            mercadoria.setValor(atualizacao.getValor());
        }
        if (!verificador.verificar(atualizacao.getDescricao())) {
            mercadoria.setDescricao(atualizacao.getDescricao());
        }
    }

    public void atualizar(Mercadoria mercadoria, Mercadoria atualizacao) {
        atualizarDados(mercadoria, atualizacao);
    }
}
