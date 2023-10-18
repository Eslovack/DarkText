package codigo;

public class Jogador extends Personagem{
	private String classe;
	private Integer fugir;

	public Integer getFugir() {
		return fugir;
	}

	public void setFugir(Integer fugir) {
		this.fugir = fugir;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	public void corteEspada(Inimigo inimigo, Jogador jogador) {
		inimigo.setVida(inimigo.getVida() - jogador.getForce());
	}
}
