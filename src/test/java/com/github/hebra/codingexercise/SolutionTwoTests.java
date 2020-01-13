package com.github.hebra.codingexercise;

import java.util.regex.Matcher;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class SolutionTwoTests {

	/**
	 * This test will verify if the regular expression used for extracting log
	 * information works as expected.
	 */
	@Test
	public void testRegExPattern() {

		/*
		 * The test payload contains different resource types and HTTP methods.
		 * Resources are local as well as external URLs. Local resources are a simple /
		 * root, a single /path/, a /sub/path/, /path-with-dash/sub/ and a
		 * /sub/path/resource.gif
		 */
		String payload = "177.71.128.21 - - [10/Jul/2018:22:21:28 +0200] \"DELETE /path/ HTTP/1.1\" 200 3574 \"-\" \"Mozilla/5.0 (X11; U; Linux x86_64; fr-FR) AppleWebKit/534.7 (KHTML, like Gecko) Epiphany/2.30.6 Safari/534.7\"\n"
				+ "168.41.191.40 - - [09/Jul/2018:10:11:30 +0200] \"GET http://example.net/faq/ HTTP/1.1\" 200 3574 \"-\" \"Mozilla/5.0 (Linux; U; Android 2.3.5; en-us; HTC Vision Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1\"\n"
				+ "168.41.191.40 - - [09/Jul/2018:10:11:30 +0200] \"POST / HTTP/1.1\" 200 3574 \"-\" \"Mozilla/5.0 (Linux; U; Android 2.3.5; en-us; HTC Vision Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1\"\n"
				+ "168.41.191.40 - - [09/Jul/2018:10:11:30 +0200] \"POST /sub/path/resource.gif HTTP/1.1\" 200 3574 \"-\" \"Mozilla/5.0 (Linux; U; Android 2.3.5; en-us; HTC Vision Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1\"\n"
				+ "168.41.191.41 - - [11/Jul/2018:17:41:30 +0200] \"GET /path-with-dash/sub/ HTTP/1.1\" 404 3574 \"-\" \"Mozilla/5.0 (Linux; U; Android 2.3.5; en-us; HTC Vision Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1\"";

		Matcher matcher = SolutionTwo.getMatcher(payload);

		int matchCounter = 0;

		String ip = null;
		String website = null;

		while (matcher.find()) {
			ip = matcher.group(1);
			website = matcher.group(4);

			matchCounter++;
		}

		Assert.isTrue(ip != null, "ip object is null.");
		Assert.isTrue(website != null, "website object is null.");

		Assert.isTrue(matchCounter == 5, "The total number of matches is not 5.");

		Assert.isTrue(ip.equals("168.41.191.41"), "The last found IP should be 168.41.191.41");
		Assert.isTrue(website.equals("/path-with-dash/sub/"), "The last found IP should be /path-with-dash/sub/");

	}
}
