package cmu.edu.test.internet;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cmu.edu.util.SyInternet;

public class TestInternetCreateSocket {

	@Test
	public void test1() throws Throwable {

		java.net.Socket socket = SyInternet.createSocket("smtp.gmail.com", 587);
		assertTrue(socket.getPort() == 587 && socket.getInetAddress().getHostName().equals("smtp.gmail.com"));

	}

}
