public boolean test() throws Throwable  {
	java.net.Socket socket = new java.net.Socket("smtp.gmail.com",587);
	java.lang.String output = canReachGmail(socket);
	return output.contains("220 smtp.gmail.com");
}
