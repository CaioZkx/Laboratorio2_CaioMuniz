package lab1;

import java.util.ArrayList;

public abstract class CachorroQuente {

	protected String queijo;
	protected ArrayList<String> ingredientes;
	protected String bebiba;
	
	public CachorroQuente(String queijo, String bebiba) {
		this.queijo = queijo;		
		this.bebiba = bebiba;
	}
	
	public void adicionarIngredientes(String ingrediente) {
		
		ingredientes.add(ingrediente);
	}
	
	public String getQueijo() {
		return queijo;
	}
	public void getBebida() {
		System.out.println("bebida: " + bebiba);
	}
	public void getTipo() {

	}

}
