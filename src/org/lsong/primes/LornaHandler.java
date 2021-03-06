package org.lsong.primes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class LornaHandler extends AbstractHandler {

	@Override
	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (response.isCommitted()) {
			// don't do anything if we are committed
			return;
		}
		System.out.println("hello, target is " + target);
		System.out.println("hello, baserequest is " + baseRequest);
		System.out.println("request is " + request);
		System.out.println("response is " + response);
		System.out.println();
		response.setStatus(200);
		baseRequest.setHandled(true);
		response.setContentType("text/html");
		response.getWriter().append("<html><body><h1>Hi There</h1></body></html>");
	}
}
