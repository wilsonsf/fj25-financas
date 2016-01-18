package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		
		Conta c = new Conta();
		c.setBanco("Banco Santander");
		c.setNumero("9999-9");
		c.setAgencia("999");
		c.setTitular("Maria");
		
		manager.persist(c);
		
		Movimentacao mov = new Movimentacao();
		mov.setConta(c);
		mov.setData(Calendar.getInstance());
		mov.setDescricao("Conta de luz - abril/2016");
		mov.setValor(new BigDecimal("100"));
		mov.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		manager.persist(mov);
		
		manager.getTransaction().commit();
		manager.close();
	}
}
