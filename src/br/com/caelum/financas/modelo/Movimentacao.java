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
	  @ requires descricao != null;
	  @ requires descricao.equals("");
	  @ requires data != null;
	  @ requires valor != null;
	  @ requires valor.compareTo(BigDecimal.ZERO) != -1;
	  
	  @ ensures id == \old(id);
	  @*/
	public Movimentacao(String descricao, Calendar data, BigDecimal valor, TipoMovimentacao tipoMovimentacao,
			Conta conta) {
		valor.compareTo(BigDecimal.ZERO);
		this.descricao = descricao;
		this.data = data;
		this.valor = valor;
		this.tipoMovimentacao = tipoMovimentacao;
		this.conta = conta;
	}
	
	
	public /*@ pure @*/ Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public /*@ pure @*/ String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public /*@ pure @*/ Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public /*@ pure @*/ BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public /*@ pure @*/ Conta getConta() {
		return conta;
	}
	
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
