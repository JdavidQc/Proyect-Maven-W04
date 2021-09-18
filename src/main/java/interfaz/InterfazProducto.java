package interfaz;

import java.util.ArrayList;

import modelo.Producto;

public interface InterfazProducto {

	
	
	
	public boolean AgregarProducto(Producto p);
	
	public boolean EliminarProducto(String codigo);
	
	public boolean ModificarProducto(Producto p);
	
	public Producto consultarProducto(String codigo);
	
	public ArrayList<Producto> listarProducto();
	
	public String getCodigoCorrolativo();
}
