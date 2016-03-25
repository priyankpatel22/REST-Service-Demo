package org.priyank.javabrains.messenger.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	
	@GET
	@Path("context")
	public String getParametersUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
		String text = uriInfo.getAbsolutePath().toString();
		String text2 = httpHeaders.getCookies().toString();
		return "Params: " + text + "Cookies: " + text2;
	}
}
