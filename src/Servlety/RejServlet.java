package pz.strona.servlety;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pz.strona.Bean.Data;
import pz.strona.DAO.UserDAO;

@WebServlet("/rej")
public class RejServlet extends HttpServlet {

	String loginRej;
	String hasloRej;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html");
		HttpSession session = req.getSession();
		RequestDispatcher rdError = req.getRequestDispatcher("/error.jsp");
		RequestDispatcher rdIndex = req.getRequestDispatcher("/index.jsp");
		RequestDispatcher rdLogin = req.getRequestDispatcher("/login.jsp");

		// ****************Data***********************************
		// java.util:
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		String biezacaData = sdf.format(data);
		// klasa Data:
		Data d = new Data();
		d.setData(biezacaData);
		session.setAttribute("d", d);
		session.setAttribute("dd", biezacaData);

		// *************** DB - pobieranie danych ********************
		UserDAO udao = new UserDAO();
		ArrayList<String> pobraneId2 = new ArrayList<String>();
		ArrayList<String> pobraneLoginy2 = new ArrayList<String>();
		ArrayList<String> pobraneHasla2 = new ArrayList<String>();
		ArrayList<String> pobraneDaty2 = new ArrayList<String>();

		pobraneId2 = udao.getIdDB();
		pobraneLoginy2 = udao.getLoginyDB();
		pobraneHasla2 = udao.getHaslaDB();
		pobraneDaty2 = udao.getDatyDB();

		// ******************** Obsluga rejestracji***********************
		loginRej = req.getParameter("loginr");
		hasloRej = req.getParameter("passwordr");
		session.setAttribute("logg", loginRej);
		boolean flag = true;

		if ((loginRej == null) && (loginRej.equals("")) && (hasloRej == null || (hasloRej.equals("")))) {
			flag = false;
			rdError.forward(req, res);
		}
		for (String c : pobraneLoginy2) {
			if (c.equals(loginRej)) {
				flag = false;
				rdError.forward(req, res);
			}
		}
		if (flag) {
			udao.setUserDB(loginRej, hasloRej, biezacaData);
			rdLogin.forward(req, res);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);

	}
}
