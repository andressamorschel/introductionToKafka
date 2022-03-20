<h1 align="center">Introduction To Kafka With Spring </h1>

## 💡Description
This repository is used to demonstrate introducing messaging using Apache Kafka with Spring. The article created referring to this repository can be found at: https://www.seguroviagem.srv.br/

This project consists of two applications, namely:
### Producer:
The producer is in charge of producing the messages and sending them to the topic, thus, the service that registers a person using MongoDB and sends the registered object as a message to the topic.
### Consumer:
The consumer is responsible for reading the messages stored in the topic, so this service reads the topic and stores the object, using Redis.
## 💻Prerequisites to run the application:
- Docker
- Java v17
- Gradle v7.1.4
## 🛠️ Open and run the project:
- Clone the repository:
```bash
$ git clone https://github.com/andressamorschel/introductionToKafka.git
```
- In the root directory, lift the docker container:
```bash
$ docker-compose up
```
- Go to the directory of one of the services and start:
```bash
$ gradle bootrun
```
<h4 align="center">Developed by Andressa Morschel👩‍💻</h4>
