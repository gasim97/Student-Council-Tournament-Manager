// The British International School of Jeddah
// Gasim Gasim 001118-0035
// IBDP Computer Science Internal Assessment
// The Tournament Manager - GUI Class

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

import java.awt.*;
import java.sql.*;
import java.util.Date;

public class GUI extends JFrame 
{
	// Panels
	private JPanel panPassword; // Panel 1
	private JPanel panHome; // Panel 2
	private JPanel panSearch; // Panel 3
	private JPanel panInfoEntry; // Panel 4
	private JPanel panCenter; // Panel 5
	private JPanel panSched; // Panel 6
	private JPanel panEdit; // Panel 7
	private JPanel panNewPass; // Panel 8
	private JPanel panScore; // Panel 9
	
	private Tournaments tournament;
	private Date now;
	
	// Images
	
	private Image background;
	private Image studentCouncilLogo;
	private Image backspace;
	
	
	// panPassword variables (Panel 1)
	
	// Buttons
	private JButton passwordSubmitButton;
	
	// Password Fields
	private JPasswordField passwordField;
	
	// Labels
	private JLabel invalidPasswordLabel;
	private JLabel passwordPromptLabel;
	private JLabel passwordLabel;
	private JLabel titleLabel;
	private JLabel propertyLabel;
	private JLabel studentCouncilLogoLabel;
	private JLabel backgroundLabel;
	
	
	// panHome variables (Panel 2)
	
	// Buttons
	private JButton backButtonTwo;
	private JButton updatePasswordButton;
	private JButton existingButton;
	private JButton newButton;
	
	// Labels
	private JLabel homePageLabel;
	private JLabel titleLabelTwo;
	private JLabel propertyLabelTwo;
	private JLabel studentCouncilLogoLabelTwo;
	private JLabel backgroundLabelTwo;
	
	
	// panSearch variables (Panel 3)
	
	// Buttons
	private JButton homeButtonThree;
	private JButton searchSubmitButton;
	private JButton tournamentsSearchButton;
	
	// Text Fields
	private JTextField searchTextField;
	
	// Labels
	private JLabel invalidSearchLabel;
	private JLabel searchLabel;
	private JLabel searchPageLabel;
	private JLabel titleLabelThree;
	private JLabel propertyLabelThree;
	private JLabel studentCouncilLogoLabelThree;
	private JLabel backgroundLabelThree;
	
	
	// panInfoEntry variables (Panel 4)
	
	// Buttons
	private JButton homeButtonFour;
	private JButton detailsSubmitButton;
	
	// Text Fields
	private JTextField tournamentNameTextField;
	private JTextField dayTextField;
	private JTextField monthTextField;
	private JTextField yearTextField;
	private JTextField startTimeTextField;
	private JTextField matchDurationTextField;
	private JTextField breakDurationTextField;
	private JTextField numTeamsTextField;
	private JTextField numVenuesTextField;
	
	// Labels
	private JLabel maxVenuesLabel;
	private JLabel numVenuesLabel;
	private JLabel maxTeamsLabel;
	private JLabel numTeamsLabel;
	private JLabel breakDurationUnitsLabel;
	private JLabel breakDurationLabel;
	private JLabel matchDurationUnitsLabel;
	private JLabel matchDurationLabel;
	private JLabel startTimeFormatLabel;
	private JLabel startTimeLabel;
	private JLabel dateLabel;
	private JLabel nameMaxCharactersLabel;
	private JLabel tournamentNameLabel;
	private JLabel tournamentDetailsPageLabel;
	private JLabel titleLabelFour;
	private JLabel propertyLabelFour;
	private JLabel backgroundLabelFour;
	
	
	// panCenter variables (Panel 5)
	
	// Buttons
	private JButton homeButtonFive;
	private JButton editButton;
	private JButton viewScheduleButton;
	private JButton deleteTournamentButton;
	
	// Labels
	private JLabel tournamentCenterLabel;
	private JLabel titleLabelFive;
	private JLabel propertyLabelFive;
	private JLabel studentCouncilLogoLabelFive;
	private JLabel backgroundLabelFive;
	private JLabel tournamentNameCenterLabel;
	private JLabel tournamentDateCenterLabel;
	private JLabel detailsCenterLabel;
	private JLabel numberOfTeamsCenterLabel;
	private JLabel numberOfVenuesCenterLabel;
	private JLabel numberOfMatchesCenterLabel;
	private JLabel numberOfTeamsValueCenterLabel;
	private JLabel numberOfVenuesValueCenterLabel;
	private JLabel numberOfMatchesValueCenterLabel;
	private JLabel matchDurationCenterLabel;
	private JLabel breakDurationCenterLabel;
	private JLabel totalDurationCenterLabel;
	private JLabel matchDurationValueCenterLabel;
	private JLabel breakDurationValueCenterLabel;
	private JLabel totalDurationValueCenterLabel;
	
	
	// panSched variables (Panel 6)
	
	// Buttons
	private JButton homeButtonSix;
	private JButton backButtonSix;
	private JButton updatePointsButton;
	
	// Scroll Panes
	private JScrollPane scheduleScrollPane;
	
	// Labels
	private JLabel tournamentIdentifierLabel;
	private JLabel viewScheduleLabel;
	private JLabel tournamentScheduleLabel;
	private JLabel titleLabelSix;
	private JLabel propertyLabelSix;
	private JLabel backgroundLabelSix;
	
	
	// panEdit variables (Panel 7)
	
	// Buttons
	private JButton homeButtonSeven;
	private JButton backButtonSeven;
	private JButton detailsSubmitButtonSeven;
	
	// Text Fields
	private JTextField tournamentNameTextFieldSeven;
	private JTextField dayTextFieldSeven;
	private JTextField monthTextFieldSeven;
	private JTextField yearTextFieldSeven;
	private JTextField startTimeTextFieldSeven;
	private JTextField matchDurationTextFieldSeven;
	private JTextField breakDurationTextFieldSeven;
	private JTextField numTeamsTextFieldSeven;
	private JTextField numVenuesTextFieldSeven;
	
	// Labels
	private JLabel maxVenuesLabelSeven;
	private JLabel numVenuesLabelSeven;
	private JLabel maxTeamsLabelSeven;
	private JLabel numTeamsLabelSeven;
	private JLabel breakDurationUnitsLabelSeven;
	private JLabel breakDurationLabelSeven;
	private JLabel matchDurationUnitsLabelSeven;
	private JLabel matchDurationLabelSeven;
	private JLabel startTimeFormatLabelSeven;
	private JLabel startTimeLabelSeven;
	private JLabel dateLabelSeven;
	private JLabel nameMaxCharactersLabelSeven;
	private JLabel tournamentNameLabelSeven;
	private JLabel tournamentDetailsPageLabelSeven;
	private JLabel titleLabelSeven;
	private JLabel propertyLabelSeven;
	private JLabel backgroundLabelSeven;
	
	
	// panNewPass (Panel 8)
	
	// Buttons
	private JButton homeButtonEight;
	private JButton newPassSubmitButton;
	private JButton clearPassButton;
	
	// Password Fields
	private JPasswordField currPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField reNewPasswordField;
	
	// Labels
	private JLabel currPasswordLabel;
	private JLabel newPasswordLabel;
	private JLabel reNewPasswordLabel;
	private JLabel newPasswordMaxMinLabel;
	private JLabel passwordPanelLabel;
	private JLabel titleLabelEight;
	private JLabel propertyLabelEight;
	private JLabel backgroundLabelEight;
	
	
	// panScore (Panel 9)
	
	// Buttons
	private JButton homeButtonNine;
	private JButton backButtonNine;
	private JButton scoreSubmitButton;
	
	// Combo Boxes
	private JComboBox teamOne;
	private JComboBox teamTwo;
	
	// Text Fields
	private JTextField teamOneScoreTextField;
	private JTextField teamTwoScoreTextField;
	
