package com.sagasoftech.spring.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.sagasoftech.spring.kafka.model.User;

@Service
public class JSONUserProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JSONUserProducer.class);
	
	private KafkaTemplate<String, User> kafkaTemplate;

	public JSONUserProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User data) {
		
		LOGGER.info(String.format("Message sent : %s", data.toString()));
		
		Message<User> message = MessageBuilder
				.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, "javaguides")
				.build();
		
		kafkaTemplate.send(message);
	}
	
	
}
