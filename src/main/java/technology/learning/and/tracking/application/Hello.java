package technology.learning.and.tracking.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    Logger LOG = LoggerFactory.getLogger(Hello.class); 
 //CheckRequest 
    @RequestMapping("/hello")
    public String welcome() {
    	LOG.info("Welcome!");
       // LOG.warn("Hello world! warning");
       // LOG.error("Hello world! error");
    	return "Welcome!";
    }

    
//    //@RequestMapping("/hello")
//    @GetMapping("/hello")
//    public String hello() {
//    	LOG.info("Hello World!");
//       // LOG.warn("Hello world! warning");
//       // LOG.error("Hello world! error");
//    	return "Hello world!";
//    }

 

}