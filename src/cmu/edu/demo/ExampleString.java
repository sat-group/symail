package cmu.edu.demo;

public class ExampleString {

//# packages: java.lang cmu.edu.mail.Address
//# return: boolean
//# hints:
public static boolean isAddressValid(cmu.edu.mail.Address address, java.lang.String ch) {
  //#SyPet
}

// # //
public static boolean test1() throws Throwable {
  cmu.edu.mail.Address add1 = new cmu.edu.mail.Address("foo");
  cmu.edu.mail.Address add2 = new cmu.edu.mail.Address("foo@gmail.com");
  boolean r1 = isAddressValid(add1, "@gmail.com");
  boolean r2 = isAddressValid(add2, "@gmail.com");
  return !r1 && r2;
}
// # //

//# packages: java.lang cmu.edu.mail.Address
//# return: java.lang.String
//# hints: substring
public static java.lang.String parseUser(cmu.edu.mail.Address address, java.lang.String ch, int pos){
	//#SyPet
}

// # //
public static boolean test2() throws Throwable  {
	cmu.edu.mail.Address address = new cmu.edu.mail.Address("foo@gmail.com");
	java.lang.String username = parseUser(address, "@gmail.com", 0);
	return (username.equals("foo"));
}
// # //

}
