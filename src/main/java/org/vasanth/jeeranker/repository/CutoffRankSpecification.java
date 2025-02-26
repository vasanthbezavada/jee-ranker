package org.vasanth.jeeranker.repository;

import jakarta.persistence.criteria.*;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.vasanth.jeeranker.dto.SearchFilter;
import org.vasanth.jeeranker.dto.SearchOperator;
import org.vasanth.jeeranker.model.CutoffRank;

public class CutoffRankSpecification implements Specification<CutoffRank> {

  private final List<SearchFilter> searchFilters;

  public CutoffRankSpecification(List<SearchFilter> searchFilters) {
    super();
    this.searchFilters = searchFilters;
  }

  @Override
  public Predicate toPredicate(
      Root<CutoffRank> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    Predicate predicate = criteriaBuilder.conjunction();

    for (SearchFilter criteria : searchFilters) {
      String key = criteria.getSearchKey();
      Object value = criteria.getValue();
      SearchOperator operator = criteria.getOperator();
      if (key == null || operator == null) {
        continue;
      }
      Expression<String> path = root.get(key).as(String.class); // Convert to String for LIKE

      predicate =
          switch (operator) {
            case EQUAL ->
                criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get(key), value));
            case NOT_EQUAL ->
                criteriaBuilder.and(predicate, criteriaBuilder.notEqual(root.get(key), value));
            case CONTAINS ->
                criteriaBuilder.and(predicate, criteriaBuilder.like(path, "%" + value + "%"));
            case DOES_NOT_CONTAIN ->
                criteriaBuilder.and(predicate, criteriaBuilder.notLike(path, "%" + value + "%"));
            case BEGINS_WITH ->
                criteriaBuilder.and(predicate, criteriaBuilder.like(path, value + "%"));
            case DOES_NOT_BEGIN_WITH ->
                criteriaBuilder.and(predicate, criteriaBuilder.notLike(path, value + "%"));
            case ENDS_WITH ->
                criteriaBuilder.and(predicate, criteriaBuilder.like(path, "%" + value));
            case DOES_NOT_END_WITH ->
                criteriaBuilder.and(predicate, criteriaBuilder.notLike(path, "%" + value));
            case GREATER_THAN ->
                criteriaBuilder.and(
                    predicate, criteriaBuilder.greaterThan(root.get(key), value.toString()));
            case GREATER_THAN_EQUAL ->
                criteriaBuilder.and(
                    predicate,
                    criteriaBuilder.greaterThanOrEqualTo(root.get(key), value.toString()));
            case LESS_THAN ->
                criteriaBuilder.and(
                    predicate, criteriaBuilder.lessThan(root.get(key), value.toString()));
            case LESS_THAN_EQUAL ->
                criteriaBuilder.and(
                    predicate, criteriaBuilder.lessThanOrEqualTo(root.get(key), value.toString()));
            case NULL -> criteriaBuilder.and(predicate, criteriaBuilder.isNull(root.get(key)));
            case NOT_NULL ->
                criteriaBuilder.and(predicate, criteriaBuilder.isNotNull(root.get(key)));
            default -> throw new UnsupportedOperationException("Unsupported operator: " + operator);
          };
    }
    return predicate;
  }
}
