package org.example.kafkacons.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.example.kafkacons.models.Userok;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserokDeserializer implements Deserializer<Userok> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Userok deserialize(String topic, byte[] payload) {
        try {
            return objectMapper.readValue(payload, Userok.class);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка десериализации объекта ", e);
        }
    }
}
