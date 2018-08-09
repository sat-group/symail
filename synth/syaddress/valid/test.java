public boolean test1() throws Throwable  {
	cmu.edu.mail.Address address = new cmu.edu.mail.Address("foo");
	boolean res = isValid(address, "@gmail.com");
	return (res == false);
}

public boolean test2() throws Throwable  {
	cmu.edu.mail.Address address = new cmu.edu.mail.Address("foo@gmail.com");
	boolean res = isValid(address, "@gmail.com");
	return (res == true); 
}

public boolean test3() throws Throwable  {
	cmu.edu.mail.Address address = new cmu.edu.mail.Address("hotmail@hotmail.com");
	boolean res = isValid(address, "@gmail.com");
	return (res == false); 
}

public boolean test() throws Throwable {
	return test1() && test2() && test3();
}
