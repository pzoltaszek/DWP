package pz.strona.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class licznikOdwiedzinDAO {

	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/uzytkownicy";
	
	final String USER = "p.zoltaszek";
	final String PASS = "piti";
	
	Integer licznikDB;

	PreparedStatement pstmt = null;
	Connection conn = null;
	Statement stmt = null;

	// *********************** metoda GET USER*****************************
	public Integer getLicznikDB() {

		try {
			// Rejestracja sterownika
			Class.forName("com.mysql.jdbc.Driver");

			// Otwieranie połączenia
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			// wykonanie zapytania
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT licz FROM licznikO";
			ResultSet rs = stmt.executeQuery(sql);

			// wydobycie danych
			while (rs.next()) {
				// Otzrymianie danych z kolumn:
				// 0 id, 1 login, 2 pass, 3 odkiedy
				licznikDB = rs.getInt("licz");
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
		return licznikDB;
	} // metoda

	// ************************** metoda SET USER
	public void setLicznikDB(Integer liczba) {
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
			sqlS = "INSERT INTO licznikO (id, licz) VALUES (NULL, ?)";
			pstmt = conn.prepareStatement(sqlS);
			//stmt.executeUpdate(sqlS);
			pstmt.setInt(1, liczba);
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
	
}
