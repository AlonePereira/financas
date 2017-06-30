package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {
    
    public static void main(String[] args) {
	
	EntityManager em = new JPAUtil().getEntityManager();
	em.getTransaction().begin();
	
	Conta conta = em.find(Conta.class, 2);
	
	Query query = em.createQuery("select count(m) from Movimentacao m where m.conta = :pConta");
	query.setParameter("pConta", conta);
	
	Long quantidade = (Long) query.getSingleResult();
	
	System.out.println("Total de movimentações: " + quantidade);
	
	em.getTransaction().commit();
	em.close();
	
    }

}
