package controle;

import java.util.ArrayList;

import modelo.IItemDAO;
import modelo.Inventario;
import modelo.Item;

public class ItemDAO implements IItemDAO {

	public void adicionarItem(Item item, Inventario inventario) {
		ArrayList<Item> itens = new ArrayList<>();
		itens.add(item);
		inventario.setItens(itens);
		
	}

	public void removerItem() {

		
	}

	public void alterarItem() {

		
	}

	public void editarItem() {

		
	}

}
