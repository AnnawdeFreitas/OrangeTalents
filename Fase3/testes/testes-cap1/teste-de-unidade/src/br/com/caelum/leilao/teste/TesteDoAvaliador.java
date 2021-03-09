package br.com.caelum.leilao.teste;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.leilao.dominio.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class TesteDoAvaliador {

	private Avaliador leiloeiro;
	private Usuario maria;
	private Usuario jose;
	private Usuario joao;
	private Usuario carlos;
	private Usuario mateus;
	private Usuario ana;

	@Before
	public void criaAvaliador() {
		this.leiloeiro = new Avaliador();

		this.joao = new Usuario("João");
		this.jose = new Usuario("José");
		this.maria = new Usuario("Maria");
		this.carlos = new Usuario("Carlos");
		this.mateus = new Usuario("Mateus");
		this.ana = new Usuario("Ana");
	}

	@After
	public void finaliza() {
		System.out.println("fim");
	}

	@BeforeClass
	public static void testandoBeforeClass() {
		System.out.println("before class");
	}

	@AfterClass
	public static void testandoAfterClass() {
		System.out.println("after class");
	}
	// parte 1 : Criando o Cenário

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(maria, 250).lance(jose, 300.0)
				.lance(joao, 400.0).constroi();

//parte 2 : Propondo uma acao
		leiloeiro.avalia(leilao);

// parte 3 : Validacao

		assertThat(leiloeiro.getMaiorLance(), equalTo(400.0));
		assertThat(leiloeiro.getMenorLance(), equalTo(250.0));
	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Leilao leilao = new Leilao("Playstation 3 novo");

		leilao.propoe(new Lance(joao, 200.0));

		leiloeiro.avalia(leilao);

		assertThat(leiloeiro.getMaiorLance(), equalTo(200.0));
		assertThat(leiloeiro.getMenorLance(), equalTo(200.0));
		assertThat(leiloeiro.getMedia(), equalTo(200.0));

	}

	@Test
	public void deveEncontrarOsTresMaioresLances() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 100.0).lance(maria, 200.0)
				.lance(joao, 300.0).lance(maria, 400.0).constroi();

		leiloeiro.avalia(leilao);

		List<Lance> maiores = leiloeiro.getTresMaiores();
		assertEquals(3, maiores.size());
		
		assertThat(maiores, hasItems(
			    new Lance(maria, 400),
			    new Lance(joao, 300),
			    new Lance(maria, 200)
			));
	}

	@Test
	public void deveEncontrarOsLancesMesmoAleatorios() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 200.0).lance(maria, 450.0)
				.lance(jose, 120.0).lance(maria, 700.0).lance(carlos, 630.0).lance(mateus, 220.0).lance(ana, 119.9)
				.constroi();

		leiloeiro.avalia(leilao);

		assertThat(leiloeiro.getMaiorLance(),equalTo(700.0));
		assertThat(leiloeiro.getMenorLance(), equalTo(119.9));
		assertThat(leiloeiro.getMedia(), equalTo(409.95));
	}

	@Test
	public void deveEntenderLeilaoComLancesEmOrdemDecrescente() {

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, 400.0).lance(maria, 300.0)
				.lance(joao, 200.0).lance(maria, 100.0).constroi();
		leiloeiro.avalia(leilao);

		assertThat(leiloeiro.getMaiorLance(), equalTo(400.0));
		assertThat(leiloeiro.getMenorLance(), equalTo(100.0));
	}

	@Test(expected = RuntimeException.class)
	public void naoDeveAvaliarLeiloesSemLance() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 novo").constroi();

		leiloeiro.avalia(leilao);

	}

}