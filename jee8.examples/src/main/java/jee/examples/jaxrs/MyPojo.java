package jee.examples.jaxrs;

import java.util.Date;

public class MyPojo {

	private String someName;

	private Date myDate;

	private long sum;

	public String getSomeName() {
		return someName;
	}

	public void setSomeName(String someName) {
		this.someName = someName;
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

}
