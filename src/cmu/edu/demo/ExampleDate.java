package cmu.edu.demo;

public class ExampleDate {

//# packages: java.time cmu.edu.mail.Mail
//# return: long
//# hints:
public static long getDays(cmu.edu.mail.Mail mail) {
	//#SyPet
}

// # //
public static boolean test1() throws Throwable {
	int diff = 3;
	java.time.LocalDateTime now = java.time.LocalDateTime.now();
	java.time.LocalDateTime dt = java.time.LocalDateTime.of(now.getYear(), now.getMonthValue(),
	now.getDayOfMonth() - diff, now.getHour(), now.getMinute());
	cmu.edu.mail.Mail mail = new cmu.edu.mail.Mail("title", "foo@gmail.com", "This is an email!", dt);
	long days = getDays(mail);
	return days == diff;
}
// # //

//# packages: java.time cmu.edu.mail.Mail
//# return: java.lang.String
//# hints:
public static java.lang.String extractDate(cmu.edu.mail.Mail mail, java.lang.String format) {
		//#SyPet
}

// # //
public static boolean test2() throws Throwable {
	java.time.LocalDateTime dt = java.time.LocalDateTime.of(2012, 3, 10, 20, 0);
	cmu.edu.mail.Mail mail = new cmu.edu.mail.Mail("title", "foo@gmail.com", "This is an email!", dt);
	java.lang.String date = extractDate(mail, "dd/MM/yyyy");
	return date.equals("10/03/2012");
}
// # //

}
