package modelo;

public class Inimigo extends Personagem{

	private String area;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public void ataque(Inimigo inimigo, Jogador jogador) {
		jogador.setVida(jogador.getVida() - inimigo.getForce());
	}
}
