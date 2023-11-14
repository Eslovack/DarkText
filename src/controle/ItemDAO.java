package controle;

import java.util.ArrayList;
import java.util.Iterator;

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
			System.out.println(listar.getId());
			System.out.println(listar.getNome());
			System.out.println(listar.getAtributo());
			System.out.println(listar.getModificador());
			
		}
		
	}

	public void editarItem() {

		
	}

}
