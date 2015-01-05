package org.lsong.primes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class ErrorHandler extends AbstractHandler{

	@Override
	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		if (response.isCommitted()) {
			// don't do anything if we are committed
			return;
		}
		
		response.setStatus(400);
		response.getWriter().append("<html><body><h1>HiQQ</h1></body></html>");
		
	}

}
