package pz.strona.servlety;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pz.strona.Bean.Data;
import pz.strona.Bean.Wpis;
import pz.strona.DAO.WpisDAO;

@WebServlet("/wpis")
public class WpisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String nickP;
	String trescP;
	String dataP;
	private ArrayList<String> nickiP = new ArrayList<String>();
	private ArrayList<String> tresciP = new ArrayList<String>();
	private ArrayList<String> datyP = new ArrayList<String>();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		RequestDispatcher rdCzwarta = request.getRequestDispatcher("/czwarta.jsp");
		
		//*************pobieranie wpisow z DB
		WpisDAO wpisyDB = new WpisDAO();
		
		nickiP = wpisyDB.getNicki();
		tresciP = wpisyDB.getTresc();
		datyP = wpisyDB.getData();
		
		//Ustawaianie wpisow pobranych z DB
		Wpis wpis = new Wpis();
		wpis.setNickL(nickiP);
		wpis.setTrescL(tresciP);
		wpis.setDataL(datyP);
		
		session.setAttribute("wpisy", wpis);
		
		//************** nowy wpis********
		//data z pz.bean:
		Data nowaData = new Data();
		
		nickP = request.getParameter("nick");
		trescP = request.getParameter("tresc");
		dataP = nowaData.getAktualnaData();
		//zapisuje nowy wpis do DB:
		if(nickP!= null && trescP!= null) {
		wpisyDB.setWpis(nickP, trescP, dataP);
		}
		// forwarduje na stone;
		rdCzwarta.forward(request, response);
		
		
	}

}
