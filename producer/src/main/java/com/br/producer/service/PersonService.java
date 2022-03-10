package com.br.producer.service;

import com.br.producer.controller.dto.PersonRequest;
import com.br.producer.controller.dto.PersonResponse;
import com.br.producer.data.PersonRepository;
import com.br.producer.domain.Person;
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

    public PersonResponse createPerson(PersonRequest request){
        var person = Person.builder()
                .personId(UUID.randomUUID().toString())
                .name(request.getName())
                .profession(request.getProfession())
                .age(request.getAge())
                .build();

        personRepository.save(person);

        return PersonResponse.builder()
                .personId(person.getPersonId())
                .name(person.getName())
                .profession(person.getProfession())
                .age(person.getAge())
                .build();
    }

    public List<PersonResponse> findAllPeople(){
        var people = personRepository.findAll();
        return people.stream().map(x -> {
            var oi = PersonResponse.builder().age(x.getAge()).build();
        log.info("oi {}", oi);
            return oi;
        }).collect(Collectors.toList());

    }

}
