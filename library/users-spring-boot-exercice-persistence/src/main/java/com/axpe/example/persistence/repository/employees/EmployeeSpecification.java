package com.axpe.example.persistence.repository.employees;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.axpe.example.persistence.entities.Employee;

public class EmployeeSpecification implements Specification<Employee> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String nif;
    private String status;

    public EmployeeSpecification(String name, String nif, String status) {
        this.name = name;
        this.nif = nif;
        this.status = status;
    }

	@Override
	public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(criteriaBuilder.equal(root.get("name"), name));
        }

        if (nif != null) {
            predicates.add(criteriaBuilder.equal(root.get("nif"), nif));
        }

        if (status != null) {
            predicates.add(criteriaBuilder.equal(root.get("status"), status));
        }
        
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	}
	
}
