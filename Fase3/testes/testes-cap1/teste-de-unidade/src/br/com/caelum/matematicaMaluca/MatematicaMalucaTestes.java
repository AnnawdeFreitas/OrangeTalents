package br.com.caelum.matematicaMaluca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MatematicaMalucaTestes {
	
	
	@Test
	public void numeroMaiorQueTrinta() {
		MatematicaMaluca matematica = new MatematicaMaluca();
		assertEquals(50*4, matematica.contaMaluca(50));
	}
	
	@Test
	public void numeroMaiorQueDez() {
		MatematicaMaluca matematica = new MatematicaMaluca();
		assertEquals(29*3, matematica.contaMaluca(29));
	}
	
	@Test
	public void numeroMenorQueDez() {
		MatematicaMaluca matematica = new MatematicaMaluca();
		assertEquals(9*2, matematica.contaMaluca(9));
	}
}
