package br.com.caelum.financas.teste;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Test;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoTest {

	@Test
	public void deveCriarUmaMovimentacao() {
		
		Movimentacao mov = new Movimentacao();
		mov.setId(new Integer(1));
		mov.setDescricao("Descrição");
		mov.setData(Calendar.getInstance());
		mov.setValor(BigDecimal.ZERO);
		mov.setConta(new Conta());
		mov.setTipoMovimentacao(TipoMovimentacao.ENTRADA);

		assertTrue(mov != null);
		assertTrue(mov.getId() == 1);
		assertTrue(mov.getDescricao().equals("Descrição"));
//		assertTrue(mov.getData().)
		assertTrue(mov.getValor().equals(BigDecimal.ZERO));
		assertTrue(mov.getConta() != null);
		assertTrue(mov.getTipoMovimentacao() == TipoMovimentacao.ENTRADA);
	}

}
