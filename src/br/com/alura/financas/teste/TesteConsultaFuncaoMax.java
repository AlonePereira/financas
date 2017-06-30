package br.com.alura.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {
    
    public static void main(String[] args) {
	
	EntityManager em = new JPAUtil().getEntityManager();
	em.getTransaction().begin();
	
	Conta conta = new Conta();
	conta.setId(2);
	
	Query query = em.createQuery("select max(m.valor) from Movimentacao m where m.conta=:pConta");
	query.setParameter("pConta", conta);
	
	BigDecimal maior = (BigDecimal) query.getSingleResult();
	
	System.out.println("O máximo é: " + maior);
	
	em.getTransaction().commit();
	em.close();
	
    }

}
