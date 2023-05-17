package model;

import interfaces.IUsuario;

public class Usuario implements IUsuario{

	private String nombre;
	
	@Override
	public void setNombre(String nombre) {
		this.nombre=nombre;
		
	}

	@Override
	public String getNombre() {
		
		return nombre;
	}

}
