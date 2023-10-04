package codigo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class DarkTextMain {

	public static void main(String[] args) {

		Integer op = Integer.MAX_VALUE;
		Scanner leitura = new Scanner(System.in);
		Random random = new Random();
		Jogador jogador = new Jogador();

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
			atributos(jogador);
			escolherArea();

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

	public static void atributos(Jogador jogador) {
		System.out.println("Classe - "+jogador.getClasse());
		System.out.println("Vida - "+jogador.getVidaMax());
		System.out.println("Força - "+jogador.getForce());
		System.out.println("Velocidade - "+jogador.getVelociadeMax());
		System.out.println("");
	}

	public static void escolherArea() {
		
		Integer op = Integer.MAX_VALUE;
		Scanner leitura = new Scanner(System.in);
		
		System.out.println("Aonde deseja se aventurar? \n 1-Floresta");
		op = Integer.valueOf(leitura.nextLine());
		
		switch(op) {
		case 1:
			break;
		}
	}
}