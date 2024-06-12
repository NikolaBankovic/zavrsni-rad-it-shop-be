package hr.fer.zavrsni1500.itshop.repository;

import hr.fer.zavrsni1500.itshop.model.PCPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PCPartRepository extends JpaRepository<PCPart, Long>, JpaSpecificationExecutor<PCPart> {
    @Query(value = "SELECT * FROM product WHERE product_type = 'PC_PART' ORDER BY times_visited DESC LIMIT 5", nativeQuery = true)
    List<PCPart> findTop5ByTimesVisited();
}
