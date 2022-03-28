package com.br.producer.service;

import com.br.producer.controller.dto.PersonRequest;
import com.br.producer.data.PersonRepository;
import com.br.producer.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final EventService eventService;

    public Person createPerson(PersonRequest request) {
        var person = Person.builder()
                .name(request.getName())
                .profession(request.getProfession())
                .age(request.getAge())
                .build();

        personRepository.save(person);
        eventService.sendPerson(person);

        return Person.builder()
                .name(person.getName())
                .profession(person.getProfession())
                .age(person.getAge())
                .build();
    }

    public List<Person> findAllPeople() {
        return personRepository.findAll();
    }

}
