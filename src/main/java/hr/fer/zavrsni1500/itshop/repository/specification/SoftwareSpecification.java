package hr.fer.zavrsni1500.itshop.repository.specification;

import hr.fer.zavrsni1500.itshop.model.Software;
import hr.fer.zavrsni1500.itshop.dto.filter.SoftwareFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class SoftwareSpecification extends ProductSpecification<Software> {

    private final SoftwareFilter filter;

    public SoftwareSpecification(final SoftwareFilter filter) {
        super(filter);
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(
            @NonNull final Root<Software> root,
            @NonNull final CriteriaQuery<?> query,
            @NonNull final CriteriaBuilder criteriaBuilder) {

        final Predicate predicate = super.toPredicate(root, query, criteriaBuilder);

        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(predicate);

        if (filter.getSoftwareType() != null) {
            predicates.add(criteriaBuilder.equal(root.get("softwareType"), filter.getSoftwareType()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
