package codigo;

public abstract class Personagem {
	private String nome;
	private Double force;
	private Double vida;
	private Double vidaMax;
	private Double mana;
	private Double manaMax;
	private Double velocidade;
	private Double velocidadeMax;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getForce() {
		return force;
	}
	public void setForce(Double force) {
		this.force = force;
	}
	public Double getVida() {
		return vida;
	}
	public void setVida(Double vida) {
		this.vida = vida;
	}
	public Double getVidaMax() {
		return vidaMax;
	}
	public void setVidaMax(Double vidaMax) {
		this.vidaMax = vidaMax;
	}
	public Double getMana() {
		return mana;
	}
	public void setMana(Double mana) {
		this.mana = mana;
	}
	public Double getManaMax() {
		return manaMax;
	}
	public void setManaMax(Double manaMax) {
		this.manaMax = manaMax;
	}
	public Double getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(Double velocidade) {
		this.velocidade = velocidade;
	}
	public Double getVelocidadeMax() {
		return velocidadeMax;
	}
	public void setVelocidadeMax(Double velocidadeMax) {
		this.velocidadeMax = velocidadeMax;
	}
}
