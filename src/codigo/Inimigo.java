package codigo;

public class Inimigo extends Personagem{

	private String area;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public static void ataque(Inimigo inimigo, Jogador jogador) {
		jogador.setVida(jogador.getVida() - inimigo.getForce());
	}
}
