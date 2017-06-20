package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class Teste {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setAgencia("6723");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("987");
		conta.setTitular("Carlos");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		
		conta.setBanco("Bradesco");
		
		em.getTransaction().commit();
		
		em.close();
	}
	
}
