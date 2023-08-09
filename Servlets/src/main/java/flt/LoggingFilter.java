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
import log.Log;

@WebFilter(urlPatterns = "/*")
public class LoggingFilter implements Filter {

	public void doFilter(
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		for (int i = 0; i < 10000; i++) {		
			Log.err.error("Error test message for rolling");
		}
		
		for (int i = 0; i < 10000; i++) {		
			Log.other.info("Info test message for rolling");
		}
		
		Log.other.info("Path: ");
		Log.other.info(req.getRequestURI());
		
		Log.other.info("Headers:");
	    Enumeration<String> headerNames = req.getHeaderNames();

	    if (headerNames != null) {
	            while (headerNames.hasMoreElements()) {
	            	Log.other.info("Header: {}", 
	                    req.getHeader(headerNames.nextElement()));
	            }
	    }

	    Log.other.info("Parameters:");
	    Enumeration<String> parameterNames = req.getParameterNames();

	    while (parameterNames.hasMoreElements()) {
	        String key = (String) parameterNames.nextElement();
	        String val = req.getParameter(key);
	        Log.other.info("{}: {}", key, val);
	    }
		
		chain.doFilter(request, response);
	}
}
