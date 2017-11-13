package pz.strona.servlety;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pz.strona.Bean.UserList;
import pz.strona.DAO.ListaDAO;


@WebServlet("/lista")
public class ListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String listaPobrana;
 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		HttpSession session = req.getSession();
		RequestDispatcher rdDruga = req.getRequestDispatcher("/druga.jsp");
		LinkedList<UserList> ListaWszystkich = new LinkedList<UserList>();
		
		listaPobrana = req.getParameter("listb");
		
		ListaDAO ldao = new ListaDAO();
		ListaWszystkich = ldao.SetLista();
		
		//if(listaPobrana != null) {
		ldao.setListaAll(ListaWszystkich);
	//	ldao.getListaAll();
		session.setAttribute("ldao", ldao );
		session.setAttribute("lista2", ListaWszystkich);
		rdDruga.forward(req, res);
					
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
