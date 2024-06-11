package hr.fer.zavrsni1500.itshop.repository;

import hr.fer.zavrsni1500.itshop.model.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SoftwareRepository extends JpaRepository<Software, Long>, JpaSpecificationExecutor<Software> {
    @Query(value = "SELECT * FROM product WHERE product_type = 'SOFTWARE' ORDER BY times_visited DESC LIMIT 5", nativeQuery = true)
    List<Software> findTop5ByTimesVisited();
}
