package controle;

import java.util.ArrayList;

import modelo.IItemDAO;
import modelo.Inventario;
import modelo.Item;

public class ItemDAO implements IItemDAO {

	public void adicionarItem(Inventario inventario ,ArrayList<Item> itens) {
		inventario.setItens(itens);
		
	}

	public void removerItem() {

		
	}

	public void listarItem(Inventario inventario,Item item) {
			
		
		
	}

	public void editarItem() {

		
	}

}
