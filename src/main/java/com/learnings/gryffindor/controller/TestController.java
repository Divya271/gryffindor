package com.learnings.gryffindor.controller;

import com.learnings.gryffindor.utils.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    private final PropertiesUtil propertiesUtil;

    public TestController(PropertiesUtil propertiesUtil) {
        this.propertiesUtil = propertiesUtil;
    }

    @GetMapping(value = "kafkaTest")
    ResponseEntity<String> test(@RequestParam String message) {
        kafkaTemplate.send(propertiesUtil.kafkaTestTopic, message);
        return ResponseEntity.status(200).build();
    }
}
