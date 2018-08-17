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
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.encryptor4j.util.FileEncryptor;
import org.encryptor4j.util.TextEncryptor;

@SuppressWarnings("deprecation")
public class SyCryptoUtils {
		  
	  public static String encrypt(String message, String key) throws Exception {
		  TextEncryptor te = new TextEncryptor(key);
		  String encrypted = te.encrypt(message);
		  return encrypted;
	  }
	  
	  public static String decrypt(String message, String key) throws Exception {
		  TextEncryptor te = new TextEncryptor(key);
		  String decrypt = te.decrypt(message);
		  return decrypt;
	  }
	  
	  public static File encryptFile(String original, String encrypted, String password) throws Exception {
		  File srcFile = new File(original);
		  File destFile = new File(encrypted);
		  FileEncryptor fe = new FileEncryptor(password);
		  fe.encrypt(srcFile, destFile);
		  return destFile;
	  }
	  
	  public static File decryptFile(String encrypted, String decrypted, String password) throws Exception {
		  File srcFile = new File(encrypted);
		  File destFile = new File(decrypted);
		  FileEncryptor fe = new FileEncryptor(password);
		  fe.decrypt(srcFile, destFile);
		  return destFile;	
	  }
	  
	  static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}

	  static File writeToFile(String path, String content) throws Exception {
		  File file = new File(path);
		  FileUtils.writeStringToFile(file, content);
		  return file;
	  }
	  
}
