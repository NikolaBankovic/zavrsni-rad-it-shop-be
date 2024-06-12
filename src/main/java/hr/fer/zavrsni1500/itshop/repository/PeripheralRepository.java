package hr.fer.zavrsni1500.itshop.repository;

import hr.fer.zavrsni1500.itshop.model.Peripheral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PeripheralRepository extends JpaRepository<Peripheral, Long>, JpaSpecificationExecutor<Peripheral> {
    @Query(value = "SELECT * FROM product WHERE product_type = 'PERIPHERAL' ORDER BY times_visited DESC LIMIT 5", nativeQuery = true)
    List<Peripheral> findTop5ByTimesVisited();
}
