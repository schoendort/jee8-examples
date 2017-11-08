package jee.examples.jaxrs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.sse.SseEventSink;

@ApplicationScoped
public class ChatClientRepo {

	private Map<String, SseEventSink> clients = new HashMap<>();

	public void addClient(String name, SseEventSink eventSink) {
		this.clients.put(name, eventSink);
	}

	public List<SseEventSink> filter(String name) {
		clients.entrySet().removeIf(e -> e.getValue().isClosed());
		return clients.entrySet().stream().filter(e -> !e.getKey().equals(name)).map(Map.Entry::getValue)
				.collect(Collectors.toList());
	}

	public Iterable<SseEventSink> getAll() {
		clients.entrySet().removeIf(e -> e.getValue().isClosed());
		return clients.values();
	}

}
