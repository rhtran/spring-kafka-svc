package com.raejz.conv.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raejz.conv.api.word.InputNumber;
import com.raejz.conv.api.word.NumberToWordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    private NumberToWordService numberToWordService;

    @Autowired
    private ProducerService producerService;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "number-topic")
    public void receive(String payload) throws Exception {
        LOGGER.info("received payload='{}'", payload);
        InputNumber number = objectMapper.readValue(payload, InputNumber.class);
        producerService.sendMessage(numberToWordService.toWords(number.getNumber()));
    }
}
