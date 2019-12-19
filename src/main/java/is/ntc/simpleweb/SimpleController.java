/*
 * Simple rest controller
 * 
 * Building an Application with Spring Boot
 * https://spring.io/guides/gs/spring-boot/
 * 
 * Building a RESTful Web Service
 * https://spring.io/guides/gs/rest-service/
 */

package is.ntc.simpleweb;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	
	String indexbody = "<h1>Start page</h1>";
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/")
	public String index() {
		    return indexbody;
		  }
	 @RequestMapping("/greeting")
	  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
	    return new Greeting(counter.incrementAndGet(),
	              String.format(template, name));
	  }
	 
	@RequestMapping(value="/greeting/{id}")
	  public Greeting greeting(@PathVariable long id,
			  @RequestParam(value="name", defaultValue="World") String name) {
	    return new Greeting(id, String.format(template, name));
	  }
}
