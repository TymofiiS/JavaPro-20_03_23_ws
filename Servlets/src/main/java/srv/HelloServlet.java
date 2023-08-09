package srv;

import java.io.IOException;

import flt.LoggingFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import log.Log;

@WebServlet(urlPatterns = "/hi")
public class HelloServlet extends HttpServlet {

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		Log.other.info("HelloServlet called");
		
		try {
			int a = 1/0;
		} catch (Exception e) {
			Log.err.error(e.getMessage());
		}
		
		response
			.getWriter()
			.append("Served at: ")
			.append(request.getContextPath());
	}
}
