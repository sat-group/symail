package cmu.edu.demo;

public class ExampleInternet {

//# packages: java.net java.io
//# return: java.lang.String
//# hints:
public static java.lang.String canReachGmail(java.net.Socket soc) {

java.io.InputStream var_0 = soc.getInputStream();
java.io.DataInputStream var_1 =  new java.io.DataInputStream(var_0);
java.lang.String var_2 = var_1.readLine();
return var_2;

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

java.net.Socket var_0 =  new java.net.Socket(host,port);
java.io.InputStream var_1 = var_0.getInputStream();
java.io.DataInputStream var_2 =  new java.io.DataInputStream(var_1);
java.lang.String var_3 = var_2.readLine();
return var_3;

}

// # //
public static boolean test() throws Throwable {
	java.lang.String output = canReachGmail("smtp.gmail.com",587);
	return output.contains("220 smtp.gmail.com");
}
// # //

}
