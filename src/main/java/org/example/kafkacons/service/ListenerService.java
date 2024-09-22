package org.example.kafkacons.service;

import lombok.extern.slf4j.Slf4j;
import org.example.kafkacons.models.Userok;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class ListenerService {

    private List<Userok> userokList = new ArrayList<>();

    @KafkaListener(
            topics = "topic-1",
            groupId = "my-group",
            containerFactory = "kafkaListenerContainerFactory")
    void listener(Userok userok) {
        log.info("Received message [{}] ", userok);
        userokList.add(userok);
        System.out.println(userokList);
    }

    @KafkaHandler(isDefault = true)
    public void handleUnknown(Object object) {
        System.out.println("Unknown type received: " + object);
    }
}
