package com.org.prj.customer.service.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.org.prj.customer.repository.entity.Login;
import com.org.prj.customer.service.model.EmployerSearchRequest;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EmployerSpecification implements Specification<Login> {
	private static final long serialVersionUID = 1L;

	private final EmployerSearchRequest employerSearchRequest;

	public EmployerSpecification(EmployerSearchRequest employerSearchRequest) {
		this.employerSearchRequest = employerSearchRequest;
	}

	@Override
	public Predicate toPredicate(Root<Login> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();
		if (employerSearchRequest.idFilteringRequired()) {
			predicates.add(criteriaBuilder.equal(root.get("id"), employerSearchRequest.getId()));
		}
		if (employerSearchRequest.contactNoFilteringRequired()) {
			predicates.add(criteriaBuilder.equal(root.get("contactNo"), employerSearchRequest.getContactNo()));
		}
		if (employerSearchRequest.companyNameFilteringRequired()) {
			predicates.add(criteriaBuilder.like(root.get("companyName"), employerSearchRequest.getCompanyName() + "%"));
		}
		if (employerSearchRequest.emailFilteringRequired()) {
			predicates.add(criteriaBuilder.like(root.get("email"), employerSearchRequest.getEmail() + "%"));
		}

		return andTogether(predicates, criteriaBuilder);
	}

	private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
		return cb.and(predicates.toArray(new Predicate[0]));
	}
}