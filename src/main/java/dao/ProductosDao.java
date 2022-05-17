package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Producto;

public interface ProductosDao extends JpaRepository<Producto, Integer> {

	@Query("select p.precioUnitario from Producto p where p.codigoProducto=?1")
	double findByPrecio(int codigoProducto);
}
