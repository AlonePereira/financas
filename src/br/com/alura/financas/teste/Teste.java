package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class Teste {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setAgencia("3456");
		conta.setBanco("Itaú");
		conta.setNumero("564");
		conta.setTitular("Alone");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
	}
	
}
