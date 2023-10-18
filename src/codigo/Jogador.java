package codigo;

public class Jogador extends Personagem{
	private String classe;

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	public static void corteEspada(Inimigo inimigo, Jogador jogador) {
		inimigo.setVida(inimigo.getVida() - jogador.getForce());
	}
}
