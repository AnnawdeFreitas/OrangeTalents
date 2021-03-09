package br.com.caelum.anoBissexto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TesteAnoBissexto {
	@Test
	public void deveRetornarAnoBissexto() {
		AnoBissexto anoBissexto = new AnoBissexto();

		assertEquals(true, anoBissexto.isAnoBissexto(2016));
		assertEquals(true, anoBissexto.isAnoBissexto(2012));
	}

	@Test
	public void naoDeveRetornarAnoBissexto() {
		AnoBissexto anoBissexto = new AnoBissexto();

		assertEquals(false, anoBissexto.isAnoBissexto(2015));
		assertEquals(false, anoBissexto.isAnoBissexto(2011));
	}
}
