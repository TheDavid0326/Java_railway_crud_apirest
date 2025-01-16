package com.davidcastro.apirest.apirest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.davidcastro.apirest.apirest.Repositories.IProductRepository;
import com.davidcastro.apirest.apirest.Entities.Product;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping ("/products") //Define la ruta base de todas las solicitudes manejadas por este controlador. En este caso, todas las solicitudes serán prefijadas con /products.
public class ProductController {

    @Autowired
    private IProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID" + id));
        
    }
    
    
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product productToUpdate=productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID" + id));
        
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        
        return productRepository.save(productToUpdate);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        Product productToDelete=productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID" + id));
        
        productRepository.delete(productToDelete);

        return "El producto con el ID: " + id + " fue eliminado";
    }
}
