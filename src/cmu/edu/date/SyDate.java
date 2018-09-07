package cmu.edu.date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.mail.Message;
import javax.mail.MessagingException;

import cmu.edu.mail.Mail;
import cmu.edu.mail.MailList;

public class SyDate {
	
	// --- need to create tests 
	
	public static long getDays(Mail mail) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime emailDate = mail.getSentDate();
		long days = Duration.between(emailDate, now).toDays();
		return days;
	}
	
	public static long getDays(Mail mail, LocalDateTime now) {
		LocalDateTime emailDate = mail.getSentDate();
		long days = Duration.between(now, emailDate).toDays();
		return days;
	}
	
	public static long getMinutes(Mail mail) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime emailDate = mail.getSentDate();
		long days = Duration.between(now, emailDate).toMinutes();
		return days;
	}
	
	public static long getMinutes(Mail mail, LocalDateTime now) {
		LocalDateTime emailDate = mail.getSentDate();
		long days = Duration.between(now, emailDate).toMinutes();
		return days;
	}
	
	public static String getDate(Mail mail, String format) {
		LocalDateTime emailDate = mail.getSentDate();
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern(format);
        String formatDateTime = emailDate.format(formatter);
        return formatDateTime;
	}
	
	public static String getDate(LocalDateTime date, String format) {
		java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern(format);
        String formatDateTime = date.format(formatter);
        return formatDateTime;
	}
	
	public static LocalDateTime buildDate(String date, String format) {
		java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern(format);
		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
		return dateTime;
	}
	
	public static LocalDateTime convertDate(java.util.Date date) {
		java.time.Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		ZonedDateTime zonedate = instant.atZone(zone);
		LocalDateTime t = zonedate.toLocalDateTime();
		return t;
	}
	
	public static LocalDateTime convertDate(Message message) throws MessagingException {
		java.util.Date date = message.getSentDate();
		java.time.Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		ZonedDateTime zonedate = instant.atZone(zone);
		LocalDateTime t = zonedate.toLocalDateTime();
		return t;
	}

		public static LocalDateTime convertDate(Message message, ZoneId zone) throws MessagingException {
		java.util.Date date = message.getSentDate();
		java.time.Instant instant = date.toInstant();
		ZonedDateTime zonedate = instant.atZone(zone);
		LocalDateTime t = zonedate.toLocalDateTime();
		return t;
	}

	public static LocalDateTime convertDate(java.util.Date date, ZoneId zone) throws MessagingException {
		java.time.Instant instant = date.toInstant();
		ZonedDateTime zonedate = instant.atZone(zone);
		LocalDateTime t = zonedate.toLocalDateTime();
		return t;
	}
	
	public static String extractDate(Mail mail, String format) {
		java.time.format.DateTimeFormatter var_0 = java.time.format.DateTimeFormatter.ofPattern(format);
		java.time.LocalDateTime var_1 = mail.getSentDate();
		java.lang.String var_2 = var_1.format(var_0);
		return var_2;
	}
	
	public static MailList convertMail(Mail mail, String format){
		java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern(format);
        String date = mail.getSentDate().format(formatter);
        String from = mail.getAddress().getAddress();
        String title = mail.getTitle();
        MailList ml = new MailList(date, from, title);
        return ml;
	}

	
}
