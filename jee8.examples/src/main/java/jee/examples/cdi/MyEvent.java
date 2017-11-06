package jee.examples.cdi;

public class MyEvent {

	private String string;

	public MyEvent(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "MyEvent = " + string;
	}

}
