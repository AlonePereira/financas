package br.com.alura.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {
    
    private EntityManager em;

    public MovimentacaoDao(EntityManager em) {
	this.em = em;
    }
    
    public List<Double> mediaDaContaPeloTipo(TipoMovimentacao tipo, Conta conta) {
	TypedQuery<Double> query = em.createQuery("select distinct avg(m.valor) from Movimentacao m where m.conta=:pConta" + 
		" and m.tipo=:pTipo" +
		" group by m.data", Double.class);
	
	query.setParameter("pConta", conta);
	query.setParameter("pTipo", tipo);
		
	return query.getResultList();
    }

}
