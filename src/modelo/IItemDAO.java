package modelo;

import java.util.ArrayList;

public interface IItemDAO {
	
	public void adicionarItem(Inventario inventario, ArrayList<Item> itens);
	
	public void removerItem(Inventario inventario);
	
	public void listarItem(Inventario inventario, ArrayList<Item> itens);
	
	public void editarItem();

}
