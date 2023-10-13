package com.example.springbootkafkatutorial.controller;

import com.example.springbootkafkatutorial.payload.User;
import com.example.springbootkafkatutorial.publisher.KafkaJsonProducer;
import com.example.springbootkafkatutorial.publisher.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private KafkaJsonProducer kafkaJsonProducer;

    // http://localhost:8080/api/v1/kafka/publish?message=url_send_message
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

    // http://localhost:8080/api/v1/kafka/publish
    @PostMapping("/publish")
    public ResponseEntity<String> publishJson(@RequestBody User user) {
        kafkaJsonProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message sent to the topic");
    }
}
