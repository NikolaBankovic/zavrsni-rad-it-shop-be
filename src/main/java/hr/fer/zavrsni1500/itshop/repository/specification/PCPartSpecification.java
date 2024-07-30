package hr.fer.zavrsni1500.itshop.repository.specification;

import hr.fer.zavrsni1500.itshop.model.PCPart;
import hr.fer.zavrsni1500.itshop.dto.filter.PCPartFilter;
import hr.fer.zavrsni1500.itshop.model.PCPartType;
import jakarta.persistence.criteria.*;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PCPartSpecification extends ProductSpecification<PCPart> {

    private final PCPartFilter filter;

    public PCPartSpecification(final PCPartFilter filter) {
        super(filter);
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(
            @NonNull final Root<PCPart> root,
            @NonNull final CriteriaQuery<?> query,
            @NonNull final CriteriaBuilder criteriaBuilder) {

        final Predicate predicate = super.toPredicate(root, query, criteriaBuilder);

        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(predicate);

        final Join<PCPart, PCPartType> pcPartTypeJoin = root.join("pcPartType");

        if (filter.getPcPartType() != null) {
            predicates.add(criteriaBuilder.equal(pcPartTypeJoin.get("typeName"), filter.getPcPartType()));
        }
        if (filter.getUsedState() != null) {
            predicates.add(criteriaBuilder.equal(root.get("usedState"), filter.getUsedState()));
        }
        if (filter.getWarrantyLength() != null) {
            predicates.add(criteriaBuilder.equal(root.get("warrantyLength"), filter.getWarrantyLength()));
        }
        if (filter.getManufacturerName() != null && !filter.getManufacturerName().isEmpty()) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("manufacturerName")), "%" + filter.getManufacturerName().toLowerCase() + "%"));
        }
        if (filter.getManufacturerCatalogueNumber() != null) {
            predicates.add(criteriaBuilder.equal(root.get("manufacturerCatalogueNumber"), filter.getManufacturerCatalogueNumber()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
