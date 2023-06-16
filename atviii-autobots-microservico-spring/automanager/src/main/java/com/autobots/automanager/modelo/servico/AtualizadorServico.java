package com.autobots.automanager.modelo.servico;

import com.autobots.automanager.entidades.Servico;
import com.autobots.automanager.modelo.StringVerificadorNulo;

public class AtualizadorServico {
    private StringVerificadorNulo verificador = new StringVerificadorNulo();

    private void atualizarDados(Servico servico, Servico atualizacao) {
        if (!verificador.verificar(atualizacao.getNome())) {
            servico.setNome(atualizacao.getNome());
        }
        if (atualizacao.getValor() > 0) {
            servico.setValor(atualizacao.getValor());
        }
        if (!verificador.verificar(atualizacao.getDescricao())) {
            servico.setDescricao(atualizacao.getDescricao());
        }
    }

    public void atualizar(Servico servico, Servico atualizacao) {
        atualizarDados(servico, atualizacao);
    }
}
