package com.rishbootdev.SpringAop.controller;

import com.rishbootdev.SpringAop.model.Person;
import com.rishbootdev.SpringAop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService serv;

    @GetMapping("/{id}")
    public Person getById(@PathVariable int id) {
        return serv.getById(id);
    }

    @GetMapping
    public List<Person> getAll() {
        return serv.getAllPersons();
    }

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person p) {
        return serv.addPerson(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable int id) {
        serv.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
