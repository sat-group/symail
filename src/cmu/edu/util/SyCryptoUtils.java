/**
 * BSD 3-Clause License
 *	
 *	
 *	Copyright (c) 2018, SyMail - SyPet 2.0, Ruben Martins
 *	All rights reserved.
 *	
 *	Redistribution and use in source and binary forms, with or without
 *	modification, are permitted provided that the following conditions are met:
 *	
 *	* Redistributions of source code must retain the above copyright notice, this
 *	  list of conditions and the following disclaimer.
 *	
 *	* Redistributions in binary form must reproduce the above copyright notice,
 *	  this list of conditions and the following disclaimer in the documentation
 *	  and/or other materials provided with the distribution.
 *	
 *	* Neither the name of the copyright holder nor the names of its
 *	  contributors may be used to endorse or promote products derived from
 *	  this software without specific prior written permission.
 *	
 *	THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 *	AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 *	IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *	DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 *	FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 *	DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *	SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 *	CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 *	OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 *	OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package cmu.edu.util;

import java.io.File;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.encryptor4j.util.FileEncryptor;
import org.encryptor4j.util.TextEncryptor;

public class SyCryptoUtils {

	public static String encrypt(String message, String key) throws Throwable {
		TextEncryptor te = new TextEncryptor(key);
		String encrypted = te.encrypt(message);
		return encrypted;
	}

	public static String decrypt(String message, String key) throws Throwable {
		TextEncryptor te = new TextEncryptor(key);
		String decrypt = te.decrypt(message);
		return decrypt;
	}

	public static File encryptFile(String original, String encrypted, String password) throws Throwable {
		File srcFile = new File(original);
		File destFile = new File(encrypted);
		FileEncryptor fe = new FileEncryptor(password);
		fe.encrypt(srcFile, destFile);
		return destFile;
	}

	public static File decryptFile(String encrypted, String decrypted, String password) throws Throwable {
		File srcFile = new File(encrypted);
		File destFile = new File(decrypted);
		FileEncryptor fe = new FileEncryptor(password);
		fe.decrypt(srcFile, destFile);
		return destFile;
	}

	public static String encryptNoSalt(String data, Key key, String protocol, int mode) throws Throwable {
		Cipher c = Cipher.getInstance(protocol);
		c.init(mode, key);
		byte[] enc = data.getBytes();
		byte[] encVal = c.doFinal(enc);
		Encoder encoder = Base64.getEncoder();
		String output = encoder.encodeToString(encVal);
		return output;
	}

	public static Key generateKey(String password, String hash, String protocol) throws Throwable {
		MessageDigest hasher = MessageDigest.getInstance(hash);
		byte[] passwordBytes = password.getBytes();
		byte[] key256 = hasher.digest(passwordBytes);
		Key key = new SecretKeySpec(key256, protocol);
		return key;
	}

	public static byte[] hashText(String password, String hash) throws Throwable {
		MessageDigest hasher = MessageDigest.getInstance(hash);
		byte[] passwordBytes = password.getBytes();
		byte[] key256 = hasher.digest(passwordBytes);
		return key256;
	}

	public static java.lang.String hashTextString(java.lang.String text, java.lang.String hash) throws Throwable {
		byte[] var_0 = org.apache.commons.codec.binary.StringUtils.getBytesIso8859_1(text);
		java.security.MessageDigest var_1 = java.security.MessageDigest.getInstance(hash);
		byte[] var_2 = var_1.digest(var_0);
		java.lang.String var_3 = org.apache.commons.codec.binary.Hex.encodeHexString(var_2);
		return var_3;
	}

	public static String decryptNoSalt(String message, Key key, String protocol, int mode) throws Throwable {
		java.util.Base64.Decoder var_0 = java.util.Base64.getMimeDecoder();
		byte[] var_1 = var_0.decode(message);
		javax.crypto.Cipher var_2 = javax.crypto.Cipher.getInstance(protocol);
		var_2.init(mode,key);
		byte[] var_3 = var_2.doFinal(var_1);
		java.lang.String var_4 =  new java.lang.String(var_3);
		return var_4;
	}
}
