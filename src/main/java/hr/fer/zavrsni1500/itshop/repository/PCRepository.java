package hr.fer.zavrsni1500.itshop.repository;

import hr.fer.zavrsni1500.itshop.model.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PCRepository extends JpaRepository<PC, Long>, JpaSpecificationExecutor<PC> {
    @Query(value = "SELECT * FROM product WHERE product_type = 'PC' ORDER BY times_visited DESC LIMIT 5", nativeQuery = true)
    List<PC> findTop5ByTimesVisited();
}
