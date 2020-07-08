package com.wellington.edu.repository;

import com.wellington.edu.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class PersonSpecificQuerys {

    @Autowired
    private EntityManager entityManager;

    public List<Person> listAllWithParams(Map<String, String> params) throws IllegalArgumentException{
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        List<Predicate> predicates = new ArrayList<>();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Person> person = criteriaQuery.from(Person.class);
        params.forEach((key, value) -> {
            if(key.equals("name")){
                predicates.add(criteriaBuilder.like(person.get("name"), value+"%"));
            }
            else if(key.equals("age")){
                predicates.add(criteriaBuilder.equal(person.get("age"), Long.parseLong(value)));
            }
            else if(key.equals("profession")){
                predicates.add(criteriaBuilder.equal(person.get("profession"), value));
            }else{
                throw new IllegalArgumentException("Parametro não identificado encontrado --> " + key);
            }
        });
        criteriaQuery.select(person)
                .where(predicates.toArray(new Predicate[]{}));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
