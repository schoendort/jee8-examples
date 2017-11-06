package jee.examples.cdi;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

@RequestScoped
public class SynchObserver2 {

	private static final Logger LOGGER = Logger.getLogger(SynchObserver2.class.getName());

	public void onMyEvent(@Observes MyEvent event) {
		LOGGER.severe(() -> "receive event + " + event);
	}

}
