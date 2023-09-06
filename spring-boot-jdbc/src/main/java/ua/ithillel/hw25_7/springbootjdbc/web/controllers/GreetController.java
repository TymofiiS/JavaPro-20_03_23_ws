package ua.ithillel.hw25_7.springbootjdbc.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetController {

	public static final Logger logger = 
			LoggerFactory.getLogger(GreetController.class);

	@ResponseBody
	@RequestMapping(
			value = "/greet", 
			method = {RequestMethod.GET, RequestMethod.POST} )
	public String showview()
	{	
		logger.info("'/greet' was called");
		
		return "Hello from greet controller";
	}
	
	@ResponseBody
	@RequestMapping(
			value = "/", 
			method = RequestMethod.GET )
	public String showStart()
	{	
		logger.info(" start page was called");
		
		return "Hello from start page";
	}
}