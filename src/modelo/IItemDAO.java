package modelo;

import java.util.ArrayList;

public interface IItemDAO {
	
	public void adicionarItem(Item item, Inventario inventario);
	
	public void removerItem();
	
	public void alterarItem();
	
	public void editarItem();

}
