package br.com.caelum.financas.teste;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class MovimentacaoDaoTest {

	private static MovimentacaoDao dao;
	private static EntityManager manager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		manager = JPAUtil.getEntityManager();
//		populaTabela();
	}

//	private static void populaTabela() {
//		dao = new MovimentacaoDao(manager);
//		manager.getTransaction().begin();
//		for (int i = 0; i < 9; i++) {
//			Movimentacao m = criaMovimentacao(i);
//			dao.adiciona(m);
//		}
//		manager.getTransaction().commit();
//		manager.close();
//	}
	
	private static Movimentacao criaMovimentacao(Integer it) {
		String diff = (it == null ? "" : it.toString());
		
		Movimentacao mov = new Movimentacao();
		mov.setDescricao("Compra de bolinhas de gude" + diff);
		mov.setData(Calendar.getInstance());
		mov.setValor(new BigDecimal(20));
		mov.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		Conta conta = new Conta();
		conta.setTitular("José Roberto"+diff);
		conta.setBanco("Banco do Brasil"+diff);
		conta.setNumero(diff+"123456-6");
		conta.setAgencia(diff+"0999");
		
		mov.setConta(null);
		
		return mov;
	}

	private Movimentacao criaMovimentacao() {
		return criaMovimentacao(null);
	}

	@Before
	public void setUp() throws Exception {
		manager = JPAUtil.getEntityManager();
		dao = new MovimentacaoDao(manager);
	}
	
	@After
	public void tearDown() throws Exception {
		manager.close();
	}
	
	@Test
	public void deveInserirUmaMovimentacao() {
		
		Movimentacao mov = criaMovimentacao();
		
		dao.adiciona(mov);
		
		
		
		fail("Not yet implemented");
	}

}
