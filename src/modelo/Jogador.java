package modelo;

public class Jogador extends Personagem {
	private String classe;
	private Integer fugir;
	private Integer cooldown2;
	private Integer op;   

	public Integer getOp() {
		return op;
	}

	public void setOp(Integer op) {
		this.op = op;
	}

	public Integer getCooldown2() {
		return cooldown2;
	}

	public void setCooldown2(Integer cooldown2) {
		this.cooldown2 = cooldown2;
	}

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
}
