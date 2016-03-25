package org.priyank.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.priyank.javabrains.messenger.database.DatabaseClass;
import org.priyank.javabrains.messenger.exception.ContentNotFoundException;
import org.priyank.javabrains.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = new DatabaseClass().getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1L, "Hello", "Priyank"));
		messages.put(2L, new Message(2L, "Hello2", "Bhavin"));
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long messageId){
		Message message = messages.get(messageId);
		if(message == null) {
			throw new ContentNotFoundException("The message - "+ messageId + "is not available");
		}
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message deleteMessage(long messageId) {
		return messages.remove(messageId);
	}

	public List<Message> getAllMessagesByYear(int year) {
		List<Message> returnList = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				returnList.add(message);
			}
		}
		return returnList;
	}

	public List<Message> getAllMessagesInRange(int start, int size) {
		List<Message> messageList = new ArrayList<Message>(messages.values());
		return messageList.subList(start, start + size);
	}
}
