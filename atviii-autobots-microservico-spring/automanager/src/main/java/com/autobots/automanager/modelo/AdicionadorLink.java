package com.autobots.automanager.modelo;

import java.util.List;
import java.util.Set;

import com.autobots.automanager.entidades.Credencial;


public interface AdicionadorLink<T> {
	public void adicionarLink(List<T> lista);
	public void adicionarLink(T objeto);
	void adicionarLink(Set<Credencial> lista);
}