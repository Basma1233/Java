package Utility;

import java.security.spec.MGF1ParameterSpec;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EnvoyerEmail {

	public static void sendMail(String adresse, String subject,String message) throws AddressException, MessagingException {


		 String from = "sediridhia@gmail.com";  //email de l'expediteur
		 String motdepasse = "dhia;789321456";
		 String [] to = {adresse};

		 String host = "smtp.gmail.com"; // On  utilise java mail comme librairie(service, bundel externe)et  le service smpt de goole pour envoyer de l'email

		 Properties prop = System.getProperties();        // les parametres pour envoyer un email
		 prop.put("mail.smtp.starttls.enable", "true");
		 prop.put("mail.smtp.host", host);
		 prop.put("mail.smtp.user", from);
		 prop.put("mail.smtp.password", motdepasse);
		 prop.put("mail.smtp.port", "587");
		 prop.put("mail.smtp.auth", "true");

		 Session session = Session.getDefaultInstance(prop);
		 MimeMessage msg = new MimeMessage(session);
		 msg.setFrom( new InternetAddress(from));
		 InternetAddress[] toAdress	= new InternetAddress[to.length];

		for (int i = 0; i < to.length; i++) {
			toAdress[i] = new InternetAddress(to[i]);
		}

		for (int i = 0; i < toAdress.length; i++) {
			msg.setRecipient(Message.RecipientType.TO, toAdress[i]);
		}

		msg.setSubject(subject);
		msg.setContent(message,"text/html; charset=utf-8");
		Transport transport = session.getTransport("smtp");
		transport.connect(host,from, motdepasse);
		transport.sendMessage(msg, 	msg.getAllRecipients());
		transport.close();
	}
}
