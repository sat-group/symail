public static boolean isValid(cmu.edu.mail.Address address, java.lang.String ch) throws Throwable{
	java.lang.String var_0 = address.getAddress();
	boolean var_1 = var_0.contains(ch);
	return var_1;
}
