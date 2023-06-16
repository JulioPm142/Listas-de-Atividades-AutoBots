package com.autobots.automanager.modelo.credencialusuariosenha;

import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.CredencialUsuarioSenha;

@Component
public class CredencialUsuarioSenhaSelecionador {
	public CredencialUsuarioSenha selecionar(List<CredencialUsuarioSenha> credenciaisusuariosenha, long id) {
		CredencialUsuarioSenha selecionado = null;
		for (CredencialUsuarioSenha credencialusuariosenha : credenciaisusuariosenha) {
			if (credencialusuariosenha.getId() == id) {
				selecionado = credencialusuariosenha;
			}
		}
		return selecionado;
	}
}