package pz.strona.servlety;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/drugi")
public class AnitStressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		HttpSession session = req.getSession();
		Integer licznikStress = 666;
		String ddd = "ddd";

		String buton = req.getParameter("Aaa");
		/*if (buton!= null) {
			licznikStress++;
			buton = null;
		}*/
		session.setAttribute("licznikS", Integer.valueOf(licznikStress));
		session.setAttribute("licz",licznikStress);
		session.setAttribute("ddd",ddd);
		session.setAttribute("but", buton);

	//	RequestDispatcher rd = req.getRequestDispatcher("/trzecia.jsp");
	//	rd.forward(req, res);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);

	}

}
