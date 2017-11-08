package jee.examples.jaxrs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseEventSink;

@Path("/chat/{name}")
@RequestScoped
public class MySimpleChat {

	@Inject
	private ChatClientRepo repo;

	@GET
	@Produces(MediaType.SERVER_SENT_EVENTS)
	public void register(@Context SseEventSink eventSink, @Context Sse sse, @PathParam("name") String name) {
		repo.addClient(name, eventSink);
		eventSink.send(sse.newEvent("Welcome " + name));
		repo.filter(name).forEach(sink -> sink.send(sse.newEvent(name + " has joined the chat")));
	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void pushMessage(String message, @PathParam("name") String name, @Context Sse sse) {
		repo.getAll().forEach(sink -> sink.send(sse.newEvent(name + ": " + message)));
	}

}
