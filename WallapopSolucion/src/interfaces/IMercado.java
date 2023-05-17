package interfaces;

import java.util.List;

/**
 * Interfaz que modela el comportamiento de una app de compra
 * venta de productos. Contendra un conjunto de productos de
 * segunda mano, y los metodos necesarios para gestionar dichos 
 * productos.
 * 
 * @author Raul SG
 *
 */
public interface IMercado {
	
	
	/**
	 * Metodo utilizado para subir un producto al registro general de productos almacenados en la
	 * app de compra venta de productos. Es decir, el producto que
	 * se registrara en la app, tendra como informacion, el nombre, precio y usuario
	 * pasados por parametros. Los productos cuando se suben, no estan caducados.
	 * 
	 * Si el producto que se quiere subir ya esta registrado, no se sube dicho producto
	 * y se devuelve false. Si por el contrario no existe, es decir no esta almacenado
	 * en el registro de productos, se añadira, y el metodo devuelve true.
	 * 
	 * Dos productos se consideran iguales si tienen el mismo nombre. Por tanto la app 
	 * no va a permitir que haya dos productos con el mismo nombre.
	 * 
	 * @param nombre. Nombre del producto que se quiere almacenar. No va a ser null.
	 * @param precio. Precio del producto que se quiere almacenar. No va a ser null.
	 * @param usuario. Usuario que ha subido el producto. No va a ser null.
	 * 
	 * 
	 */
	public boolean subirProducto(String nombre, double precio, IUsuario usuario);
	
	
	/**
	 * Metodo que devuelve el listado completo de todos los
	 * productos registrados en la app de compra venta.
	 * 
	 * @return List<IProducto>. Lista de los productos registrados.
	 */
	public List<IProducto> getProductos();
	
	/**
	 * Metodo que devuelve una lista con los productos cuyo precio se encuentra entre el rango
	 * [min , max], es decir, cuyo precio es mayor o igual que min, y menor o igual que max.
	 * 
	 * min y max, siempre van a ser mayores que cero, y min<max, por lo que no hay que controlar dicha 
	 * casuistica. No hay productos que valgan null.
	 * 
	 * 
	 * @param min. Parametro que representa el valor mas bajo por el que se desea filtrar
	 * el precio de los productos registrados
	 * @param max. Parametro que representa el valor mas alto por el que se desea filtrar
	 * el precio de los productos registrados
	 * 
	 * @return Lista con todos los productos cuyo precio se encuentra definido en la orquilla
	 * de precios definida con min y max (min y max incluidos)
	 */
	public List<IProducto> getFiltrarProductosPorPrecio(double min, double max);
	
	
	/**
	 * Metodo que devuelve el listado de productos visibles registrados en la app,
	 * ordenados por precio desde el mas barato primero, hasta el mas caro, en 
	 * ultimo lugar. Los productos visibles, son aquellos que no se encuetran caducados.
	 * Es decir, se va a devolver una lista con los productos que no han caducado,
	 * ordenados por precio, desde el mas barato, hasta el mas caro. No hay productos que valgan null.
	 * 
	 * @return List<IProducto>. Lista de productos no caducados, ordenada por precio, en orden creciente de 
	 * menor a mayor precio.
	 */
	public List<IProducto> getProductosVisiblesOrdenados();
	
	
	/**
	 * Metodo al que se le indica el nombre de un producto, y lo elimina, si existe,
	 * del registro general de productos. Ademas se retorna dicho producto. Devolvera null,
	 * si no existe ningun producto con dicho nombre registrado.
	 * 
	 * Dos productos se consideran que son iguales si tienen el mismo nombre.
	 * 
	 * @implNote: Debido a que no se permiten subir dos productos con el 
	 * mismo nombre. No existen dos productos con el mismo nombre almacenados en la app.
	 * 
	 * 
	 * @param nombre. Nombre del producto que se desea eliminar del listado 
	 * de productos, y devolver como resultado.
	 * 
	 * @return IProducto. Producto que se ha borrado. En caso de que no exista ningun
	 * producto con el nombre indicado, se devolvera null.
	 * 
	 *  
	 */
	public IUsuario removeProducto(String nombre);

}
