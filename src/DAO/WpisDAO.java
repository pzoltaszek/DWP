package pz.strona.DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class WpisDAO {
	
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/uzytkownicy";
	
	final String USER = "p.zoltaszek";
	final String PASS = "piti";
	
	PreparedStatement pstmt = null;
	Connection conn = null;
	Statement stmt = null;
	
	private ArrayList<String> nickA = new ArrayList<String>();
	private ArrayList<String> trescA = new ArrayList<String>();
	private ArrayList<String> dataA = new ArrayList<String>();
	
	String sqlNick = "SELECT nick FROM wpisy";
	String sqlTresc = "SELECT tresc FROM wpisy";
	String sqlData = "SELECT data FROM wpisy";
	

	public void setWpis(String nickP, String trescP, String dataP) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

			String sqlS;
			
			sqlS = "INSERT INTO wpisy (id, nick, tresc, data) VALUES (NULL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sqlS);
			//stmt.executeUpdate(sqlS);
			pstmt.setString(1, nickP);
			pstmt.setString(2, trescP);
			pstmt.setString(3, dataP);
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
	//***********************************************************
	public ArrayList <String> getNicki() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlNick);
			while(rs.next()) {
				nickA.add(rs.getString("nick"));
			}		
			// zamykanie polaczen
			rs.close();
			conn.close();
			stmt.close();
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
		return nickA;
	} // metoda	
	
	//****************************************************
	
	public ArrayList <String> getTresc() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlTresc);
			while(rs.next()) {
				trescA.add(rs.getString("tresc"));
			}		
			// zamykanie polaczen
			rs.close();
			conn.close();
			stmt.close();
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
		return trescA;
	} // metoda	
	
	//********************************************************8
	public ArrayList <String> getData() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlData);
			while(rs.next()) {
				dataA.add(rs.getString("data"));
			}		
			// zamykanie polaczen
			rs.close();
			conn.close();
			stmt.close();
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
		return dataA;
	} // metoda	
	
}
