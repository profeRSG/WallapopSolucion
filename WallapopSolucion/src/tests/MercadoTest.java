package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.IMercado;
import interfaces.IProducto;
import interfaces.IUsuario;
import model.Mercado;
import model.Producto;
import model.Usuario;

/**
 * Clase de tes utilizada para probar la clase Mercado
 * @author Raul SG
 *
 */
class MercadoTest {
	
	private static IMercado wallapop;//Mercadi con el que se van a hacer test
	private static IUsuario lale;//Usuario para test

	@BeforeEach //Antes de cada pruieba
	void setUp() throws Exception {
		lale=new Usuario();
		lale.setNombre("Lale");//Creamos el usuario Lale
		
		wallapop=new Mercado();//Creamos el mercado
		wallapop.subirProducto("casa", 7, lale);//Subimos 5 productos
		wallapop.subirProducto("loma", 3, lale);
		wallapop.subirProducto("casa2", 12, lale);
		wallapop.subirProducto("loma2", 17, lale);
		wallapop.subirProducto("loma3", 8, lale);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	/**
	 * Se quiere probar la suibida de un objeto que no se ha subido antes
	 */
	void subirTrue() {
		assertEquals(5, wallapop.getProductos().size());//Comprobamso que hay 5 productos
		assertEquals(wallapop.subirProducto("tente", 0, lale),true);//Subimos un objeto. Comprobamos que devuelev true
		assertEquals(6, wallapop.getProductos().size());//Comprobamos que se ha incrementado el numero de productos
	}
	
	@Test
	/**
	 * Se quiere probar la suibida de un objeto que  se ha subido antes
	 */
	void subirFalse() {
		assertEquals(5, wallapop.getProductos().size());//Comprobamso que hay 5 productos
		assertEquals(wallapop.subirProducto("casa", 0, lale),false);//Subimos un objeto que ya se ha subido. Comprobamos que devuelve false
		assertEquals(5, wallapop.getProductos().size());//Comprobamos que no se ha incremantado el numero de productos
	}
	
	@Test
	/**
	 * Se quiere probar el filtro por precio.
	 * Se prueba con diferentes numeros, que el tamaño de la lista es el esperado
	 * al filtrarla
	 */
	void getFitrarPrecio() {
		assertEquals(3, wallapop.getFiltrarProductosPorPrecio(7, 12).size());// 3 productos, entre 7 y 12
		assertEquals(4, wallapop.getFiltrarProductosPorPrecio(7, 17).size());// 7 productos, entre 7 y 17
		assertEquals(0, wallapop.getFiltrarProductosPorPrecio(200, 300).size()); // 0 productos, entre 200 y 300
	}
	
	@Test
	/**
	 * Se quiere probar el metodo getProductosVisiblesOrdenados
	 */
	void getOrdenados() {
		List<IProducto> r = wallapop.getProductosVisiblesOrdenados();//Llamamos al metodo
		//y guardamos el resultado en la lista r
		IProducto loma=new Producto();//A continuacion creamos objetos para comprar con lo que
		//esta contenido en la lista
		loma.setNombre("loma");
		IProducto loma2=new Producto();
		loma2.setNombre("loma2");
		IProducto loma3=new Producto();
		loma3.setNombre("loma3");
		assertEquals(r.get(0),loma);//El primer objeto debe ser loma, al ser el mas barato
		assertEquals(r.get(4),loma2);//Luego loma2
		assertEquals(r.get(2),loma3);//Y loma 3
		
		IProducto qwe=new Producto();
		qwe.setNombre("qweqweqwe");
		assertNotEquals(r.get(1),qwe);
	}
	
	
	@Test
	/**
	 * Se quiere probar el metodo getProductosVisiblesOrdenados
	 */
	void getOrdenados2() {
		//El metodo hace lo mismo que el test  getOrdenados(),
		//Pero poniendo un articulo no visible, para ver
		//Sis e subre dicha parte.
		
		IProducto p=wallapop.getProductos().get(1);
		p.setCaducado(true);
		
		List<IProducto> r = wallapop.getProductosVisiblesOrdenados();
		IProducto loma=new Producto();
		loma.setNombre("loma");
		IProducto loma2=new Producto();
		loma2.setNombre("loma2");
		IProducto loma3=new Producto();
		loma3.setNombre("loma3");
		assertNotEquals(r.get(0),loma);
		assertEquals(r.get(3),loma2);
		assertEquals(r.get(1),loma3);
		
		IProducto qwe=new Producto();
		qwe.setNombre("qweqweqwe");
		assertNotEquals(r.get(1),qwe);
		//TODO evitar duplicidad de codigo con getOrdenados()
	}
	
	@Test
	/**
	 * Metodo para probar que se borra un objeto que existe
	 */
	void removeExiste() {
		assertEquals(5, wallapop.getProductos().size());
		IUsuario l=wallapop.removeProducto("casa");
		assertEquals(true,l.getNombre().equals("Lale"));
		assertEquals(4, wallapop.getProductos().size());
	}
	
	@Test
	
	void removeExistePreciso() {
		assertEquals(5, wallapop.getProductos().size());//Tamaño de 5
		IUsuario l=wallapop.removeProducto("casa2");//Borramos casa2
		assertEquals(true,l.getNombre().equals("Lale"));//Vemos que el usuario de casa2 era Lale
		assertEquals(4, wallapop.getProductos().size());//Comprobamos que casa2 se borro
		assertEquals(wallapop.subirProducto("casa2", 0, lale),true);//Subimos casa2 otra vez
		assertEquals(5, wallapop.getProductos().size());//Aumenta el tamaño
		assertEquals(wallapop.subirProducto("casa2", 0, lale),false);//Subimos casa2 otra vez
		assertEquals(5, wallapop.getProductos().size());//Esta vez no aumenta el tamaño
	}
	
	@Test
	/**
	 * Metodo para probar que no se borra un objeto que no existe
	 */
	void removeNoExiste() {
		assertEquals(5, wallapop.getProductos().size());
		IUsuario l=wallapop.removeProducto("asdasdasdasd");
		assertEquals(null,l);
		assertEquals(5, wallapop.getProductos().size());
	}

}
