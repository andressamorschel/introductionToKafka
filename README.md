<h1 align="center">Introduction To Kafka With Spring </h1>

This repository is used to demonstrate introducing messaging using Apache Kafka with Spring. The article created referring to this repository can be found at: https:oi.com

This project consists of two applications, namely:
## Producer:
The producer is in charge of producing the messages and sending them to the topic, thus, the service that registers a person using MongoDB and sends the registered object as a message to the topic.
## Consumer:
The consumer is responsible for reading the messages stored in the topic, so this service reads the topic and stores the object, using Redis.
