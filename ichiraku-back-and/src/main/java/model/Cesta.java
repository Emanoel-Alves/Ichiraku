package model;

public class Cesta {
	
	private int id;
	private int idPrato;
	private int idUsuario;
	private String nomePrato;
	private double valorPrato;
	
	public Cesta(int id, int idPrato, int idUsuario, String nomePrato, Double valorPrato) {
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
	public int getIdPrato() {
		return idPrato;
	}
	public void setIdPrato(int idPrato) {
		this.idPrato = idPrato;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomePrato() {
		return nomePrato;
	}
	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}
	public Double getValorPrato() {
		return valorPrato;
	}
	public void setValorPrato(Double valorPrato) {
		this.valorPrato = valorPrato;
	}
	@Override
	public String toString() {
		return "Cesta [id=" + id + ", idPrato=" + idPrato + ", idUsuario=" + idUsuario + ", nomePrato=" + nomePrato
				+ ", valorPrato=" + valorPrato + "]";
	}
	
	
	
	
	
}
