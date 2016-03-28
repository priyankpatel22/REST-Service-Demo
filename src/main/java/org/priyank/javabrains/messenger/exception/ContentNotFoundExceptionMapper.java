package org.priyank.javabrains.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Handled Exception
 * 
 * */

import org.priyank.javabrains.messenger.model.ErrorMessage;

@Provider
public class ContentNotFoundExceptionMapper implements ExceptionMapper<ContentNotFoundException>{

	@Override
	public Response toResponse(ContentNotFoundException ex) {
		// TODO Auto-generated method stub
//		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 404, "www.priyank.com");
		return Response.status(Status.NOT_FOUND).build();
	}

}
