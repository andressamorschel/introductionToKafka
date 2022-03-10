package com.br.producer.service;

import com.br.producer.domain.Person;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    @Value("${topic.name.producer}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendPerson(Person person) {
        Gson gson = new Gson();
        log.info("event published {}", person);
        kafkaTemplate.send(topic, gson.toJson(person));
    }

}
