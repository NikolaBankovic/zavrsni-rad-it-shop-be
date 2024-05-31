package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.model.Product;
import hr.fer.zavrsni1500.itshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable final Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteProduct(@PathVariable final Long id) {
        productService.deleteProduct(id);
    }
}
