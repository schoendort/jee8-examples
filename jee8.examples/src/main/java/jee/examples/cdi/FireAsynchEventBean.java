package jee.examples.cdi;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Singleton
@Startup
public class FireAsynchEventBean {

	private static final Logger LOGGER = Logger.getLogger(FireAsynchEventBean.class.getName());

	@Inject
	private Event<MyEvent> eventBus;

	@PostConstruct
	public void postConstruct() {
		LOGGER.severe(() -> "firing event");
		eventBus.fireAsync(new MyEvent("asynch"))
				.thenAccept(event -> LOGGER.severe(() -> "event process completed " + event));
		LOGGER.severe(() -> "firing event finished");
	}
}
