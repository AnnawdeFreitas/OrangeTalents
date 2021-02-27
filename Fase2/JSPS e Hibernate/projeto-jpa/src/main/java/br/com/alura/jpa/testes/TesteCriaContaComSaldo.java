package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta.Conta;

public class TesteCriaContaComSaldo {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setAgencia(56231);
		conta.setNumero(54632);
		conta.setTitular("Reinaldo");
		conta.setSaldo(100.0);


		em.getTransaction().begin();
		em.persist(conta);
		
		em.getTransaction().commit();
		em.close();
		
		conta.setSaldo(500.0);
	}
}
