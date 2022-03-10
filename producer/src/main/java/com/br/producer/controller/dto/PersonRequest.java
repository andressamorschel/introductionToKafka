package com.br.producer.controller.dto;

import lombok.Data;

@Data
public class PersonRequest {

    private String personId;

    private String name;

    private int age;

    private String profession;

}
