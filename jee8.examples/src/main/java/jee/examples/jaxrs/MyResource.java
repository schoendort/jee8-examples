package jee.examples.jaxrs;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/service1")
public class MyResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public MyPojo getPojo() {
		MyPojo pojo = new MyPojo();
		pojo.setMyDate(new Date());
		pojo.setSomeName("blablabla");
		pojo.setSum(1234L);
		return pojo;
	}

}
