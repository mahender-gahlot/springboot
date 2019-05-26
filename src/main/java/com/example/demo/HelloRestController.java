package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix="helloapp")
public class HelloRestController {

	private String saying;
	
	/**
	 * @return the saying
	 */
	public String getSaying() {
		return saying;
	}

	/**
	 * @param saying the saying to set
	 */
	public void setSaying(String saying) {
		this.saying = saying;
	}

	@RequestMapping(method=RequestMethod.GET,value = "/hello",
			 produces = "text/plain")
	public String hola(){
		String hostname = null;
		 try {
		 hostname = InetAddress.getLocalHost()
		 .getHostAddress();
		 } catch (UnknownHostException e) {
		 hostname = "unknown";
		 }
		 return saying + hostname;
	}
}
