package cmu.edu.demo;

public class ExampleCrypto {

//# packages: java.security org.apache.commons.codec.binary java.lang.String
//# return: java.lang.String
//# hints: digest
public static java.lang.String hashTextString(java.lang.String text, java.lang.String hash) {
  //#SyPet
}

// # //
public static boolean test1() throws Throwable {
	java.lang.String hashpassword = "117a520adbd19eff51100215aa7a7fbf";
	java.lang.String decrypted = hashTextString("mysupersecretpassword", "MD5");
	return decrypted.equals(hashpassword);
}
// # //


//# packages: javax.crypto.Cipher java.util.Base64 java.lang.String java.security.Key
//# return: java.lang.String
//# hints: doFinal decode
public static java.lang.String decrypt(java.lang.String text, java.security.Key key, java.lang.String protocol, int mode){
 //#SyPet
}

// # //
public static boolean test2() throws Throwable {
	java.lang.String password = "mysupersecretpassword";
	java.lang.String text = "qtAgNnuVEVxdFs9pebI0I3MZ+gAlDvAnq1OWESNqlwY=";
	java.security.Key key = cmu.edu.util.SyCryptoUtils.generateKey(password, "MD5", "AES");
	java.lang.String decrypted = decrypt(text, key, "AES", javax.crypto.Cipher.DECRYPT_MODE);
	java.lang.String decoded = "This is a secret message";
	return decrypted.equals(decoded);
}
// # //

}
