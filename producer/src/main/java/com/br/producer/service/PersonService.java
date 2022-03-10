package com.br.producer.service;

import com.br.producer.controller.dto.PersonRequest;
import com.br.producer.controller.dto.PersonResponse;
import com.br.producer.data.PersonRepository;
import com.br.producer.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final EventService eventService;

    public PersonResponse createPerson(PersonRequest request) {
        var person = Person.builder()
                .personId(UUID.randomUUID().toString())
                .name(request.getName())
                .profession(request.getProfession())
                .age(request.getAge())
                .build();

        personRepository.save(person);
        eventService.sendPerson(person);

        return PersonResponse.builder()
                .personId(person.getPersonId())
                .name(person.getName())
                .profession(person.getProfession())
                .age(person.getAge())
                .build();
    }

    public List<PersonResponse> findAllPeople() {
        var people = personRepository.findAll();
        return people.stream().map(PersonService::convertToResponse).collect(Collectors.toList());
    }

    private static PersonResponse convertToResponse(Person person) {
        return PersonResponse.builder()
                .age(person.getAge())
                .personId(person.getPersonId())
                .name(person.getName())
                .profession(person.getProfession())
                .build();
    }

}
