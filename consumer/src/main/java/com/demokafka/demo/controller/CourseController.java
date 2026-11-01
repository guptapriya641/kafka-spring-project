package com.demokafka.demo.controller;

import com.demokafka.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/get-course")
    public ResponseEntity<String> getCourse(){
        String response = courseService.getMessage();
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


}
