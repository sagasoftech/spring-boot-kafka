package com.sagasoftech.spring.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagasoftech.spring.kafka.model.User;
import com.sagasoftech.spring.kafka.producer.JSONUserProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class JSONMeaageController {

	private JSONUserProducer kafkaProducer;

	public JSONMeaageController(JSONUserProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user){
		kafkaProducer.sendMessage(user);
		return ResponseEntity.ok("JSON message sent to Kafka Topic");
	}
}
