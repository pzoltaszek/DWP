package pz.strona.servlety;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/pierszy")
public class ColorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		HttpSession session = req.getSession();
		String kolor = "grey";

		kolor = (String) req.getAttribute("kolor");
		session.setAttribute("kolor", kolor);
		
		// ***************** Cookie********************
		Cookie kolorCookie = new Cookie("kolorCookie", kolor);
		kolorCookie.setMaxAge(24 * 60 * 60); // w sek
		res.addCookie(kolorCookie);
		

		RequestDispatcher rd = req.getRequestDispatcher("/pierwsza.jsp");
		rd.forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doGet(req, res);
	}
}
