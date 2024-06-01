package com.rubenrdc.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rubenrdc.apirest.Repositories.ProductoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.rubenrdc.apirest.Entities.Producto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productRep;

    ////

    @GetMapping("/api/products")
    public List<Producto> getAllProducts() {
        return productRep.findAll();
    }

    @GetMapping("/api/products/{id}")
    public Producto getProductById(@PathVariable Long id) {
        Producto product = productRep.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encuentra el producto con el ID: " + id));
        /*
         * Objeto.(Metodo o Funcion(parametro)).metodo(retorno del metodo -> accion con
         * o sin el objeto o valor retornado);
         */

        return product;
    }

    @PostMapping("/api/saveproducts")
    public Producto saveProduct(@RequestBody Producto productObtenido) {
        return productRep.save(productObtenido);
    }

    @PutMapping("/api/updateproducts/{id}")
    public Producto UpdateProduct(@PathVariable Long id, @RequestBody Producto productObtenido) {
        Producto product = productRep.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encuentra el producto con el ID: " + id));

        product.setNombre(productObtenido.getNombre());
        product.setPrecio(productObtenido.getPrecio());

        return productRep.save(product);
    }

    @DeleteMapping("/api/updateproducts/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Producto product = productRep.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encuentra el producto con el ID: " + id));
        productRep.delete(product);


        return "El producto con el ID: "+id+" se elimino de manera exitosa.";
    }
}
