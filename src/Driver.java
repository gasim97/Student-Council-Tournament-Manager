// The British International School of Jeddah
// Gasim Gasim 001118-0035
// IBDP Computer Science Internal Assessment
// The Tournament Manager - Driver Class

import java.sql.*;

import javax.swing.JOptionPane;

public class Driver
{
	private static Connection conn;
	private static Statement stmt;
	private static int update;
	private static ResultSet rs;
	
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException exc)
		{
			javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" + exc + "\n\nPlease report error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// method to establish a connection to the database and return the connection
	public static Connection getMySQLConnection() throws SQLException
	{
		// connecting to the database
		String address = "jdbc:mysql://localhost:3306";
		String userName = "root";
		String password = "";
		conn = DriverManager.getConnection(address, userName, password);
		stmt = conn.createStatement();
		// creating the database and its tables if it does not exist (i.e. first time running the program)
		update = stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS tournament_manager");
		update = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS tournament_manager.password "
				+ "(passwordID int(11) auto_increment primary key, password varchar(20))");
		update = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS tournament_manager.tournaments "
				+ "(tournamentID int(11) auto_increment primary key, tournamentName varchar(20), "
				+ "date date, startTime int(11), matchDuration int(11), breakDuration int(11), "
				+ "numTeams int(11), numVenues int(11))");
		update = stmt.executeUpdate("CREATE TABLE IF NOT EXISTS tournament_manager.teams "
				+ "(teamID int(11), teamName varchar(20), points int(11), goalDifference int(11), "
				+ "tournaments_tournamentID int(11))");
		rs = stmt.executeQuery("SELECT password FROM tournament_manager.password WHERE passwordID = 1");
		if (!(rs.next()))
		{
			update = stmt.executeUpdate("INSERT INTO tournament_manager.password (passwordID, password) "
					+ "VALUES ('1', '1')");
		}
		return conn;
	}
	
	public static void cleanup(Statement stmt, Connection conn) 
	{
		try 
		{
			if (stmt != null);		
			if (conn != null);
			
			stmt.close();
			conn.close();
		} 
		catch (Exception exc) 
		{
			javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" + exc + "\n\nPlease report error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void cleanup(Statement stmt, Connection conn, ResultSet rsltSet) 
	{
		try
		{	
			if (stmt != null);		
			if (conn != null);
			if (rsltSet != null);
			
			stmt.close();
			conn.close();
			rsltSet.close();
		} 
		catch (Exception exc) 
		{
			javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" + exc + "\n\nPlease report error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}