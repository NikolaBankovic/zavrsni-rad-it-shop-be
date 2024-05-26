package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.model.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);
    List<Product> getAllProducts();
    void deleteProduct(Long id);
}
