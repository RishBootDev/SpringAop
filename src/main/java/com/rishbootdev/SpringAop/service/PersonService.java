package com.rishbootdev.SpringAop.service;

import com.rishbootdev.SpringAop.aop.MyLogging;
import com.rishbootdev.SpringAop.model.Person;
import com.rishbootdev.SpringAop.repository.PersonRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepo repo;

    public Person addPerson(Person p){
        return repo.save(p);
    }

    @Transactional
    @MyLogging
    public List<Person> getAllPersons(){
        return repo.findAll();
    }

    public Person getById(int id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("the user does not exist"));
    }
    public void deletePerson(int id){
        repo.deleteById(id);
    }
}
