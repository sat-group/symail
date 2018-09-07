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

package cmu.edu.mail;

import java.time.LocalDateTime;

import cmu.edu.mail.Address;

public class Mail {

	private String title;
	private Address from;
	private String body;
	private LocalDateTime date;
	private boolean replyTo;
	private boolean favorite;
	private boolean read;
	private boolean deleted;
	
	public void setFavorite(boolean value) {
		favorite = value;
	}
	
	public void setRead(boolean value) {
		read = value;
	}
	
	public void setReplied(boolean value) {
		replyTo = value;
	}
	
	public void setDeleted(boolean value) {
		deleted = value;
	}
	
	public boolean getDeleted() {
		return deleted;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public boolean getFavorite() {
		return favorite;
	}

	public boolean getReplied() {
		return replyTo;
	}

	public Address getAddress() {
		return from;
	}

	public LocalDateTime getSentDate() {
		return date;
	}
	
	public boolean getRead() {
		return read;
	}
	
	public Mail(String title, String address, String body) {
		this.title = title;
		this.from = new Address(address);
		this.body = body;
		this.date = LocalDateTime.now();
		favorite = false;
		replyTo = false;
		read = false;
		deleted = false;
	}

	public Mail(String title, String address, String body, LocalDateTime date) {
		this.title = title;
		this.from = new Address(address);
		this.body = body;
		this.date = date;
		favorite = false;
		replyTo = false;
		read = false;
		deleted = false;
	}

	public Mail(String title, String address, String body, LocalDateTime date, boolean favorite, boolean reply, boolean read) {
		this.title = title;
		this.from = new Address(address);
		this.body = body;
		this.date = date;
		this.favorite = favorite;
		this.replyTo = reply;
		this.read = read;
		deleted = false;
	}

}
