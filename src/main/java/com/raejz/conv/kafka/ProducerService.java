package com.raejz.conv.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raejz.conv.api.word.NumberInWord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @Value("${spring.kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Async
    public void sendMessage(NumberInWord message) {
        logger.info(String.format("$$ -> Producing message --> %s" ,message));

        try {
            kafkaTemplate.send(topic, objectMapper.writeValueAsString(message));
        } catch (Exception e) {
            logger.error("Unable to send message to Kafka", e);
        }

    }
}
