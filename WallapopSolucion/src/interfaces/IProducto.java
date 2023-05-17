package interfaces;

/**
 * Interfaz que modela el comportamiento de un producto dentro
 * de la apliacion de compra/venta de productos
 * 
 * @author Raul SG
 *
 */
public interface IProducto extends Comparable<IProducto>{
	
	/**
	 * Metodo utilizado para modificar el nombre de un producto. 
	 * 
	 * @param nombre. El nombre pasado por parametro sera el nuevo nombre
	 * 
	 * El nombre nunca va a ser null.
	 */
	public void setNombre(String nombre);
	
	/**
	 * Metodo que devuelve el nombre del producto.
	 * 
	 * @return String. Cadena que contiene el nombre del producto
	 */
	public String getNombre();
	
	/**
	 * Metodo utilizado para modificar el precio de un producto. 
	 * 
	 * @param precio. El precio pasado por parametro sera el nuevo precio
	 * 
	 */
	public void setPrecio(double precio);
	
	/**
	 * Metodo que devuelve el nombre del producto.
	 * 
	 * @return double. Precio del producto
	 */
	public double getPrecio();
	
	
	/**
	 * Metodo utilizado para modificar el usuario, propietario de un producto. 
	 * 
	 * @param usuario. Usuario al que pertenece el producto, y lo pone a la venta.
	 * 
	 */
	public void setUsuario(IUsuario usuario);
	
	/**
	 * Metodo que devuelve el usuario propietario del producto.
	 * 
	 * @return IUsuario. Usuario, dueño del producto
	 */
	public IUsuario getUsuario();
	
	/**
	 * Metodo utilizado para indicar si el producto ha caducado o no. 
	 * 
	 * @param caducado. Valdra true, cuando el producto se encuentre caducado, y 
	 * sera false cuando el producto no se encuentre caducado.
	 * 
	 * @implNote Si un producto ha caducado, es decir caducado=true, significa que no
	 * es visible por el resto de usuarios, y debe ser renovado de nuevo para que sea visible. 
	 * Esto sera tenido en cuenta en IMercado, interfaz encargada de devolver resultados a los usuarios
	 */
	public void setCaducado(boolean caducado);
	
	/**
	 * Metodo que devuelve si un producto ha caducado o no.
	 * 
	 * @return boolean. True, si esta caducado, false si no lo esta.
	 */
	public boolean getCaducado();

}
