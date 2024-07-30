package hr.fer.zavrsni1500.itshop.repository.specification;

import hr.fer.zavrsni1500.itshop.model.Peripheral;
import hr.fer.zavrsni1500.itshop.dto.filter.PeripheralFilter;
import hr.fer.zavrsni1500.itshop.model.PeripheralType;
import jakarta.persistence.criteria.*;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PeripheralSpecification extends ProductSpecification<Peripheral> {

    private final PeripheralFilter filter;

    public PeripheralSpecification(final PeripheralFilter filter) {
        super(filter);
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(
            @NonNull final Root<Peripheral> root,
            @NonNull final CriteriaQuery<?> query,
            @NonNull final CriteriaBuilder criteriaBuilder) {

        final Predicate predicate = super.toPredicate(root, query, criteriaBuilder);

        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(predicate);

        final Join<Peripheral, PeripheralType> peripheralTypeJoin = root.join("peripheralType");

        if (filter.getPeripheralType() != null) {
            predicates.add(criteriaBuilder.equal(peripheralTypeJoin.get("typeName"), filter.getPeripheralType()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
