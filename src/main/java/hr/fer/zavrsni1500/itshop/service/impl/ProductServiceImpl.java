package hr.fer.zavrsni1500.itshop.service.impl;

import hr.fer.zavrsni1500.itshop.dto.ProductDto;
import hr.fer.zavrsni1500.itshop.model.Product;
import hr.fer.zavrsni1500.itshop.repository.ProductRepository;
import hr.fer.zavrsni1500.itshop.service.ProductService;
import hr.fer.zavrsni1500.itshop.util.mapper.ProductMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDto getProductById(final Long id) {
        final Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product with ID(%d) not found!", id)));

        return productMapper.productToProductDto(product);
    }

    public List<ProductDto> getAllProducts() {
        final List<Product> products = productRepository.findAll();
        return productMapper.productsToProductDtos(products);
    }

    public void deleteProduct(final Long id) {
        final Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product with ID(%d) not found!", id)));
        productRepository.delete(product);
    }
}
