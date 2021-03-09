package br.com.caelum.leilao.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominio.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class TesteDoLeilao {

	private Usuario steveJobs;
	private Usuario steveWozniak;
	private Usuario annaWaleska;
	private Usuario billGates;

	@Before
	public void novoUsuario() {
		this.annaWaleska = new Usuario("Anna Waleska");
		this.steveJobs = new Usuario("Steve Jobs");
		this.steveWozniak = new Usuario("Steve Wozniak");
		this.billGates = new Usuario("Bill Gates");
	}

	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("Macbook pro 15");
		assertEquals(0, leilao.getLances().size());

		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));

		assertEquals(1, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);

	}

	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook pro 15").lance(steveJobs, 2000).lance(steveWozniak, 3000)
				.lance(annaWaleska, 4000).constroi();

		assertEquals(3, leilao.getLances().size());
		assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(3000.0, leilao.getLances().get(1).getValor(), 0.00001);
		assertEquals(4000.0, leilao.getLances().get(2).getValor(), 0.00001);

	}

	@Test
	public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15").lance(steveJobs, 2000.0).lance(billGates, 3000.0)
				.lance(steveJobs, 4000.0).lance(billGates, 5000.0).lance(steveJobs, 6000.0).lance(billGates, 7000.0)
				.lance(steveJobs, 8000.0).lance(billGates, 9000.0).lance(steveJobs, 10000.0).lance(billGates, 11000.0)
				.constroi();

		// deve ser ignorado
		leilao.propoe(new Lance(steveJobs, 12000.0));

		assertEquals(10, leilao.getLances().size());
		assertEquals(11000.0, leilao.getLances().get(leilao.getLances().size() - 1).getValor(), 0.00001);
	}

	@Test
	public void deveDobrarOUltimoLanceDado() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15").lance(steveJobs, 2000)
		.lance(billGates, 3000).constroi();
		leilao.dobraLance(steveJobs);

		assertEquals(4000, leilao.getLances().get(2).getValor(), 0.00001);
	}

	@Test
	public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15").constroi();

		leilao.dobraLance(steveJobs);

		assertEquals(0, leilao.getLances().size());
	}

}
