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

import org.priyank.javabrains.messenger.model.Comment;
import org.priyank.javabrains.messenger.service.CommentService;

/**
 * 
 * CURD Operation with REST messages on the comments information 
 * for a particular message
 * The URL will be continuation for the Message URL below
 * 'http://localhost:8080/messenger/webapi/messages/{any_comment_information}'
 * 
 * */

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService commentService = new CommentService();
	
	/**
	 * Use of HTTP GET method to access data
	 * Also use of path parameter passes in the URL to access particular information from the database
	 * This method will get only on particular comment of a message
	 * 
	 * @param messageId - Message ID for which we need the comment
	 * @param commentId - Comment ID we need information for
	 * */
	
	@GET
	@Path("/{commentId}")
	public String getComment(@PathParam("messageId") long messageId, 
							  @PathParam("commentId") long commentId) {
		return "messageId: "+ messageId + " Comment ID: " + commentId;
	}
	
	/**
	 * Use of HTTP GET method to access data
	 * This method will get all the information for a message based on message id
	 * 
	 * @param messageId - Message ID for which we need the infoamtion
	 * */
	
	@GET
	public List<Comment> getComment(@PathParam("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}
	
	
	/**
	 * Use of HTTP POST method to access data
	 * This method will add a new comment for a message
	 * 
	 * @param messageId - Message ID for which we need to a new comment
	 * @param comment - Add a comment
	 * */
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}
	
	/**
	 * Use of HTTP PUT method to access data
	 * */
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, Comment comment) {
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}
	
	/**
	 * Use of HTTP DELETE method to access data
	 * This method will delete a particular comment for a message
	 * */
	@DELETE
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return commentService.removeComment(messageId, commentId);
	}
}
