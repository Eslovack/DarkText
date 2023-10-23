package codigo;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
import javax.swing.ImageIcon;

public class DarkTextMain {

	public static void main(String[] args) {

		int vitoria = 2;
		boolean floresta = true;
		boolean pantano = true;
		boolean nova_area = false;
		String nova_area_nome = null;
		Scanner leitura = new Scanner(System.in);
		Jogador jogador = new Jogador();
		Inimigo inimigo = new Inimigo();
		jogador.setCooldown2(0);
		jogador.setOp(Integer.MAX_VALUE);

		while (jogador.getOp() != 0) {// ----------------------------------------------------------------
			jogador.setOp(
					Integer.valueOf(JOptionPane.showConfirmDialog(null, "Bem vindo deseja começar sua Aventura?")));

			if (jogador.getOp() == 1 || jogador.getOp() == 2) {
				break;
			}
			jogador.setNome(JOptionPane.showInputDialog(null, "Qual seu nome"));

			criativo(jogador, inimigo, floresta, pantano, nova_area, nova_area_nome);
			classe(jogador);
			atributos(jogador, inimigo, "j");
			while (vitoria != 1) {
				escolherArea(inimigo);
				atributos(jogador, inimigo, "i");
				jogador.setFugir(0);
				combate(jogador, inimigo, vitoria);
			}
		} // ----------------------------------------------------------------------------------

		leitura.close();
	}

	public static void criativo(Jogador jogador, Inimigo inimigo, boolean floresta, boolean pantano, boolean nova_area, String nova_area_nome  ) {

		Integer op = Integer.MAX_VALUE;
		while (op != 0 && op != 1 && op != 2 && op != 3 && op != 4) {
			op = Integer.valueOf(JOptionPane.showConfirmDialog(null, "Deseja utilizar o modo criativo"));
			if (op == 0) {
				op = Integer.valueOf(JOptionPane.showInputDialog(null,
						"O que deseja fazer? \n 0-sair \n 1-alterar nome \n 2-listar os atributos de todos os inimigos \n 3-adicionar inimigo/Área \n 4-remover área"));

				switch (op) {
				case 0: {
					break;
				}
				case 1: {
					jogador.setNome(JOptionPane.showInputDialog("Qual seu novo nome"));
					JOptionPane.showMessageDialog(null, "seu novo nome é "+jogador.getNome());
					break;
				}
				case 2: {
					JOptionPane.showMessageDialog(null,"Nome - Capivara \n Vida - 80\n Mana - 0 \n Força - 12 \n Velocidade - 35");
					JOptionPane.showMessageDialog(null,"Nome - Lobo Guará \n Vida - 90\n Mana - 0 \n Força - 15 \n Velocidade - 70");
					JOptionPane.showMessageDialog(null,"Nome - Onça Pintada \n Vida - 100\n Mana - 0 \n Força - 20 \n Velocidade - 20");
					
					JOptionPane.showMessageDialog(null,"Nome - Sucuri \n Vida - 100\n Mana - 0 \n Força - 25 \n Velocidade - 45");
					JOptionPane.showMessageDialog(null,"Nome - Crocodilo \n Vida - 150\n Mana - 0 \n Força - 20 \n Velocidade - 50");
					JOptionPane.showMessageDialog(null,"Nome - Jacaré do papo amarelo \n Vida - 180\n Mana - 0 \n Força - 30 \n Velocidade - 50");
					break;

				}
				case 3: {
					//Incompleto
					nova_area_nome = JOptionPane.showInputDialog(null, "Qual o nome da nova área?");
					nova_area = true;
					inimigo.setNome(JOptionPane.showInputDialog(null, "Qual o nome do novo inimigo?"));
					inimigo.setVida(Double.valueOf(JOptionPane.showInputDialog(null, "Qual a vida do novo inimigo?")));
					inimigo.setVidaMax(inimigo.getVida());
					inimigo.setForce(Double.valueOf(JOptionPane.showInputDialog(null, "Qual a força do novo inimigo?")));
					inimigo.setMana(Double.valueOf(JOptionPane.showInputDialog(null, "Qual a mana do novo inimigo?")));
					inimigo.setManaMax(inimigo.getMana());
					inimigo.setVelocidade(Double.valueOf(JOptionPane.showInputDialog(null, "Qual a velocidade do novo inimigo?")));
					inimigo.setVelocidadeMax(inimigo.getVelocidade());
					break;
				}
				case 4: {
					break;
				}
				default:
					JOptionPane.showInternalMessageDialog(null, "Opção errada");
					break;
				}
			}
		}
	}

