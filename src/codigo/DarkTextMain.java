package codigo;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;



import java.util.Random;

public class DarkTextMain {

	public static void main(String[] args) {

		int op = Integer.MAX_VALUE;
		Scanner leitura = new Scanner(System.in);
		Jogador jogador = new Jogador();
		Inimigo inimigo = new Inimigo();

		while (op != 0) {// ----------------------------------------------------------------
			op = Integer.valueOf(JOptionPane.showInputDialog(null, "Bem vindo deseja começar sua Aventura? \n 0-Não \n qualquer outro número para sim"));

			if (op == 0) {
				break;
			}
			jogador.setNome(JOptionPane.showInputDialog(null,"Qual seu nome"));
			

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
		op = Integer.valueOf(JOptionPane.showInputDialog(null,"Deseja utilizar o modo criativo \n 1-sim \n qualquer outro número pra não "));
		if (op == 1) {
			op = Integer.valueOf(JOptionPane.showInputDialog(null,"O que deseja fazer? \n 0-sair \n 1-alterar nome \n 2-listar os atributos dos inimigos \n 3-adicionar inimigo \n 4-remover área"));

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
			JOptionPane.showMessageDialog(null,"Classe - " + jogador.getClasse() +
			"\n Vida - " + jogador.getVidaMax() + 
			"\n Mana - " + jogador.getManaMax() + 
			"\n Força - " + jogador.getForce() + 
			"\n Velocidade - " + jogador.getVelociadeMax()); 
		} else if (op == "i") {
			
			JOptionPane.showMessageDialog(null,"Nome - " + inimigo.getNome() +
			"\n Vida - " + inimigo.getVidaMax() + 
			"\n Mana - " + inimigo.getManaMax() + 
			"\n Força - " + inimigo.getForce() + 
			"\n Velocidade - " + inimigo.getVelociadeMax()); 
		}
	}

	public static void escolherArea(Inimigo inimigo) {

		Integer op = Integer.MAX_VALUE;
		
		op = Integer.valueOf(JOptionPane.showInputDialog("Aonde deseja se aventurar? \n 1-Floresta"));

		switch (op) {
		case 1:
			florestaInimigo(inimigo);
			
			JOptionPane.showMessageDialog(null, "Enquanto se aventurava pela floresta, você encontrou um " + inimigo.getNome());
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
		JOptionPane.showMessageDialog(null,"Sua vez");
		//System.out.println("Sua vez");
	}

	public static void tela(Jogador jogador, Inimigo inimigo, String op) {
		if (op == "j") {
			
			JOptionPane.showMessageDialog(null, jogador.getNome()+
					"\n Vida - " + jogador.getVida() +
					"\n Mana - " + jogador.getMana());

			
		} else if (op == "i") {
			JOptionPane.showMessageDialog(null,inimigo.getNome() + 
					"\n Vida - "  + inimigo.getVida() +
					"\n Mana - " + inimigo.getMana());
			
			

		}
	}
}