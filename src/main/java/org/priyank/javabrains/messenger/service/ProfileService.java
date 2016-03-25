package org.priyank.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.priyank.javabrains.messenger.database.DatabaseClass;
import org.priyank.javabrains.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = new DatabaseClass().getProfiles();
	
	public ProfileService() {
		profiles.put("Priyank", new Profile(1L, "Priyank", "Priyank", "Patel", new Date(), "Priyank"));
		profiles.put("Bhavin", new Profile(2L, "Bhavin", "Bhavin", "Patel", new Date(), "Bhavin"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getId() <= 0) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile deleteProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
