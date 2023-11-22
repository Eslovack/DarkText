package controle;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import modelo.IItemDAO;
import modelo.Inventario;
import modelo.Item;

public class ItemDAO implements IItemDAO {

	public void adicionarItem(Inventario inventario ,ArrayList<Item> itens) {
		inventario.setItens(itens);
		
	}

	public void removerItem(Inventario inventario) {
		
		
	}

	public void listarItem(Inventario inventario, ArrayList<Item> itens) {
		
		for (Item listar : itens) {
			JOptionPane.showMessageDialog(null, listar.getId() + "\n" + listar.getNome() + "\n" + listar.getAtributo() + "\n"+listar.getModificador() );
			
		}
		
	}

	public void editarItem() {

		
	}

}
