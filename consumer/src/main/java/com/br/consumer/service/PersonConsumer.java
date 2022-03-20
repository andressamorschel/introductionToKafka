package com.br.consumer.service;

import com.br.consumer.domain.Person;
import com.br.consumer.service.dto.PersonRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonConsumer {

    private final ObjectMapper objectMapper;
    private final PersonService personService;

    @Value("${topic.name.consumer")
    private String topic;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    public void consume(@Payload String personMessage) {

        try {
            var person = objectMapper.readValue(personMessage, PersonRequest.class);
            personService.createPerson(person);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.info("topic: {}", topic);
        log.info("message received: {}", personMessage);
    }

}
