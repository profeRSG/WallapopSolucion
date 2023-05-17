package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import interfaces.IMercado;
import interfaces.IProducto;
import interfaces.IUsuario;

public class Mercado implements IMercado{
	List<IProducto> productos=new LinkedList<>();//Lista donde vamos a guardar los 
	//productos subidos (dados de alta)

	@Override
	public boolean subirProducto(String nombre, double precio, IUsuario usuario) {
		IProducto productoParaSubir=new Producto();//Creamos un objeto producto sin datos.
		productoParaSubir.setNombre(nombre);//Le seteamos el nombre pasado como parametro
		productoParaSubir.setPrecio(precio);//Lo mismo con el precio
		productoParaSubir.setUsuario(usuario);//Seteamos el usuario
		productoParaSubir.setCaducado(false);//Por defecto no esta caducado. Eta linea realmente
		//sobra, ya que los boolean por defecto son false.
		boolean resultado=false;//Resultado va a indicar si se sube finalmente el objeto.
		//Por defecto le damos el valor false
		if(!productos.contains(productoParaSubir)) {//Vemos si la lista productos no contiene el producto
			//Para utiliar el contains, debe estar implementado equals en la clase producto
			resultado=true;//Si no o contiene, resulatdo va a ser true, ya que se va a subir
			productos.add(productoParaSubir);//Guardamos el producto en la lista
		}
		
		return resultado;
	}

	@Override
	public List<IProducto> getFiltrarProductosPorPrecio(double min, double max) {
		List<IProducto> resultado=new ArrayList<>();//Creamos una lista vacia para almacenar el resultado
		for(IProducto producto:productos) {//Para cada producto
			double precio=producto.getPrecio();//Obtenemos su precio
			if(precio>=min && precio <=max)//Si el precio se encuentra entre el rango especificado
				resultado.add(producto);//Se añade el producto a resultado
		}
		return resultado;//Se devuelev la lista
	}

	@Override
	public List<IProducto> getProductosVisiblesOrdenados() {
		List<IProducto> resultado=new ArrayList<>();//Creamos una lista vacia
		for(IProducto producto:productos) { //Por cada producto 
			if(!producto.getCaducado())//Si no esta caducado
				resultado.add(producto);//Añadimos el producto
		}
		Collections.sort(resultado);//Ordenamos todos los productos
		return resultado;//Devolvemos el resultado
	}

	@Override
	public IUsuario removeProducto(String nombre) {
		IUsuario usuarioPropietario=null;//Variable utiliada para almacenar el usuario propietario del producto borrado
		IProducto productoParaBuscar=new Producto();//Creamos un producto para buscarlo
		productoParaBuscar.setNombre(nombre);//Le indicamos el nombre
		//Se podría utilizar la siguienet linea para ver la posicion 
		//del objeto: int i=productos.indexOf(productoParaBuscar);
		
		boolean encontrado=false;
		for(int i=0;i<productos.size() && !encontrado;i++) {//Recorremos la lista, mientras no encontremos el producto
			if(productos.get(i).equals(productoParaBuscar)) {//Si son iguales, es decir, si tienen el mismo nombre
				usuarioPropietario=productos.get(i).getUsuario();//Obtenemos el usuario del producto situado en i
				productos.remove(i);//Borramos el producto situado en la posicion i
			}
		}
		return usuarioPropietario;//Devolvemos el usuario
	}

	@Override
	public List<IProducto> getProductos() {
		
		return productos;//Retornamos la lista de productos
	}

}
