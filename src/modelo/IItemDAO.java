package modelo;

import java.util.ArrayList;

public interface IItemDAO {
	
	public void adicionarItem(Inventario inventario, ArrayList<Item> itens);
	
	public void removerItem();
	
	public void listarItem(Inventario inventario, Item item);
	
	public void editarItem();

}