	public static void classe(Jogador jogador) {

		Integer op = Integer.MAX_VALUE;
		while (op != 1 && op != 2 && op != 3) {
			op = Integer
					.valueOf(JOptionPane.showInputDialog("Escolha sua classe \n 1-Cavaleiro \n 2-Mago \n 3-Clérico"));
			switch (op) {
			case 1:
				jogador.setClasse("Cavaleiro");
				jogador.setVidaMax(120.0);
				jogador.setVida(120.0);
				jogador.setForce(20.0);
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
			default:
				JOptionPane.showInternalMessageDialog(null, "Opção errada");
				break;
			}
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

	public static void escolherArea(Inimigo inimigo ) {
		ImageIcon iconic = new ImageIcon("Floresta.jpeg");
		ImageIcon iconici = new ImageIcon("Pantano.jpeg");
		Integer op = Integer.MAX_VALUE;
		while (op != 1 && op != 2) {
			op = Integer.valueOf(JOptionPane.showInputDialog("Aonde deseja se aventurar? \n 1-Floresta \n 2-Pantano"));

			switch (op) {
			case 1:
				florestaInimigo(inimigo);
				JOptionPane.showMessageDialog(null, "", null, JOptionPane.INFORMATION_MESSAGE, iconic);
				JOptionPane.showMessageDialog(null,
						"Enquanto se aventurava pela floresta, você encontrou um " + inimigo.getNome());
				break;
			case 2:
				pantanoInimigo(inimigo);

				JOptionPane.showInternalMessageDialog(null, "", null, JOptionPane.INFORMATION_MESSAGE, iconici);
				break;

			default:
				JOptionPane.showInternalMessageDialog(null, "Opção errada");
				break;
			}
		}
	}

	public static void pantanoInimigo(Inimigo inimigo) {
		Random random = new Random();
		Integer op = random.nextInt(0, 101);

		if (op < 50) {
			inimigo.setNome("Sucuri");
			inimigo.setVidaMax(100.0);
			inimigo.setVida(100.0);
			inimigo.setForce(25.0);
			inimigo.setManaMax(0.0);
			inimigo.setMana(0.0);
			inimigo.setVelocidadeMax(45.0);
			inimigo.setVelocidade(45.0);
		} else if (op >= 50 && op < 85) {
			inimigo.setNome("Crocodilo");
			inimigo.setVidaMax(150.0);
			inimigo.setVida(150.0);
			inimigo.setForce(20.0);
			inimigo.setManaMax(0.0);
			inimigo.setMana(0.0);
			inimigo.setVelocidadeMax(50.0);
			inimigo.setVelocidade(50.0);
		} else if (op >= 85) {
			inimigo.setNome("Jacaré do papo amarelo");
			inimigo.setVidaMax(180.0);
			inimigo.setVida(180.0);
			inimigo.setForce(30.0);
			inimigo.setManaMax(0.0);
			inimigo.setMana(0.0);
			inimigo.setVelocidadeMax(50.0);
			inimigo.setVelocidade(50.0);

		}
	}

	public static void florestaInimigo(Inimigo inimigo) {

		Random random = new Random();
		Integer op = random.nextInt(0, 101);

		if (op < 50) {
			inimigo.setNome("Capivara");
			inimigo.setVidaMax(80.0);
			inimigo.setVida(80.0);
			inimigo.setForce(12.0);
			inimigo.setManaMax(0.0);
			inimigo.setMana(0.0);
			inimigo.setVelocidadeMax(35.0);
			inimigo.setVelocidade(35.0);
		} else if (op >= 50 && op < 85) {
			inimigo.setNome("Lobo Guará");
			inimigo.setVidaMax(90.0);
			inimigo.setVida(90.0);
			inimigo.setForce(15.0);
			inimigo.setManaMax(0.0);
			inimigo.setMana(0.0);
			inimigo.setVelocidadeMax(70.0);
			inimigo.setVelocidade(70.0);
		} else if (op >= 85) {
			inimigo.setNome("Onça Pintada");
			inimigo.setVidaMax(100.0);
			inimigo.setVida(100.0);
			inimigo.setForce(20.0);
			inimigo.setManaMax(0.0);
			inimigo.setMana(0.0);
			inimigo.setVelocidadeMax(85.0);
			inimigo.setVelocidade(85.0);

		}
	}

	public static void combate(Jogador jogador, Inimigo inimigo, int vitoria) {
		ImageIcon iconic = new ImageIcon("morte.jpeg");
		ImageIcon iconic1 = new ImageIcon("vitoria.jpeg");

		vitoria = 2;

		while (vitoria == 2 && jogador.getFugir()!= 1) {
			if (jogador.getVelocidade() >= inimigo.getVelocidade()) {
				jogador.setVelocidade(jogador.getVelocidade() - inimigo.getVelocidadeMax());
				inimigo.setVelocidade(inimigo.getVelocidadeMax());
				menuAction(jogador, inimigo, vitoria);

				if (jogador.getVida() <= 0) {
					vitoria = 1;
					JOptionPane.showMessageDialog(null, "", null, JOptionPane.INFORMATION_MESSAGE, iconic);
					break;
				} else if (inimigo.getVida() <= 0) {
					vitoria = 0;
					JOptionPane.showMessageDialog(null, "", null, JOptionPane.INFORMATION_MESSAGE, iconic1);
					break;
				}

			} else if (inimigo.getVelocidade() > jogador.getVelocidade()) {
				inimigo.setVelocidade(inimigo.getVelocidade() - jogador.getVelocidadeMax());
				jogador.setVelocidade(jogador.getVelocidadeMax());
				JOptionPane.showMessageDialog(null, inimigo.getNome() + " te atacou");
				inimigo.ataque(inimigo, jogador);
				if (jogador.getVida() <= 0) {
					vitoria = 1;
					JOptionPane.showMessageDialog(null, "", null, JOptionPane.INFORMATION_MESSAGE, iconic);
					break;
				} else if (inimigo.getVida() <= 0) {
					vitoria = 0;
					JOptionPane.showMessageDialog(null, "", null, JOptionPane.INFORMATION_MESSAGE, iconic1);
					break;
				}

			} else if (jogador.getFugir() == 1) {
				break;
			}
			if (jogador.getCooldown2() >= 1) {
				jogador.setCooldown2(jogador.getCooldown2() - 1);
			}
		}
	}

	public static void menuAction(Jogador jogador, Inimigo inimigo, int vitoria) {

		while (true) {
			JOptionPane.showMessageDialog(null, "\n Sua vez");
			jogador.setOp(Integer.valueOf(JOptionPane.showInputDialog(jogador.getNome() + "\n Vida: "
					+ jogador.getVida() + "\n Mana: " + jogador.getMana() + "\n" + inimigo.getNome() + "\n Vida: "
					+ inimigo.getVida() + "\n Mana: " + inimigo.getMana() + "\n" + "\n 1-Habilidade \n 2-Fugir ")));

			if (jogador.getOp() == 1) {
				jogador.setOp(0);
				menuHabili(jogador, inimigo, vitoria);
				break;
			} else if (jogador.getOp() == 2) {
				jogador.setFugir(1);
				jogador.setVida(jogador.getVidaMax());
				jogador.setMana(jogador.getManaMax());
				jogador.setVelocidade(jogador.getVelocidadeMax());
				break;
			} else {
				JOptionPane.showInternalMessageDialog(null, "Opção errada");
			}
		}
	}

	public static void menuHabili(Jogador jogador, Inimigo inimigo, int vitoria) {
		while (jogador.getOp() != 1 && jogador.getOp() != 2) {
			if (jogador.getClasse().equals("Cavaleiro")) {
				jogador.setOp(Integer.valueOf(JOptionPane.showInputDialog(null,
						jogador.getCooldown2() + "\n1- Corte de espada \n 2- Ataque forte")));
				if (jogador.getOp() == 1) {
					corteEspada(jogador, inimigo, vitoria);
					JOptionPane.showMessageDialog(null, "Você atacou o(a) " + inimigo.getNome());
				} else if (jogador.getOp() == 2) {
					ataqueForte(jogador, inimigo, vitoria);
					JOptionPane.showMessageDialog(null, "Você atacou o(a) " + inimigo.getNome());
				} else {
					JOptionPane.showInternalMessageDialog(null, "Opção errada");
				}

			} else if (jogador.getClasse().equals("Mago")) {
				jogador.setOp(
						Integer.valueOf(JOptionPane.showInputDialog(null, "1- Corte de adaga \n 2- Bola de fogo")));
				if (jogador.getOp() == 1) {
					corteAdaga(jogador, inimigo, vitoria);
					JOptionPane.showMessageDialog(null, "Você atacou o(a) " + inimigo.getNome());
					break;
				} else if (jogador.getOp() == 2) {
					bola_de_fogo(jogador, inimigo, vitoria);
					JOptionPane.showMessageDialog(null, "Você atacou o(a) " + inimigo.getNome());
					break;
				} else {
					JOptionPane.showInternalMessageDialog(null, "Opção errada");
				}

			}
			if (jogador.getClasse().equals("Clérico")) {
				jogador.setOp(Integer.valueOf(JOptionPane.showInputDialog(null, "1- Corte de adaga \n 2- Cura")));
				if (jogador.getOp() == 1) {
					corteAdaga(jogador, inimigo, vitoria);
					JOptionPane.showMessageDialog(null, "Você atacou o(a) " + inimigo.getNome());
					break;
				} else if (jogador.getOp() == 2) {
					cura(jogador, inimigo, vitoria);
					JOptionPane.showMessageDialog(null, "Você se curou");
					break;
				} else {
					JOptionPane.showInternalMessageDialog(null, "Opção errada");
				}
			}
		}
	}

	public static void corteEspada(Jogador jogador, Inimigo inimigo, int vitoria) {
		inimigo.setVida(inimigo.getVida() - jogador.getForce());
	}

	public static void ataqueForte(Jogador jogador, Inimigo inimigo, int vitoria) {
		if (jogador.getCooldown2() == 0) {
			if (jogador.getMana() >= 0) {
				inimigo.setVida(inimigo.getVida() - (jogador.getForce() * 1.50));
				jogador.setCooldown2(3);
			} else {
				JOptionPane.showMessageDialog(null, "você não tem mana para executar a habilidade");
				menuAction(jogador, inimigo, vitoria);
			}
		} else {
			JOptionPane.showMessageDialog(null, "A habilidade está em cooldown");
			menuAction(jogador, inimigo, vitoria);
		}
	}

	public static void corteAdaga(Jogador jogador, Inimigo inimigo, int vitoria) {
		inimigo.setVida(inimigo.getVida() - jogador.getForce());
	}

	public static void bola_de_fogo(Jogador jogador, Inimigo inimigo, int vitoria) {
		if (jogador.getCooldown2() == 0) {
			if (jogador.getMana() >= 20) {
				inimigo.setVida(inimigo.getVida() - 50);
				jogador.setMana(jogador.getMana() - 20);
				jogador.setCooldown2(5);
			}else {
				JOptionPane.showMessageDialog(null, "você não tem mana para executar a habilidade");
				menuAction(jogador, inimigo, vitoria);
			}
		} else {
			JOptionPane.showMessageDialog(null, "A habilidade está em cooldown");
			menuAction(jogador, inimigo, vitoria);
		}
	}

	public static void cura(Jogador jogador, Inimigo inimigo, int vitoria) {
		if (jogador.getCooldown2() == 0) {
			if (jogador.getMana() >= 20) {
				if (jogador.getVida() <= jogador.getVidaMax()) {
					jogador.setVida(jogador.getVida() + 40);
					jogador.setMana(jogador.getMana() - 20);
					jogador.setCooldown2(5);
					if (jogador.getVida() >= jogador.getVidaMax()) {
						jogador.setVida(jogador.getVidaMax());
					}
				}else {
					JOptionPane.showMessageDialog(null, "sua vida já está no máximo");
					menuAction(jogador, inimigo, vitoria);	
				}
			}else {
				JOptionPane.showMessageDialog(null, "você não tem mana para executar a habilidade");
				menuAction(jogador, inimigo, vitoria);
			}
		} else {
			JOptionPane.showMessageDialog(null, "A habilidade está em cooldown");
			menuAction(jogador, inimigo, vitoria);
		}
	}
}