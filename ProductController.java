
package com.example.productcatalog.controller;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.model.InventorySummary;
import com.example.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) String category,
                                     @RequestParam(required = false) Double price,
                                     @RequestParam(required = false) String sort) {
        return productService.getAllProducts(category, price, sort);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/inventory-summary")
    public InventorySummary getInventorySummary() {
        return productService.getInventorySummary();
    }
}
