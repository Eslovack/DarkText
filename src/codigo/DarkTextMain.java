package codigo;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
import javax.swing.ImageIcon;

public class DarkTextMain {

	public static void main(String[] args) {

		int vitoria = 2;
		Scanner leitura = new Scanner(System.in);
		Jogador jogador = new Jogador();
		Inimigo inimigo = new Inimigo();
		Inimigo inimigo2 = new Inimigo();
		jogador.setCooldown2(0);
		jogador.setOp(Integer.MAX_VALUE);
		Area area = new Area();
		area.setFloresta("");
		area.setPantano("");
		area.setNova_area("removido");
		area.setNova_area_nome("");

		while (jogador.getOp() != 0) {// ----------------------------------------------------------------
			jogador.setOp(
					Integer.valueOf(JOptionPane.showConfirmDialog(null, "Bem vindo deseja começar sua Aventura?")));

			if (jogador.getOp() == 1 || jogador.getOp() == 2) {
				break;
			}
			jogador.setNome(JOptionPane.showInputDialog(null, "Qual seu nome"));

			criativo(jogador, inimigo, inimigo2, area);
			classe(jogador);
			atributos(jogador, inimigo, "j");
			while (vitoria != 1) {
				escolherArea(inimigo, inimigo2, area);
				atributos(jogador, inimigo, "i");
				restaurar(jogador, inimigo, vitoria);
				combate(jogador, inimigo, vitoria);
			}
		} // ----------------------------------------------------------------------------------

		leitura.close();
	}

	public static void criativo(Jogador jogador, Inimigo inimigo, Inimigo inimigo2, Area area) {

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
					JOptionPane.showMessageDialog(null, "seu novo nome é " + jogador.getNome());
					break;
				}
				case 2: {
					JOptionPane.showMessageDialog(null,
							"Nome - Capivara \n Vida - 80\n Mana - 0 \n Força - 12 \n Velocidade - 35");
					JOptionPane.showMessageDialog(null,
							"Nome - Lobo Guará \n Vida - 90\n Mana - 0 \n Força - 15 \n Velocidade - 70");
					JOptionPane.showMessageDialog(null,
							"Nome - Onça Pintada \n Vida - 100\n Mana - 0 \n Força - 20 \n Velocidade - 20");

					JOptionPane.showMessageDialog(null,
							"Nome - Sucuri \n Vida - 100\n Mana - 0 \n Força - 25 \n Velocidade - 45");
					JOptionPane.showMessageDialog(null,
							"Nome - Crocodilo \n Vida - 150\n Mana - 0 \n Força - 20 \n Velocidade - 50");
					JOptionPane.showMessageDialog(null,
							"Nome - Jacaré do papo amarelo \n Vida - 180\n Mana - 0 \n Força - 30 \n Velocidade - 50");
					break;

				}
				case 3: {
					area.setNova_area_nome(JOptionPane.showInputDialog(null, "Qual o nome da nova área?"));
					area.setNova_area("");
					inimigo2.setNome(JOptionPane.showInputDialog(null, "Qual o nome do novo inimigo?"));
					inimigo2.setVida(Double.valueOf(JOptionPane.showInputDialog(null, "Qual a vida do novo inimigo?")));
					inimigo2.setVidaMax(inimigo2.getVida());
					inimigo2.setForce(
							Double.valueOf(JOptionPane.showInputDialog(null, "Qual a força do novo inimigo?")));
					inimigo2.setMana(Double.valueOf(JOptionPane.showInputDialog(null, "Qual a mana do novo inimigo?")));
					inimigo2.setManaMax(inimigo2.getMana());
					inimigo2.setVelocidade(
							Double.valueOf(JOptionPane.showInputDialog(null, "Qual a velocidade do novo inimigo?")));
					inimigo2.setVelocidadeMax(inimigo2.getVelocidade());
					area.setNova_area("");
					break;
				}
				case 4: {
					op = 0;
					while (op != 1 && op != 2) {
						op = Integer.valueOf(JOptionPane.showInputDialog(null,
								"Qual área você deseja remover? \n 1-Floresta \n 2-Pantano"));
						if (op == 1) {
							area.setFloresta("removido");
						} else if (op == 2) {
							area.setPantano("removido");
						} else {
							JOptionPane.showInternalMessageDialog(null, "Opção errada");
						}
					}
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
				jogador.setVelocidadeMax(50.0);
				jogador.setVelocidade(50.0);
				break;
			case 3:
				jogador.setClasse("Clérico");
				jogador.setVidaMax(100.0);
				jogador.setVida(100.0);
				jogador.setForce(15.0);
				jogador.setManaMax(100.0);
				jogador.setMana(100.0);
				jogador.setVelocidadeMax(50.0);
				jogador.setVelocidade(50.0);
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

	public static void escolherArea(Inimigo inimigo, Inimigo inimigo2, Area area) {
		ImageIcon iconic = new ImageIcon("Floresta.jpeg");
		ImageIcon iconici = new ImageIcon("Pantano.jpeg");
		Integer op = Integer.MAX_VALUE;

		if (area.getNova_area().equals("removido")) {
			while (op != 1 && op != 2) {
				op = Integer.valueOf(JOptionPane.showInputDialog("Aonde deseja se aventurar? \n 1-Floresta "
						+ area.getFloresta() + " \n 2-Pantano " + area.getPantano()));

				switch (op) {
				case 1:
					if (area.getFloresta() != "removido") {
						florestaInimigo(inimigo);
						JOptionPane.showMessageDialog(null, "", null, JOptionPane.INFORMATION_MESSAGE, iconic);
						JOptionPane.showMessageDialog(null,
								"Enquanto se aventurava pela floresta, você encontrou um " + inimigo.getNome());
					} else {
						JOptionPane.showInternalMessageDialog(null, "Opção errada");
						escolherArea(inimigo, inimigo2, area);
					}

					break;
				case 2:
					if (area.getPantano() != "removido") {
						pantanoInimigo(inimigo);
						JOptionPane.showInternalMessageDialog(null, "", null, JOptionPane.INFORMATION_MESSAGE, iconici);
					} else {
						JOptionPane.showInternalMessageDialog(null, "Opção errada");
						escolherArea(inimigo, inimigo2, area);
					}
					break;

				default:
					JOptionPane.showInternalMessageDialog(null, "Opção errada");
					break;
				}
			}
		} else {
			while (op != 1 && op != 2 && op != 3) {
				op = Integer.valueOf(
						JOptionPane.showInputDialog("Aonde deseja se aventurar? \n 1-Floresta " + area.getFloresta()
								+ " \n 2-Pantano " + area.getPantano() + " \n 3-" + area.getNova_area_nome()));

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
				case 3:
					novaArea(inimigo, inimigo2);
					break;

				default:
					JOptionPane.showInternalMessageDialog(null, "Opção errada");
					break;
				}
			}
		}

	}

