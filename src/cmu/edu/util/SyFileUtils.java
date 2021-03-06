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

import com.google.gson.Gson;

import cmu.edu.mail.Mail;

@SuppressWarnings("deprecation")
public class SyFileUtils {

	public static boolean existFile(String path) {
		File file = new File(path);
		return file.isFile();
	}

	public static File[] listFiles(String path) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		return listOfFiles;
	}

	public static boolean existDirectory(String path) {
		File dir = new File(path);
		return dir.isDirectory();
	}

	public static File createDirectory(String path) {
		File dir = new File(path);
		dir.mkdir();
		return dir;
	}

	public static File cleanDirectory(String path) throws IOException {
		File dir = new File(path);
		FileUtils.cleanDirectory(dir);
		return dir;
	}

	public static File writeToFile(String path, String content) throws IOException {
		File file = new File(path);
		FileUtils.writeStringToFile(file, content);
		return file;
	}

	public static String readFromFile(String path) throws IOException {
		File file = new File(path);
		String content = FileUtils.readFileToString(file);
		return content;
	}

	public static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	
	public static File writeFile(String path, String content, Charset encoding) throws IOException {
		File file = new File(path);
		FileUtils.writeStringToFile(file, content, encoding);
		return file;
	}
	
	// --- need to create tests 
	
	public static File classToJson(String path, Mail mail, Gson json) throws IOException {
		String result = json.toJson(mail);
		File file = SyFileUtils.writeToFile(path, result);
		return file;
	}
	

}
