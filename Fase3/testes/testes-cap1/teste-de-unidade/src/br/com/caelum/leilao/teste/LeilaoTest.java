package br.com.caelum.leilao.teste;
import static br.com.caelum.leilao.dominio.LeilaoMatcher.temUmLance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

import br.com.caelum.leilao.dominio.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hamcrest.Matcher;

public class LeilaoTest {
    @Test
    public void deveReceberUmLance() {
        Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15").constroi();
        assertEquals(0, leilao.getLances().size());

        Lance lance = new Lance(new Usuario("Steve Jobs"), 2000);
        leilao.propoe(lance);

        assertThat(leilao.getLances().size(), equalTo(1));
        assertThat(leilao, temUmLance(lance));
    }

}