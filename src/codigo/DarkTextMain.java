package codigo;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class DarkTextMain {

	public static void main(String[] args) {

		Integer op = Integer.MAX_VALUE;
		Scanner leitura = new Scanner(System.in);

		while (op != 0) {
			System.out.println("Bem vindo deseja começar sua Aventura? \n 1-Sim \n 2-Não");
			op = Integer.valueOf(leitura.nextLine());
			if (op == 2) {
				break;
			}
			System.out.println("Qual seu nome");

			op = Integer.valueOf(leitura.nextLine());

			switch (op) {
			case 0: {
				break;
			}
			case 1: {
				System.out.println("Nome:");
				String nome = leitura.nextLine();
				System.out.println("Cpf:");
				String cpf = leitura.nextLine();

			}
			case 2: {
				System.out.println("Digite o cpf da pessoa que deseja alterar:");

			}

			}

		}

		leitura.close();
	}
}
