package hr.fer.zavrsni1500.itshop.repository;

import hr.fer.zavrsni1500.itshop.model.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PCRepository extends JpaRepository<PC, Long>, JpaSpecificationExecutor<PC> {
}
