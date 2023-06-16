package com.autobots.automanager.modelo.servico;

import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Servico;

@Component
public class SelecionadorServico {
	public Servico selecionar(List<Servico> servicos, long id) {
		Servico selecionado = null;
		for (Servico servico : servicos) {
			if (servico.getId() == id) {
				selecionado = servico;
			}
		}
		return selecionado;
	}
}