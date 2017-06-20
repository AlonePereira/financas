package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		conta.setTitular("João");
		conta.setNumero("456");
		
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		
		conta.setTitular("Julio");
		em2.merge(conta);
		
		em2.getTransaction().commit();
	}
	
}
