package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.caelum.financas.modelo.listeners.MovimentacaoListener;

@Entity
@EntityListeners(MovimentacaoListener.class)
public class Movimentacao {

	//@ public invariant valor >= 0;
	//@ public invariant conta != null;
	//@ public invariant data.owner == this;

	@GeneratedValue
	@Id
	private /*@ spec_public @*/  Integer id;

	private /*@ spec_public non_null @*/  String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	private /*@ spec_public non_null @*/  Calendar data;

	private /*@ spec_public non_null @*/  BigDecimal valor;

	@Enumerated(EnumType.STRING)
	private /*@ spec_public non_null @*/  TipoMovimentacao tipoMovimentacao;

	@ManyToOne (cascade={CascadeType.PERSIST})
	private /*@ spec_public non_null @*/  Conta conta;

	/*@
	  @ requires newDescricao != null && newDescricao.equals("");
	  @ requires newDate != null;
	  @ requires newValor != null && newValor.compareTo(BigDecimal.ZERO) != -1;
	  @ requires newConta != null;
	  @ assignable descricao;
	  @ assignable data;
	  @ assignable valor;
	  @ assignable tipoMovimentacao;
	  @ assignable conta;
	  @ ensures id == \old(id);
	  @ ensures descricao == newDescricao;
	  @ ensures data == newDate;
	  @ ensures valor == newValor;
	  @ ensures tipoMovimentacao == tipo;
	  @ ensures conta == newConta;
	  @*/
	public Movimentacao(String newDescricao, Calendar newDate, BigDecimal newValor, TipoMovimentacao tipo,
			Conta newConta) {
		descricao = newDescricao;
		data = newDate;
		valor = newValor;
		tipoMovimentacao = tipo;
		conta = newConta;
	}

	/*@
	  @ requires newId != null && newId.compareTo(BigDecimal.ZERO) == 1;
	  @ assignable id;
	  @ ensures id.equals(newId);
	  @*/
	public Movimentacao(Integer newId) {
		id = newId;
	}

	/*
	 * Mantendo para compatibilidade de código legado.
	 */
	@Deprecated
	public Movimentacao() {}

	/*@	assignable \nothing;
	  @	ensures \result == this.id;
	  @ @*/
	public /*@ pure @*/ Integer getId() {
		return id;
	}

	/*@ requires newId != null && 0 < newId;
	  @ assignable id;
	  @ ensures id == newId
	  @	&& \only_assigned(id); @*/
	public void setId(Integer newId) {
		id = newId;
	}

	/*@	assignable \nothing;
	  @	ensures \result == descricao;
	  @ @*/
	public /*@ pure @*/ String getDescricao() {
		return descricao;
	}

	/*@ requires newDescricao != null && !newDescricao.equals("");
	  @ assignable descricao;
	  @ ensures descricao == newDescricao
	  @	&& \only_assigned(descricao); @*/
	public void setDescricao(String newDescricao) {
		descricao = newDescricao;
	}

	/*@	assignable \nothing;
	  @	ensures \result == data;
	  @ ensures data.owner == this;
	  @ @*/
	public /*@ pure @*/ Calendar getData() {
		return data;
	}

	/*@ requires newData != null;
	  @ assignable data;
	  @ ensures data == newData
	  @	&& \only_assigned(descricao); @*/
	public void setData(Calendar newData) {
		data = newData;
	}

	/*@	assignable \nothing;
	  @	ensures \result == valor;
	  @ ensures valor.owner == this;
	  @ @*/
	public /*@ pure @*/ BigDecimal getValor() {
		return valor;
	}

	/*@	public normal_behavior
	  @		requires newValor.compareTo(BigDecimal.ZERO) != -1;
	  @		assignable valor;
	  @		ensures valor.equals(newValor);
	  @ also
	  @		public exceptional_behavior
	  @		requires newValor.compareTo(BigDecimal.ZERO) == -1;
	  @		assignable \nothing;
	  @		signals_only ValorNegativoException;
	  @		signals (ValorNegativoException e)
	  @			valor.compareTo(BigDecimal.ZERO) == -1;
	  @*/
	public void setValor(BigDecimal newValor) {
		valor = newValor;
	}

	/*@	assignable \nothing;
	  @	ensures \result == conta;
	  @ ensures conta.owner == this
	  @ @*/
	public /*@ pure @*/ Conta getConta() {
		return conta;
	}

	/*@ requires newConta != null;
	  @ assignable conta;
	  @ ensures conta.equals(newConta);
	  @	&& \only_assigned(conta); @*/
	public void setConta(Conta newConta) {
		conta = newConta;
	}

	public /*@ pure @*/ TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	//@ assignable data;
	@PrePersist
	@PreUpdate
	public void preAltera() {
		this.setData(Calendar.getInstance());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
