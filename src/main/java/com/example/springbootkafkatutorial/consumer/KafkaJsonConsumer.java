package com.example.springbootkafkatutorial.consumer;

import com.example.springbootkafkatutorial.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "${kafka.topic.json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(User user) {
        LOGGER.info(String.format("Json message received -> %s", user.toString()));
    }
}
