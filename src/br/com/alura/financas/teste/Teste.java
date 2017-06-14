package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.financas.modelo.Conta;

public class Teste {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setAgencia("3456");
		conta.setBanco("Itaú");
		conta.setNumero("564");
		conta.setTitular("Alone");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
}
