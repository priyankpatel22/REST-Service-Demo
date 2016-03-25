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

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class messageResource {
	
	MessageService messageService = new MessageService();
	
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
	
	@GET
	@Path("/{messageId}/coments")
	public CommentResource extendedCommentPathCall() {
		return new CommentResource();
	}
}
