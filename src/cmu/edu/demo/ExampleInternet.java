package cmu.edu.demo;

public class ExampleInternet {

//# packages: java.net java.io
//# return: java.lang.String
//# hints:
public static java.lang.String canReachGmail(java.net.Socket soc) {
  //#SyPet
}

// # //
public static boolean test1() throws Throwable {
	java.net.Socket socket = new java.net.Socket("smtp.gmail.com",587);
	java.lang.String output = canReachGmail(socket);
	return output.contains("220 smtp.gmail.com");
}
// # //


//# packages: java.net java.io
//# return: java.lang.String
//# hints: java.net.Socket
public static java.lang.String canReachGmail(java.lang.String host, int port) {
  //#SyPet
}

// # //
public static boolean test() throws Throwable {
	java.lang.String output = canReachGmail("smtp.gmail.com",587);
	return output.contains("220 smtp.gmail.com");
}
// # //

}
