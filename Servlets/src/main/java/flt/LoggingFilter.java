package flt;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class LoggingFilter implements Filter {

	public void doFilter(
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		System.out.println("Path: ");
		System.out.println(req.getRequestURI());
		
		System.out.println("Headers:");
	    Enumeration<String> headerNames = req.getHeaderNames();

	    if (headerNames != null) {
	            while (headerNames.hasMoreElements()) {
	                    System.out.println(
	                    		"Header: " + 
	                    req.getHeader(headerNames.nextElement()));
	            }
	    }

	    System.out.println("Parameters:");
	    Enumeration<String> parameterNames = req.getParameterNames();

	    while (parameterNames.hasMoreElements()) {
	        String key = (String) parameterNames.nextElement();
	        String val = req.getParameter(key);
	        System.out.println( key + ": " + val);
	    }
		
		chain.doFilter(request, response);
	}
}
