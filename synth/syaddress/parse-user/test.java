public boolean test() throws Throwable  {
	cmu.edu.mail.Address address = new cmu.edu.mail.Address("foo@gmail.com");
	java.lang.String username = parseUser(address, "@gmail.com", 0);
	return (username.equals("foo"));
}
