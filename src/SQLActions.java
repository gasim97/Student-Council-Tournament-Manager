// The British International School of Jeddah
// Gasim Gasim 001118-0035
// IBDP Computer Science Internal Assessment
// The Tournament Manager - SQLActions Class

import java.sql.*;

public class SQLActions
{
	private static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;
	private static int update;
	
	// method that establishes a connection to the database through
	// calling the getMySQLConnection method in the Driver class
	
	public static void connect() throws SQLException
	{
		conn = Driver.getMySQLConnection();
		stmt = conn.createStatement();
	}
	
	// accessor methods to retrieve data stored in the database
	
	// method to retrieve the program password from the database,
	// compare it to the hashed password inputed by the user String passwordInputHash
	// and return a boolean validation value of true if the passwords match or false if
	// they do not
	public static boolean getPassword(int passwordInputHash) throws SQLException
	{
		connect();
		boolean validation = false;
		String passwordString = null;
		rs = stmt.executeQuery("SELECT password FROM tournament_manager.password WHERE passwordID = 1");
		if (rs.next())
		{
			passwordString = rs.getString("password");
		}
		int password = Integer.parseInt(passwordString);
		if (passwordInputHash == password)
		{
			validation = true;
		}
		return validation;
	}
	
	// method to retrieve and display the names of all the
	// tournaments stored in the database
	public static String getTournamentNames() throws SQLException
	{
		connect();
		String selection = "";
		String [] tournamentsArray;
		String tournaments = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTournaments\n";
		int counter = 0;
		int counterTwo = -1;
		rs = stmt.executeQuery("SELECT tournamentName FROM tournament_manager.tournaments");
		while (rs.next())
		{
			counter++;
			tournaments = tournaments + "\n" + counter + ". " + rs.getString("tournamentName");
		}
		tournamentsArray = new String[counter];
		rs = stmt.executeQuery("SELECT tournamentName FROM tournament_manager.tournaments");
		while (rs.next())
		{
			counterTwo++;
			tournamentsArray[counterTwo] = rs.getString("tournamentName");
		}
		if (counter != 0)
		{
			try
			{
				String option = javax.swing.JOptionPane.showInputDialog(null, tournaments + "\n\nEnter a tournament number:", "", 1);
				if (Integer.parseInt(option) > 0 && Integer.parseInt(option) <= counter)
				{
					selection = tournamentsArray[Integer.parseInt(option) - 1];
				}
				else
				{
					if (counter == 1)
					{
						javax.swing.JOptionPane.showMessageDialog(null, "Invalid tournament number entered! \"" + option 
								+ "\" is invalid!\n\nInstructions:\n\n\t\tEnter a valid tournament number equal to 1.", "Invalid Input", 2);
					}
					else
					{
						javax.swing.JOptionPane.showMessageDialog(null, "Invalid tournament number entered! \"" + option 
								+ "\" is invalid!\n\nInstructions:\n\n\t\tEnter a valid tournament number between 1 and " + counter 
								+ " (inclusive).", "Invalid Input", 2);
					}
				}
			}
			catch (NumberFormatException exc)
			{
				javax.swing.JOptionPane.showMessageDialog(null, "To access tournament information, enter a valid tournament name and "
						+ "click the Submit button, or click\nthe Tournaments button and enter a valid tournament number.", 
						"Instructions", 1);
				selection = "*********************"; // 21 character value, as the tournament name cannot be more than 20 characters
			}
		}
		else
		{
			javax.swing.JOptionPane.showMessageDialog(null, "There is currently no tournament stored in the database.", "", 1);
			selection = "*********************";
		}
		return selection;
	}
	
