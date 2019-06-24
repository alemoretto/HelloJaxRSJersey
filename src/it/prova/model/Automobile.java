package it.prova.model;

public class Automobile {

	private Long id;
	private String marca;
	private String modello;
	
	public Automobile() {
		// TODO Auto-generated constructor stub
	}

	public Automobile(Long id, String marca, String modello) {
		this.id = id;
		this.marca = marca;
		this.modello = modello;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

}
