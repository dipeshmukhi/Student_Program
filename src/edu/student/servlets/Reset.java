package edu.student.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Reset
 */
public class Reset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reset() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
			Connection connection = (Connection)session.getAttribute("myDataSource");
			//Statement lResetSql = connection.createStatement();
			
			String result;
		   // Recipient's email ID needs to be mentioned.
		   String to = (String)request.getAttribute("txtEmailId");
		
		   // Sender's email ID needs to be mentioned
		   final String from = "deepesh.mukhi@gmail.com";
		   final String pass = "";
			
		   // Get system properties object
		   Properties properties = new Properties();
		
		   // Setup mail server
		   properties.setProperty("mail.smtp.auth", "true");
		   properties.setProperty("mail.smtp.starttls.enable", "true");
		   properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		   properties.setProperty("mail.smtp.port", "587");
		   
		   properties.setProperty("mail.from", from); 
		   properties.setProperty("mail.debug", "true");
		
		   // Get the default Session object.
		   Session mailSession = Session.getInstance(properties,new javax.mail.Authenticator()
		   																	  {
		   																			protected PasswordAuthentication getPasswordAuthentication() 
			   																	   {
			   																			return new PasswordAuthentication(from, pass);
			   																	   }
		   																	  }
		   														);
		   														
		
		   try
		   {
		      // Create a default MimeMessage object.
		      MimeMessage message = new MimeMessage(mailSession);
		      // Set From: header field of the header.
		      message.setFrom(new InternetAddress(from));
		      // Set To: header field of the header.
		      message.addRecipient(Message.RecipientType.TO,
		                               new InternetAddress(to));
		      // Set Subject: header field
		      message.setSubject("This is the Subject Line!");
		      // Now set the actual message
		      message.setText("This is actual message");
		      // Send message
		      Transport.send(message);
		      result = "Sent message successfully....";
		   }
		   catch (MessagingException mex)
		   {
		      mex.printStackTrace();
		      result = "Error: unable to send message....";
		   }

	}

}
