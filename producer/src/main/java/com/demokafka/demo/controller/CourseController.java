package com.demokafka.demo.controller;

import com.demokafka.demo.model.Course;
import com.demokafka.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add-course")
    public ResponseEntity<String> addCourse(@RequestBody Course course){
        String response = courseService.sendMessage(course);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


}
