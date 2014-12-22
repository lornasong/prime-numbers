package org.lsong.primes;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@WebService
@Produces({ "text/html" })
@Path("/prime")
public class PrimeService {

	@Path("/trial")
	@GET
	@WebMethod
	public String trial(//
			@QueryParam("value")//
			int value) {

		StringBuilder sb = new StringBuilder();

		sb.append("<html><body>\n");
		sb.append("<h1> Find Prime Numbers with Trial Division </h1>\n");

		sb.append("<p><form>\n");
		sb.append("Please enter an integer two or greater: <input name='value' type='text'");
		sb.append(" />");
		sb.append("<input type='submit' />\n");
		sb.append("</form></p>\n");

		if (value > 1) {
			sb.append("<p> Prime numbers are: "
					+ TrialDivisionPrime.getPrimeArray(value) + " </p>\n");
		} else {
			sb.append("<p> There are no prime numbers in that range!</p>");
		}

		sb.append("</body></html>\n");
		return sb.toString();
	}

	@Path("/sieve")
	@GET
	@WebMethod
	public String sieve(//
			@QueryParam("value")//
			int value) {

		StringBuilder sb = new StringBuilder();

		sb.append("<html><body>\n");
		sb.append("<h1> Find Prime Numbers With Sieve Technique </h1>\n");

		sb.append("<p><form>\n");
		sb.append("Please enter an integer two or greater: <input name='value' type='text'");
		sb.append(" />");
		sb.append("<input type='submit' />\n");
		sb.append("</form></p>\n");

		if (value > 1) {
			sb.append("<p> Prime numbers are: "
					+ new SievePrime(value).getArrayOfPrimes() + " </p>\n");
		} else {
			sb.append("<p> There are no prime numbers in that range!</p>");
		}

		sb.append("</body></html>\n");
		return sb.toString();
	}

}