	// method to retrieve the details of tournament String tournamentName,
	// create a tournament object with the correct details and return the
	// object, or return a null tournament object if tournament tournamnetName
	// is not stored in the database
	public static Tournaments getTournament(String tournamentName) throws SQLException
	{
		connect();
		Tournaments tournament = null;
		rs = stmt.executeQuery("SELECT * FROM tournament_manager.tournaments WHERE tournamentName = \"" + tournamentName +"\"");
		if (rs.next())
		{
			Date date = rs.getDate("date");
			String dateStr = date.toString();
			int startTime = rs.getInt("startTime");
			int matchDuration = rs.getInt("matchDuration");
			int breakDuration = rs.getInt("breakDuration");
			int numTeams = rs.getInt("numTeams");
			int numVenues = rs.getInt("numVenues");
			int reference = rs.getInt("tournamentID");
			rs = stmt.executeQuery("SELECT * FROM tournament_manager.teams WHERE tournaments_tournamentID = " + reference);
			Teams [] tournamentTeams = new Teams[numTeams];
			int counter = -1;
			while (rs.next())
			{
				counter++;
				String teamName = rs.getString("teamName");
				int teamNum = rs.getInt("teamID");
				int points = rs.getInt("points");
				int goalDifference = rs.getInt("goalDifference");
				tournamentTeams[counter] = new Teams(teamName, teamNum, points, goalDifference);
			}
			tournament = new Tournaments(tournamentName, dateStr, startTime, matchDuration, breakDuration, numTeams, numVenues, tournamentTeams);
		}
		return tournament;
	}
	
	// method to check the availability of a tournament name String
	// tournamentName, and return true if the name is available and
	// false if it is not
	public static boolean tournamentNameCheck(String tournamentName) throws SQLException
	{
		boolean confirmation;
		rs = stmt.executeQuery("SELECT * FROM tournament_manager.tournaments WHERE tournamentName = \"" +tournamentName +"\"");
		if (rs.next())
		{
			confirmation = false;
		}
		else
		{
			confirmation = true;
		}
		return confirmation;
	}
	
	// mutator methods insert and edit data in the database
	
	// method to add a tournament Tournaments newTournament to the
	// database
	public static void addTournament(Tournaments newTournament) throws SQLException
	{
		connect();
		update = stmt.executeUpdate("INSERT INTO tournament_manager.tournaments (tournamentName, date, startTime, matchDuration, breakDuration, numTeams, numVenues) VALUES (\"" + newTournament.getTournamentName() + "\", \"" + newTournament.getDate() + "\", \"" + newTournament.getStartTime() + "\", \"" + newTournament.getMatchDuration() + "\", \"" + newTournament.getBreakDuration() + "\", \"" + newTournament.getNumTeams() + "\", \"" + newTournament.getNumVenues() + "\")");
		rs = stmt.executeQuery("SELECT tournamentID FROM tournament_manager.tournaments WHERE tournamentName = \"" + newTournament.getTournamentName() + "\"");
		if (rs.next())
		{
			int reference = rs.getInt("tournamentID");
			Teams [] tournamentTeams = newTournament.getTournamentTeams();
			for (int loopFirstDegree = 1; loopFirstDegree <= newTournament.getNumTeams(); loopFirstDegree++)
			{
				update = stmt.executeUpdate("INSERT INTO tournament_manager.teams (teamID, teamName, points, goalDifference, tournaments_tournamentID) VALUES (" + tournamentTeams[loopFirstDegree-1].getTeamNum() + ", \"" + tournamentTeams[loopFirstDegree-1].getTeamName() + "\", " + tournamentTeams[loopFirstDegree-1].getPoints() + ", " + tournamentTeams[loopFirstDegree-1].getGoalDifference() + ", " + reference + ")");
			}
		}
	}
	
	// method to delete a stored tournament String tournamentName
	// from the database
	public static void deleteTournament(String tournamentName) throws SQLException
	{
		connect();
		rs = stmt.executeQuery("SELECT tournamentID FROM tournament_manager.tournaments WHERE tournamentName = \"" + tournamentName + "\"");
		if (rs.next())
		{
			update = stmt.executeUpdate("DELETE FROM tournament_manager.teams WHERE tournaments_tournamentID = " + rs.getInt("tournamentID"));
		}
		rs = stmt.executeQuery("SELECT tournamentID FROM tournament_manager.tournaments WHERE tournamentName = \"" + tournamentName + "\"");
		if (rs.next())
		{
			update = stmt.executeUpdate("DELETE FROM tournament_manager.tournaments WHERE tournamentID = " + rs.getInt("tournamentID"));
		}
	}
	
