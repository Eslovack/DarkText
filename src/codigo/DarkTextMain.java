package codigo;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class DarkTextMain {

	public static void main(String[] args) {

		Integer op = Integer.MAX_VALUE;
		Scanner leitura = new Scanner(System.in);
		Jogador jogador = new Jogador();

		while (op != 0) {
			
			System.out.println("Bem vindo deseja começar sua Aventura? \n 1-Sim \n 2-Não");
			op = Integer.valueOf(leitura.nextLine());
			if (op == 2) {
				break;
			}
			System.out.println("Qual seu nome");
			jogador.setNome(leitura.nextLine());
			
			System.out.println("Deseja utilizar o modo criativo \n 1-sim \n qualquer outra tecla pra não ");
			op = Integer.valueOf(leitura.nextLine());
			if (op == 1) {
				
			switch (op) {
			case 0: {
				break;
			}
			case 1: {

				break;
			}
			case 2: {

				break;
			}}
			}

		}

		leitura.close();
	}
}
