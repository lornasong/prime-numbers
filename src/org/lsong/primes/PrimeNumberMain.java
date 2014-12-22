package org.lsong.primes;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.nio.SelectChannelConnector;

import com.j256.simplewebframework.displayer.StringResultDisplayer;
import com.j256.simplewebframework.handler.LoggingHandler;
import com.j256.simplewebframework.handler.ServiceHandler;

/**
 * Little sample program which starts a test web-server up on port 8080 which
 * demonstrates some of the features of the SimpleWebFramework.
 * 
 * @author graywatson
 */
public class PrimeNumberMain {

	/** default web port that we will server jetty results on */
	private static final int DEFAULT_WEB_PORT = 8080;

	public static void main(String[] args) throws Exception {
		// create jetty server
		Server server = new Server();
		// create the connector which receives HTTPD connections
		SelectChannelConnector connector = new SelectChannelConnector();
		// start it on the default port
		connector.setPort(DEFAULT_WEB_PORT);
		connector.setReuseAddress(true);
		server.addConnector(connector);

		// create a service handler
		ServiceHandler serviceHandler = new ServiceHandler();
		// register our service that handles requests from simple-web-framework
		serviceHandler.registerWebService(new PrimeService());
		// register a displayer of String results
		serviceHandler.registerResultDisplayer(new StringResultDisplayer());

		// LORNA TRIAL
		// ServletContextHandler context = new
		// ServletContextHandler(ServletContextHandler.SESSIONS);
		// ContextHandler context = new ContextHandler();

		// logging handler is designed to _wrap_ another handler
		// in this case we are wrapping our handler collection below (see setHandler)
		LoggingHandler loggingHandler = new LoggingHandler();

		// this is a collection of handlers (not surprisingly).  When handle() method
		// gets called, the handler collection will call each of the handlers in the
		// collection until a request has been satisfied
		HandlerCollection handlerCollection = new HandlerCollection();
		handlerCollection.addHandler(serviceHandler);
		handlerCollection.addHandler(new LornaHandler());
		loggingHandler.setHandler(handlerCollection);

		// this could be a collection of handlers or ...
		server.setHandler(loggingHandler);
		// server.setHandler(loggingHandler);

		// LORNA

		// server.setHandler(context);
		server.start();
		// keeps on running because of the jetty threads so you will need to
		// kill it
	}
}
