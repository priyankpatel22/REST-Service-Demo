package org.priyank.javabrains.messenger.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.priyank.javabrains.messenger.model.Message;
import org.priyank.javabrains.messenger.service.MessageService;


/**
 * 
 * CURD Operation with REST messages on the message information 
 * The URL will be as below
 * 'http://localhost:8080/messenger/webapi/{any_message_infoamtion}'
 * 
 * */

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class messageResource {
	
	MessageService messageService = new MessageService();
	
	/**
	 * Use of HTTP GET method to access data
	 * Also use of Bean Parameter passes in the URL to access particular information from the BEan class
	 * Here the BEan class will contain all the Query Parameters
	 * 
	 * @param prameterBean - The bean will contain all the Query parameter Getters and Setters
	 * */
	
	@GET
	public List<Message> getMessage(@BeanParam PrameterBean prameterBean) {
		if(prameterBean.getYear() > 0) {
			return messageService.getAllMessagesByYear(prameterBean.getYear());
		}
		if(prameterBean.getStart() >= 0 && prameterBean.getSize() > 0) {
			return messageService.getAllMessagesInRange(prameterBean.getStart(), prameterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@POST
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") long messageId) {
		return messageService.deleteMessage(messageId);
	}
	
	@GET
	@Path("/{messageId}")
	public Message returnMessage(@PathParam("messageId") long messageId) {
		return messageService.getMessage(messageId);
	}
	
	/**
	 * Very important method
	 * How you forward information from message URL to comments for that particular message
	 * e.g. URL: 'http://localhost:8080/messenger/webapi/messages/{any_comment_information}'
	 * The method will instantiate Comment class object if any comment information is provided 
	 * in the URL
	 * 
	 * */
	
	@GET
	@Path("/{messageId}/coments")
	public CommentResource extendedCommentPathCall() {
		return new CommentResource();
	}
}
