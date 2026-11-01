package com.demokafka.demo.service;

import com.demokafka.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class CourseService {

    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public CourseService(
            KafkaTemplate<String, String> kafkaTemplate,
            ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendMessage(Course course) {
        String json = objectMapper.writeValueAsString(course);

        kafkaTemplate.send("demokafka", "course", json);

        return "Course message sent successfully";
    }
}

