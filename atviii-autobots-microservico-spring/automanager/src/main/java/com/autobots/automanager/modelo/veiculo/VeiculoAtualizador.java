package com.autobots.automanager.modelo.veiculo;

import com.autobots.automanager.entidades.Veiculo;
import com.autobots.automanager.modelo.StringVerificadorNulo;


public class VeiculoAtualizador {
    private StringVerificadorNulo verificador = new StringVerificadorNulo();


    private void atualizarDados(Veiculo veiculo, Veiculo atualizacao) {
        if (atualizacao.getTipo() != null) {
            veiculo.setTipo(atualizacao.getTipo());
        }
        if (!verificador.verificar(atualizacao.getModelo())) {
            veiculo.setModelo(atualizacao.getModelo());
        }
        if (!verificador.verificar(atualizacao.getPlaca())) {
            veiculo.setPlaca(atualizacao.getPlaca());
        }
    }

    public void atualizar(Veiculo veiculo, Veiculo atualizacao) {
        atualizarDados(veiculo, atualizacao);
    }
}


