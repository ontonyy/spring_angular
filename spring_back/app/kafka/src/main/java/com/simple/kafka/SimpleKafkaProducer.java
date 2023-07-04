package com.simple.main.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simple.main.exception.SimpleException;
import com.simple.main.models.responses.SimpleResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class SimpleKafkaProducer {
    private final KafkaTemplate<String, byte[]> kafkaTemplate;
    private final SimpleKafkaProperties simpleKafkaProperties;
    private final ObjectMapper objectMapper;

    public void sendMessage(final SimpleResponse simpleResponse) {
        final byte[] payload = convertObjectToBytes(simpleResponse);
        final Message<byte[]> message = MessageBuilder
                                        .withPayload(payload)
                                        .setHeader("kafka_topic", simpleKafkaProperties.getName())
                                        .build();
        kafkaTemplate.send(message);
    }

    private byte[] convertObjectToBytes(final SimpleResponse simpleResponse) {
        try {
            return objectMapper.writeValueAsBytes(simpleResponse);
        } catch (JsonProcessingException ex) {
            log.error("Cannot be serialized to bytes: {}", simpleResponse, ex);
            throw new SimpleException(ex);
        }
    }
}
