package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteMovimentacaoConta {
    
    public static void main(String[] args) {
	
	EntityManager em = new JPAUtil().getEntityManager();
	em.getTransaction().begin();
	
	String query = "select distinct c from Conta c left join fetch c.movimentacoes";
	
	Query jpql = em.createQuery(query);
	
	List<Conta> contas = jpql.getResultList();
	
	for (Conta conta : contas) {
	    System.out.println("Titula: " + conta.getTitular());
	    System.out.println("Movimentacoes: ");
	    System.out.println(conta.getMovimentacoes().size());
	}
	
	em.getTransaction().commit();
	em.close();
	
    }

}
