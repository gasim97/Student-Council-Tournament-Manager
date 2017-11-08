// The British International School of Jeddah
// Gasim Gasim 001118-0035
// IBDP Computer Science Internal Assessment
// The Tournament Manager - Tournaments Class

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class Tournaments 
{
	private String tournamentName; // String(20) -> Max: 20 characters -> 42Bytes
	private String date;
	private int startTime;
	private int matchDuration;
	private int breakDuration;
	private int numTeams; // integer -> 4Bytes
	private int numVenues; // short -> 2Bytes
	public Teams [] tournamentTeams;
	private int numMatches; // integer -> numMatch
	private String [] matches;
	private boolean objectComplete;
	private JTable scheduleTable;
	private JScrollPane scheduleScrollPane;
	
	// class constructor that accepts a tournament name String,
	// tournament date String, number of teams integer and number
	// of venues integer as a parameter
	public Tournaments(String tournamentName, String date, int startTime, int matchDuration, int breakDuration, int numTeams, int numVenues)
	{

		this.tournamentName = tournamentName;
		this.date = date;
		this.startTime = startTime;
		this.matchDuration = matchDuration;
		this.breakDuration = breakDuration;
		this.numTeams = numTeams;
		setTeamNames(numTeams);
		numMatches = calculateNumMatches(numTeams);
		this.numVenues = numVenues;
		setMatches(numTeams);
		mixMatchOrder();
	}
	
	// class constructor that accepts a tournament name String,
	// tournament date String, number of teams integer, number of
	// venues integer and an array of Teams objects as a parameter
	public Tournaments(String tournamentName, String date, int startTime, int matchDuration, int breakDuration, int numTeams, int numVenues, Teams [] tournamentTeams)
	{
		this.tournamentName = tournamentName;
		this.date = date;
		this.startTime = startTime;
		this.matchDuration = matchDuration;
		this.breakDuration = breakDuration;
		this.numTeams = numTeams;
		this.tournamentTeams = new Teams[numTeams];
		for (int loopFirstDegree = 0; loopFirstDegree < numTeams; loopFirstDegree++)
		{
			this.tournamentTeams[loopFirstDegree] = tournamentTeams[loopFirstDegree];
		}
		numMatches = calculateNumMatches(numTeams);
		this.numVenues = numVenues;
		setMatches(numTeams);
		mixMatchOrder();
	}
	
	// accessor methods to allow the private variables to be
	// acquired from outside the Teams class

	public String getTournamentName()
	{
		return tournamentName;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getStartTime()
	{
		String startTimeString;
		if (startTime < 1000)
		{
			startTimeString = "0" + startTime;
		}
		else
		{
			startTimeString = startTime + "";
		}
		return startTimeString;
	}
	
	public int getMatchDuration()
	{
		return matchDuration;
	}
	
	public int getBreakDuration()
	{
		return breakDuration;
	}
	
	public int getNumTeams()
	{
		return numTeams;
	}
	
	public int getNumVenues()
	{
		return numVenues;
	}
	
	public Teams [] getTournamentTeams()
	{
		return tournamentTeams;
	}
	
	public String [] getTeamNames()
	{
		String teamNames[] = new String[numTeams];
		for (int loopFirstDegree = 0; loopFirstDegree < numTeams; loopFirstDegree++)
		{
			teamNames[loopFirstDegree] = tournamentTeams[loopFirstDegree].getTeamName();
		}
		return teamNames;
	}
	
	public String getTeamName(int teamNum)
	{
		return tournamentTeams[(teamNum - 1)].getTeamName();
	}
	
	public String [] getMatches()
	{
		return matches;
	}
	
	public JScrollPane getScheduleScrollPane()
	{
		setScheduleScrollPane();
		return scheduleScrollPane;
	}
	
	// method that returns a boolean value to the GUI class when
	// an object is being created, true is returned when the object
	// has successfully been completed (i.e. the user has inputed
	// all the required data, such as all the team names), and false
	// is returned when the object has not not been successfully
	// completed (i.e. the user has not inputed all the required
	// data, such as all the team names)
	public boolean getCompletionConfirmation()
	{
		return objectComplete;
	}
	
	// mutator methods to allow the private variable to be altered
	// from outside the Teams class
	
	public void setTournamentName(String tournamentName)
	{
		this.tournamentName = tournamentName;
	}
	
	// method to set the tournament date
	public void setDate(String date)
	{
		this.date = date;
	}
	
	// method to set the tournament team names
	private void setTeamNames(int numTeams)
	{
		javax.swing.JOptionPane.showMessageDialog(null, "You will now be prompted to input the team names of the " + numTeams + " teams participating in " + tournamentName + ".\n\nPlease ensure the teams names are inputed correctly, as you will not be able to alter the names following their submission.", "Attention!", 1);
		objectComplete = true;
		try
		{
			tournamentTeams = new Teams[numTeams];
			for (int loopFirstDegree = 0; loopFirstDegree < numTeams; loopFirstDegree++)
			{
				tournamentTeams[loopFirstDegree] = new Teams(javax.swing.JOptionPane.showInputDialog(null, "Enter Team " + (loopFirstDegree + 1) + " Name: ", "Team " + (loopFirstDegree + 1)), loopFirstDegree);
				if (tournamentTeams[loopFirstDegree].getTeamName().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(null, "Team " + (loopFirstDegree + 1) + " name field is empty!\n\nInstructions:\n\n\t\tPlease enter a team name for Team " + (loopFirstDegree + 1) + ".", "Invalid Team Name", 2);
					loopFirstDegree--;
				}
				else if (tournamentTeams[loopFirstDegree].getTeamName().length() > 20)
				{
					javax.swing.JOptionPane.showMessageDialog(null, "\"" + tournamentTeams[loopFirstDegree].getTeamName() + "\" is too long!\n\nInstructions:\n\n\t\tPlease enter a team name for Team " + (loopFirstDegree + 1) + " that is 20 charachters or less.", "Invalid Team Name", 2);
					loopFirstDegree--;
				}
				for (int loopSecondDegree = 0; loopSecondDegree < loopFirstDegree; loopSecondDegree++)
				{
					if (tournamentTeams[loopSecondDegree].getTeamName().equalsIgnoreCase(tournamentTeams[loopFirstDegree].getTeamName()))
					{
						javax.swing.JOptionPane.showMessageDialog(null, "\"" + tournamentTeams[loopFirstDegree].getTeamName() + "\" has already been used!\n\nInstructions:\n\n\t\tPlease enter a new team name for Team " + (loopFirstDegree + 1) + ".", "Invalid Team Name", 2);
						loopFirstDegree--;
						break;
					}
				}
			}
		}
		catch (NullPointerException exc)
		{
			objectComplete = false;
			javax.swing.JOptionPane.showMessageDialog(null, "The " + this.tournamentName + " tournament has not been created, as you have not inputed the names of all participating teams.\nPlease re-submit the tournament details if you wish to create the " + this.tournamentName + " tournament.", "Attention!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
//	public void setTeamNamesPost(int numTeams)
//	{
//		tournamentTeams = new Teams[numTeams];
//		for (int loopFirstDegree = 0; loopFirstDegree < numTeams; loopFirstDegree++)
//		{
//			tournamentTeams[loopFirstDegree] = new Teams(javax.swing.JOptionPane.showInputDialog(null, "Enter Team " + (loopFirstDegree + 1) + " Name: ", tournamentTeams[loopFirstDegree].getTeamName()), loopFirstDegree);
//			if (tournamentTeams[loopFirstDegree].getTeamName().equals(""))
//			{
//				javax.swing.JOptionPane.showMessageDialog(null, "Team " + (loopFirstDegree + 1) + " name field is empty!\n\nInstructions:\n\n\t\tPlease enter a team name for team " + (repeatFirstDegree + 1) + ".", "Invalid Team Name", 2);
//				loopFirstDegree--;
//			}
//			else if (tournamentTeams[loopFirstDegree].getTeamName().length() > 20)
//			{
//				javax.swing.JOptionPane.showMessageDialog(null, "\"" + tournamentTeams[loopFirstDegree].getTeamName() + "\" is too long!\n\nInstructions:\n\n\t\tPlease enter a team name for team " + (loopFirstDegree + 1) + " that is 20 charachters or less.", "Invalid Team Name", 2);
//				loopFirstDegree--;
//			}
//		}
//	}
	
//	public void setTeamName(String teamName, int teamNum)
//	{
//		tournamentTeams[(teamNum - 1)].setTeamName(teamName);
//	}
	
	// method to calculate the total duration of the tournament based on
	// the number of matches and venues as well as the match and break
	// durations
	public int calculateTotalDuration()
	{
		double totalDuration = (calculateNumMatches(numTeams) * matchDuration) + ((calculateNumMatches(numTeams) - 1) * breakDuration);
		if (numVenues == 2)
		{
			totalDuration = totalDuration/2;
		}
		else if (numVenues == 3)
		{
			totalDuration = totalDuration/3;
		}
		totalDuration = totalDuration/60;
		return (int) (totalDuration);
	}
	
	// method to arrange the tournament teams in the tournamentTeams array
	// in order of highest to lowest points, then highest to lowest goal
	// difference
	public void orderTeams()
	{
		Teams temp;
		// sorting according to the number of points 
		for (int loopFirstDegree = 0; loopFirstDegree < numTeams; loopFirstDegree++)
		{
			for (int loopSecondDegree = loopFirstDegree; loopSecondDegree < numTeams; loopSecondDegree++)
			{
				if (tournamentTeams[loopFirstDegree].getPoints() < tournamentTeams[loopSecondDegree].getPoints())
				{
					temp = tournamentTeams[loopFirstDegree];
					tournamentTeams[loopFirstDegree] = tournamentTeams[loopSecondDegree];
					tournamentTeams[loopSecondDegree] = temp;
				}
			}
		}
		// sorting teams with the same points according to their goal differences
		for (int loopFirstDegree = 0; loopFirstDegree < numTeams; loopFirstDegree++)
		{
			for (int loopSecondDegree = loopFirstDegree; loopSecondDegree < numTeams; loopSecondDegree++)
			{
				if ((tournamentTeams[loopFirstDegree].getPoints() == tournamentTeams[loopSecondDegree].getPoints()) && 
						(tournamentTeams[loopFirstDegree].getGoalDifference() < tournamentTeams[loopSecondDegree].getGoalDifference()))
				{
					temp = tournamentTeams[loopFirstDegree];
					tournamentTeams[loopFirstDegree] = tournamentTeams[loopSecondDegree];
					tournamentTeams[loopSecondDegree] = temp;
				}
			}
		}
	}
	
	// recursive method to calculate the number of matches to be played
	// in the tournament based on the number of teams
	public int calculateNumMatches(int numTeams)
	{
		if (numTeams == 2)
		{
			return 1;
		}
		else
		{
			return (numTeams - 1) + calculateNumMatches(numTeams - 1);
		}
	}
	
	// method to fill in the matches array with all the possible matches
	private void setMatches(int numTeams)
	{
		matches = new String[numMatches];
		int counter = -1;
		for (int loopFirstDegree = 0; loopFirstDegree < (numTeams - 1); loopFirstDegree++)
		{
			for (int loopSecondDegree = (loopFirstDegree + 1); loopSecondDegree < numTeams; loopSecondDegree++)
			{
				counter++;
				matches[counter] = getTeamName((loopFirstDegree + 1)) + " vs. " + getTeamName((loopSecondDegree + 1));
			}
		}
	}
	
	// method to mix up the match order
	public void mixMatchOrder()
	{
		int counter = 0;
		for (int loopFirstDegree = 0; loopFirstDegree < numMatches; loopFirstDegree++)
		{
			if (matches[loopFirstDegree] != null)
			{
				counter++;
			}
			else
			{
				break;
			}
		}
		for (int loopFirstDegree = 0; loopFirstDegree < (numMatches/2); loopFirstDegree++)
		{
			int divisor = (int)(Math.random() * counter + 1);
			for (int loopSecondDegree = 0; loopSecondDegree < (numMatches/divisor); loopSecondDegree = loopSecondDegree + divisor)
			{
				String temp = matches[loopSecondDegree];
				matches[loopSecondDegree] = matches[(counter - 1) - loopSecondDegree];
				matches[(counter - 1) - loopSecondDegree] = temp;
			}
			for (int loopSecondDegree = 0; loopSecondDegree < numMatches; loopSecondDegree++)
			{
				String temp = matches[loopSecondDegree];
				matches[loopSecondDegree] = matches[(counter - 1) - loopSecondDegree];
				matches[(counter - 1) - loopSecondDegree] = temp;
			}
		}
	}
	
	// method to fill in the schedule and points table that will be displayed on
	// the Tournament Schedule Panel, the table is added to a scroll
	// pane that is returned when the getScheduleScrollPane() method
	// is called from the GUI class
	public void setScheduleScrollPane()
	{
		String [] columnHeadings = {"", "Venue 1", "Venue 2", "Venue 3", "-", "Team Name", "Points", "GD"};
		Object [][] data;
		if (calculateNumMatches(numTeams)/numVenues >= numTeams)
		{
			data = new Object[calculateNumMatches(numTeams)/numVenues][8];
		}
		else
		{
			data = new Object[numTeams][8];
		}
		int time = startTime;
		String timeString;
		int counter = 0;
		for (int loopFirstDegree = 0; loopFirstDegree < calculateNumMatches(numTeams)/numVenues; loopFirstDegree++)
		{
			if (numVenues == 1)
			{
				timeString = time + "";
				if (timeString.length() < 2)
				{
					timeString = "000" + timeString;
				}
				if (timeString.length() < 3)
				{
					timeString = "00" + timeString;
				}
				if (timeString.length() < 4)
				{
					timeString = "0" + timeString;
				}
				if (Integer.parseInt(timeString.substring(2, 4)) >= 60)
				{
					time = time + 40;
					timeString = time + "";
				}
				if (timeString.length() < 2)
				{
					timeString = "000" + timeString;
				}
				if (timeString.length() < 3)
				{
					timeString = "00" + timeString;
				}
				if (timeString.length() < 4)
				{
					timeString = "0" + timeString;
				}
				if (Integer.parseInt(timeString.substring(0, 2)) >= 24)
				{
					time = time - 2400;
					timeString = time + "";
				}
				if (timeString.length() < 2)
				{
					timeString = "000" + timeString;
				}
				if (timeString.length() < 3)
				{
					timeString = "00" + timeString;
				}
				if (timeString.length() < 4)
				{
					timeString = "0" + timeString;
				}
				data [loopFirstDegree][0] = timeString;
				data [loopFirstDegree][1] = matches[counter];
				counter++;
				data [loopFirstDegree][2] = "N/A";
				data [loopFirstDegree][3] = "N/A";
				if (counter >= calculateNumMatches(numTeams))
				{
					break;
				}
				time = time + matchDuration + breakDuration;
			}
			else if (numVenues == 2)
			{
				timeString = time + "";
				if (timeString.length() < 2)
				{
					timeString = "000" + timeString;
				}
				if (timeString.length() < 3)
				{
					timeString = "00" + timeString;
				}
				if (timeString.length() < 4)
				{
					timeString = "0" + timeString;
				}
				if (Integer.parseInt(timeString.substring(2, 4)) >= 60)
				{
					time = time + 40;
					timeString = time + "";
				}
				if (timeString.length() < 2)
				{
					timeString = "000" + timeString;
				}
				if (timeString.length() < 3)
				{
					timeString = "00" + timeString;
				}
				if (timeString.length() < 4)
				{
					timeString = "0" + timeString;
				}
				if (Integer.parseInt(timeString.substring(0, 2)) >= 24)
				{
					time = time - 2400;
					timeString = time + "";
				}
				if (timeString.length() < 2)
				{
					timeString = "000" + timeString;
				}
				if (timeString.length() < 3)
				{
					timeString = "00" + timeString;
				}
				if (timeString.length() < 4)
				{
					timeString = "0" + timeString;
				}
				data [loopFirstDegree][0] = timeString;
				data [loopFirstDegree][1] = matches[counter];
				counter++;
				if (counter >= calculateNumMatches(numTeams))
				{
					data [loopFirstDegree][2] = "-";
					data [loopFirstDegree][3] = "N/A";
					break;
				}
				data [loopFirstDegree][2] = matches[counter];
				counter++;
				data [loopFirstDegree][3] = "N/A";
				if (counter >= calculateNumMatches(numTeams))
				{
					break;
				}
				time = time + matchDuration + breakDuration;
			}
			else
			{
				timeString = time + "";
				if (timeString.length() < 2)
				{
					timeString = "000" + timeString;
				}
				if (timeString.length() < 3)
				{
					timeString = "00" + timeString;
				}
				if (timeString.length() < 4)
				{
					timeString = "0" + timeString;
				}
				if (Integer.parseInt(timeString.substring(2, 4)) >= 60)
				{
					time = time + 40;
					timeString = time + "";
				}
				if (timeString.length() < 2)
				{
					timeString = "000" + timeString;
				}
				if (timeString.length() < 3)
				{
					timeString = "00" + timeString;
				}
				if (timeString.length() < 4)
				{
					timeString = "0" + timeString;
				}
				if (Integer.parseInt(timeString.substring(0, 2)) >= 24)
				{
					time = time - 2400;
					timeString = time + "";
				}
				if (timeString.length() < 2)
				{
					timeString = "000" + timeString;
				}
				if (timeString.length() < 3)
				{
					timeString = "00" + timeString;
				}
				if (timeString.length() < 4)
				{
					timeString = "0" + timeString;
				}
				data [loopFirstDegree][0] = timeString;
				data [loopFirstDegree][1] = matches[counter];
				counter++;
				if (counter >= calculateNumMatches(numTeams))
				{
					data [loopFirstDegree][2] = "-";
					data [loopFirstDegree][3] = "-";
					break;
				}
				data [loopFirstDegree][2] = matches[counter];
				counter++;
				if (counter >= calculateNumMatches(numTeams))
				{
					data [loopFirstDegree][3] = "-";
					break;
				}
				data [loopFirstDegree][3] = matches[counter];
				counter++;
				if (counter >= calculateNumMatches(numTeams))
				{
					break;
				}
				time = time + matchDuration + breakDuration;
			}
		}
		orderTeams();
		for (int loopFirstDegree = 0; loopFirstDegree < numTeams; loopFirstDegree++)
		{
			data [loopFirstDegree][4] = loopFirstDegree + 1;
			data [loopFirstDegree][5] = tournamentTeams[loopFirstDegree].getTeamName();
			data [loopFirstDegree][6] = tournamentTeams[loopFirstDegree].getPoints();
			data [loopFirstDegree][7] = tournamentTeams[loopFirstDegree].getGoalDifference();
		}
		for (int loopFirstDegree = 1; loopFirstDegree < numTeams; loopFirstDegree++)
		{
			if ((tournamentTeams[loopFirstDegree].getPoints() == tournamentTeams[loopFirstDegree - 1].getPoints()) && (tournamentTeams[loopFirstDegree].getGoalDifference() == tournamentTeams[loopFirstDegree - 1].getGoalDifference()))
			{
				data [loopFirstDegree][4] = data [loopFirstDegree - 1][4];
			}
		}
		scheduleTable = null;
		scheduleTable = new JTable(data, columnHeadings);
		scheduleTable.setBounds(20, 50, 300, 300);
		scheduleTable.setBackground(Color.LIGHT_GRAY);
		scheduleTable.setFont(new Font("Serif", Font.PLAIN, 8));
		scheduleTable.setLayout(new FlowLayout());
		scheduleTable.setFillsViewportHeight(true);
		scheduleTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		scheduleTable.getColumnModel().getColumn(4).setPreferredWidth(7);
		scheduleTable.getColumnModel().getColumn(7).setPreferredWidth(7);
		scheduleScrollPane = null;
		scheduleScrollPane = new JScrollPane(scheduleTable);
		scheduleScrollPane.setBounds(20, 50, 500, 300);
	}
}