	public static void novaArea(Inimigo inimigo, Inimigo inimigo2) {
		inimigo.setNome(inimigo2.getNome());
		inimigo.setVidaMax(inimigo2.getVidaMax());
		inimigo.setVida(inimigo2.getVida());
		inimigo.setForce(inimigo2.getForce());
		inimigo.setManaMax(inimigo2.getManaMax());
		inimigo.setMana(inimigo2.getMana());
		inimigo.setVelocidadeMax(inimigo2.getVelocidadeMax());
		inimigo.setVelocidade(inimigo2.getVelocidade());
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
		ImageIcon mortepng = new ImageIcon("morte.jpeg");
		ImageIcon vitoriapng = new ImageIcon("vitoria.jpeg");

		vitoria = 2;

		while (vitoria == 2 && jogador.getFugir() != 1) {
			if (jogador.getVelocidade() >= inimigo.getVelocidade()) {
				jogador.setVelocidade(jogador.getVelocidade() - inimigo.getVelocidadeMax());
				inimigo.setVelocidade(inimigo.getVelocidadeMax());
				menuAction(jogador, inimigo, vitoria);

				if (jogador.getVida() <= 0) {
					vitoria = 1;
					JOptionPane.showMessageDialog(null, "", null, JOptionPane.INFORMATION_MESSAGE, mortepng);
					break;
				} else if (inimigo.getVida() <= 0) {
					vitoria = 0;
					JOptionPane.showMessageDialog(null, "", null, JOptionPane.INFORMATION_MESSAGE, vitoriapng);
					break;
				}

			} else if (inimigo.getVelocidade() > jogador.getVelocidade()) {
				inimigo.setVelocidade(inimigo.getVelocidade() - jogador.getVelocidadeMax());
				jogador.setVelocidade(jogador.getVelocidadeMax());
				JOptionPane.showMessageDialog(null, inimigo.getNome() + " te atacou");
				inimigo.ataque(inimigo, jogador);
				if (jogador.getVida() <= 0) {
					vitoria = 1;
					JOptionPane.showMessageDialog(null, "", null, JOptionPane.INFORMATION_MESSAGE, mortepng);
					break;
				} else if (inimigo.getVida() <= 0) {
					vitoria = 0;
					JOptionPane.showMessageDialog(null, "", null, JOptionPane.INFORMATION_MESSAGE, vitoriapng);
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
				JOptionPane.showMessageDialog(null, "Você Fugiu");
				restaurar(jogador, inimigo, vitoria);
				jogador.setFugir(1);
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
						"\n1- Corte de espada \n 2- Ataque forte(" + jogador.getCooldown2() + ")")));
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
				jogador.setOp(Integer.valueOf(JOptionPane.showInputDialog(null,
						"1- Corte de adaga \n 2- Bola de fogo(" + jogador.getCooldown2() + ")")));
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
				jogador.setOp(Integer.valueOf(JOptionPane.showInputDialog(null,
						"1- Corte de adaga \n 2- Cura(" + jogador.getCooldown2() + ")")));
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

	public static void restaurar(Jogador jogador, Inimigo inimigo, int vitoria) {
		jogador.setFugir(0);
		jogador.setVida(jogador.getVidaMax());
		jogador.setMana(jogador.getManaMax());
		jogador.setVelocidade(jogador.getVelocidadeMax());
		vitoria = 2;
		jogador.setCooldown2(0);
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
				jogador.setCooldown2(4);
			} else {
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
					jogador.setVida(jogador.getVida() + 50);
					jogador.setMana(jogador.getMana() - 20);
					jogador.setCooldown2(4);
					if (jogador.getVida() >= jogador.getVidaMax()) {
						jogador.setVida(jogador.getVidaMax());
					}
				} else {
					JOptionPane.showMessageDialog(null, "sua vida já está no máximo");
					menuAction(jogador, inimigo, vitoria);
				}
			} else {
				JOptionPane.showMessageDialog(null, "você não tem mana para executar a habilidade");
				menuAction(jogador, inimigo, vitoria);
			}
		} else {
			JOptionPane.showMessageDialog(null, "A habilidade está em cooldown");
			menuAction(jogador, inimigo, vitoria);
		}
	}
}