package pz.strona.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class UserDAO {

	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/uzytkownicy";

	
	final String USER = "p.zoltaszek";
	final String PASS = "piti";
	ArrayList<String> pobraneUser = new ArrayList<String>();
	
	ArrayList<String> pobraneId = new ArrayList<String>();
	ArrayList<String> pobraneLoginy = new ArrayList<String>();
	ArrayList<String> pobraneHasla = new ArrayList<String>();
	ArrayList<String> pobraneDaty = new ArrayList<String>();

	PreparedStatement pstmt = null;
	Connection conn = null;
	Statement stmt = null;

	// *********************** metoda GET USER*****************************
	public ArrayList<String> getUserDB() {

		try {
			// Rejestracja sterownika
			Class.forName("com.mysql.jdbc.Driver");

			// Otwieranie połączenia
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			// wykonanie zapytania
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, login, haslo, odkiedy FROM pierwsza";
			ResultSet rs = stmt.executeQuery(sql);

			// wydobycie danych
			while (rs.next()) {
				// Otzrymianie danych z kolumn:
				// 0 id, 1 login, 2 pass, 3 odkiedy
				int id = rs.getInt("id");
				String idS = Integer.toString(id);
				pobraneUser.add(0, idS);
				pobraneUser.add(1, rs.getString("login"));
				pobraneUser.add(2, rs.getString("haslo"));
				pobraneUser.add(3, rs.getString("odkiedy"));
				// String first = rs.getString("login");
				// String last = rs.getString("haslo");
				// String third = rs.getString("odkiedy");

			}
			// zamykanie polaczen
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// wyjatek JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// wyjatek Class.forName
			e.printStackTrace();
		} finally {
			// finally - do zamkniecia polaczen
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // finally try
		} // try
		return pobraneUser;
	} // metoda

	// ************************** metoda SET USER
	public void setUserDB(String logN, String pasN, String dataN) {
		try {
			// Rejestracja sterownika
			Class.forName("com.mysql.jdbc.Driver");

			// Otwieranie połączenia
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			// Zapisanie

			String sqlS;
			// INSERT INTO nazwaTabeli (kolumna1, kolumna2, itd) VALUES (wartosc1, wartosc2,
			// itd);
			//(id, login, haslo, odkiedy)
			sqlS = "INSERT INTO pierwsza (id, login, haslo, odkiedy) VALUES (NULL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sqlS);
			//stmt.executeUpdate(sqlS);
			pstmt.setString(1, logN);
			pstmt.setString(2, pasN);
			pstmt.setString(3, dataN);
			pstmt.executeUpdate();
			// zamykanie polaczen
			
			conn.close();
			pstmt.close();
		} catch (SQLException se) {
			// wyjatek JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// wyjatek Class.forName
			e.printStackTrace();
		} finally {
			// finally - do zamkniecia polaczen
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // finally try
		} // try

	} // metoda

	// **************** metoda GET - loginy
	public ArrayList<String> getLoginyDB() {

		try {
			// Rejestracja sterownika
			Class.forName("com.mysql.jdbc.Driver");

			// Otwieranie połaączenia
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			// wykonanie zapytania
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT login FROM pierwsza";
			ResultSet rs = stmt.executeQuery(sql);

			// wydobycie danych
			// petla: i<login.length() ???
		
			while (rs.next()) {
				// Otzrymianie tablicy loginow:
				
				pobraneLoginy.add(rs.getString("login"));
			}
			
			// zamykanie polaczen
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// wyjatek JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// wyjatek Class.forName
			e.printStackTrace();
		} finally {
			// finally - do zamkniecia polaczen
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // finally try
		} // try
		return pobraneLoginy;
	} // metoda

	// **************** metoda GET -Hasla
		public ArrayList<String> getHaslaDB() {

			try {
				// Rejestracja sterownika
				Class.forName("com.mysql.jdbc.Driver");

				// Otwieranie połaączenia
				conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

				// wykonanie zapytania
				stmt = conn.createStatement();
				String sql;
				sql = "SELECT haslo FROM pierwsza";
				ResultSet rs = stmt.executeQuery(sql);

				// wydobycie danych
				
				while (rs.next()) {
					// Otzrymianie tablicy loginow:
					
					pobraneHasla.add(rs.getString("haslo"));
				}
				
				// zamykanie polaczen
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException se) {
				// wyjatek JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// wyjatek Class.forName
				e.printStackTrace();
			} finally {
				// finally - do zamkniecia polaczen
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				}
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // finally try
			} // try
			return pobraneHasla;
		} // metoda

		// **************** metoda GET - ID
		public ArrayList<String> getIdDB() {

			try {
				// Rejestracja sterownika
				Class.forName("com.mysql.jdbc.Driver");

				// Otwieranie połaączenia
				conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

				// wykonanie zapytania
				stmt = conn.createStatement();
				String sql;
				sql = "SELECT id FROM pierwsza";
				ResultSet rs = stmt.executeQuery(sql);

				// wydobycie danych
				
			
				while (rs.next()) {
					// Otzrymianie tablicy loginow:
					
					pobraneId.add(rs.getString("id"));
				}
				
				// zamykanie polaczen
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException se) {
				// wyjatek JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// wyjatek Class.forName
				e.printStackTrace();
			} finally {
				// finally - do zamkniecia polaczen
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				}
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // finally try
			} // try
			return pobraneId;
		} // metoda

		// **************** metoda GET - DAta
				public ArrayList<String> getDatyDB() {

					try {
						// Rejestracja sterownika
						Class.forName("com.mysql.jdbc.Driver");

						// Otwieranie połaączenia
						conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

						// wykonanie zapytania
						stmt = conn.createStatement();
						String sql;
						sql = "SELECT odkiedy FROM pierwsza";
						ResultSet rs = stmt.executeQuery(sql);

						// wydobycie danych
						
					
						while (rs.next()) {
							// Otzrymianie tablicy loginow:
							
							pobraneDaty.add(rs.getString("odkiedy"));
						}
						
						// zamykanie polaczen
						rs.close();
						stmt.close();
						conn.close();
					} catch (SQLException se) {
						// wyjatek JDBC
						se.printStackTrace();
					} catch (Exception e) {
						// wyjatek Class.forName
						e.printStackTrace();
					} finally {
						// finally - do zamkniecia polaczen
						try {
							if (stmt != null)
								stmt.close();
						} catch (SQLException se2) {
						}
						try {
							if (conn != null)
								conn.close();
						} catch (SQLException se) {
							se.printStackTrace();
						} // finally try
					} // try
					return pobraneDaty;
				} // metoda
	
} // class
