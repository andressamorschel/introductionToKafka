package com.br.consumer.service;

import com.br.consumer.data.PersonRepository;
import com.br.consumer.domain.Person;
import com.br.consumer.service.dto.PersonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Iterable<Person> findAll(){
        return personRepository.findAll();
    }

    public void createPerson(PersonRequest request){
        var person = Person.builder()
                .age(request.getAge())
                .name(request.getName())
                .profession(request.getProfession())
                .build();
        personRepository.save(person);
    }
}
