package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Cliente;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteContaCliente {
    
    public static void main(String[] args) {
	
	Cliente cliente = new Cliente();
	cliente.setNome("Leonardo");
	cliente.setEndereco("Rua Fulano, 123");
	cliente.setProfissao("Professor");
	
	Conta conta = new Conta();
	conta.setId(2);
	
	cliente.setConta(conta);
	
	EntityManager em = new JPAUtil().getEntityManager();
	em.getTransaction().begin();
	
	em.persist(cliente);
	
	em.getTransaction().commit();
	em.close();
	
    }

}
