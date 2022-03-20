package com.br.producer.controller;

import com.br.producer.controller.dto.PersonRequest;
import com.br.producer.domain.Person;
import com.br.producer.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody PersonRequest request) {
        return personService.createPerson(request);
    }

    @GetMapping
    public List<Person> findAllPeople() {
        return personService.findAllPeople();
    }
}
