package com.sagasoftech.spring.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sagasoftech.spring.kafka.model.User;

@Service
public class JSONKafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JSONKafkaConsumer.class);

	@KafkaListener(topics= "javaguides_json", groupId = "myGroup")
	public void consume(User user) {
		LOGGER.info(String.format("Message is received -> %s ", user.toString()));
	}
}
