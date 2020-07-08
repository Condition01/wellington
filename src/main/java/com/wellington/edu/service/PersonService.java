package com.wellington.edu.service;

import com.wellington.edu.model.Person;
import com.wellington.edu.repository.PersonRepository;
import com.wellington.edu.repository.PersonSpecificQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonSpecificQuerys personSpecificQuerys;

    public List<Person> listAllPersons(){
        return this.personRepository.findAll();
    }

    public List<Person> listPersonWithParams(Map<String, String> params) throws IllegalArgumentException{
        if(params.size() == 0){
            return this.listAllPersons();
        }else{
            return personSpecificQuerys.listAllWithParams(params);
        }
    }

    public Person savePerson(Person person){
        return this.personRepository.save(person);
    }

    public Person getPerson(long id) throws Exception{
        Optional<Person> personOptional = personRepository.findById(id);
        if(personOptional.isPresent()){
            return personOptional.get();
        }else{
            throw new Exception("Pessoa não encontrada");
        }
    }

}
