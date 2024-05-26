package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.model.Product;
import hr.fer.zavrsni1500.itshop.repository.ProductRepository;
import hr.fer.zavrsni1500.itshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Product with ID(%d) not found!", id)));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Product with ID(%d) not found!", id)));
        productRepository.delete(product);
    }

}