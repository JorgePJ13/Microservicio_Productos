package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductosService;

@CrossOrigin("*")
@RestController
public class ProductosController {

	@Autowired
	ProductosService service;

	@GetMapping(value = "Productos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> listaProductos() {
		return service.productos();
	}

	@GetMapping(value = "Producto/{codigoProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public double precioProducto(@PathVariable("codigoProducto") int codigoProducto) {
		return service.precioProducto(codigoProducto);
	}

	@PutMapping(value = "Producto/{codigoProducto}/{unidades}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String modificarProducto(@PathVariable("codigoProducto") int codigoProducto,
			@PathVariable("unidades") int unidades) {
		return String.valueOf(service.actualizarStock(codigoProducto, unidades));
	}
}
