package com.example.javadata.service;

import com.example.javadata.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public String getPersonsByCity(String city) {
        return repository.getPersons(city);
    }
}
