package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.financas.dao.MovimentacaoDao;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TestaJpqlAvancadaMediaData {
    
    public static void main(String[] args) {
	
	EntityManager em = new JPAUtil().getEntityManager();
	em.getTransaction().begin();
	
	Conta conta = new Conta();
	conta.setId(2);
	
	MovimentacaoDao dao = new MovimentacaoDao(em);
	
	List<Double> medias = dao.mediaDaContaPeloTipo(TipoMovimentacao.SAIDA, conta);
	
	for (Double media : medias) {
	    System.out.println("A média é: " + media);
	}
	
	em.getTransaction().commit();
	em.close();
	
    }

}
