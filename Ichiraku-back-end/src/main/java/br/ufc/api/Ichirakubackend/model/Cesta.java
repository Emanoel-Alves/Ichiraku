package br.ufc.api.Ichirakubackend.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="cesta")
public class Cesta {
	
	@Id
	@GeneratedValue
	private int id;
	private Integer idPrato;
	private Integer idUsuario;
	private String nomePrato;
	private BigDecimal valorPrato;
	
	public Cesta(int id, Integer idPrato, Integer idUsuario, String nomePrato, BigDecimal valorPrato) {
		super();
		this.id = id;
		this.idPrato = idPrato;
		this.idUsuario = idUsuario;
		this.nomePrato = nomePrato;
		this.valorPrato = valorPrato;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getIdPrato() {
		return idPrato;
	}
	public void setIdPrato(Integer idPrato) {
		this.idPrato = idPrato;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomePrato() {
		return nomePrato;
	}
	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}
	public BigDecimal getValorPrato() {
		return valorPrato;
	}
	public void setValorPrato(BigDecimal valorPrato) {
		this.valorPrato = valorPrato;
	}
	@Override
	public String toString() {
		return "Cesta [id=" + id + ", idPrato=" + idPrato + ", idUsuario=" + idUsuario + ", nomePrato=" + nomePrato
				+ ", valorPrato=" + valorPrato + "]";
	}
}
