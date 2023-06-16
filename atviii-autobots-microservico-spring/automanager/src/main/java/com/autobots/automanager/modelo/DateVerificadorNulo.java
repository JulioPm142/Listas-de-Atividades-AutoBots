package com.autobots.automanager.modelo;

import java.util.Date;

public class DateVerificadorNulo {

	public boolean verificar(Date data) {
		boolean nulo = true;
		if (!(data == null)) {
			nulo=false;
			}
		return nulo;
	}
}

