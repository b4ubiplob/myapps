package sampleweb;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class FirstResource {
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String firstMethod() {
		return "Hello World";
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FirstTO> sampleJson() {
		List<FirstTO> list = new ArrayList<>();
		list.add(new FirstTO("firstStr_1", 1, "FirstStr1"));
		list.add(new FirstTO("secondStr_1", 2, "SecondStr1"));
		return list;
	}

}
