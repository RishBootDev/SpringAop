package com.rishbootdev.SpringAop.repository;

import com.rishbootdev.SpringAop.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person,Integer> {
}
