package hr.fer.zavrsni1500.itshop.repository;

import hr.fer.zavrsni1500.itshop.model.PCPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PCPartRepository extends JpaRepository<PCPart, Long>, JpaSpecificationExecutor<PCPart> {
}
