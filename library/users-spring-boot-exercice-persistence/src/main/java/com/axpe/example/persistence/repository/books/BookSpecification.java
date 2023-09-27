package com.axpe.example.persistence.repository.books;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.axpe.example.persistence.entities.Book;

public class BookSpecification implements Specification<Book> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String OPERADOR_LIKE = "%";
	private String name;
    private String author;
    private String category;

    public BookSpecification(String name, String author, String category) {
        this.name = name;
        this.author = author;
        this.category = category;
    }

	@Override
	public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(criteriaBuilder.like(root.get("name"), OPERADOR_LIKE + name + OPERADOR_LIKE));
        }

        if (author != null) {
            predicates.add(criteriaBuilder.like(root.get("author"), OPERADOR_LIKE + author + OPERADOR_LIKE));
        }

        if (category != null) {
            predicates.add(criteriaBuilder.like(root.get("category"), OPERADOR_LIKE + category + OPERADOR_LIKE));
        }
        
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	}
	
}
