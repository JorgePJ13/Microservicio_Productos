package service;

import java.util.List;

import model.Producto;

public interface ProductosService {

	/**
	 * Metodo que devuelve la lista de productos existentes
	 * 
	 * @return la lista de productos
	 */
	List<Producto> productos();
	
	/**
	 * Metodo que actualiza el stock de un determinado producto.
	 * 
	 * @param codigoProducto: el producto a actualizar
	 * @param unidades: numero de unidades compradas
	 * @return true si se ha actualizado correctamente; false en caso contrario
	 */
	boolean actualizarStock(int codigoProducto, int unidades);
	
	/**
	 * Metodo que devuelve el precio de un producto
	 * 
	 * @param codigoProducto: el codigo del producto a buscar 
	 * @return el precio del producto
	 */
	double precioProducto(int codigoProducto);
	
	/**
	 * Metodo que busca un producto segun su id
	 * 
	 * @param codigoProducto: identificador del producto
	 * @return el producto segun su codigo
	 */
	Producto buscarProductoId(int codigoProducto);
}
