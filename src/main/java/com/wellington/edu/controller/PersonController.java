package com.wellington.edu.controller;

import com.wellington.edu.model.Person;
import com.wellington.edu.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/find")
    public ResponseEntity<Object> getPersons(@RequestParam Map<String,String> searchParams){
        try {
            return ResponseEntity.ok(this.personService.listPersonWithParams(searchParams));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = {"/insert", "/update"})
    public ResponseEntity<Object> updatePerson(@RequestBody Person person){
        try {
            return ResponseEntity.ok(this.personService.savePerson(person));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
