package com.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.model.Message;

@RestController
public class RestDemo {

	@CrossOrigin
	@GetMapping("/messages")
	public List<Message> getMessages() {
		List<Message> messages = new ArrayList<>();
		Message m = new Message();
		m.setName("Joe");
		m.setContent("Welcome to Spring");
		messages.add(m);
		Message m1 = new Message();
		m1.setName("Lisley");
		m1.setContent("Welcome to Spring with React");
		messages.add(m1);
		return messages;
	}
}
