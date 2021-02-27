package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta.*;

public class TesteCriaConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setAgencia(4321);
		conta.setNumero(1234);
		conta.setTitular("Anna");

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
	}

}
