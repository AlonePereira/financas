package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Categoria;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteMovimentacoesPorCategoria {
    
public static void main(String[] args) {
	
	EntityManager em = new JPAUtil().getEntityManager();
	em.getTransaction().begin();
	
	Categoria categoria = new Categoria();
	categoria.setId(1);
	
	Query query = em.createQuery("select m from Movimentacao m join m.categorias c where c=:pCategoria");
	query.setParameter("pCategoria", categoria);
	
	List<Movimentacao> movimentacoes = query.getResultList();
	
	for(Movimentacao m : movimentacoes) {
	    System.out.println("\nDescricao..: " + m.getDescricao());
	    System.out.println("\nValor..: R$" + m.getValor());
	}
	
	em.getTransaction().commit();
	em.close();
	
    }

}
