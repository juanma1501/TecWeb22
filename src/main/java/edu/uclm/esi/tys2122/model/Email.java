package edu.uclm.esi.tys2122.model;

import edu.uclm.esi.tys2122.http.Manager;
import org.json.JSONObject;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	private final Properties properties = new Properties();

	public void send(String destinatario, String subject, String body) {
		JSONObject emailParameters = (JSONObject) Manager.get().getConfiguration().getJSONObject("email");

		String smtpHost = (String) emailParameters.get("host");
		String startTTLS = (String) emailParameters.get("startTTLS");
		String port = (String) emailParameters.get("port");
		String sender = (String) emailParameters.get("sender");
		String serverUser = (String) emailParameters.get("serverUser");
		String userAutentication = (String) emailParameters.get("auth");
		String pwd = (String) emailParameters.get("pwd"); // PONER LA CONTRASEÑA
		String fallback = (String) emailParameters.get("fallback");

		properties.put("mail.smtp.host", smtpHost);
		properties.put("mail.smtp.starttls.enable", startTTLS);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.mail.sender", sender);
		properties.put("mail.smtp.user", serverUser);
		properties.put("mail.smtp.auth", userAutentication);
		properties.put("mail.smtp.socketFactory.port", port);
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback", fallback);
        
        Runnable r = new Runnable() {
			@Override
			public void run() {
		        Authenticator auth = new AutentificadorSMTP(sender, pwd);
		        Session session = Session.getInstance(properties, auth);

		        MimeMessage msg = new MimeMessage(session);
		        try {
			        msg.setSubject(subject);
			        msg.setText(body);
			        msg.setFrom(new InternetAddress(sender));
			        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			        Transport.send(msg);
		        } catch (Exception e) {
					System.err.println(e);
				}
			}
		};
		new Thread(r).start();
	}
	
	private class AutentificadorSMTP extends javax.mail.Authenticator {
        private String sender;
		private String pwd;

		public AutentificadorSMTP(String sender, String pwd) {
			this.sender = sender;
			this.pwd = pwd;
		}

		public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(sender, pwd);
        }
    }
	
	public static void main(String[] args) throws Exception {
		Email sender=new Email();
		sender.send("alonsodiazsobrino@gmail.com", "Hola", "Ya me va el correo");
		System.out.println("Enviado");
	}
}
