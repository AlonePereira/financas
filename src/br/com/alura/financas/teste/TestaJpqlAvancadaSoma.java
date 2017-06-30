package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TestaJpqlAvancadaSoma {
    
    public static void main(String[] args) {
	
	EntityManager em = new JPAUtil().getEntityManager();
	em.getTransaction().begin();
	
	Conta conta = new Conta();
	conta.setId(2);
	
	Query query = em.createQuery("select avg(m.valor) from Movimentacao m where m.conta=:pConta" + 
	" and m.tipo=:pTipo" +
	" order by m.valor desc");
	query.setParameter("pConta", conta);
	query.setParameter("pTipo", TipoMovimentacao.SAIDA);
	
	Double soma = (Double) query.getSingleResult();
	
	System.out.println("A média é: " + soma);
	
	em.getTransaction().commit();
	em.close();
	
    }

}
