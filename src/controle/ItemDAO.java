package controle;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.IItemDAO;
import modelo.Item;

public class ItemDAO implements IItemDAO {
	
	private static ArrayList<Item> itens;
	private static ItemDAO instancia;
	
	public static ItemDAO getInstancia() {

		if (instancia == null) {
			instancia = new ItemDAO();
			itens = new ArrayList<>();
		}

		return instancia;
	}

	public void adicionarItem(Item item) {
		itens.add(item);
		
	}

	public void removerItem(String op1) {
		int excluir = -1;
		int i = 0;
		
		for (Item listar : itens) {
			if(listar.getNome().equals(op1) ) {
				excluir = i;
			}
			i++;
		}
		if( excluir >= 0) {
			itens.remove(excluir);
		}
		
	}

	public void listarItem() {
		
		for (Item listar : itens) {
			JOptionPane.showMessageDialog(null, listar.getId() + "\n" + listar.getNome() + "\n" + listar.getAtributo() + "\n"+listar.getModificador() );
			
		}
		
	}

	public void editarItem(String op1) {
		Item editar = new Item();
		int i = 0;
		for (Item listar : itens) {
			if(listar.getNome().equals(op1) ) {
				editar.setId(listar.getId());
				editar.setNome(listar.getNome());
				editar.setAtributo(listar.getAtributo());
				editar.setModificador(Double.valueOf(JOptionPane.showInputDialog(null, "Digite o novo modificador do item")));
				i++;
			}
		}
		itens.remove(i-1);
		itens.add(editar);
		
		
	}

}
