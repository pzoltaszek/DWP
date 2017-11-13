package pz.strona.DAO;

import java.util.ArrayList;
import java.util.LinkedList;

import pz.strona.Bean.UserList;
import pz.strona.DAO.UserDAO;

public class ListaDAO {
	private LinkedList<UserList> listaAll = new LinkedList<UserList>();

	// *************** DB - pobieranie danych do listy ********************

	public LinkedList<UserList> getListaAll() {
		return listaAll;
	}

	public void setListaAll(LinkedList<UserList> listaAll) {
		this.listaAll = listaAll;
	}

	public LinkedList<UserList> SetLista() {
		ArrayList<String> pobraneId3 = new ArrayList<String>();
		ArrayList<String> pobraneLoginy3 = new ArrayList<String>();
		ArrayList<String> pobraneDaty3 = new ArrayList<String>();

		UserDAO udao = new UserDAO();
		pobraneId3 = udao.getIdDB();
		pobraneLoginy3 = udao.getLoginyDB();
		pobraneDaty3 = udao.getDatyDB();
		int z = pobraneId3.size();

		for (int d = 0; d < z; d++) {
			listaAll.add(new UserList(pobraneId3.get(d), pobraneLoginy3.get(d), pobraneDaty3.get(d)));
		}

		return listaAll;
	}

}
