package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TestaJpqlAvancadaMediaData {
    
    public static void main(String[] args) {
	
	EntityManager em = new JPAUtil().getEntityManager();
	em.getTransaction().begin();
	
	Conta conta = new Conta();
	conta.setId(2);
	
	TypedQuery<Double> query = em.createQuery("select distinct avg(m.valor) from Movimentacao m where m.conta=:pConta" + 
	" and m.tipo=:pTipo" +
	" group by m.data", Double.class);
	query.setParameter("pConta", conta);
	query.setParameter("pTipo", TipoMovimentacao.SAIDA);
	
	List<Double> medias = query.getResultList();
	
	for (Double media : medias) {
	    System.out.println("A média é: " + media);
	}
	
	em.getTransaction().commit();
	em.close();
	
    }

}
