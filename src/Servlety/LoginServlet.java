package pz.strona.servlety;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pz.strona.Bean.Data;
import pz.strona.Bean.LicznikOdwiedzin;
import pz.strona.Bean.User;
import pz.strona.DAO.UserDAO;
import pz.strona.DAO.licznikOdwiedzinDAO;

@WebServlet("/witaj")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String imiePobrane;
	String hasloPobrane;
	String wyloguj;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html");
		HttpSession session = req.getSession();
		RequestDispatcher rdError = req.getRequestDispatcher("/error.jsp");
		RequestDispatcher rdIndex = req.getRequestDispatcher("/index.jsp");
		RequestDispatcher rdLogin = req.getRequestDispatcher("/login.jsp");
	
		// ****************** formularz logowania *******************
		imiePobrane = req.getParameter("loginp");
		hasloPobrane = req.getParameter("passwordp");


		User u = new User();
		u.setLoginp(imiePobrane);
		u.setPasswordp(hasloPobrane);
		session.setAttribute("u", u);

		// ***************** Cookie********************
		Cookie imieCookie = new Cookie("imieCookie", imiePobrane);
		imieCookie.setMaxAge(24 * 60 * 60); // w sek
		res.addCookie(imieCookie);
		
		//*******************Licznik odwiedzin*********
		
		licznikOdwiedzinDAO lodao = new licznikOdwiedzinDAO();
		LicznikOdwiedzin lo = new LicznikOdwiedzin();
		
		Integer licznikOdw = (Integer) lodao.getLicznikDB();
		licznikOdw++;
		//session.setAttribute("li", Integer.valueOf(licznikOdw));
		
		lo.setLicznikOdwiedzin(licznikOdw);
		session.setAttribute("lo", lo);
		lodao.setLicznikDB(licznikOdw);		

		/*
		 * //******************imie inaczej********************** StringBuffer s = new
		 * StringBuffer(imiePobrane); StringBuffer s2 = s.reverse(); s2.toString();
		 * req.setAttribute("s2", s2);
		 */

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

		// *************************** adres*********************
		session.setAttribute("adres", req.getRemoteAddr());

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
		

		// ************ przekierowanie i warunek loginu ****************

		if ((imiePobrane == null) && (imiePobrane.equals("")) && (hasloPobrane == null || (hasloPobrane.equals("")))) {
			rdError.forward(req, res);
		}

		else {
			for (String a : pobraneLoginy2) {
				if (a.equals(imiePobrane)) {
					for (String b : pobraneHasla2) {
						if (b.equals(hasloPobrane)) {
							int numerU = pobraneHasla2.indexOf(b);

							Integer idzDB = Integer.parseInt(pobraneId2.get(numerU));
							String loginzDB = pobraneLoginy2.get(numerU);
							String passzDB = pobraneHasla2.get(numerU);
							String datazDB = pobraneDaty2.get(numerU);

							session.setAttribute("idzDB", idzDB);
							session.setAttribute("loginzDB", loginzDB);
							session.setAttribute("passzDB", passzDB);
							session.setAttribute("datazDB", datazDB);

							rdIndex.forward(req, res);
							return;
						}

					}
				}

			}
		}
		rdError.forward(req, res);
		//************************* logout
		wyloguj = req.getParameter("logout");
		if(wyloguj.equals("logout")) {
			
			session.setAttribute("u", null);
			session.setAttribute("lo", null);
			session.setAttribute("idzDB", null);
			session.setAttribute("loginzDB", null);
			session.setAttribute("passzDB", null);
			session.setAttribute("datazDB", null);
			session.invalidate();
			rdLogin.forward(req, res);
			
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);

	}
}
