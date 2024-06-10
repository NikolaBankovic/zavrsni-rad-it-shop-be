package hr.fer.zavrsni1500.itshop.repository.specification;

import hr.fer.zavrsni1500.itshop.model.PC;
import hr.fer.zavrsni1500.itshop.dto.filter.PCFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PCSpecification extends ProductSpecification<PC> {

    private final PCFilter filter;

    public PCSpecification(final PCFilter filter) {
        super(filter);
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(
            @NonNull final Root<PC> root,
            @NonNull final CriteriaQuery<?> query,
            @NonNull final CriteriaBuilder criteriaBuilder) {

        final Predicate predicate = super.toPredicate(root, query, criteriaBuilder);

        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(predicate);

        if (filter.getPcType() != null) {
            predicates.add(criteriaBuilder.equal(root.get("pcType"), filter.getPcType()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
