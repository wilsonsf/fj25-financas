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
	
	private /*@ spec_public @*/  String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private /*@ spec_public @*/  Calendar data;
	
	private /*@ spec_public @*/  BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	private /*@ spec_public @*/  TipoMovimentacao tipoMovimentacao;
	
	@ManyToOne (cascade={CascadeType.PERSIST})
	private /*@ spec_public @*/  Conta conta;
	 
	/*@
	  @ requires newDescricao != null;
	  @ requires newDescricao.equals("");
	  @ requires newDate != null;
	  @ requires newValor != null;
	  @ requires newValor.compareTo(BigDecimal.ZERO) != -1;
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
		this.descricao = newDescricao;
		this.data = newDate;
		this.valor = newValor;
		this.tipoMovimentacao = tipo;
		this.conta = newConta;
	}
	
	/*
	 * Mantendo para compatibilidade de código legado.
	 */
	@Deprecated
	public Movimentacao() {}
	
	public /*@ pure @*/ Integer getId() {
		return id;
	}
	
	/*@ requires newId != null && 0 < newId;
	  @ assignable id;
	  @ ensures id == newId
	  @	&& \only_assigned(id); @*/
	public void setId(Integer newId) {
		this.id = newId;
	}
	
	public /*@ pure @*/ String getDescricao() {
		return descricao;
	}
	
	/*@ requires newDescricao != null && !newDescricao.equals("");
	  @ assignable descricao;
	  @ ensures descricao == newDescricao 
	  @	&& \only_assigned(descricao); @*/
	public void setDescricao(String newDescricao) {
		this.descricao = newDescricao;
	}
	
	
	public /*@ pure @*/ Calendar getData() {
		return data;
	}
	
	/*@ requires newData != null;
	  @ assignable data;
	  @ ensures data == newData 
	  @	&& \only_assigned(descricao); @*/
	public void setData(Calendar newData) {
		this.data = newData;
	}
	
	public /*@ pure @*/ BigDecimal getValor() {
		return valor;
	}
	
	/*@	public normal_behavior
	  @		requires 0 <= valor;
	  @		assignable valor;
	  @		ensures valor == v;
	  @ also
	  @	public exceptional_behavior
	  @		requires newValor.compareTo(BigDecimal.ZERO) != -1;
	  @		assignable \nothing;
	  @		ensures valor == \old(valor);
	  @*/
	public void setValor(BigDecimal v) {
		this.valor = v;
	}
	
	public /*@ pure @*/ Conta getConta() {
		return conta;
	}
	
	/*@	
	  @ 
	  @*/
	public void setConta(Conta conta) {
		this.conta = conta;
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
	
}
