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
		HttpSession session2 = req.getSession();
		String buton = req.getParameter("aaa");
		/*Integer aa = 123;
		session2.setAttribute("aa", aa);*/
	
		Integer licznikS = (Integer) session2.getAttribute("licznikS");
	
		if (licznikS == null) {
			licznikS = 1;
		}
			else {
				licznikS++;
				//session2.setAttribute("licznikS", Integer.valueOf(licznikS));
			}
		session2.setAttribute("licznikS", Integer.valueOf(licznikS));
	
if (buton != null) {
		RequestDispatcher rd = req.getRequestDispatcher("/trzecia.jsp");
		rd.forward(req, res);
}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);

	}

}
