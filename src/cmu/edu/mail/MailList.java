package cmu.edu.mail;

public class MailList {
	
	private String date;
	private String from;
	private String title;
	
	public MailList(String date, String from, String title) {
		this.date = date;
		this.from = from;
		this.title = title;
	}
	
	public String getDate() {
		return date;
	}

	public String getFrom() {
		return from;
	}
	
	public String getTitle() {
		return title;
	}
}
