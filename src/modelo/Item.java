package modelo;

public class Item {
	private int id;
	private String nome;
	private Double modificador;
	private String atributo;
	
	
	public String getNome() {
		return nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getModificador() {
		return modificador;
	}
	public void setModificador(Double modificador) {
		this.modificador = modificador;
	}
	public String getAtributo() {
		return atributo;
	}
	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

}
