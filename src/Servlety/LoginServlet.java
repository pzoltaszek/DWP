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
import pz.strona.Bean.User;
import pz.strona.DAO.UserDAO;

@WebServlet("/witaj")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String imiePobrane;
	String hasloPobrane;
	String loginRej;
	String hasloRej;

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
		
		if ((imiePobrane == null) && (imiePobrane.equals("")) && (hasloPobrane == null || (hasloPobrane.equals("")))) {
			rdError.forward(req, res);
		}

		User u = new User();
		u.setLoginp(imiePobrane);
		u.setPasswordp(hasloPobrane);
		session.setAttribute("u", u);

		// ***************** Cookie********************
		Cookie imieCookie = new Cookie("imieCookie", imiePobrane);
		imieCookie.setMaxAge(24 * 60 * 60); // w sek
		res.addCookie(imieCookie);

		/*
		 * //******************imie inaczej********************** 
		 * StringBuffer s = new
		 * StringBuffer(imiePobrane); 
		 * StringBuffer s2 = s.reverse(); 
		 * s2.toString();
		 * req.setAttribute("s2", s2);
		 */

		// ****************Data***********************************
		//java.util:
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		String biezacaData = sdf.format(data);
		//klasa Data:
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
		
		//******************** Obsluga rejestracji***********************
		loginRej = req.getParameter("loginr");
		hasloRej = req.getParameter("passwordr");
		session.setAttribute("logg", loginRej);
		
		if ((loginRej == null) && (loginRej.equals("")) && (hasloRej == null || (hasloRej.equals("")))) {
			rdError.forward(req, res);
		}
		else {rdError.forward(req, res);}

			for (String c : pobraneLoginy2) {
				if (c.equals(loginRej)) {
					rdError.forward(req, res);
				} else {
					udao.setUserDB(loginRej, hasloRej, biezacaData);
					rdLogin.forward(req, res);
				}
			}
			
		
		

		// ************ przekierowanie i warunek loginu ****************

		if ((imiePobrane == null) && (imiePobrane.equals("")) && (hasloRej == null || (hasloRej.equals("")))) {
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
							
							session.setAttribute("idzDB",idzDB);
							session.setAttribute("loginzDB",loginzDB);
							session.setAttribute("passzDB",passzDB); 
							session.setAttribute("datazDB",datazDB);
							
							rdIndex.forward(req, res);
							return;
						} 
							
					}
				}  
					
			}
		} rdError.forward(req, res);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);

	}
}