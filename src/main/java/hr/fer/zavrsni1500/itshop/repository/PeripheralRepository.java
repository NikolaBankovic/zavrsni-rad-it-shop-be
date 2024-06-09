package hr.fer.zavrsni1500.itshop.repository;

import hr.fer.zavrsni1500.itshop.model.Peripheral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PeripheralRepository extends JpaRepository<Peripheral, Long>, JpaSpecificationExecutor<Peripheral> {
}
