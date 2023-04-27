package com.example.javadata.repository;

import com.example.javadata.entity.Contact;
import com.example.javadata.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PersonRepository {
    @PersistenceContext
    EntityManager entityManager;

    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        putValues();
    }

    public String getPersons(String city) {
        return city;
    }


    @Transactional
    public void putValues() {
        Person person1 = new Person();
        person1.setPerson("Sabir", "Lord", 25);
        Person person2 = new Person();
        person2.setPerson("Sophi", "Got", 50);
        Person person3 = new Person();
        person3.setPerson("Lina", "Eat", 10);

        List<Contact> contacts = new ArrayList<>();

        contacts.add(Contact.builder()
                .person(person1)
                .phoneNumber("12345543210")
                .cityOfLiving("Moscow")
                .build());

        contacts.add(Contact.builder()
                .person(person2)
                .phoneNumber("99999999999")
                .cityOfLiving("Moscow")
                .build());

        contacts.add(Contact.builder()
                .person(person2)
                .phoneNumber("66666666666")
                .cityOfLiving("Moscow")
                .build());

        contacts.forEach(contact -> entityManager.persist(contact));
    }
}
