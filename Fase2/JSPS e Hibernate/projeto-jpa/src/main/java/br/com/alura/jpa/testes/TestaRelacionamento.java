package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta.Conta;
import br.com.alura.jpa.modelo.Conta.Movimentacao;
import br.com.alura.jpa.modelo.Conta.TipoMovimentacao;

public class TestaRelacionamento {
	public static void main (String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setAgencia(null);
		conta.setNumero(34345345);
		conta.setAgencia(123123123);
		conta.setTitular("Adrian");
		conta.setSaldo(300.0);
		
		
		
		Movimentacao movimentacao  = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal(200.0));
		movimentacao.setConta(conta);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		
		em.close();
	}
	
}
