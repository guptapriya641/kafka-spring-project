
package com.demokafka.demo.service;

import com.demokafka.demo.model.Course;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private String message;
    private final ObjectMapper objectMapper;

    public CourseService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "demokafka", groupId = "demo-group")
    public void consume(String json) {
        try {
            Course course = objectMapper.readValue(json, Course.class);

            message = course + " got the data from Kafka";

            System.out.println("Received course: " + course.getCourseId()+","+course.getTitle()+","+course.getTrainer()+","+course.getPrice());
            System.out.println("Message: " + message);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to convert JSON to Course", e);
        }
    }

    public String getMessage() {
        return message;
    }
}
