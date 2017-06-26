package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TestaConsulta {
    
    public static void main(String[] args) {
	
	EntityManager em = new JPAUtil().getEntityManager();
	em.getTransaction().begin();
	
	Conta conta = new Conta();
	conta.setId(2);
	
	Query query = em.createQuery("select m from Movimentacao m where m.conta=:pConta" + 
	" and m.tipo=:pTipo" +
	" order by m.valor desc");
	query.setParameter("pConta", conta);
	query.setParameter("pTipo", TipoMovimentacao.SAIDA);
	
	List<Movimentacao> movimentacoes = query.getResultList();
	
	for(Movimentacao m : movimentacoes) {
	    System.out.println("\nDescricao..: " + m.getDescricao());
	    System.out.println("\nValor..: R$" + m.getValor());
	}
	
	em.getTransaction().commit();
	em.close();
	
    }

}
