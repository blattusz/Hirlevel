package Controller;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Converter.converter;

/**
 * Servlet implementation class SimaSend
 */
@WebServlet("/SimaSend")
public class SimaSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimaSend() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static String Cim = "";
	public static String Targy = "";
	public static String Szoveg = "";
	public static String status = "";
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		Cim = request.getParameter("Cim");
		Targy = request.getParameter("Targy");
		Szoveg = request.getParameter("Szoveg");
		
		converter.html = Szoveg;
		converter.HtmlConverter();
		try {
			MimeMessage simpleMessage = new MimeMessage(login.session);
			simpleMessage.setFrom(new InternetAddress(login.UserName));
			simpleMessage.setSubject(Targy);
			simpleMessage.setText(Szoveg, "utf-8", "html");

				simpleMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Cim));
				Transport.send(simpleMessage);

				status = "Email Sikeresen elküldve Ide: "+ Cim +"";
				
				RequestDispatcher rd = request.getRequestDispatcher("Sima.jsp");
		        rd.forward(request, response);
				


		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
