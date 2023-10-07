package codigo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class DarkTextMain {

	public static void main(String[] args) {

		Integer op = Integer.MAX_VALUE;
		Scanner leitura = new Scanner(System.in);
		Jogador jogador = new Jogador();
		Inimigo inimigo = new Inimigo();

		while (op != 0) {// ----------------------------------------------------------------

			System.out.println("Bem vindo deseja começar sua Aventura? \n 0-Não \n qualquer outro número para sim");
			op = Integer.valueOf(leitura.nextLine());
			if (op == 0) {
				break;
			}

			System.out.println("Qual seu nome");
			jogador.setNome(leitura.nextLine());

			criativo(jogador);
			classe(jogador);
			atributos(jogador, inimigo, "j");
			escolherArea(inimigo);
			atributos(jogador, inimigo, "i");
			velocidade(jogador, inimigo);

			// System.out.println(jogador.getNome()); //testar troca de nome

		} // ----------------------------------------------------------------------------------

		leitura.close();
	}

	public static void criativo(Jogador jogador) {

		Integer op = Integer.MAX_VALUE;
		Scanner leitura = new Scanner(System.in);

		System.out.println("Deseja utilizar o modo criativo \n 1-sim \n qualquer outro número pra não ");
		op = Integer.valueOf(leitura.nextLine());

		if (op == 1) {

			System.out.println(
					"O que deseja fazer? \n 0-sair \n 1-alterar nome \n 2-listar os atributos dos inimigos \n 3-adicionar inimigo \n 4-remover área");
			op = Integer.valueOf(leitura.nextLine());

			switch (op) {
			case 0: {
				break;
			}
			case 1: {

				System.out.println("Qual seu novo nome");
				jogador.setNome(leitura.nextLine());

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
		Scanner leitura = new Scanner(System.in);

		System.out.println("Escolha sua classe \n 1-Cavaleiro \n 2-Mago \n 3-Clérico");
		op = Integer.valueOf(leitura.nextLine());
		switch (op) {
		case 1:
			jogador.setClasse("Cavaleiro");
			jogador.setVidaMax(120.0);
			jogador.setVida(120.0);
			jogador.setForce(25.0);
			jogador.setManaMax(35.0);
			jogador.setMana(35.0);
			jogador.setVelociadeMax(75.0);
			jogador.setVelocidade(75.0);
			break;
		case 2:
			jogador.setClasse("Mago");
			jogador.setVidaMax(80.0);
			jogador.setVida(80.0);
			jogador.setForce(12.0);
			jogador.setManaMax(120.0);
			jogador.setMana(120.0);
			jogador.setVelociadeMax(40.0);
			jogador.setVelocidade(40.0);
			break;
		case 3:
			jogador.setClasse("Clérico");
			jogador.setVidaMax(100.0);
			jogador.setVida(100.0);
			jogador.setForce(15.0);
			jogador.setManaMax(100.0);
			jogador.setMana(100.0);
			jogador.setVelociadeMax(40.0);
			jogador.setVelocidade(40.0);
			break;
		}
	}

	public static void atributos(Jogador jogador, Inimigo inimigo, String op) {
		if (op == "j") {
			System.out.println("Classe - " + jogador.getClasse());
			System.out.println("Vida - " + jogador.getVidaMax());
			System.out.println("Mana - " + jogador.getManaMax());
			System.out.println("Força - " + jogador.getForce());
			System.out.println("Velocidade - " + jogador.getVelociadeMax());
			System.out.println("");
		} else if (op == "i") {
			System.out.println("Nome - " + inimigo.getNome());
			System.out.println("Vida - " + inimigo.getVidaMax());
			System.out.println("Mana - " + inimigo.getManaMax());
			System.out.println("Força - " + inimigo.getForce());
			System.out.println("Velocidade - " + inimigo.getVelociadeMax());
			System.out.println("");
		}
	}

	public static void escolherArea(Inimigo inimigo) {

		Integer op = Integer.MAX_VALUE;
		Scanner leitura = new Scanner(System.in);

		System.out.println("Aonde deseja se aventurar? \n 1-Floresta");
		op = Integer.valueOf(leitura.nextLine());

		switch (op) {
		case 1:
			florestaInimigo(inimigo);
			System.out.println("Enquanto se aventurava pela floresta, você encontrou um " + inimigo.getNome());
			System.out.println("");
			break;
		}
	}

	public static void florestaInimigo(Inimigo inimigo) {
		Random random = new Random();
		Integer op = random.nextInt(0, 101);

		if (op < 50) {
			inimigo.setNome("goblin");
			inimigo.setVidaMax(80.0);
			inimigo.setVida(80.0);
			inimigo.setForce(15.0);
			inimigo.setManaMax(0.0);
			inimigo.setMana(0.0);
			inimigo.setVelociadeMax(45.0);
			inimigo.setVelocidade(45.0);
		} else if (op >= 50) {
			inimigo.setNome("lobo selvagem");
			inimigo.setVidaMax(80.0);
			inimigo.setVida(80.0);
			inimigo.setForce(12.0);
			inimigo.setManaMax(0.0);
			inimigo.setMana(0.0);
			inimigo.setVelociadeMax(70.0);
			inimigo.setVelocidade(70.0);
		}
	}

	public static void velocidade(Jogador jogador, Inimigo inimigo) {
		if (jogador.getVelocidade() > inimigo.getVelocidade()) {
			jogador.setVelocidade(jogador.getVelocidade() - inimigo.getVelociadeMax());
			inimigo.setVelocidade(inimigo.getVelociadeMax());

		} else {
			inimigo.setVelocidade(inimigo.getVelocidade() - jogador.getVelociadeMax());
			jogador.setVelocidade(jogador.getVelociadeMax());
		}

	}

	public static void menuAction(Jogador jogador) {
		System.out.println("Sua vez");
	}

	public static void tela(Jogador jogador, Inimigo inimigo, String op) {
		if (op == "j") {
			System.out.println(jogador.getNome());
			System.out.println("Vida - " + jogador.getVida());
			System.out.println("Mana - " + jogador.getMana());
			System.out.println("");
		} else if (op == "i") {
			System.out.println(inimigo.getNome());
			System.out.println("Vida - " + inimigo.getVida());
			System.out.println("Mana - " + inimigo.getMana());
			System.out.println("");

		}
	}
}