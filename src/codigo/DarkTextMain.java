package codigo;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;

public class DarkTextMain {

	public static void main(String[] args) {

		int op = Integer.MAX_VALUE;
		int vitoria = 2;
		Scanner leitura = new Scanner(System.in);
		Jogador jogador = new Jogador();
		Inimigo inimigo = new Inimigo();

		while (op != 0) {// ----------------------------------------------------------------
			op = Integer.valueOf(JOptionPane.showConfirmDialog(null, "Bem vindo deseja começar sua Aventura?"));

			if (op == 1 || op == 2) {
				break;
			}
			jogador.setNome(JOptionPane.showInputDialog(null, "Qual seu nome"));

			criativo(jogador);
			classe(jogador);
			atributos(jogador, inimigo, "j");
			while (vitoria == 2) {
				escolherArea(inimigo);
				atributos(jogador, inimigo, "i");
				combate(jogador, inimigo, vitoria, op);
			}
		} // ----------------------------------------------------------------------------------

		leitura.close();
	}

	public static void criativo(Jogador jogador) {

		Integer op = Integer.MAX_VALUE;
		op = Integer.valueOf(JOptionPane.showConfirmDialog(null, "Deseja utilizar o modo criativo"));
		if (op == 0) {
			op = Integer.valueOf(JOptionPane.showInputDialog(null,
					"O que deseja fazer? \n 0-sair \n 1-alterar nome \n 2-listar os atributos dos inimigos \n 3-adicionar inimigo \n 4-remover área"));

			switch (op) {
			case 0: {
				break;
			}
			case 1: {
				jogador.setNome(JOptionPane.showInputDialog("Qual seu novo nome"));
				break;
			}
			case 2: {

				break;

			}
			case 3: {
				break;
			}
			case 4: {
				break;
			}
			}
		}
	}

	public static void classe(Jogador jogador) {

		Integer op = Integer.MAX_VALUE;

		op = Integer.valueOf(JOptionPane.showInputDialog("Escolha sua classe \n 1-Cavaleiro \n 2-Mago \n 3-Clérico"));
		switch (op) {
		case 1:
			jogador.setClasse("Cavaleiro");
			jogador.setVidaMax(120.0);
			jogador.setVida(120.0);
			jogador.setForce(25.0);
			jogador.setManaMax(35.0);
			jogador.setMana(35.0);
			jogador.setVelocidadeMax(75.0);
			jogador.setVelocidade(75.0);
			break;
		case 2:
			jogador.setClasse("Mago");
			jogador.setVidaMax(80.0);
			jogador.setVida(80.0);
			jogador.setForce(12.0);
			jogador.setManaMax(120.0);
			jogador.setMana(120.0);
			jogador.setVelocidadeMax(40.0);
			jogador.setVelocidade(40.0);
			break;
		case 3:
			jogador.setClasse("Clérico");
			jogador.setVidaMax(100.0);
			jogador.setVida(100.0);
			jogador.setForce(15.0);
			jogador.setManaMax(100.0);
			jogador.setMana(100.0);
			jogador.setVelocidadeMax(40.0);
			jogador.setVelocidade(40.0);
			break;
		}
	}

	public static void atributos(Jogador jogador, Inimigo inimigo, String op) {
		if (op == "j") {
			JOptionPane.showMessageDialog(null,
					"Classe - " + jogador.getClasse() + "\n Vida - " + jogador.getVidaMax() + "\n Mana - "
							+ jogador.getManaMax() + "\n Força - " + jogador.getForce() + "\n Velocidade - "
							+ jogador.getVelocidadeMax());
		} else if (op == "i") {

			JOptionPane.showMessageDialog(null,
					"Nome - " + inimigo.getNome() + "\n Vida - " + inimigo.getVidaMax() + "\n Mana - "
							+ inimigo.getManaMax() + "\n Força - " + inimigo.getForce() + "\n Velocidade - "
							+ inimigo.getVelocidadeMax());
		}
	}

	public static void escolherArea(Inimigo inimigo) {

		Integer op = Integer.MAX_VALUE;

		op = Integer.valueOf(JOptionPane.showInputDialog("Aonde deseja se aventurar? \n 1-Floresta"));

		switch (op) {
		case 1:
			florestaInimigo(inimigo);

			JOptionPane.showMessageDialog(null,
					"Enquanto se aventurava pela floresta, você encontrou um " + inimigo.getNome());
			break;
		}
	}

	public static void florestaInimigo(Inimigo inimigo) {
		Random random = new Random();
		Integer op = random.nextInt(0, 101);

		if (op < 50) {
			inimigo.setNome("Goblin");
			inimigo.setVidaMax(80.0);
			inimigo.setVida(80.0);
			inimigo.setForce(15.0);
			inimigo.setManaMax(0.0);
			inimigo.setMana(0.0);
			inimigo.setVelocidadeMax(45.0);
			inimigo.setVelocidade(45.0);
		} else if (op >= 50) {
			inimigo.setNome("Lobo selvagem");
			inimigo.setVidaMax(80.0);
			inimigo.setVida(80.0);
			inimigo.setForce(12.0);
			inimigo.setManaMax(0.0);
			inimigo.setMana(0.0);
			inimigo.setVelocidadeMax(70.0);
			inimigo.setVelocidade(70.0);
		}
	}

	public static void combate(Jogador jogador, Inimigo inimigo, int vitoria, int op) {
		jogador.setFugir(0);
		vitoria = 2;
		while (vitoria == 2) {
			if (jogador.getVelocidade() >= inimigo.getVelocidade()) {
				jogador.setVelocidade(jogador.getVelocidade() - inimigo.getVelocidadeMax());
				inimigo.setVelocidade(inimigo.getVelocidadeMax());
				menuAction(jogador, inimigo, op, vitoria);
				if (jogador.getVida() <=0 ) {
					vitoria = 1;
				}else if (inimigo.getVida() <= 0 ) {
					vitoria = 0;
				}
			} else if (inimigo.getVelocidade() > jogador.getVelocidade()) {
				inimigo.setVelocidade(inimigo.getVelocidade() - jogador.getVelocidadeMax());
				jogador.setVelocidade(jogador.getVelocidadeMax());
				JOptionPane.showMessageDialog(null, inimigo.getNome() + " te atacou");
				inimigo.ataque(inimigo, jogador);
				if (jogador.getVida() <=0 ) {
					vitoria = 1;
					JOptionPane.showMessageDialog(null,"você ganhou");
				}else if (inimigo.getVida() <= 0 ) {
					vitoria = 0;
					JOptionPane.showMessageDialog(null,"você morreu");
				}
			}
			if (jogador.getFugir() == 1) {
				break;
			}
		}
	}

	public static void menuAction(Jogador jogador, Inimigo inimigo, int op, int vitoria) {

		JOptionPane.showMessageDialog(null, "\n Sua vez");
		op = Integer.valueOf(JOptionPane.showInputDialog(jogador.getNome() + "\n Vida: " + jogador.getVida()
				+ "\n Mana: " + jogador.getMana() + "\n" + inimigo.getNome() + "\n Vida: " + inimigo.getVida()
				+ "\n Mana: " + inimigo.getMana() + "\n" + "\n 1-Habilidade" + "\n 2-Fugir"));
		if (op == 1) {
			jogador.corteEspada(inimigo, jogador);
		} else if (op == 2) {
			jogador.setFugir(1);
			jogador.setVida(jogador.getVidaMax());
			jogador.setMana(jogador.getManaMax());
			jogador.setVelocidade(jogador.getVelocidadeMax());
		}
	}

}