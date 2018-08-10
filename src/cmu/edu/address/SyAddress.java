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

package cmu.edu.address;

import cmu.edu.mail.Address;

/**
 * This class contains the functions synthesized by SyPet.
 * 
 * @author SyPet 2.0
 * @author Ruben Martins
 */
public class SyAddress {

	public static boolean isValid(Address address, String ch) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		java.lang.String var_0 = address.getAddress();
		boolean var_1 = var_0.contains(ch);
		return var_1;
		// *** [End] Code Synthesized by SyPet 2.0 ***
	}
	
	public static String parseUser(Address address, java.lang.String pattern, int start) {
		// *** [Begin] Code Synthesized by SyPet 2.0 ***
		java.lang.String var_0 = pattern.substring(start);
	    java.lang.String var_1 =  new java.lang.String();
	    java.lang.String var_2 = address.getAddress();
	    java.lang.String var_3 = var_2.replaceFirst(var_0,var_1);
	    return var_3;
		// *** [End] Code Synthesized by SyPet 2.0 *** 
	}

}
