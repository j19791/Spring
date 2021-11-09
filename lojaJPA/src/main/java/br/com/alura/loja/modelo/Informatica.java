package br.com.alura.loja.modelo;

import javax.persistence.Entity;

@Entity
public class Informatica extends Produto {

	private String marca;
	private Integer modelo;
	
	
	public Informatica() {
	}


	public Informatica(String marca, Integer modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}


	public String getMarca() {
		return marca;
	}


	public Integer getModelo() {
		return modelo;
	}
	
	
	
}