	// Labels
	private JLabel versusLabel;
	private JLabel scoreSeperatorLabel;
	private JLabel scorePanelLabel;
	private JLabel titleLabelNine;
	private JLabel propertyLabelNine;
	private JLabel backgroundLabelNine;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException
	{
		EventQueue.invokeLater(new Runnable() 
		{
			@Override
			public void run() 
			{
				try 
				{
					GUI frame = new GUI();
					frame.setVisible(true);
				} 
				catch (Exception exc) 
				{
					javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" 
							+ exc + "\n\nPlease report error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Creating the frame.
	 */
	
	
	public GUI() throws SQLException
	{
		background = new ImageIcon(this.getClass().getResource("/nike.png")).getImage();
		studentCouncilLogo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		backspace = new ImageIcon(this.getClass().getResource("/backspace.png")).getImage();
		
		
		// setting-up the frame
		setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
		setIconImage(studentCouncilLogo);
		setTitle("BISJ Student Council Tournament Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 175, 550, 400);
		
		// Password Entry Panel (Panel 1)
		panPassword = new JPanel();
		panPassword.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panPassword);
		panPassword.setLayout(null);
		
		// Homepage Panel (Panel 2)
		panHome = new JPanel();
		panHome.setBorder(new EmptyBorder(5, 5, 5, 5));
		panHome.setLayout(null);
		
		// Tournament Search Panel (Panel 3)
		panSearch = new JPanel();
		panSearch.setBorder(new EmptyBorder(5, 5, 5, 5));
		panSearch.setLayout(null);
		
		// New Tournament Panel (i.e. tournament details entry panel) (Panel 4)
		panInfoEntry = new JPanel();
		panInfoEntry.setBorder(new EmptyBorder(5, 5, 5, 5));
		panInfoEntry.setLayout(null);
		
		// Tournament Center Panel (Panel 5)
		panCenter = new JPanel();
		panCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		panCenter.setLayout(null);
		
		// Tournament Schedule and Points Panel (Panel 6)
		panSched = new JPanel();
		panSched.setBorder(new EmptyBorder(5, 5, 5, 5));
		panSched.setLayout(null);
		
		// Details Edit Panel (Panel 7)
		panEdit = new JPanel();
		panEdit.setBorder(new EmptyBorder(5, 5, 5, 5));
		panEdit.setLayout(null);
		
		// New Password Panel (Panel 8)
		panNewPass = new JPanel();
		panNewPass.setBorder(new EmptyBorder(5, 5, 5, 5));
		panNewPass.setLayout(null);
		
		// Score Update Panel (Panel 9)
		panScore = new JPanel();
		panScore.setBorder(new EmptyBorder(5, 5, 5, 5));
		panScore.setLayout(null);
		
		
		
		
		// First Panel (panPassword)
		
		
		
		// Label that appears when an invalid password is submitted
		invalidPasswordLabel = new JLabel("");
		invalidPasswordLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		invalidPasswordLabel.setForeground(Color.RED);
		invalidPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		invalidPasswordLabel.setBounds(100, 155, 150, 29);
		panPassword.add(invalidPasswordLabel);
		
		// Password entry prompt label
		passwordPromptLabel = new JLabel("Please enter the password to access the Tournament Manager");
		passwordPromptLabel.setForeground(Color.RED);
		passwordPromptLabel.setFont(new Font("Lucida Grande", Font.BOLD, 8));
		passwordPromptLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordPromptLabel.setBounds(41, 98, 271, 16);
		panPassword.add(passwordPromptLabel);
		
		// Password submission button
		passwordSubmitButton = new JButton("Submit");
		passwordSubmitButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					char [] passwordInputArray = passwordField.getPassword();
					String passwordInput = new String(passwordInputArray);
					// hashing the password or setting it as 1 if the field is empty
					int passwordInputHash;
					if (passwordInput.equals(""))
					{
						passwordInputHash = 1;
					}
					else
					{
						passwordInputHash = passwordInput.hashCode();
					}
					// passing the entered password to the getPassword method in the
					// SQLActions class and obtaining a boolean value (verification)
					// indicating whether or not the entered password matches the
					// password stored in the database
					boolean verification = SQLActions.getPassword(passwordInputHash);
					// checking the state of the boolean variable verification 
					if (verification == true)
					{
						// reseting text fields
						invalidPasswordLabel.setText("");
						passwordField.setText("");
						panPassword.setVisible(false);
						panHome.setVisible(true);
						setContentPane(getPanel2());
					}
					else
					{
						// informing the user that the submitted password is invalid
						invalidPasswordLabel.setText("Invalid password!");
						passwordField.setText("");
					}
				}
				// attempting to catch an SQL error in
				// verifying the entered password
				catch (SQLException exc)
				{
					javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n"
						+ exc + "\n\nPlease report error to: gasim97@gmail.com\n\n\nPossible sources of error:\n\n"
								+ "1.\tMySQL Workbench is not installed.\nhttps://www.mysql.com/products/workbench/\n\n"
								+ "2.\tXAMPP is not installed.\nhttps://www.apachefriends.org/download.html\n\n"
								+ "3.\tMySQL Database server has not been run using the XAMPP interface.",
						"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		passwordSubmitButton.setToolTipText("Click to submit password");
		passwordSubmitButton.setBounds(116, 180, 117, 29);
		panPassword.add(passwordSubmitButton);
		
		passwordLabel = new JLabel("Password*");
		passwordLabel.setBounds(27, 139, 71, 16);
		panPassword.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter password here");
		passwordField.setBounds(100, 133, 150, 28);
		panPassword.add(passwordField);
		
		titleLabel = new JLabel("Tournament Manager");
		titleLabel.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 20));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.GRAY);
		titleLabel.setBounds(155, 10, 241, 28);
		panPassword.add(titleLabel);
		
		propertyLabel = new JLabel("This program is the property of the British International School of Jeddah Student Council");
		propertyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		propertyLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 10));
		propertyLabel.setBounds(0, 360, 550, 16);
		panPassword.add(propertyLabel);
		
		studentCouncilLogoLabel = new JLabel("");
		studentCouncilLogoLabel.setToolTipText("BISJ Student Council Logo");
		studentCouncilLogoLabel.setIcon(new ImageIcon(studentCouncilLogo));
		studentCouncilLogoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		studentCouncilLogoLabel.setBounds(116, 221, 117, 97);
		panPassword.add(studentCouncilLogoLabel);
		
		backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(background));
		backgroundLabel.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundLabel.setBounds(0, 10, 550, 349);
		panPassword.add(backgroundLabel);
		
		
		
		
		// Second Panel (panHome)
		
		
		
		
		backButtonTwo = new JButton("");
		backButtonTwo.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				panHome.setVisible(false);
				panPassword.setVisible(true);
				setContentPane(getPanel1());
				setMainButton(passwordSubmitButton);
			}
		});
		backButtonTwo.setToolTipText("Click to return to the previous window");
		backButtonTwo.setIcon(new ImageIcon(backspace));
		backButtonTwo.setBounds(0, 10, 35, 35);
		panHome.add(backButtonTwo);
		
		updatePasswordButton = new JButton("Update Password");
		updatePasswordButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				panHome.setVisible(false);
				panNewPass.setVisible(true);
				setContentPane(getPanel8());
				setMainButton(newPassSubmitButton);
			}
		});
		updatePasswordButton.setToolTipText("Click to update password");
		updatePasswordButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		updatePasswordButton.setBounds(30, 15, 115, 29);
		panHome.add(updatePasswordButton);
		
		existingButton = new JButton("Existing");
		existingButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				panHome.setVisible(false);
				panSearch.setVisible(true);
				setContentPane(getPanel3());
				searchTextField.requestFocusInWindow();
				searchTextField.selectAll();
				setMainButton(searchSubmitButton);
			}
		});
		existingButton.setToolTipText("Click to search for an existing tournament");
		existingButton.setBounds(116, 98, 117, 29);
		panHome.add(existingButton);
		
		newButton = new JButton("New");
		newButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				panHome.setVisible(false);
				panInfoEntry.setVisible(true);
				setContentPane(getPanel4());
				setMainButton(detailsSubmitButton);
			}
		});
		newButton.setToolTipText("Click to create a new tournament");
		newButton.setBounds(116, 157, 117, 29);
		panHome.add(newButton);
	
		homePageLabel = new JLabel("- Homepage -");
		homePageLabel.setForeground(Color.GRAY);
		homePageLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		homePageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		homePageLabel.setBounds(165, 39, 231, 16);
		panHome.add(homePageLabel);
		
		titleLabelTwo = new JLabel("Tournament Manager");
		titleLabelTwo.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 20));
		titleLabelTwo.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabelTwo.setForeground(Color.GRAY);
		titleLabelTwo.setBounds(155, 10, 241, 28);
		panHome.add(titleLabelTwo);
		
		propertyLabelTwo = new JLabel("This program is the property of the British International School of Jeddah Student Council");
		propertyLabelTwo.setHorizontalAlignment(SwingConstants.CENTER);
		propertyLabelTwo.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 10));
		propertyLabelTwo.setBounds(0, 360, 550, 16);
		panHome.add(propertyLabelTwo);
		
		studentCouncilLogoLabelTwo = new JLabel("");
		studentCouncilLogoLabelTwo.setToolTipText("BISJ Student Council Logo");
		studentCouncilLogoLabelTwo.setIcon(new ImageIcon(studentCouncilLogo));
		studentCouncilLogoLabelTwo.setHorizontalAlignment(SwingConstants.CENTER);
		studentCouncilLogoLabelTwo.setBounds(116, 221, 117, 97);
		panHome.add(studentCouncilLogoLabelTwo);
		
		backgroundLabelTwo = new JLabel("");
		backgroundLabelTwo.setIcon(new ImageIcon(background));
		backgroundLabelTwo.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundLabelTwo.setBounds(0, 10, 550, 349);
		panHome.add(backgroundLabelTwo);
		
		
		
		
		// Third Panel (panSearch)
		
		
		
		
		invalidSearchLabel = new JLabel("");
		invalidSearchLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		invalidSearchLabel.setForeground(Color.RED);
		invalidSearchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		invalidSearchLabel.setBounds(70, 155, 220, 29);
		panSearch.add(invalidSearchLabel);
		
		homeButtonThree = new JButton("");
		homeButtonThree.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// reseting text fields
				invalidSearchLabel.setText("");
				searchTextField.setText("Tournament Name");
				panSearch.setVisible(false);
				panHome.setVisible(true);
				setContentPane(getPanel2());
			}
		});
		homeButtonThree.setToolTipText("Click to return to the homepage");
		homeButtonThree.setIcon(new ImageIcon(GUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));
		homeButtonThree.setBounds(0, 10, 35, 35);
		panSearch.add(homeButtonThree);
		
		searchTextField = new JTextField();
		searchTextField.setText("Tournament Name");
		searchTextField.setToolTipText("Enter tournament name here");
		searchTextField.setBounds(66, 133, 231, 28);
		searchTextField.setColumns(10);
		panSearch.add(searchTextField);
		
		searchLabel = new JLabel("Search");
		searchLabel.setBounds(20, 139, 48, 16);
		panSearch.add(searchLabel);
		
		tournamentsSearchButton = new JButton("Tournaments");
		tournamentsSearchButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					boolean repeat = true;
					while (repeat == true)
					{
						String tournamentName = SQLActions.getTournamentNames();
						if (tournamentName.equals("*********************")) // returned if a non-integer value
																			// is input by the user or the database
																			// is empty
						{
							repeat = false;
							searchTextField.requestFocusInWindow();
							searchTextField.selectAll();
						}
						else if (!(tournamentName.equals("")))
						{
							searchTextField.setText(tournamentName);
							searchSubmitButton.doClick();
							repeat = false;
						}
					}
				}
				// attempting to catch an SQL error in
				// retrieving the tournaments names
				// stored in the database
				catch (SQLException exc)
				{
					javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" 
							+ exc + "\n\nPlease report error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tournamentsSearchButton.setToolTipText("Click to view stored tournaments");
		tournamentsSearchButton.setBounds(66, 180, 117, 29);
		panSearch.add(tournamentsSearchButton);
		
		searchSubmitButton = new JButton("Submit");
		searchSubmitButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String searchCriteria = searchTextField.getText();
				try 
				{
					tournament = SQLActions.getTournament(searchCriteria);
				} 
				// attempting to catch an SQL error in
				// searching the database for the entered
				// tournament name
				catch (SQLException exc) 
				{
					javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have "
							+ "gone wrong!\n\n" + exc + "\n\nPlease report error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
				}
				if (tournament != null)
				{
					// reseting text fields
					searchTextField.setText("Tournament Name");
					invalidSearchLabel.setText("");
					// setting the labels on panel 5 (panCenter)
					tournamentNameCenterLabel.setText(tournament.getTournamentName());
					tournamentDateCenterLabel.setText(tournament.getDate().toString().substring(8, 10) + "-" 
					+ tournament.getDate().toString().substring(5, 7) + "-" + tournament.getDate().toString().substring(0, 4));
					numberOfTeamsValueCenterLabel.setText(":  " + tournament.getNumTeams());
					numberOfVenuesValueCenterLabel.setText(":  " + tournament.getNumVenues());
					numberOfMatchesValueCenterLabel.setText(":  " + tournament.calculateNumMatches(tournament.getNumTeams()));
					matchDurationValueCenterLabel.setText(":  " + tournament.getMatchDuration());
					breakDurationValueCenterLabel.setText(":  " + tournament.getBreakDuration());
					totalDurationValueCenterLabel.setText(":  ~" + tournament.calculateTotalDuration() + "h");
					panSearch.setVisible(false);
					panCenter.setVisible(true);
					setContentPane(getPanel5());
				}
				else
				{
					// displaying an error message indicating
					// and invalid tournament name entered
					invalidSearchLabel.setText("This tournament does not exist.");
					// reseting text fields
					searchTextField.setText("");
				}
			}
		});
		searchSubmitButton.setToolTipText("Click to submit search criteria");
		searchSubmitButton.setBounds(180, 180, 117, 29);
		panSearch.add(searchSubmitButton);
		
		searchPageLabel = new JLabel("- Tournament Search Page -");
		searchPageLabel.setForeground(Color.GRAY);
		searchPageLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		searchPageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchPageLabel.setBounds(165, 39, 231, 16);
		panSearch.add(searchPageLabel);
		
		titleLabelThree = new JLabel("Tournament Manager");
		titleLabelThree.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 20));
		titleLabelThree.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabelThree.setForeground(Color.GRAY);
		titleLabelThree.setBounds(155, 10, 241, 28);
		panSearch.add(titleLabelThree);
		
		propertyLabelThree = new JLabel("This program is the property of the British International School of Jeddah Student Council");
		propertyLabelThree.setHorizontalAlignment(SwingConstants.CENTER);
		propertyLabelThree.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 10));
		propertyLabelThree.setBounds(0, 360, 550, 16);
		panSearch.add(propertyLabelThree);
		
		studentCouncilLogoLabelThree = new JLabel("");
		studentCouncilLogoLabelThree.setToolTipText("BISJ Student Council Logo");
		studentCouncilLogoLabelThree.setIcon(new ImageIcon(studentCouncilLogo));
		studentCouncilLogoLabelThree.setHorizontalAlignment(SwingConstants.CENTER);
		studentCouncilLogoLabelThree.setBounds(116, 221, 117, 97);
		panSearch.add(studentCouncilLogoLabelThree);
		
		backgroundLabelThree = new JLabel("");
		backgroundLabelThree.setIcon(new ImageIcon(background));
		backgroundLabelThree.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundLabelThree.setBounds(0, 10, 550, 349);
		panSearch.add(backgroundLabelThree);
		
		
		
		
		// Fourth Panel (panInfoEntry)
		
		
		
		
		homeButtonFour = new JButton("");
		homeButtonFour.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// reseting text fields
				tournamentNameTextField.setText("");
				dayTextField.setText("");
				monthTextField.setText("");
				yearTextField.setText("");
				startTimeTextField.setText("");
				matchDurationTextField.setText("");
				breakDurationTextField.setText("");
				numTeamsTextField.setText("");
				numVenuesTextField.setText("");
				panInfoEntry.setVisible(false);
				panHome.setVisible(true);
				setContentPane(getPanel2());
			}
		});
		homeButtonFour.setToolTipText("Click to return to the homepage");
		homeButtonFour.setIcon(new ImageIcon(GUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));
		homeButtonFour.setBounds(0, 10, 35, 35);
		panInfoEntry.add(homeButtonFour);
		
		detailsSubmitButton = new JButton("Submit");
		detailsSubmitButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					try
					{
						int error = 0;
						int error2 = 0;
						now = new Date();
						// checking whether or not a tournament name has been entered
						if (tournamentNameTextField.getText().length() == 0)
						{
							error = 1;
							invalidInputMessage("Tournament name field is empty!\n\nInstructions:\n\n\t\tEnter a tournament name.");
						}
						// checking whether or not the tournament name is too long
						else if (tournamentNameTextField.getText().length() > 20)
						{
							error = 1;
							invalidInputMessage("Tournament name is too long! -> \"" + tournamentNameTextField.getText() + "\" is invalid.\n\nInstructions:\n\n\t\tEnter a tournament name that is 20 characters or less.");
						}
						else
						{
							try
							{
								// checking whether or not the tournament name has already been used
								if (SQLActions.tournamentNameCheck(tournamentNameTextField.getText()) == false)
								{
									error = 1;
									invalidInputMessage("Tournament name is not available! -> \"" + tournamentNameTextField.getText() + "\" has already been used.");
									int suggestionNumber = 1;
									while (SQLActions.tournamentNameCheck(tournamentNameTextField.getText() + " - " + suggestionNumber) == false)
									{
										suggestionNumber++;
									}
									String suggestName = tournamentNameTextField.getText() + " - " + suggestionNumber;
									if (!(suggestName.length() > 20))
									{
										int option = JOptionPane.showConfirmDialog(null, "The name \"" + suggestName + "\" is available.\nWould you like to use this name?", "Suggestion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
										if (option == JOptionPane.YES_OPTION)
										{
											tournamentNameTextField.setText(suggestName);
											error = 0;
										}
									}
								}
							}
							// attempting to catch an SQL error in searching the database to detect any tournament name clashes
							catch (SQLException exc)
							{
								javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" + exc + "\n\nPlease report error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						// checking whether or not the date field is incomplete
						if (dayTextField.getText().length() == 0 || monthTextField.getText().length() == 0 || yearTextField.getText().length() == 0)
						{
							error = 1;
							invalidInputMessage("Date field is incomplete!\n\nInstructions:\n\n\t\tEnter a date (DD/MM/YYYY).");
						}
						// checking whether or not the year entered has already passed
						else if (Integer.parseInt(yearTextField.getText()) < Integer.parseInt(now.toString().substring(24, 28)))
						{
							error = 1;
							invalidInputMessage("Invalid year entered! \"" + yearTextField.getText() + "\" is invalid.\n\nInstructions:\n\n\t\tEnter a year greater than or equal to " + now.toString().substring(24, 28));
						}
						// checking whether or not the month entered is invalid
						else if (!(Integer.parseInt(monthTextField.getText()) > 0 && Integer.parseInt(monthTextField.getText()) < 13))
						{
							error2 = 1;
							invalidInputMessage("Invalid month entered! \"" + monthTextField.getText() + "\" is invalid."
									+ "\n\nInstructions:\n\n\t\tEnter a month between 1 and 12 (inclusive).");
							// checking whether or not the day and month may have been accidentally transposed
							// and if yes, suggesting the untransposed date and making the adjustment upon the
							// user's approval
							if ((((Integer.parseInt(dayTextField.getText()) == 1 || Integer.parseInt(dayTextField.getText()) == 3 
									|| Integer.parseInt(dayTextField.getText()) == 5 || Integer.parseInt(dayTextField.getText()) == 7 
									|| Integer.parseInt(dayTextField.getText()) == 8 || Integer.parseInt(dayTextField.getText()) == 10 
									|| Integer.parseInt(dayTextField.getText()) == 12) && (Integer.parseInt(monthTextField.getText()) >= 1 
									&& Integer.parseInt(monthTextField.getText()) <= 31)) || (Integer.parseInt(dayTextField.getText()) == 2 
									&& (Integer.parseInt(monthTextField.getText()) >= 1 && Integer.parseInt(monthTextField.getText()) <= 29)) 
									|| ((Integer.parseInt(dayTextField.getText()) == 4 || Integer.parseInt(dayTextField.getText()) == 6 
									|| Integer.parseInt(dayTextField.getText()) == 9 || Integer.parseInt(dayTextField.getText()) == 11) 
											&& (Integer.parseInt(monthTextField.getText()) >= 1 && Integer.parseInt(monthTextField.getText()) <= 30))))
							{
								int option = JOptionPane.showConfirmDialog(null, "Did you mean " + monthTextField.getText() + "/" 
										+ dayTextField.getText() + "/" + yearTextField.getText() + " (DD/MM/YYYY)?", "Transposed Date", 
										JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								if (option == JOptionPane.YES_OPTION)
								{
									String temp = dayTextField.getText();
									dayTextField.setText(monthTextField.getText());
									monthTextField.setText(temp);
									error2 = 0;
								}
							}
						}
						// checking whether or not the day entered is valid
						else if (!(((Integer.parseInt(monthTextField.getText()) == 1 || Integer.parseInt(monthTextField.getText()) == 3 || Integer.parseInt(monthTextField.getText()) == 5 || Integer.parseInt(monthTextField.getText()) == 7 || Integer.parseInt(monthTextField.getText()) == 8 || Integer.parseInt(monthTextField.getText()) == 10 || Integer.parseInt(monthTextField.getText()) == 12) && (Integer.parseInt(dayTextField.getText()) >= 1 && Integer.parseInt(dayTextField.getText()) <= 31)) || (Integer.parseInt(monthTextField.getText()) == 2 && (Integer.parseInt(dayTextField.getText()) >= 1 && Integer.parseInt(dayTextField.getText()) <= 29)) || ((Integer.parseInt(monthTextField.getText()) == 4 || Integer.parseInt(monthTextField.getText()) == 6 || Integer.parseInt(monthTextField.getText()) == 9 || Integer.parseInt(monthTextField.getText()) == 11) && (Integer.parseInt(dayTextField.getText()) >= 1 && Integer.parseInt(dayTextField.getText()) <= 30))))
						{
							error = 1;
							invalidInputMessage("Invalid day entered! \"" + dayTextField.getText() + "/" + monthTextField.getText() + "\" is invalid!\n\nInstructions\n\n\t\tEnter a real date.");
						}
						// checking whether or not a start time has been entered
						if (startTimeTextField.getText().length() == 0)
						{
							error = 1;
							invalidInputMessage("Start time field is empty!\n\nInstructions:\n\n\t\tEnter a start time.");
						}
						// checking whether or not the start time entered is valid
						else if (startTimeTextField.getText().length() != 4 || Integer.parseInt(startTimeTextField.getText()) > 2359 || Integer.parseInt(startTimeTextField.getText()) < 0000 || Integer.parseInt(startTimeTextField.getText().substring(2, 4)) >= 60)
						{
							error = 1;
							invalidInputMessage("Invalid start time entered! -> \"" + startTimeTextField.getText() + "\" is invalid.\n\nInstructions:\n\n\t\tEnter a start time in 24 hour clock format.\n\nExamples\n\n\t\t0830 for 8:30 am\n\t\t1200 for 12:00 pm\n\t\t1415 for 2:15 pm");
						}
						// checking whether or not a match duration has been entered
						if (matchDurationTextField.getText().length() == 0)
						{
							error = 1;
							invalidInputMessage("Match duration field is empty!\n\nInstructions:\n\n\t\tEnter match duration in minutes (integer).");
						}	
						// checking whether or not a break duration has been entered
						if (breakDurationTextField.getText().length() == 0)
						{
							error = 1;
							invalidInputMessage("Break duration field is empty!\n\nInstructions:\n\n\t\tEnter break duration in minutes (integer).");
						}
						// checking whether or not a number of teams has been entered
						if (numTeamsTextField.getText().length() == 0)
						{
							error = 1;
							invalidInputMessage("Number of teams field is empty!\n\nInstructions:\n\n\t\tEnter a number of teams.");
						}
						// checking whether or not the entered number of teams is valid
						else if (!(Integer.parseInt(numTeamsTextField.getText()) > 1 && Integer.parseInt(numTeamsTextField.getText()) < 21))
						{
							error = 1;
							invalidInputMessage("Invalid number of teams entered! -> \"" + numTeamsTextField.getText() + "\" is invalid.\n\nInstructions:\n\n\t\tEnter a number of teams between 2 and 20 (inclusive).");
						}
						// checking whether or not a number of venues has been entered
						if (numVenuesTextField.getText().length() == 0)
						{
							error = 1;
							invalidInputMessage("Number of venues field is empty!\n\nInstructions:\n\n\t\tEnter a number of venues.");
						}
						// checking whether or not the entered number of venues is valid
						else if(!(Integer.parseInt(numVenuesTextField.getText()) > 0 && Integer.parseInt(numVenuesTextField.getText()) <= 3))
						{
							error = 1;
							invalidInputMessage("Invalid number of venues entered! -> \"" + numVenuesTextField.getText() + "\" is invalid.\n\nInstructions:\n\n\t\tEnter a number of venues between 1 and 3 (inclusive).");
						}
						// checking whether or not any errors were detected
						if (error == 0 && error2 == 0)
						{
							// checking whether or not the entered day
							// is in the correct two digit format and 
							// adjusting the format if not
							if (dayTextField.getText().length() == 1)
							{
								dayTextField.setText("0" + dayTextField.getText());
							}
							// checking whether or not the entered month
							// is in the correct two digit format and 
							// adjusting the format if not
							if (monthTextField.getText().length() == 1)
							{
								monthTextField.setText("0" + monthTextField.getText());
							}
							tournament = new Tournaments(tournamentNameTextField.getText(), yearTextField.getText() + "-" + monthTextField.getText() + "-" + dayTextField.getText(), Integer.parseInt(startTimeTextField.getText()), Integer.parseInt(matchDurationTextField.getText()), Integer.parseInt(breakDurationTextField.getText()), Integer.parseInt(numTeamsTextField.getText()), Integer.parseInt(numVenuesTextField.getText()));
							if (tournament.getCompletionConfirmation() == true)
							{
								try
								{
									SQLActions.addTournament(tournament);
								}
								// attempting to catch an SQL error in adding the tournament to the database
								catch (SQLException exc)
								{
									javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" + exc + "\n\nPlease report error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
								}
								javax.swing.JOptionPane.showMessageDialog(null, tournament.getTournamentName() + " Tournament Created!", "", 1);
								// reseting text fields
								tournamentNameTextField.setText("");
								dayTextField.setText("");
								monthTextField.setText("");
								yearTextField.setText("");
								startTimeTextField.setText("");
								matchDurationTextField.setText("");
								breakDurationTextField.setText("");
								numTeamsTextField.setText("");
								numVenuesTextField.setText("");
								// setting labels on panel 5 (panCenter)
								tournamentNameCenterLabel.setText(tournament.getTournamentName());
								tournamentDateCenterLabel.setText(tournament.getDate().toString().substring(8, 10) + "-" + tournament.getDate().toString().substring(5, 7) + "-" + tournament.getDate().toString().substring(0, 4));
								numberOfTeamsValueCenterLabel.setText(":  " + tournament.getNumTeams());
								numberOfVenuesValueCenterLabel.setText(":  " + tournament.getNumVenues());
								numberOfMatchesValueCenterLabel.setText(":  " + tournament.calculateNumMatches(tournament.getNumTeams()));
								matchDurationValueCenterLabel.setText(":  " + tournament.getMatchDuration());
								breakDurationValueCenterLabel.setText(":  " + tournament.getBreakDuration());
								totalDurationValueCenterLabel.setText(":  ~" + tournament.calculateTotalDuration() + "h");
								panInfoEntry.setVisible(false);
								panCenter.setVisible(true);
								setContentPane(getPanel5());
							}
						}
					}
					// attempting to catch any error generated by the input of a non-integer in a field that requires the 
					// input of an integer
					catch (NumberFormatException exc)
					{
						javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\nThe tournament has not been created.\nPlease ensure the inputed data is correct.\n\nThe value in double quotation marks below is invalid!\n" + exc, "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch (Exception exc)
				{
				}
			}
		});
		detailsSubmitButton.setToolTipText("Click to submit details");
		detailsSubmitButton.setBounds(400, 317, 117, 28);
		panInfoEntry.add(detailsSubmitButton);
		
		numVenuesTextField = new JTextField();
		numVenuesTextField.setHorizontalAlignment(SwingConstants.CENTER);
		numVenuesTextField.setToolTipText("Enter number of venues here");
		numVenuesTextField.setBounds(125, 315, 150, 28);
		panInfoEntry.add(numVenuesTextField);
		numVenuesTextField.setColumns(10);
		
		maxVenuesLabel = new JLabel("(max. 3 venues)");
		maxVenuesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		maxVenuesLabel.setForeground(Color.RED);
		maxVenuesLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		maxVenuesLabel.setBounds(0, 335, 125, 15);
		panInfoEntry.add(maxVenuesLabel);
		
		numVenuesLabel = new JLabel("Number of Venues*");
		numVenuesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numVenuesLabel.setBounds(0, 320, 125, 16);
		panInfoEntry.add(numVenuesLabel);
		
		numTeamsTextField = new JTextField();
		numTeamsTextField.setHorizontalAlignment(SwingConstants.CENTER);
		numTeamsTextField.setToolTipText("Enter number of teams here");
		numTeamsTextField.setBounds(125, 275, 150, 28);
		panInfoEntry.add(numTeamsTextField);
		numTeamsTextField.setColumns(10);
		
		maxTeamsLabel = new JLabel("(max. 20 teams)");
		maxTeamsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		maxTeamsLabel.setForeground(Color.RED);
		maxTeamsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		maxTeamsLabel.setBounds(0, 295, 125, 15);
		panInfoEntry.add(maxTeamsLabel);
		
		numTeamsLabel = new JLabel("Number of Teams*");
		numTeamsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numTeamsLabel.setBounds(0, 280, 125, 16);
		panInfoEntry.add(numTeamsLabel);
		
		breakDurationTextField = new JTextField();
		breakDurationTextField.setHorizontalAlignment(SwingConstants.CENTER);
		breakDurationTextField.setToolTipText("Enter break duration here");
		breakDurationTextField.setBounds(125, 235, 150, 28);
		panInfoEntry.add(breakDurationTextField);
		breakDurationTextField.setColumns(10);
		
		breakDurationUnitsLabel = new JLabel("(minutes)");
		breakDurationUnitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		breakDurationUnitsLabel.setForeground(Color.RED);
		breakDurationUnitsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		breakDurationUnitsLabel.setBounds(0, 255, 125, 15);
		panInfoEntry.add(breakDurationUnitsLabel);
		
		breakDurationLabel = new JLabel("Break Duration*");
		breakDurationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		breakDurationLabel.setBounds(0, 240, 125, 16);
		panInfoEntry.add(breakDurationLabel);
		
		matchDurationTextField = new JTextField();
		matchDurationTextField.setHorizontalAlignment(SwingConstants.CENTER);
		matchDurationTextField.setToolTipText("Enter match duration here");
		matchDurationTextField.setBounds(125, 195, 150, 28);
		panInfoEntry.add(matchDurationTextField);
		matchDurationTextField.setColumns(10);
		
		matchDurationUnitsLabel = new JLabel("(minutes)");
		matchDurationUnitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		matchDurationUnitsLabel.setForeground(Color.RED);
		matchDurationUnitsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		matchDurationUnitsLabel.setBounds(0, 215, 125, 15);
		panInfoEntry.add(matchDurationUnitsLabel);
		
		matchDurationLabel = new JLabel("Match Duration*");
		matchDurationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		matchDurationLabel.setBounds(0, 200, 125, 16);
		panInfoEntry.add(matchDurationLabel);
		
		startTimeTextField = new JTextField();
		startTimeTextField.setHorizontalAlignment(SwingConstants.CENTER);
		startTimeTextField.setToolTipText("Enter start time here");
		startTimeTextField.setBounds(125, 155, 150, 28);
		panInfoEntry.add(startTimeTextField);
		startTimeTextField.setColumns(10);
		
		startTimeFormatLabel = new JLabel("(eg. 0830 for 8:30 am)");
		startTimeFormatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		startTimeFormatLabel.setForeground(Color.RED);
		startTimeFormatLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		startTimeFormatLabel.setBounds(0, 175, 125, 15);
		panInfoEntry.add(startTimeFormatLabel);
		
		startTimeLabel = new JLabel("Start Time*");
		startTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		startTimeLabel.setBounds(0, 160, 125, 16);
		panInfoEntry.add(startTimeLabel);
		
		yearTextField = new JTextField();
		yearTextField.setHorizontalAlignment(SwingConstants.CENTER);
		yearTextField.setToolTipText("YYYY");
		yearTextField.setBounds(205, 115, 90, 28);
		panInfoEntry.add(yearTextField);
		yearTextField.setColumns(10);
		
		monthTextField = new JTextField();
		monthTextField.setHorizontalAlignment(SwingConstants.CENTER);
		monthTextField.setToolTipText("MM");
		monthTextField.setBounds(165, 115, 45, 28);
		panInfoEntry.add(monthTextField);
		monthTextField.setColumns(10);
		
		dayTextField = new JTextField();
		dayTextField.setHorizontalAlignment(SwingConstants.CENTER);
		dayTextField.setToolTipText("DD");
		dayTextField.setBounds(125, 115, 45, 28);
		panInfoEntry.add(dayTextField);
		dayTextField.setColumns(10);
		
		dateLabel = new JLabel("Date*");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setBounds(0, 120, 125, 16);
		panInfoEntry.add(dateLabel);
		
		tournamentNameTextField = new JTextField();
		tournamentNameTextField.setToolTipText("Enter tournament name here");
		tournamentNameTextField.setBounds(125, 75, 150, 28);
		panInfoEntry.add(tournamentNameTextField);
		tournamentNameTextField.setColumns(10);
		
		nameMaxCharactersLabel = new JLabel("(max. 20 characters)");
		nameMaxCharactersLabel.setForeground(Color.RED);
		nameMaxCharactersLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		nameMaxCharactersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameMaxCharactersLabel.setBounds(0, 95, 125, 15);
		panInfoEntry.add(nameMaxCharactersLabel);
		
		tournamentNameLabel = new JLabel("Tournament Name*");
		tournamentNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tournamentNameLabel.setBounds(0, 80, 125, 16);
		panInfoEntry.add(tournamentNameLabel);
		
		tournamentDetailsPageLabel = new JLabel("- Details Entry Page -");
		tournamentDetailsPageLabel.setForeground(Color.GRAY);
		tournamentDetailsPageLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		tournamentDetailsPageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tournamentDetailsPageLabel.setBounds(165, 39, 231, 16);
		panInfoEntry.add(tournamentDetailsPageLabel);
		
		titleLabelFour = new JLabel("Tournament Manager");
		titleLabelFour.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 20));
		titleLabelFour.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabelFour.setForeground(Color.GRAY);
		titleLabelFour.setBounds(155, 10, 241, 28);
		panInfoEntry.add(titleLabelFour);
		
		propertyLabelFour = new JLabel("This program is the property of the British International School of Jeddah Student Council");
		propertyLabelFour.setHorizontalAlignment(SwingConstants.CENTER);
		propertyLabelFour.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 10));
		propertyLabelFour.setBounds(0, 360, 550, 16);
		panInfoEntry.add(propertyLabelFour);
		
		backgroundLabelFour = new JLabel("");
		backgroundLabelFour.setIcon(new ImageIcon(background));
		backgroundLabelFour.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundLabelFour.setBounds(0, 10, 550, 349);
		panInfoEntry.add(backgroundLabelFour);
		
		
		
		
		// Fifth Panel (panCenter)
		
		
		
		
		homeButtonFive = new JButton("");
		homeButtonFive.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// reseting text fields
				tournamentNameCenterLabel.setText("");
				tournamentDateCenterLabel.setText("");
				numberOfTeamsValueCenterLabel.setText(":");
				numberOfVenuesValueCenterLabel.setText(":");
				numberOfMatchesValueCenterLabel.setText(":");
				matchDurationValueCenterLabel.setText(":");
				breakDurationValueCenterLabel.setText(":");
				totalDurationValueCenterLabel.setText(":");
				panCenter.setVisible(false);
				panHome.setVisible(true);
				setContentPane(getPanel2());
			}
		});
		homeButtonFive.setToolTipText("Click to return to the homepage");
		homeButtonFive.setIcon(new ImageIcon(GUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));
		homeButtonFive.setBounds(0, 10, 35, 35);
		panCenter.add(homeButtonFive);
		
		deleteTournamentButton = new JButton("Delete Tournament");
		deleteTournamentButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + tournament.getTournamentName() + "?\nThis action cannot be undone.", "Attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				{
					try
					{
						if (confirmation == JOptionPane.YES_OPTION)
						{
							SQLActions.deleteTournament(tournament.getTournamentName());
							JOptionPane.showMessageDialog(null, tournament.getTournamentName() + " has been successfully deleted!");
							homeButtonFive.doClick();
						}
					}
					// attempting to catch an SQL error in deleting the tournament from the database
					catch (SQLException exc)
					{
						javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" + exc + "\n\nPlease report error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		deleteTournamentButton.setToolTipText("Click to delete tournament");
		deleteTournamentButton.setBounds(190, 250, 150, 25);
		panCenter.add(deleteTournamentButton);
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// setting text fields on panel 7 (panEdit)
				tournamentNameTextFieldSeven.setText(tournament.getTournamentName());
				dayTextFieldSeven.setText(tournament.getDate().substring(8, 10));
				monthTextFieldSeven.setText(tournament.getDate().substring(5, 7));
				yearTextFieldSeven.setText(tournament.getDate().substring(0, 4));
				startTimeTextFieldSeven.setText(tournament.getStartTime());
				matchDurationTextFieldSeven.setText(tournament.getMatchDuration() + "");
				breakDurationTextFieldSeven.setText(tournament.getBreakDuration() + "");
				numTeamsTextFieldSeven.setText(tournament.getNumTeams() + "");
				numVenuesTextFieldSeven.setText(tournament.getNumVenues() + "");
				panCenter.setVisible(false);
				panEdit.setVisible(true);
				setContentPane(getPanel7());
				setMainButton(detailsSubmitButtonSeven);
			}
		});
		editButton.setToolTipText("Click to edit tournament details");
		editButton.setBounds(77, 250, 115, 25);
		panCenter.add(editButton);
		
		viewScheduleButton = new JButton("View Schedule");
		viewScheduleButton.setToolTipText("Click to view tournament schedule");
		viewScheduleButton.setBounds(60, 162, 150, 50);
		panCenter.add(viewScheduleButton);
		
		viewScheduleButton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e)
			{
				// retrieving the schedule in the form of a scroll pane and adding
				// it to panel 6 (panSched) and setting the correct page title
				scheduleScrollPane = tournament.getScheduleScrollPane();
				panSched.add(scheduleScrollPane);
				tournamentIdentifierLabel.setText(tournament.getTournamentName());
				panCenter.setVisible(false);
				panSched.setVisible(true);
				setContentPane(getPanel6());
			}
		});
		
		totalDurationValueCenterLabel = new JLabel(":");
		totalDurationValueCenterLabel.setToolTipText("Approximate Total Duration (hours)");
		totalDurationValueCenterLabel.setForeground(Color.WHITE);
		totalDurationValueCenterLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		totalDurationValueCenterLabel.setBounds(375, 335, 50, 15);
		panCenter.add(totalDurationValueCenterLabel);
		
		breakDurationValueCenterLabel = new JLabel(":");
		breakDurationValueCenterLabel.setToolTipText("Break Duration (minutes)");
		breakDurationValueCenterLabel.setForeground(Color.WHITE);
		breakDurationValueCenterLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		breakDurationValueCenterLabel.setBounds(375, 315, 50, 15);
		panCenter.add(breakDurationValueCenterLabel);
		
		matchDurationValueCenterLabel = new JLabel(":");
		matchDurationValueCenterLabel.setToolTipText("Match Duration (minutes)");
		matchDurationValueCenterLabel.setForeground(Color.WHITE);
		matchDurationValueCenterLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		matchDurationValueCenterLabel.setBounds(375, 295, 50, 15);
		panCenter.add(matchDurationValueCenterLabel);
		
		totalDurationCenterLabel = new JLabel("Total Duration");
		totalDurationCenterLabel.setForeground(Color.WHITE);
		totalDurationCenterLabel.setBounds(265, 335, 105, 15);
		panCenter.add(totalDurationCenterLabel);
		
		breakDurationCenterLabel = new JLabel("Break Duration");
		breakDurationCenterLabel.setForeground(Color.WHITE);
		breakDurationCenterLabel.setBounds(265, 315, 105, 15);
		panCenter.add(breakDurationCenterLabel);
		
		matchDurationCenterLabel = new JLabel("Match Duration");
		matchDurationCenterLabel.setForeground(Color.WHITE);
		matchDurationCenterLabel.setBounds(265, 295, 105, 15);
		panCenter.add(matchDurationCenterLabel);
		
		numberOfMatchesValueCenterLabel = new JLabel(":");
		numberOfMatchesValueCenterLabel.setToolTipText("Number of Matches");
		numberOfMatchesValueCenterLabel.setForeground(Color.WHITE);
		numberOfMatchesValueCenterLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		numberOfMatchesValueCenterLabel.setBounds(155, 335, 50, 15);
		panCenter.add(numberOfMatchesValueCenterLabel);
		
		numberOfVenuesValueCenterLabel = new JLabel(":");
		numberOfVenuesValueCenterLabel.setToolTipText("Number of Venues");
		numberOfVenuesValueCenterLabel.setForeground(Color.WHITE);
		numberOfVenuesValueCenterLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		numberOfVenuesValueCenterLabel.setBounds(155, 315, 50, 15);
		panCenter.add(numberOfVenuesValueCenterLabel);
		
		numberOfTeamsValueCenterLabel = new JLabel(":");
		numberOfTeamsValueCenterLabel.setToolTipText("Number of Teams");
		numberOfTeamsValueCenterLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		numberOfTeamsValueCenterLabel.setForeground(Color.WHITE);
		numberOfTeamsValueCenterLabel.setBounds(155, 295, 50, 15);
		panCenter.add(numberOfTeamsValueCenterLabel);
		
		numberOfMatchesCenterLabel = new JLabel("Number of Matches");
		numberOfMatchesCenterLabel.setForeground(Color.WHITE);
		numberOfMatchesCenterLabel.setBounds(20, 335, 130, 15);
		panCenter.add(numberOfMatchesCenterLabel);
		
		numberOfVenuesCenterLabel = new JLabel("Number of Venues");
		numberOfVenuesCenterLabel.setForeground(Color.WHITE);
		numberOfVenuesCenterLabel.setBounds(20, 315, 130, 15);
		panCenter.add(numberOfVenuesCenterLabel);
		
		numberOfTeamsCenterLabel = new JLabel("Number of Teams");
		numberOfTeamsCenterLabel.setForeground(Color.WHITE);
		numberOfTeamsCenterLabel.setBounds(20, 295, 130, 15);
		panCenter.add(numberOfTeamsCenterLabel);
		
		detailsCenterLabel = new JLabel("Details:");
		detailsCenterLabel.setForeground(Color.WHITE);
		detailsCenterLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		detailsCenterLabel.setBounds(20, 255, 60, 15);
		panCenter.add(detailsCenterLabel);
		
		tournamentDateCenterLabel = new JLabel("");
		tournamentDateCenterLabel.setToolTipText("DD-MM-YYYY");
		tournamentDateCenterLabel.setForeground(Color.WHITE);
		tournamentDateCenterLabel.setBounds(20, 105, 80, 15);
		panCenter.add(tournamentDateCenterLabel);
		
		tournamentNameCenterLabel = new JLabel("");
		tournamentNameCenterLabel.setForeground(Color.WHITE);
		tournamentNameCenterLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		tournamentNameCenterLabel.setBounds(10, 75, 250, 28);
		panCenter.add(tournamentNameCenterLabel);
		
		tournamentCenterLabel = new JLabel("- Tournament Center -");
		tournamentCenterLabel.setForeground(Color.GRAY);
		tournamentCenterLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		tournamentCenterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tournamentCenterLabel.setBounds(165, 39, 231, 16);
		panCenter.add(tournamentCenterLabel);
		
		titleLabelFive = new JLabel("Tournament Manager");
		titleLabelFive.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 20));
		titleLabelFive.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabelFive.setForeground(Color.GRAY);
		titleLabelFive.setBounds(155, 10, 241, 28);
		panCenter.add(titleLabelFive);
		
		propertyLabelFive = new JLabel("This program is the property of the British International School of Jeddah Student Council");
		propertyLabelFive.setHorizontalAlignment(SwingConstants.CENTER);
		propertyLabelFive.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 10));
		propertyLabelFive.setBounds(0, 360, 550, 16);
		panCenter.add(propertyLabelFive);
		
		studentCouncilLogoLabelFive = new JLabel("");
		studentCouncilLogoLabelFive.setToolTipText("BISJ Student Council Logo");
		studentCouncilLogoLabelFive.setIcon(new ImageIcon(studentCouncilLogo));
		studentCouncilLogoLabelFive.setHorizontalAlignment(SwingConstants.CENTER);
		studentCouncilLogoLabelFive.setBounds(435, 260, 115, 95);
		panCenter.add(studentCouncilLogoLabelFive);
		
		backgroundLabelFive = new JLabel("");
		backgroundLabelFive.setIcon(new ImageIcon(background));
		backgroundLabelFive.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundLabelFive.setBounds(0, 10, 550, 349);
		panCenter.add(backgroundLabelFive);
		
		
		
		
		// Sixth Panel (panSched)
		
		
		
		
		homeButtonSix = new JButton("");
		homeButtonSix.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				panSched.remove(scheduleScrollPane);
				panSched.setVisible(false);
				panHome.setVisible(true);
				setContentPane(getPanel2());
			}
		});
		homeButtonSix.setToolTipText("Click to return to the homepage");
		homeButtonSix.setIcon(new ImageIcon(GUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));
		homeButtonSix.setBounds(0, 10, 35, 35);
		panSched.add(homeButtonSix);
		
		backButtonSix = new JButton("");
		backButtonSix.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				panSched.remove(scheduleScrollPane);
				panSched.setVisible(false);
				panCenter.setVisible(true);
				setContentPane(getPanel5());
			}
		});
		backButtonSix.setToolTipText("Click to return to the previous page");
		backButtonSix.setIcon(new ImageIcon(backspace));
		backButtonSix.setBounds(35, 10, 35, 35);
		panSched.add(backButtonSix);
		
		updatePointsButton = new JButton("Update Points");
		updatePointsButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				panSched.remove(scheduleScrollPane);
				teamOne.insertItemAt("-Select-", 0);
				teamTwo.insertItemAt("-Select-", 0);
				teamOneScoreTextField.setToolTipText("Select a team and enter the score here");
				teamTwoScoreTextField.setToolTipText("Select a team and enter the score here");
				String [] tournamentTeams = tournament.getTeamNames();
				for (int loopFirstDegree = 0; loopFirstDegree < tournament.getNumTeams(); loopFirstDegree++)
				{
					teamOne.insertItemAt(tournamentTeams[loopFirstDegree], (loopFirstDegree + 1));
					teamTwo.insertItemAt(tournamentTeams[loopFirstDegree], (loopFirstDegree + 1));
				}
				teamOne.setSelectedIndex(0);
				teamTwo.setSelectedIndex(0);
				panSched.setVisible(false);
				panScore.setVisible(true);
				setContentPane(getPanel9());
				setMainButton(scoreSubmitButton);
			}
		});
		updatePointsButton.setToolTipText("Click to update team points");
		updatePointsButton.setBounds(400, 15, 117, 29);
		panSched.add(updatePointsButton);
		
		tournamentIdentifierLabel = new JLabel();
		tournamentIdentifierLabel.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
		tournamentIdentifierLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tournamentIdentifierLabel.setForeground(Color.GRAY);
		tournamentIdentifierLabel.setBounds(20, 50, 300, 300);
		panSched.add(tournamentIdentifierLabel);
		
		viewScheduleLabel = new JLabel("Click here to view schedule");
		viewScheduleLabel.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 15));
		viewScheduleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		viewScheduleLabel.setForeground(Color.GRAY);
		viewScheduleLabel.setBounds(20, 25, 300, 300);
		panSched.add(viewScheduleLabel);
		
		tournamentScheduleLabel = new JLabel("- Tournament Schedule -");
		tournamentScheduleLabel.setForeground(Color.GRAY);
		tournamentScheduleLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		tournamentScheduleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tournamentScheduleLabel.setBounds(165, 30, 231, 16);
		panSched.add(tournamentScheduleLabel);
		
		titleLabelSix = new JLabel("Tournament Manager");
		titleLabelSix.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 20));
		titleLabelSix.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabelSix.setForeground(Color.GRAY);
		titleLabelSix.setBounds(155, 10, 241, 28);
		panSched.add(titleLabelSix);
		
		propertyLabelSix = new JLabel("This program is the property of the British International School of Jeddah Student Council");
		propertyLabelSix.setHorizontalAlignment(SwingConstants.CENTER);
		propertyLabelSix.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 10));
		propertyLabelSix.setBounds(0, 360, 550, 16);
		panSched.add(propertyLabelSix);
		
		backgroundLabelSix = new JLabel("");
		backgroundLabelSix.setIcon(new ImageIcon(background));
		backgroundLabelSix.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundLabelSix.setBounds(0, 10, 550, 349);
		panSched.add(backgroundLabelSix);
		
		
		
		
		// Seventh Panel (panEdit)
		
		
		
		
		homeButtonSeven = new JButton("");
		homeButtonSeven.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// reseting text fields
				tournamentNameTextFieldSeven.setText("");
				dayTextFieldSeven.setText("");
				monthTextFieldSeven.setText("");
				yearTextFieldSeven.setText("");
				startTimeTextFieldSeven.setText("");
				matchDurationTextFieldSeven.setText("");
				breakDurationTextFieldSeven.setText("");
				numTeamsTextFieldSeven.setText("");
				numVenuesTextFieldSeven.setText("");
				panEdit.setVisible(false);
				homeButtonFive.doClick();
			}
		});
		homeButtonSeven.setToolTipText("Click to return to the homepage");
		homeButtonSeven.setIcon(new ImageIcon(GUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));
		homeButtonSeven.setBounds(0, 10, 35, 35);
		panEdit.add(homeButtonSeven);
		
		backButtonSeven = new JButton("");
		backButtonSeven.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// reseting text fields
				tournamentNameTextFieldSeven.setText("");
				dayTextFieldSeven.setText("");
				monthTextFieldSeven.setText("");
				yearTextFieldSeven.setText("");
				startTimeTextFieldSeven.setText("");
				matchDurationTextFieldSeven.setText("");
				breakDurationTextFieldSeven.setText("");
				numTeamsTextFieldSeven.setText("");
				numVenuesTextFieldSeven.setText("");
				panEdit.setVisible(false);
				panCenter.setVisible(true);
				setContentPane(getPanel5());
			}
		});
		backButtonSeven.setToolTipText("Click to return to the previous page");
		backButtonSeven.setIcon(new ImageIcon(backspace));
		backButtonSeven.setBounds(35, 10, 35, 35);
		panEdit.add(backButtonSeven);
		
		detailsSubmitButtonSeven = new JButton("Submit");
		detailsSubmitButtonSeven.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					int error = 0;
					int error2 = 0;
					now = new Date();
					// checking whether or not a tournament name has been entered
					if (tournamentNameTextFieldSeven.getText().length() == 0)
					{
						error = 1;
						invalidInputMessage("Tournament name field is empty!\n\nInstructions:\n\n\t\tEnter a tournament name.");
					}
					// checking whether or not the tournament name is too long
					else if (tournamentNameTextFieldSeven.getText().length() > 20)
					{
						error = 1;
						invalidInputMessage("Tournament name is too long! -> \"" + tournamentNameTextFieldSeven.getText() +
								"\" is invalid.\n\nInstructions:\n\n\t\tEnter a tournament name that is 20 characters or less.");
					}
					else
					{
						try
						{
							// checking whether or not the tournament name has already been used
							if (SQLActions.tournamentNameCheck(tournamentNameTextFieldSeven.getText()) == false &&
									!(tournamentNameTextFieldSeven.getText().equals(tournament.getTournamentName())))
							{
								error = 1;
								invalidInputMessage("Tournament name is not available! -> \"" + tournamentNameTextFieldSeven.getText() + "\" has already "
										+ "been used.");
								int suggestionNumber = 1;
								while (SQLActions.tournamentNameCheck(tournamentNameTextFieldSeven.getText() + " - " + suggestionNumber) == false)
								{
									suggestionNumber++;
								}
								String suggestName = tournamentNameTextFieldSeven.getText() + " - " + suggestionNumber;
								if (!(suggestName.length() > 20))
								{
									int option = JOptionPane.showConfirmDialog(null, "The name \"" + suggestName + "\" is available.\nWould you like to "
											+ "use this name?", "Suggestion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
									if (option == JOptionPane.YES_OPTION)
									{
										tournamentNameTextField.setText(suggestName);
										error = 0;
									}
								}
							}
						}
						// attempting to catch an SQL error in searching the database to detect any tournament name clashes
						catch (SQLException exc)
						{
							javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" + exc + "\n\nPlease report "
									+ "error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					// checking whether or not the date field is incomplete
					if (dayTextFieldSeven.getText().length() == 0 || monthTextFieldSeven.getText().length() == 0 || yearTextFieldSeven.getText().length() == 0)
					{
						error = 1;
						invalidInputMessage("Date field is incomplete!\n\nInstructions:\n\n\t\tEnter a date (DD/MM/YYYY).");
					}
					// checking whether or not the year entered has already passed
					else if (Integer.parseInt(yearTextFieldSeven.getText()) < Integer.parseInt(now.toString().substring(24, 28)))
					{
						error = 1;
						invalidInputMessage("Invalid year entered! \"" + yearTextFieldSeven.getText() + "\" is invalid.\n\nInstructions:"
								+ "\n\n\t\tEnter a year greater than or equal to " + now.toString().substring(24, 28));
					}
					// checking whether or not the month entered is invalid
					else if (!(Integer.parseInt(monthTextFieldSeven.getText()) > 0 && Integer.parseInt(monthTextFieldSeven.getText()) < 13))
					{
						error2 = 1;
						invalidInputMessage("Invalid month entered! \"" + monthTextFieldSeven.getText() + "\" is invalid."
								+ "\n\nInstructions:\n\n\t\tEnter a month between 1 and 12 (inclusive).");
						// checking whether or not the day and month may have been accidentally transposed
						// and if yes, suggesting the untransposed date and making the adjustment upon the
						// user's approval
						if ((((Integer.parseInt(dayTextFieldSeven.getText()) == 1 || Integer.parseInt(dayTextFieldSeven.getText()) == 3 ||
								Integer.parseInt(dayTextFieldSeven.getText()) == 5 || Integer.parseInt(dayTextFieldSeven.getText()) == 7 ||
								Integer.parseInt(dayTextFieldSeven.getText()) == 8 || Integer.parseInt(dayTextFieldSeven.getText()) == 10 ||
								Integer.parseInt(dayTextFieldSeven.getText()) == 12) && (Integer.parseInt(monthTextFieldSeven.getText()) >= 1 &&
								Integer.parseInt(monthTextFieldSeven.getText()) <= 31)) || (Integer.parseInt(dayTextFieldSeven.getText()) == 2 &&
								(Integer.parseInt(monthTextFieldSeven.getText()) >= 1 && Integer.parseInt(monthTextFieldSeven.getText()) <= 29)) ||
								((Integer.parseInt(dayTextFieldSeven.getText()) == 4 || Integer.parseInt(dayTextFieldSeven.getText()) == 6 ||
								Integer.parseInt(dayTextFieldSeven.getText()) == 9 || Integer.parseInt(dayTextFieldSeven.getText()) == 11) &&
								(Integer.parseInt(monthTextFieldSeven.getText()) >= 1 && Integer.parseInt(monthTextFieldSeven.getText()) <= 30))))
						{
							int option = JOptionPane.showConfirmDialog(null, "Did you mean " + monthTextFieldSeven.getText() + "/"
									+ dayTextFieldSeven.getText() + "/" + yearTextFieldSeven.getText() + " (DD/MM/YYYY)?", "Transposed Date",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (option == JOptionPane.YES_OPTION)
							{
								String temp = dayTextFieldSeven.getText();
								dayTextFieldSeven.setText(monthTextFieldSeven.getText());
								monthTextFieldSeven.setText(temp);
								error2 = 0;
							}
						}
					}
					// checking whether or not the day entered is valid
					else if (!(((Integer.parseInt(monthTextFieldSeven.getText()) == 1 || Integer.parseInt(monthTextFieldSeven.getText()) == 3 ||
							Integer.parseInt(monthTextFieldSeven.getText()) == 5 || Integer.parseInt(monthTextFieldSeven.getText()) == 7 ||
							Integer.parseInt(monthTextFieldSeven.getText()) == 8 || Integer.parseInt(monthTextFieldSeven.getText()) == 10 ||
							Integer.parseInt(monthTextFieldSeven.getText()) == 12) && (Integer.parseInt(dayTextFieldSeven.getText()) >= 1 &&
							Integer.parseInt(dayTextFieldSeven.getText()) <= 31)) || (Integer.parseInt(monthTextFieldSeven.getText()) == 2 &&
							(Integer.parseInt(dayTextFieldSeven.getText()) >= 1 && Integer.parseInt(dayTextFieldSeven.getText()) <= 29)) ||
							((Integer.parseInt(monthTextFieldSeven.getText()) == 4 || Integer.parseInt(monthTextFieldSeven.getText()) == 6 ||
							Integer.parseInt(monthTextFieldSeven.getText()) == 9 || Integer.parseInt(monthTextFieldSeven.getText()) == 11) &&
							(Integer.parseInt(dayTextFieldSeven.getText()) >= 1 && Integer.parseInt(dayTextFieldSeven.getText()) <= 30))))
					{
						error = 1;
						invalidInputMessage("Invalid day entered! \"" + dayTextFieldSeven.getText() + "/" + monthTextFieldSeven.getText() +
								"\" is invalid!\n\nInstructions\n\n\t\tEnter a real date.");
					}
					// checking whether or not a start time has been entered
					if (startTimeTextFieldSeven.getText().length() == 0)
					{
						error = 1;
						invalidInputMessage("Start time field is empty!\n\nInstructions:\n\n\t\tEnter a start time.");
					}
					// checking whether or not the start time entered is valid
					else if (startTimeTextFieldSeven.getText().length() != 4 || Integer.parseInt(startTimeTextFieldSeven.getText()) > 2359 || 
							Integer.parseInt(startTimeTextFieldSeven.getText()) < 0000 || Integer.parseInt(startTimeTextFieldSeven.getText().substring(2, 4)) 
							>= 60)
					{
						error = 1;
						invalidInputMessage("Invalid start time entered! -> \"" + startTimeTextFieldSeven.getText() +
								"\" is invalid.\n\nInstructions:\n\n\t\tEnter a start time in 24 hour clock format.\n\nExamples\n\n\t\t0830 "
								+ "for 8:30 am\n\t\t1200 for 12:00 pm\n\t\t1415 for 2:15 pm");
					}
					// checking whether or not a match duration has been entered
					if (matchDurationTextFieldSeven.getText().length() == 0)
					{
						error = 1;
						invalidInputMessage("Match duration field is empty!\n\nInstructions:\n\n\t\tEnter match duration in minutes (integer).");
					}
					// checking whether or not a break duration has been entered
					if (breakDurationTextFieldSeven.getText().length() == 0)
					{
						error = 1;
						invalidInputMessage("Break duration field is empty!\n\nInstructions:\n\n\t\tEnter break duration in minutes (integer).");
					}
					// checking whether or not a number of venues has been entered
					if (numVenuesTextFieldSeven.getText().length() == 0)
					{
						error = 1;
						invalidInputMessage("Number of venues field is empty!\n\nInstructions:\n\n\t\tEnter a number of venues.");
					}
					// checking whether or not the entered number of venues is valid
					else if(!(Integer.parseInt(numVenuesTextFieldSeven.getText()) > 0 && Integer.parseInt(numVenuesTextFieldSeven.getText()) <= 3))
					{
						error = 1;
						invalidInputMessage("Invalid number of venues entered! -> \"" + numVenuesTextFieldSeven.getText()
							+ "\" is invalid.\n\nInstructions:\n\n\t\tEnter a number of venues between 1 and 3 (inclusive).");
					}
					// checking whether or not any errors were detected
					if (error == 0 && error2 == 0)
					{
						// checking whether or not the entered day
						// is in the correct two digit format and 
						// adjusting the format if not
						if (dayTextField.getText().length() == 1)
						{
							dayTextField.setText("0" + dayTextField.getText());
						}
						// checking whether or not the entered month
						// is in the correct two digit format and 
						// adjusting the format if not
						if (monthTextField.getText().length() == 1)
						{
							monthTextField.setText("0" + monthTextField.getText());
						}
						int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to update " + tournament.getTournamentName()
							+ "?\nThis action cannot be undone.", "Attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (confirmation == JOptionPane.YES_OPTION)
						{
							try
							{
								tournament = SQLActions.updateDetails(tournament.getTournamentName(), tournamentNameTextFieldSeven.getText(),
										yearTextFieldSeven.getText() + "-" + monthTextFieldSeven.getText() + "-" + dayTextFieldSeven.getText(), Integer.parseInt(startTimeTextFieldSeven.getText()), Integer.parseInt(matchDurationTextFieldSeven.getText()), Integer.parseInt(breakDurationTextFieldSeven.getText()), Integer.parseInt(numVenuesTextFieldSeven.getText()));
							}
							// attempting to catch an SQL error in updating the tournament details in the database
							catch (SQLException exc)
							{
								javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" + exc
										+ "\n\nPlease report error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
							}
							// reseting text fields
							tournamentNameTextFieldSeven.setText("");
							dayTextFieldSeven.setText("");
							monthTextFieldSeven.setText("");
							yearTextFieldSeven.setText("");
							startTimeTextFieldSeven.setText("");
							matchDurationTextFieldSeven.setText("");
							breakDurationTextFieldSeven.setText("");
							numTeamsTextFieldSeven.setText("");
							numVenuesTextFieldSeven.setText("");
							// setting labels on panel 5 (panCenter)
							tournamentNameCenterLabel.setText(tournament.getTournamentName());
							tournamentDateCenterLabel.setText(tournament.getDate().toString().substring(8, 10) + "-" + tournament.getDate().toString().substring(5, 7)+ "-" + tournament.getDate().toString().substring(0, 4));
							numberOfVenuesValueCenterLabel.setText(":  " + tournament.getNumVenues());
							matchDurationValueCenterLabel.setText(":  " + tournament.getMatchDuration());
							breakDurationValueCenterLabel.setText(":  " + tournament.getBreakDuration());
							totalDurationValueCenterLabel.setText(":  ~" + tournament.calculateTotalDuration() + "h");
							panEdit.setVisible(false);
							panCenter.setVisible(true);
							setContentPane(getPanel5());
						}
					}
				}
				// attempting to catch any error generated by the input of a non-integer in a field that requires the 
				// input of an integer
				catch (NumberFormatException exc)
				{
					javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\nThe tournament details have not "
							+ "been updated.\nPlease ensure the inputed data is correct.\n\nThe value in double quotation marks below is invalid!\n"
							+ exc, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		detailsSubmitButtonSeven.setToolTipText("Click to submit updated details");
		detailsSubmitButtonSeven.setBounds(400, 317, 117, 28);
		panEdit.add(detailsSubmitButtonSeven);
		
		numVenuesTextFieldSeven = new JTextField();
		numVenuesTextFieldSeven.setHorizontalAlignment(SwingConstants.CENTER);
		numVenuesTextFieldSeven.setToolTipText("Enter number of venues here");
		numVenuesTextFieldSeven.setBounds(125, 315, 150, 28);
		panEdit.add(numVenuesTextFieldSeven);
		numVenuesTextFieldSeven.setColumns(10);
		
		maxVenuesLabelSeven = new JLabel("(max. 3 venues)");
		maxVenuesLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		maxVenuesLabelSeven.setForeground(Color.RED);
		maxVenuesLabelSeven.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		maxVenuesLabelSeven.setBounds(0, 335, 125, 15);
		panEdit.add(maxVenuesLabelSeven);
		
		numVenuesLabelSeven = new JLabel("Number of Venues*");
		numVenuesLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		numVenuesLabelSeven.setBounds(0, 320, 125, 16);
		panEdit.add(numVenuesLabelSeven);
		
		numTeamsTextFieldSeven = new JTextField();
		numTeamsTextFieldSeven.setEnabled(false);
		numTeamsTextFieldSeven.setHorizontalAlignment(SwingConstants.CENTER);
		numTeamsTextFieldSeven.setToolTipText("This field cannot be edited");
		numTeamsTextFieldSeven.setBounds(125, 275, 150, 28);
		panEdit.add(numTeamsTextFieldSeven);
		numTeamsTextFieldSeven.setColumns(10);
		
		maxTeamsLabelSeven = new JLabel("(max. 20 teams)");
		maxTeamsLabelSeven.setEnabled(false);
		maxTeamsLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		maxTeamsLabelSeven.setForeground(Color.RED);
		maxTeamsLabelSeven.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		maxTeamsLabelSeven.setBounds(0, 295, 125, 15);
		panEdit.add(maxTeamsLabelSeven);
		
		numTeamsLabelSeven = new JLabel("Number of Teams*");
		numTeamsLabelSeven.setEnabled(false);
		numTeamsLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		numTeamsLabelSeven.setBounds(0, 280, 125, 16);
		panEdit.add(numTeamsLabelSeven);
		
		breakDurationTextFieldSeven = new JTextField();
		breakDurationTextFieldSeven.setHorizontalAlignment(SwingConstants.CENTER);
		breakDurationTextFieldSeven.setToolTipText("Enter break duration here");
		breakDurationTextFieldSeven.setBounds(125, 235, 150, 28);
		panEdit.add(breakDurationTextFieldSeven);
		breakDurationTextFieldSeven.setColumns(10);
		
		breakDurationUnitsLabelSeven = new JLabel("(minutes)");
		breakDurationUnitsLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		breakDurationUnitsLabelSeven.setForeground(Color.RED);
		breakDurationUnitsLabelSeven.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		breakDurationUnitsLabelSeven.setBounds(0, 255, 125, 15);
		panEdit.add(breakDurationUnitsLabelSeven);
		
		breakDurationLabelSeven = new JLabel("Break Duration*");
		breakDurationLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		breakDurationLabelSeven.setBounds(0, 240, 125, 16);
		panEdit.add(breakDurationLabelSeven);
		
		matchDurationTextFieldSeven = new JTextField();
		matchDurationTextFieldSeven.setHorizontalAlignment(SwingConstants.CENTER);
		matchDurationTextFieldSeven.setToolTipText("Enter match duration here");
		matchDurationTextFieldSeven.setBounds(125, 195, 150, 28);
		panEdit.add(matchDurationTextFieldSeven);
		matchDurationTextFieldSeven.setColumns(10);
		
		matchDurationUnitsLabelSeven = new JLabel("(minutes)");
		matchDurationUnitsLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		matchDurationUnitsLabelSeven.setForeground(Color.RED);
		matchDurationUnitsLabelSeven.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		matchDurationUnitsLabelSeven.setBounds(0, 215, 125, 15);
		panEdit.add(matchDurationUnitsLabelSeven);
		
		matchDurationLabelSeven = new JLabel("Match Duration*");
		matchDurationLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		matchDurationLabelSeven.setBounds(0, 200, 125, 16);
		panEdit.add(matchDurationLabelSeven);
		
		startTimeTextFieldSeven = new JTextField();
		startTimeTextFieldSeven.setHorizontalAlignment(SwingConstants.CENTER);
		startTimeTextFieldSeven.setToolTipText("Enter start time here");
		startTimeTextFieldSeven.setBounds(125, 155, 150, 28);
		panEdit.add(startTimeTextFieldSeven);
		startTimeTextFieldSeven.setColumns(10);
		
		startTimeFormatLabelSeven = new JLabel("(eg. 0830 for 8:30 am)");
		startTimeFormatLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		startTimeFormatLabelSeven.setForeground(Color.RED);
		startTimeFormatLabelSeven.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		startTimeFormatLabelSeven.setBounds(0, 175, 125, 15);
		panEdit.add(startTimeFormatLabelSeven);
		
		startTimeLabelSeven = new JLabel("Start Time*");
		startTimeLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		startTimeLabelSeven.setBounds(0, 160, 125, 16);
		panEdit.add(startTimeLabelSeven);
		
		yearTextFieldSeven = new JTextField();
		yearTextFieldSeven.setHorizontalAlignment(SwingConstants.CENTER);
		yearTextFieldSeven.setToolTipText("YYYY");
		yearTextFieldSeven.setBounds(205, 115, 90, 28);
		panEdit.add(yearTextFieldSeven);
		yearTextFieldSeven.setColumns(10);
		
		monthTextFieldSeven = new JTextField();
		monthTextFieldSeven.setHorizontalAlignment(SwingConstants.CENTER);
		monthTextFieldSeven.setToolTipText("MM");
		monthTextFieldSeven.setBounds(165, 115, 45, 28);
		panEdit.add(monthTextFieldSeven);
		monthTextFieldSeven.setColumns(10);
		
		dayTextFieldSeven = new JTextField();
		dayTextFieldSeven.setHorizontalAlignment(SwingConstants.CENTER);
		dayTextFieldSeven.setToolTipText("DD");
		dayTextFieldSeven.setBounds(125, 115, 45, 28);
		panEdit.add(dayTextFieldSeven);
		dayTextFieldSeven.setColumns(10);
		
		dateLabelSeven = new JLabel("Date*");
		dateLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabelSeven.setBounds(0, 120, 125, 16);
		panEdit.add(dateLabelSeven);
		
		tournamentNameTextFieldSeven = new JTextField();
		tournamentNameTextFieldSeven.setToolTipText("Enter tournament name here");
		tournamentNameTextFieldSeven.setBounds(125, 75, 150, 28);
		panEdit.add(tournamentNameTextFieldSeven);
		tournamentNameTextFieldSeven.setColumns(10);
		
		nameMaxCharactersLabelSeven = new JLabel("(max. 20 characters)");
		nameMaxCharactersLabelSeven.setForeground(Color.RED);
		nameMaxCharactersLabelSeven.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		nameMaxCharactersLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		nameMaxCharactersLabelSeven.setBounds(0, 95, 125, 15);
		panEdit.add(nameMaxCharactersLabelSeven);
		
		tournamentNameLabelSeven = new JLabel("Tournament Name*");
		tournamentNameLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		tournamentNameLabelSeven.setBounds(0, 80, 125, 16);
		panEdit.add(tournamentNameLabelSeven);
		
		tournamentDetailsPageLabelSeven = new JLabel("- Details Edit Page -");
		tournamentDetailsPageLabelSeven.setForeground(Color.GRAY);
		tournamentDetailsPageLabelSeven.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		tournamentDetailsPageLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		tournamentDetailsPageLabelSeven.setBounds(165, 39, 231, 16);
		panEdit.add(tournamentDetailsPageLabelSeven);
		
		titleLabelSeven = new JLabel("Tournament Manager");
		titleLabelSeven.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 20));
		titleLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabelSeven.setForeground(Color.GRAY);
		titleLabelSeven.setBounds(155, 10, 241, 28);
		panEdit.add(titleLabelSeven);
		
		propertyLabelSeven = new JLabel("This program is the property of the British International School of Jeddah Student Council");
		propertyLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		propertyLabelSeven.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 10));
		propertyLabelSeven.setBounds(0, 360, 550, 16);
		panEdit.add(propertyLabelSeven);
		
		backgroundLabelSeven = new JLabel("");
		backgroundLabelSeven.setIcon(new ImageIcon(background));
		backgroundLabelSeven.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundLabelSeven.setBounds(0, 10, 550, 349);
		panEdit.add(backgroundLabelSeven);
		
		
		
		
		// Eighth Panel (panNewPass)
		
		
		
		
		homeButtonEight = new JButton("");
		homeButtonEight.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// reseting text fields
				currPasswordField.setText("");
				newPasswordField.setText("");
				reNewPasswordField.setText("");
				panNewPass.setVisible(false);
				panHome.setVisible(true);
				setContentPane(getPanel2());
			}
		});
		homeButtonEight.setToolTipText("Click to return to the homepage");
		homeButtonEight.setIcon(new ImageIcon(GUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));
		homeButtonEight.setBounds(0, 10, 35, 35);
		panNewPass.add(homeButtonEight);
		
		newPassSubmitButton = new JButton("Submit");
		newPassSubmitButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{	
					int error = 0;
					char [] currPasswordArray = currPasswordField.getPassword();
					String currPassword = new String(currPasswordArray);
					int currPasswordHash;
					if (currPassword.equals(""))
					{
						currPasswordHash = 1;
					}
					else
					{
						currPasswordHash = currPassword.hashCode();
					}
					char [] newPasswordArray = newPasswordField.getPassword();
					String newPassword = new String(newPasswordArray);
					char [] reNewPasswordArray = reNewPasswordField.getPassword();
					String reNewPassword = new String(reNewPasswordArray);
					// passing the entered password to the getPassword method in the
					// SQLActions class and obtaining a boolean value (verification)
					// indicating whether or not the entered password matches the
					// password stored in the database
					boolean verification = SQLActions.getPassword(currPasswordHash);
					// checking the state of the boolean variable verification 
					if (verification == false)
					{
						error = 1;
						invalidInputMessage("The inputed current password is invalid!");
					}
					// double entry validation
					else if (!newPassword.equals(reNewPassword))
					{
						error = 1;
						invalidInputMessage("The inputed new passwords do not match!");
					}
					// checking the entered new password is greater than 7 characters
					else if (newPassword.length() <= 8)
					{
						error = 1;
						invalidInputMessage("The inputed new password is too short!\n\nInstructions:\n\n\t\tEnter a new password that is 8 "
								+ "or more and 20 or less characters.");
					}
					// checking the entered new password is shorter than 21 characters
					else if (newPassword.length() >= 20)
					{
						error = 1;
						invalidInputMessage("The inputed new password is too long!\n\nInstructions:\n\n\t\tEnter a new password that is 8 "
								+ "or more and 20 or less characters.");
					}
					// checking whether or not any errors were discovered
					if (error == 0)
					{
						int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the tournament manager password?",
								"Attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (confirmation == JOptionPane.YES_OPTION)
						{
							try
							{
								int newPasswordHash = newPassword.hashCode();
								SQLActions.updatePassword(newPasswordHash);
								javax.swing.JOptionPane.showMessageDialog(null, "The Tournament Manager password has been successfully updated!");
								// reseting text fields
								currPasswordField.setText("");
								newPasswordField.setText("");
								reNewPasswordField.setText("");
								panNewPass.setVisible(false);
								panHome.setVisible(true);
								setContentPane(getPanel2());
							}
							// attempting to catch an SQL error in 
							// updating the password in the database
							catch (SQLException exc)
							{
								javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" + exc +
										"\n\nPlease report error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
							}	
						}
					}
					else
					{
						// reseting text fields
						currPasswordField.setText("");
						newPasswordField.setText("");
						reNewPasswordField.setText("");
					}
				}
				// attempting to catch an SQL error 
				// in verifying the entered password
				catch (SQLException exc)
				{
					javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" + exc +
							"\n\nPlease report error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		newPassSubmitButton.setToolTipText("Click to submit the new password");
		newPassSubmitButton.setBounds(178, 234, 117, 29);
		panNewPass.add(newPassSubmitButton);
		
		clearPassButton = new JButton("Clear Password");
		clearPassButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					try
					{
						int error = 0;
						char [] currPasswordArray = currPasswordField.getPassword();
						String currPassword = new String(currPasswordArray);
						int currPasswordHash;
						if (currPassword.equals(""))
						{
							currPasswordHash = 1;
						}
						else
						{
							currPasswordHash = currPassword.hashCode();
						}
						// passing the entered password to the getPassword method in the
						// SQLActions class and obtaining a boolean value (verification)
						// indicating whether or not the entered password matches the
						// password stored in the database
						boolean verification = SQLActions.getPassword(currPasswordHash);
						// checking the state of the boolean variable verification 
						if (verification == false)
						{
							error = 1;
							invalidInputMessage("The inputed current password is invalid!\n\nInstructions:\n\n\t\tEnter the valid current password and "
									+ "re-click the Clear Password button.");
						}
						// checking whether or not a password is stored in the database
						else if ((verification = SQLActions.getPassword(1)) == true)
						{
							error = 1;
							JOptionPane.showMessageDialog(null, "The Tournament Manager is currently not password protected.", "Attention!",
									JOptionPane.QUESTION_MESSAGE);
						}
						else
						{
							int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear the current password?\nDoing so will reduce the "
									+ "Tournament Manager's security.", "Attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (option == JOptionPane.NO_OPTION)
							{
								error = 1;
							}
						}
						if (error == 0)
						{
							try
							{
								SQLActions.updatePassword(1);
								javax.swing.JOptionPane.showMessageDialog(null, "The Tournament Manager password has been successfully cleared!");
								// reseting text fields
								currPasswordField.setText("");
								newPasswordField.setText("");
								reNewPasswordField.setText("");
								panNewPass.setVisible(false);
								panHome.setVisible(true);
								setContentPane(getPanel2());
							}
							// attempting to catch an SQL error in 
							// clearing the password in the database
							catch (SQLException exc)
							{
								javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" + exc +
										"\n\nPlease report error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
							}	
						}
						else
						{
							// reseting text fields
							currPasswordField.setText("");
							newPasswordField.setText("");
							reNewPasswordField.setText("");
						}
					}
					// attempting to catch an SQL error 
					// in verifying the entered password
					catch (SQLException exc)
					{
						javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" + exc +
								"\n\nPlease report error to: gasim97@gmail.com", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch (NullPointerException exc)
				{
				}
			}
		});
		clearPassButton.setToolTipText("Click to clear the current password");
		clearPassButton.setBounds(168, 263, 137, 29);
		panNewPass.add(clearPassButton);
		
		newPasswordMaxMinLabel = new JLabel("(min. 8 and max. 20 characters)");
		newPasswordMaxMinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newPasswordMaxMinLabel.setForeground(Color.RED);
		newPasswordMaxMinLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		newPasswordMaxMinLabel.setBounds(0, 175, 155, 15);
		panNewPass.add(newPasswordMaxMinLabel);
		
		reNewPasswordField = new JPasswordField();
		reNewPasswordField.setToolTipText("Re-enter the new password here");
		reNewPasswordField.setBounds(160, 195, 150, 28);
		panNewPass.add(reNewPasswordField);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setToolTipText("Enter a new password here");
		newPasswordField.setBounds(160, 155, 150, 28);
		panNewPass.add(newPasswordField);
		
		currPasswordField = new JPasswordField();
		currPasswordField.setToolTipText("Enter the current password here");
		currPasswordField.setBounds(160, 115, 150, 28);
		panNewPass.add(currPasswordField);
		
		reNewPasswordLabel = new JLabel("Re-enter new password");
		reNewPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reNewPasswordLabel.setBounds(0, 201, 155, 16);
		panNewPass.add(reNewPasswordLabel);
		
		newPasswordLabel = new JLabel("New password");
		newPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newPasswordLabel.setBounds(0, 161, 155, 16);
		panNewPass.add(newPasswordLabel);
		
		currPasswordLabel = new JLabel("Current password*");
		currPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		currPasswordLabel.setBounds(0, 121, 155, 16);
		panNewPass.add(currPasswordLabel);
		
		passwordPanelLabel = new JLabel("- Password -");
		passwordPanelLabel.setForeground(Color.GRAY);
		passwordPanelLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		passwordPanelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordPanelLabel.setBounds(165, 39, 231, 16);
		panNewPass.add(passwordPanelLabel);
		
		titleLabelEight = new JLabel("Tournament Manager");
		titleLabelEight.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 20));
		titleLabelEight.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabelEight.setForeground(Color.GRAY);
		titleLabelEight.setBounds(155, 10, 241, 28);
		panNewPass.add(titleLabelEight);
		
		propertyLabelEight = new JLabel("This program is the property of the British International School of Jeddah Student Council");
		propertyLabelEight.setHorizontalAlignment(SwingConstants.CENTER);
		propertyLabelEight.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 10));
		propertyLabelEight.setBounds(0, 360, 550, 16);
		panNewPass.add(propertyLabelEight);
		
		backgroundLabelEight = new JLabel("");
		backgroundLabelEight.setIcon(new ImageIcon(background));
		backgroundLabelEight.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundLabelEight.setBounds(0, 10, 550, 349);
		panNewPass.add(backgroundLabelEight);
		
		setMainButton(passwordSubmitButton);
		
		
		
		
		// Ninth Panel (panScore)
		
		
		
		
		homeButtonNine = new JButton("");
		homeButtonNine.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				teamOne.removeAllItems();
				teamTwo.removeAllItems();
				teamOneScoreTextField.setText("");
				teamTwoScoreTextField.setText("");
				panScore.setVisible(false);
				panHome.setVisible(true);
				setContentPane(getPanel2());
			}
		});
		homeButtonNine.setToolTipText("Click to return to the homepage");
		homeButtonNine.setIcon(new ImageIcon(GUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));
		homeButtonNine.setBounds(0, 10, 35, 35);
		panScore.add(homeButtonNine);
		
		backButtonNine = new JButton("");
		backButtonNine.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				teamOne.removeAllItems();
				teamTwo.removeAllItems();
				teamOneScoreTextField.setText("");
				teamTwoScoreTextField.setText("");
				scheduleScrollPane = tournament.getScheduleScrollPane();
				panSched.add(scheduleScrollPane);
				panScore.setVisible(false);
				panSched.setVisible(true);
				setContentPane(getPanel6());
			}
		});
		backButtonNine.setToolTipText("Click to return to the previous page");
		backButtonNine.setIcon(new ImageIcon(backspace));
		backButtonNine.setBounds(35, 10, 35, 35);
		panScore.add(backButtonNine);
		
		scoreSubmitButton = new JButton("Submit Score");
		scoreSubmitButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int error = 0;
				// error checking
				if (teamOne.getSelectedIndex() == 0 || teamTwo.getSelectedIndex() == 0)
				{
					error = 1;
					invalidInputMessage("Please select two teams from the drop-down-lists!");
				}
				else if (teamOne.getSelectedIndex() == teamTwo.getSelectedIndex())
				{
					error = 1;
					invalidInputMessage("Please select two different teams from the drop-down-lists.");
				}
				if (teamOneScoreTextField.getText().equals("") || teamTwoScoreTextField.getText().equals(""))
				{
					error = 1;
					invalidInputMessage("Please enter the match score.");
				}
				if (error == 0)
				{
					int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to update " + tournament.getTournamentName() +
							" points?\nThis action cannot be undone.", "Attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (confirmation == JOptionPane.YES_OPTION)
					{
						// updating points and goal difference
						int teamOneScore = Integer.parseInt(teamOneScoreTextField.getText());
						int teamTwoScore = Integer.parseInt(teamTwoScoreTextField.getText());
						try
						{
							if (teamOneScore == teamTwoScore)
							{
								tournament.tournamentTeams[(teamOne.getSelectedIndex() - 1)].addPoints(1);
								tournament.tournamentTeams[(teamTwo.getSelectedIndex() - 1)].addPoints(1);
							}
							else if (teamOneScore > teamTwoScore)
							{
								tournament.tournamentTeams[(teamOne.getSelectedIndex() - 1)].addPoints(3);
							}
							else
							{
								tournament.tournamentTeams[(teamTwo.getSelectedIndex() - 1)].addPoints(3);
							}
							tournament.tournamentTeams[(teamOne.getSelectedIndex() - 1)].setGoalDifference(teamOneScore - teamTwoScore);
							tournament.tournamentTeams[(teamTwo.getSelectedIndex() - 1)].setGoalDifference(teamTwoScore - teamOneScore);
							try
							{
								SQLActions.updatePoints(tournament);
							}
							catch (SQLException exc)
							{
								javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\n" + exc +
										"\n\nPlease report error to: gasim97@gmail.com", 
										"Error", JOptionPane.ERROR_MESSAGE);
							}
							backButtonNine.doClick();
						}
						catch (NumberFormatException exc)
						{
							javax.swing.JOptionPane.showMessageDialog(null, "Oops! Something seems to have gone wrong!\n\nThe score has "
									+ "not been submitted.\nPlease ensure the inputed data is correct.\n\nThe value in double quotation "
									+ "marks below is invalid!\n" + exc, "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		scoreSubmitButton.setToolTipText("Click to submit the score");
		scoreSubmitButton.setBounds(100, 225, 125, 29);
		panScore.add(scoreSubmitButton);
		
		teamOne = new JComboBox();
		teamOne.setBounds(25, 150, 125, 28);
		teamOne.addActionListener(new ActionListener() 
			{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (teamOne.getSelectedIndex() == 0)
				{
					teamOneScoreTextField.setToolTipText("Select a team and enter the score here");
				}
				else
				{
					teamOneScoreTextField.setToolTipText("Enter " + teamOne.getSelectedItem() + "'s score here");
				}
			}
		});
		panScore.add(teamOne);
		
		teamTwo = new JComboBox();
		teamTwo.setBounds(175, 150, 125, 28);
		teamTwo.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (teamTwo.getSelectedIndex() == 0)
				{
					teamTwoScoreTextField.setToolTipText("Select a team and enter the score here");
				}
				else
				{
					teamTwoScoreTextField.setToolTipText("Enter " + teamTwo.getSelectedItem() + "'s score here");
				}
			}
		});
		panScore.add(teamTwo);
		
		versusLabel = new JLabel("vs.");
		versusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		versusLabel.setBounds(150, 150, 25, 28);
		panScore.add(versusLabel);
		
		scoreSeperatorLabel = new JLabel("-");
		scoreSeperatorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreSeperatorLabel.setBounds(150, 180, 25, 28);
		panScore.add(scoreSeperatorLabel);
		
		teamOneScoreTextField = new JTextField();
		teamOneScoreTextField.setHorizontalAlignment(SwingConstants.CENTER);
		teamOneScoreTextField.setBounds(63, 180, 50, 28);
		panScore.add(teamOneScoreTextField);
		teamOneScoreTextField.setColumns(10);
		
		teamTwoScoreTextField = new JTextField();
		teamTwoScoreTextField.setHorizontalAlignment(SwingConstants.CENTER);
		teamTwoScoreTextField.setBounds(213, 180, 50, 28);
		panScore.add(teamTwoScoreTextField);
		teamTwoScoreTextField.setColumns(10);
		
		scorePanelLabel = new JLabel("- Score Update -");
		scorePanelLabel.setForeground(Color.GRAY);
		scorePanelLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
		scorePanelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scorePanelLabel.setBounds(165, 39, 231, 16);
		panScore.add(scorePanelLabel);
		
		titleLabelNine = new JLabel("Tournament Manager");
		titleLabelNine.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 20));
		titleLabelNine.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabelNine.setForeground(Color.GRAY);
		titleLabelNine.setBounds(155, 10, 241, 28);
		panScore.add(titleLabelNine);
		
		propertyLabelNine = new JLabel("This program is the property of the British International School of Jeddah Student Council");
		propertyLabelNine.setHorizontalAlignment(SwingConstants.CENTER);
		propertyLabelNine.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 10));
		propertyLabelNine.setBounds(0, 360, 550, 16);
		panScore.add(propertyLabelNine);
		
		backgroundLabelNine = new JLabel("");
		backgroundLabelNine.setIcon(new ImageIcon(background));
		backgroundLabelNine.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundLabelNine.setBounds(0, 10, 550, 349);
		panScore.add(backgroundLabelNine);
	}
	
	// container accessor methods
	
	private Container getPanel1()
	{
		return panPassword; // Password Entry Panel
	}
	
	private Container getPanel2()
	{
		return panHome; // Homepage Panel
	}
	
	private Container getPanel3()
	{
		return panSearch; // Tournament Search Panel
	}
	
	private Container getPanel4()
	{
		return panInfoEntry; // New Tournament Panel (i.e. tournament details entry panel)
	}
	
	private Container getPanel5()
	{
		return panCenter; // Tournament Center Panel
	}
	
	private Container getPanel6()
	{
		return panSched; // Tournament Schedule and Points Panel
	}
	
	private Container getPanel7()
	{
		return panEdit; // Details Edit Panel
	}
	
	private Container getPanel8()
	{
		return panNewPass; // New Password Panel
	}
	
	private Container getPanel9()
	{
		return panScore; // Score Input Panel
	}
	
	// invalid input pane template
	private void invalidInputMessage(String message)
	{
		javax.swing.JOptionPane.showMessageDialog(null, message, "Invalid Input", 2);
	}
	
	// method to change the frame's main button as panels are changed
	private void setMainButton(JButton button)
	{
		SwingUtilities.getRootPane(button).setDefaultButton(button);
	}
}