package com.example.springbootkafkatutorial.publisher;

import com.example.springbootkafkatutorial.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Value("${kafka.topic.json.name}")
    private String topicKafka;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {
        LOGGER.info(String.format("Sent user: %s", user));
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, topicKafka)
                .build();

        kafkaTemplate.send(message);
    }
}
