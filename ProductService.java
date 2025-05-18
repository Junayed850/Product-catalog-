
package com.example.productcatalog.service;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.model.InventorySummary;
import com.example.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(String category, Double price, String sort) {
        if (category != null) return productRepository.findByCategory(category);
        if (price != null) return productRepository.findByPriceLessThanEqual(price);
        if ("asc".equalsIgnoreCase(sort)) return productRepository.findAllByOrderByPriceAsc();
        if ("desc".equalsIgnoreCase(sort)) return productRepository.findAllByOrderByPriceDesc();
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productDetails.getName());
        product.setCategory(productDetails.getCategory());
        product.setPrice(productDetails.getPrice());
        product.setAvailableQuantity(productDetails.getAvailableQuantity());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public InventorySummary getInventorySummary() {
        List<Product> all = productRepository.findAll();
        int totalProducts = all.size();
        int totalStock = all.stream().mapToInt(Product::getAvailableQuantity).sum();
        return new InventorySummary(totalProducts, totalStock);
    }
}
