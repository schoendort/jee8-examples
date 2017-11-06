package jee.examples.cdi;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.ObservesAsync;

@RequestScoped
public class AsynchObserver {

	private static final Logger LOGGER = Logger.getLogger(AsynchObserver.class.getName());

	public void onEvent(@ObservesAsync MyEvent event) {
		LOGGER.severe(() -> "receive event + " + event);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			LOGGER.log(Level.SEVERE, "shit", e);
		}
	}
}
