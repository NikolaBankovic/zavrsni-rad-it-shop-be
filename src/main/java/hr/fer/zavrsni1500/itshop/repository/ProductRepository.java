package hr.fer.zavrsni1500.itshop.repository;

import hr.fer.zavrsni1500.itshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Query(value = "SELECT DISTINCT d_type FROM product", nativeQuery = true)
    List<String> findAllDistinctDTypes();
}
