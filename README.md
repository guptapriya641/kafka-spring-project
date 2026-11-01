# Spring Boot Kafka Producer and Consumer

A demonstration project integrating Apache Kafka with Spring Boot using separate Producer and Consumer applications.

## Project Structure

- `producer` – Sends Course messages to Kafka.
- `consumer` – Receives and processes Kafka messages.

## Technologies

- Java 17
- Spring Boot 4.1.2
- Spring Kafka 4.1.2
- Apache Kafka
- Maven
- JSON Serialization and Deserialization

## Kafka Configuration

- Bootstrap Server: `localhost:9092`
- Topic: `demokafka`
- Consumer Group: `demo-group`

## Application Ports

| Application | Port |
|---|---:|
| Producer | 8081 |
| Consumer | 8082 |

## How to Run

1. Start the Kafka broker.
2. Start the Producer application.
3. Start the Consumer application.
4. Send a Course message through the Producer API.
5. Verify that the Consumer receives the message.

## Purpose

This project demonstrates asynchronous communication between independent Spring Boot applications using Apache Kafka.
