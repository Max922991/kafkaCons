package org.example.kafkacons.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ListenerService {

    @KafkaListener(
            topics = "topic-1",
            groupId = "my-group"
    )
    void listener(Object o) {
        log.info("Received message [{}] ", o);
    }

}
