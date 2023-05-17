package model;

import java.util.Objects;

import interfaces.IProducto;
import interfaces.IUsuario;

public class Producto implements IProducto{
	private String nombre;
	private IUsuario usuario;
	private double precio;
	private boolean caducado;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public IUsuario getUsuario() {
		return usuario;
	}
	public void setUsuario(IUsuario usuario) {
		this.usuario = usuario;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	//Para booleanos, se utiliza mucho la terminologia isXXX en lugar de getXXX
	//Por ello incluimos este metodo tambien.
	public boolean isCaducado() {
		return caducado;
	}
	public void setCaducado(boolean caducado) {
		this.caducado = caducado;
	}
	@Override
	public int compareTo(IProducto o) {
		return Double.compare(precio, o.getPrecio());
	}
	@Override
	public boolean getCaducado() {
		return isCaducado();
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre);
		//Dos productos son iguales si tienen el mismo nombre.
	}
	
	

	
}
