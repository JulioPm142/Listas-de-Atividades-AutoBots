package com.autobots.automanager.modelo.credencialcodigobarra;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CredencialUsuarioSenhaSelecionador {
	public CredencialUsuarioSenhaSelecionador selecionar(List<CredencialUsuarioSenhaSelecionador> CredUsuSenhas, long id) {
		CredencialUsuarioSenhaSelecionador selecionado = null;
		for (CredencialUsuarioSenhaSelecionador CredUsuSenha : CredUsuSenhas) {
			if (CredUsuSenha.getId() == id) {
				selecionado = CredUsuSenha;
			}
		}
		return selecionado;
	}

	private long getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}