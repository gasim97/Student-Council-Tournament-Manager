// The British International School of Jeddah
// Gasim Gasim 001118-0035
// IBDP Computer Science Internal Assessment
// The Tournament Manager - Teams Class

public class Teams 
{
	private String teamName;
	private int teamNum;
	private int points;
	private int goalDifference;
	
	// class constructor that accepts a team name string and a team number integer as a parameter
	
	public Teams(String teamName, int teamNum)
	{
		this.teamName = teamName;
		this.teamNum = teamNum;
		this.points = 0;
		this.goalDifference = 0;
	}
	
	public Teams(String teamName, int teamNum, int points, int goalDifference)
	{
		this.teamName = teamName;
		this.teamNum = teamNum;
		this.points = points;
		this.goalDifference = goalDifference;
	}
	
	// accessor methods to allow the private variables to be acquired from outside the Teams class
	
	public String getTeamName()
	{
		return teamName;
	}
	
	public int getTeamNum()
	{
		return teamNum;
	}
	
	public int getPoints()
	{
		return points;
	}
	
	public int getGoalDifference()
	{
		return goalDifference;
	}
	
	// mutator methods to allow the private variable to be altered from outside the Teams class
	
	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}
	
	public void setTeamNum(int teamNum)
	{
		this.teamNum = teamNum;
	}
	
	public void setPoints(int points)
	{
		this.points = points;
	}
	
	public void addPoints(int points)
	{
		this.points = this.points + points;
	}
	
	public void setGoalDifference(int goals)
	{
		this.goalDifference = this.goalDifference + goals;
	}
}