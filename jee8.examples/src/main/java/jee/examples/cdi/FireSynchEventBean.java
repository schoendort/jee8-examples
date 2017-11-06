package jee.examples.cdi;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Singleton
@Startup
public class FireSynchEventBean {

	private static final Logger LOGGER = Logger.getLogger(FireSynchEventBean.class.getName());

	@Inject
	private Event<MyEvent> eventBus;

	@PostConstruct
	public void postConstruct() {
		LOGGER.severe(() -> "firing event");
		eventBus.fire(new MyEvent());
		LOGGER.severe(() -> "firing event finished");
	}

}
