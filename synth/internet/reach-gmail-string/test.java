public boolean test() throws Throwable  {
	java.lang.String output = canReachGmail("smtp.gmail.com",587);
	return output.contains("220 smtp.gmail.com");
}
