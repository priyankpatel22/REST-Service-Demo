package org.priyank.javabrains.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.priyank.javabrains.messenger.model.Profile;
import org.priyank.javabrains.messenger.service.ProfileService;

/**
 * 
 * CURD Operation with REST messages on the profiles information 
 * The URL will be as below
 * 
 * */

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getMessage() {
		return profileService.getAllProfiles();
	}
	
	@POST
	public Profile addMessage(Profile profile){
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateMessage(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public Profile deleteMessage(@PathParam("profileName") String profileName) {
		return profileService.deleteProfile(profileName);
	}
	
	@GET
	@Path("/{profileName}")
	public String returnMessage(@PathParam("profileName") String profileName) {
		return profileName;
	}
}