	// method to update tournament details
	public static Tournaments updateDetails(String tournamentName, String newTournamentName, String newDate, 
			int newStartTime, int newMatchDuration, int newBreakDuration, int newNumVenues) throws SQLException
	{
		connect();
		update = stmt.executeUpdate("UPDATE tournament_manager.tournaments SET tournamentName = \"" + newTournamentName + "\" "
				+ "WHERE tournamentName = \"" + tournamentName + "\"");
		update = stmt.executeUpdate("UPDATE tournament_manager.tournaments SET date = \"" + newDate + "\" WHERE tournamentName = "
				+ "\"" + newTournamentName + "\"");
		update = stmt.executeUpdate("UPDATE tournament_manager.tournaments SET startTime = " + newStartTime + " WHERE tournamentName "
				+ "= \"" + newTournamentName + "\"");
		update = stmt.executeUpdate("UPDATE tournament_manager.tournaments SET matchDuration = " + newMatchDuration + " "
				+ "WHERE tournamentName = \"" + newTournamentName + "\"");
		update = stmt.executeUpdate("UPDATE tournament_manager.tournaments SET breakDuration = " + newBreakDuration + " "
				+ "WHERE tournamentName = \"" + newTournamentName + "\"");
		update = stmt.executeUpdate("UPDATE tournament_manager.tournaments SET numVenues = " + newNumVenues + " "
				+ "WHERE tournamentName = \"" + newTournamentName + "\"");
		Tournaments tournament = null;
		rs = stmt.executeQuery("SELECT * FROM tournament_manager.tournaments WHERE tournamentName = \"" + newTournamentName +"\"");
		if (rs.next())
		{
			Date date = rs.getDate("date");
			String dateStr = date.toString();
			int startTime = rs.getInt("startTime");
			int matchDuration = rs.getInt("matchDuration");
			int breakDuration = rs.getInt("breakDuration");
			int numTeams = rs.getInt("numTeams");
			int numVenues = rs.getInt("numVenues");
			int reference = rs.getInt("tournamentID");
			rs = stmt.executeQuery("SELECT * FROM tournament_manager.teams WHERE tournaments_tournamentID = " + reference);
			Teams [] tournamentTeams = new Teams[numTeams];
			int counter = -1;
			while (rs.next())
			{
				counter++;
				String teamName = rs.getString("teamName");
				int teamNum = rs.getInt("teamID");
				int points = rs.getInt("points");
				int goalDifference = rs.getInt("goalDifference");
				tournamentTeams[counter] = new Teams(teamName, teamNum, points, goalDifference);
			}
			tournament = new Tournaments(newTournamentName, dateStr, startTime, matchDuration, breakDuration, numTeams, numVenues, 
					tournamentTeams);
		}
		return tournament;
	}
	
	// method to update the number points associated with each team
	// in a tournament Tournaments tournament
	public static void updatePoints(Tournaments tournament) throws SQLException
	{
		connect();
		rs = stmt.executeQuery("SELECT tournamentID FROM tournament_manager.tournaments WHERE tournamentName = \"" + tournament.getTournamentName() + "\"");
		if (rs.next())
		{
			int reference = rs.getInt("tournamentID");
			Teams [] teams = tournament.getTournamentTeams();
			for (int loopFirstDegree = 0; loopFirstDegree < tournament.getNumTeams(); loopFirstDegree++)
			{
				update = stmt.executeUpdate("UPDATE tournament_manager.teams SET points = " + teams[loopFirstDegree].getPoints() + " WHERE (tournaments_tournamentID, teamName) = (" + reference + ", \"" + teams[loopFirstDegree].getTeamName() + "\")");
				update = stmt.executeUpdate("UPDATE tournament_manager.teams SET goalDifference = " + teams[loopFirstDegree].getGoalDifference() + " WHERE (tournaments_tournamentID, teamName) = (" + reference + ", \"" + teams[loopFirstDegree].getTeamName() + "\")");
			}
		}
	}
	
	// method to update the program's password to String newPassword
	public static void updatePassword(int newPasswordHash) throws SQLException
	{
		connect();
		update = stmt.executeUpdate("UPDATE tournament_manager.password SET password = \"" + newPasswordHash + "\" WHERE passwordID = 1");
	}
}