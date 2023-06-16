package com.autobots.automanager.modelo.credencialusuariosenha;

import java.util.Set;

import com.autobots.automanager.entidades.Credencial;
import com.autobots.automanager.entidades.CredencialUsuarioSenha;
import com.autobots.automanager.modelo.StringVerificadorNulo;

public class CredencialUsuarioSenhaAtualizador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();

	public void atualizar(CredencialUsuarioSenha credencialusuariosenha, CredencialUsuarioSenha atualizacao) {
		if (atualizacao != null) {
			if (!verificador.verificar(atualizacao.getNomeUsuario())) {
				credencialusuariosenha.setNomeUsuario(atualizacao.getNomeUsuario());
			}
			if (!verificador.verificar(atualizacao.getSenha())) {
				credencialusuariosenha.setSenha(atualizacao.getSenha());
			}
		}
	}

	public void atualizar(Set<Credencial> credenciais, Set<Credencial> credenciais2) {
		// TODO Auto-generated method stub
		
	}

}