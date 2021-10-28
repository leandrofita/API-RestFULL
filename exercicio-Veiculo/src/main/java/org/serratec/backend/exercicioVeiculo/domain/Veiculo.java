package org.serratec.backend.exercicioVeiculo.domain;

public class Veiculo {
	
	int id;
	String nome;
	String marca;
	public Veiculo(int id, String nome, String marca) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	

}
