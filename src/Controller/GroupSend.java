package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Vector;

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
import javax.swing.text.html.HTML;

import Converter.converter;

/**
 * Servlet implementation class KiskerSend
 */
@WebServlet("/GroupSend")
public class GroupSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static int i = 0;
	public final static Vector<String> CimzettVektor = new Vector<String>();
	public static String grouptatus = "";
	public static String Cimzettek = "";
	public static String Targy = "";
	public static String Szoveg = "asd";
	/**
     * @see HttpServlet#HttpServlet()
     */
    public GroupSend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		Cimzettek = request.getParameter("Cimek");
		Targy = request.getParameter("Targy");
		Szoveg = request.getParameter("Szoveg");
		
	
		
		try{
		    PrintWriter writer = new PrintWriter("kisker.txt", "UTF-8");
		    writer.println(Cimzettek);
		    writer.close();
		} catch (IOException e) {
		   // do something
		}
		
		
		BufferedReader br = null;
		FileReader fr = null;
		
		try {

			fr = new FileReader("kisker.txt");
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader("kisker.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				CimzettVektor.addElement(sCurrentLine);							
			}
		} catch (IOException e1) {

			e1.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();
			}
		}

		converter.html = Szoveg;
		converter.HtmlConverter();
		

		
		
		
		try {
			MimeMessage simpleMessage = new MimeMessage(login.session);
			simpleMessage.setFrom(new InternetAddress(login.UserName));
			simpleMessage.setSubject(Targy);
			simpleMessage.setText(converter.html, "utf-8", "html");


			for (String cimzett : CimzettVektor) {
				simpleMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(cimzett));
				Transport.send(simpleMessage);
				i++;
				
				if((CimzettVektor.size()-i) < 1)
				{
					grouptatus = "Minden levél Elküldve!";
					response.sendRedirect("Csoportos.jsp");
				}

				if (i % 50 == 0) {
					try {
						Random ido = new Random(System.currentTimeMillis());
						int randomNumber = ido.nextInt(61000 - 31000) + 61000;
						Thread.sleep(randomNumber);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}

		} catch (MessagingException e) {
			grouptatus = "Rossz Bejelentkezés vagy Elérted a napi 1000 E-mailes Limitet!";
			response.sendRedirect("Csoportos.jsp");
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
