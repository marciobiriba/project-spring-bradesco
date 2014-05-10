package br.com.bradesco.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Conta")
public class Conta {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="CODIGO_AGENCIA")
	private Integer codAgencia;
	@Column(name="CODIGO_CONTA")
	private Long codConta;
	@Column(name="SALDO")
	private Double saldo; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCodAgencia() {
		return codAgencia;
	}
	public void setCodAgencia(Integer codAgencia) {
		this.codAgencia = codAgencia;
	}
	public Long getCodConta() {
		return codConta;
	}
	public void setCodConta(Long codConta) {
		this.codConta = codConta;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
	
}
