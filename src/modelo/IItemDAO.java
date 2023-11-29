package modelo;

import java.util.ArrayList;

public interface IItemDAO {
	
	public void adicionarItem(Item item);
	
	public void removerItem(String op1);
	
	public void listarItem();
	
	public void editarItem(String op1);

}
