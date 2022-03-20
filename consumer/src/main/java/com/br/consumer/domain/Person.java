package com.br.consumer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@RedisHash("Person")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String id;

    private String name;

    private int age;

    private String profession;
}
