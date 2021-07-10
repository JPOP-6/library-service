package com.library.service.system.kafkalistener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Service
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "BookServiceTopic", groupId = "group_id")
    public void get(ConsumerRecord<String, String> record){
        System.out.println("MESSAGE RECEIVED --------------------------" + record.value());
    }
}
