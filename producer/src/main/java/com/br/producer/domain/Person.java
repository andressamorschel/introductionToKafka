package com.br.producer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    private String id;

    private String name;

    private int age;

    private String profession;
}
