package cmu.edu.demo;

public class ExampleCrypto {

//# packages: java.security org.apache.commons.codec.binary java.lang.String
//# return: java.lang.String
//# hints: digest
public static java.lang.String hashTextString(java.lang.String text, java.lang.String hash) {

byte[] var_0 = org.apache.commons.codec.binary.StringUtils.getBytesIso8859_1(text);
java.security.MessageDigest var_1 = java.security.MessageDigest.getInstance(hash);
byte[] var_2 = var_1.digest(var_0);
java.lang.String var_3 = org.apache.commons.codec.binary.Hex.encodeHexString(var_2);
return var_3;

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

java.util.Base64.Decoder var_0 = java.util.Base64.getMimeDecoder();
javax.crypto.Cipher var_1 = javax.crypto.Cipher.getInstance(protocol);
byte[] var_2 = var_0.decode(text);
var_1.init(mode,key);
byte[] var_3 = var_1.doFinal(var_2);
java.lang.String var_4 =  new java.lang.String(var_3);
return var_4;

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
