package org.priyank.javabrains.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.priyank.javabrains.messenger.model.Message;
import org.priyank.javabrains.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
