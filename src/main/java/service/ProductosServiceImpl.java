package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService {

	@Autowired
	ProductosDao dao;
	
	public ProductosServiceImpl(@Autowired ProductosDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Producto> productos() {
		return dao.findAll();
	}

	@Override
	public boolean actualizarStock(int codigoProducto, int unidades) {
		Optional<Producto> producto = dao.findById(codigoProducto);
		if(producto.isPresent() && producto.get().getStock() >= unidades) {
			Producto p = producto.get();
			p.setStock(p.getStock() - unidades);
			dao.save(p);
			return true;
		}
		return false;
	}

	@Override
	public double precioProducto(int codigoProducto) {
		Producto p = buscarProductoId(codigoProducto);
		if(p != null) {
			return dao.findByPrecio(codigoProducto);
		}
		return -1;
	}

	@Override
	public Producto buscarProductoId(int codigoProducto) {
		Optional<Producto> producto = dao.findById(codigoProducto);
		if (producto.isPresent()) {
			return producto.get();
		} else {
			return null;
		}
	}
	
	

}
