package org.priyank.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.priyank.javabrains.messenger.database.DatabaseClass;
import org.priyank.javabrains.messenger.model.Message;
import org.priyank.javabrains.messenger.model.Comment;

public class CommentService {

	private Map<Long, Message> message = DatabaseClass.getMessages();
	
	public CommentService() {
		
	}
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = message.get(messageId).getComment(); 
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId) {
		Map<Long, Comment> comments = message.get(messageId).getComment(); 
		return comments.get(messageId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = message.get(messageId).getComment(); 
		comment.setId(comments.size() + 1);
		return comments.put(comment.getId(), comment);
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = message.get(messageId).getComment();
		if(comment.getId() < 0){
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = message.get(messageId).getComment();
		return comments.remove(commentId);
	}
}
