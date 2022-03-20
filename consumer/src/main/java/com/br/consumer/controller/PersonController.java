package com.br.consumer.controller;

import com.br.consumer.domain.Person;
import com.br.consumer.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/consumer/people")
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public Iterable<Person> findAll(){
        return personService.findAll();
    }
}
