package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class Teste {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(1);
		conta.setAgencia("6723");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("987");
		conta.setTitular("Carlos");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		conta = em.find(Conta.class, conta.getId());
		em.remove(conta);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
