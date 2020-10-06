import java.awt.EventQueue;

//Setting up window
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableCellRenderer;

//Tools to create table and get database data
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TeamApp {

	// Setting up window with table text fields and then tab with all the visible elements

	private static TeamApp window;
	private DefaultTableModel dtm;

	JFrame frmFootballClub;

	// NP - new player tab
	// PL - player's list tab
	// EP - edit player's details (hidden)
	
	JTabbedPane tabbedPane;

	// NP - new player tab
	private JPanel panelAddPlayerNP;
	private JTable tableSearchResults; // table to store search results

	private JButton btnAddPlayerNP;

	private JTextField txtFirstNameNP;
	private JTextField txtLastNameNP;
	private JTextField txtAddressNP;

	private JLabel lblFirstNameNP;
	private JLabel lblLastNameNP;
	private JLabel lblDateOfBirthNP;
	private JLabel lblAddressNP;
	private JLabel lblMaleFemaleNP;
	private JLabel lblStartDateNP;
	private JLabel lblEnterNewPlayersNP;
	
	private JTextField txtAgeNP;
	private JComboBox comboMaleFemaleNP;
	private JComboBox comboDOBDayNP;
	private JComboBox comboDOBYearNP;
	private JComboBox comboDOBMonthNP;
	private JTextField txtAgeFromPL;
	private JLabel lblDOBMonthNP;
	private JLabel lblDOBDayNP;
	private JLabel lblDOBYearNP;
	private JComboBox comboStartMonthNP;
	private JLabel lblStartMonthNP;
	private JLabel lblStartDayNP;
	private JComboBox comboStartDayNP;
	private JLabel lblStartYearNP;
	private JComboBox comboStartYearNP;
	private JButton btnClearFormNP;
	private JButton btnTodayNP;
	
	// variables to add mouse listener to text fields and remove initial text from fields.
		private int txtFieldsCounter = 0;
		private int txtFieldsNumber = 6;
		private JTextField[] txtfields = new JTextField[txtFieldsNumber];

	// PL - player's list tab
	private JPanel panelPlayersListPL;
	
	private JScrollPane scrollPanePL; //table scroll pane

	private JButton btnSearchPL;
	private JButton btnResetFormPL;
	private JTextField txtFirstNamePL;
	private JTextField txtLastNamePL;

	private JLabel lblFirstNamePL;
	private JLabel lblLastNamePl;
	private JLabel lblDateOfBirthPL;
	private JLabel lblAgePL;
	
	private JButton btnEditPlayersDetailsPL;
	private int tableSearchResultsSelectedRow;
	private JTextField txtAgeToPL;
	private JLabel lblAgeFromPL;
	private JLabel lblAgeToPL;
	private JComboBox comboDOBMonthPL;
	private JLabel lblDOBMonthPL;
	private JLabel lblDOBDayPL;
	private JComboBox comboDOBDayPL;
	private JLabel lblDOBYearPL;
	private JComboBox comboDOBYearPL;
	private JLabel lblCountryPL;
	private JTextField txtCountryPL;

	// EP - edit player's details (hidden)
	private JPanel panelEditPlayerEP;
	private JLabel lblEditPlayersEP;
	private JLabel lblFirstNameEP;
	private JLabel lblLastNameEP;
	private JLabel lblDateOfBirthEP;
	private JLabel lblAddressEP;
	private JLabel lblMaleFemaleEP;
	private JLabel lblStartDateEP;
	private JLabel lblAgesEP;
	private JLabel lblDOBMonthEP;
	private JLabel lblDOBDayEP;
	private JLabel lblDOBYearEP;
	private JLabel lblStartMonthEP;
	private JLabel lblStartDayEP;
	private JLabel lblStartYearEP;
	private JTextField txtFirstNameEP;
	private JTextField txtLastNameEP;
	private JComboBox comboDOBMonthEP;
	private JComboBox comboDOBDayEP;
	private JComboBox comboDOBYearEP;
	private JTextField txtAddressEP;
	private JComboBox comboMaleFemaleEP;
	private JComboBox comboStartMonthEP;
	private JComboBox comboStartDayEP;
	private JComboBox comboStartYearEP;
	private JTextField txtAgesEP;
	private JButton btnClearDetailsEP;
	private JButton btnTodayEP;
	private JButton btnUpdateEP;
	private JButton btnRemovePlayerPL;
	private JButton btnCancelEP;
	
	
	//setting up invisible to user global variables
	private int playerID;
	
	// Tools to create table and get database data
	/*
	 * private ResultSet rs; // Results set definition private DefaultTableModel
	 * tablemodel; // Default table model to setup table --> like a template.
	 * private ResultSetMetaData rsMetaData; // This will be getting table columns
	 * names
	 */

	/**
	 * Create the application. Constructor of the class TeamApp
	 */
	public TeamApp() {

		initializeApp(); // call method initialize to set up forms and windows
		activateActionButtons();
		new OperationsOnDB().setupDefaultTable(); //removing existing table and creating new one with default data (see OperationsonDB() class).

		// test method to validate date.
		validateDate(2, 31, 2020);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new TeamApp(); // creating new window, which invokes construction of class TeamApp
					window.frmFootballClub.setVisible(true); // making window visible

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initializeApp() {

		// Initializing the frame with panels and labels
		frmFootballClub = new JFrame();
		frmFootballClub.setTitle("Football club - Player's management system.");
		frmFootballClub.setBackground(Color.WHITE);
		frmFootballClub.setBounds(100, 100, 919, 476);
		frmFootballClub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setForeground(new Color(0, 51, 153));
		tabbedPane.setBackground(new Color(255, 255, 255));
		frmFootballClub.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		/* P L A Y E R S    L I S T */

		// panel
		panelPlayersListPL = new JPanel();
		panelPlayersListPL.setForeground(new Color(255, 255, 255));
		panelPlayersListPL.setBackground(Color.WHITE);
		tabbedPane.addTab("Player's list", null, panelPlayersListPL, null);
		panelPlayersListPL.setLayout(null);

		// table with list of players

		setupDefaultTable();

		tableSearchResults.setShowVerticalLines(false);
		tableSearchResults.setIntercellSpacing(new Dimension(3, 3));
		tableSearchResults.setSelectionForeground(Color.WHITE);
		tableSearchResults.setRowMargin(2);
		tableSearchResults.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		//while item from the table is selected, the edit button is becoming visible to the user.
		ListSelectionModel cellSelectionModel = tableSearchResults.getSelectionModel();
		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnEditPlayersDetailsPL.setVisible(true);
				btnRemovePlayerPL.setVisible(true);
				
			}});
		
		tableSearchResults.setFillsViewportHeight(true);
		tableSearchResults.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableSearchResults.setForeground(new Color(106, 90, 205));
		tableSearchResults.setBorder(new LineBorder(Color.WHITE, 1, true));
		tableSearchResults.setRowHeight(25);
		tableSearchResults.getTableHeader().setBackground(new Color(116, 165, 242));
		tableSearchResults.getTableHeader().setForeground(new Color(255, 255, 255));
		
		/********************************************* Some table tools to use in different project possibly.
		 * tableSearchResults.setModel(new DefaultTableModel( new Object[][] { { null,
		 * "Kathy", "Star", new Integer(6), "Portland", "1/1/2019" }, { null, "John",
		 * "Play", new Integer(10), "Portugal", "1/3/2018" }, { null, null, null, null,
		 * null, null }, { null, null, null, null, null, null }, { null, null, null,
		 * null, null, null }, { null, null, null, null, null, null }, }, new String[] {
		 * "Select", "First Name", "Last Name", "Age", "Address", "Start date" }) {
		 * Class[] columnTypes = new Class[] { Boolean.class, Object.class,
		 * Object.class, Object.class, Object.class, Object.class };
		 * 
		 * public Class getColumnClass(int columnIndex) { return
		 * columnTypes[columnIndex]; } });
		 * tableSearchResults.getColumnModel().getColumn(0).setResizable(false);
		 * tableSearchResults.getColumnModel().getColumn(0).setPreferredWidth(30);
		 * tableSearchResults.getColumnModel().getColumn(1).setResizable(false);
		 * tableSearchResults.getColumnModel().getColumn(2).setResizable(false);
		 * tableSearchResults.getColumnModel().getColumn(3).setResizable(false);
		 * tableSearchResults.getColumnModel().getColumn(4).setResizable(false);
		 * tableSearchResults.getColumnModel().getColumn(5).setResizable(false);
		 ************************************************/
		
		
		// Getting row # of the selected item
		tableSearchResults.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			tableSearchResultsSelectedRow = tableSearchResults.getSelectedRow();
			}
		});

		
		// scrollPanePL.setViewportView(tableSearchResults);//DELETE THIS LATER?

		// scroll pane and table
		scrollPanePL = new JScrollPane(tableSearchResults);
		scrollPanePL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPanePL.setForeground(SystemColor.activeCaption);
		scrollPanePL.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPanePL.setBackground(Color.WHITE);
		scrollPanePL.setEnabled(false);
		scrollPanePL.setBorder(BorderFactory.createEmptyBorder());
		scrollPanePL.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanePL.setBounds(10, 81, 863, 317);
		panelPlayersListPL.add(scrollPanePL);

		// labels
		lblFirstNamePL = new JLabel("First Name");
		lblFirstNamePL.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstNamePL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstNamePL.setBounds(10, 10, 72, 19);
		panelPlayersListPL.add(lblFirstNamePL);

		lblLastNamePl = new JLabel("Last Name");
		lblLastNamePl.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastNamePl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastNamePl.setBounds(10, 35, 72, 19);
		panelPlayersListPL.add(lblLastNamePl);

		lblDateOfBirthPL = new JLabel("Date of Birth");
		lblDateOfBirthPL.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateOfBirthPL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateOfBirthPL.setBounds(163, 57, 88, 22);
		panelPlayersListPL.add(lblDateOfBirthPL);

		lblAgePL = new JLabel("Age");
		lblAgePL.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgePL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgePL.setBounds(163, 10, 88, 22);
		panelPlayersListPL.add(lblAgePL);

		txtFirstNamePL = new JTextField();
		txtFirstNamePL.setColumns(10);
		txtFirstNamePL.setBounds(81, 8, 72, 20);
		panelPlayersListPL.add(txtFirstNamePL);

		txtLastNamePL = new JTextField();
		txtLastNamePL.setColumns(10);
		txtLastNamePL.setBounds(81, 34, 72, 20);
		panelPlayersListPL.add(txtLastNamePL);

		// buttons
		btnSearchPL = new JButton("Search"); // to search of data in the database and display in the table of results
		btnSearchPL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearchPL.setForeground(SystemColor.text);
		btnSearchPL.setBackground(SystemColor.inactiveCaption);
		btnSearchPL.setBounds(428, 33, 100, 20);
		panelPlayersListPL.add(btnSearchPL); // button action in the section below - activateActionButtons() function.

		btnResetFormPL = new JButton("Reset form"); // To reset the data in the form to the default//action for this button is set in the activateActionButtons() function.
		btnResetFormPL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnResetFormPL.setForeground(SystemColor.text);
		btnResetFormPL.setBackground(SystemColor.inactiveCaption);
		btnResetFormPL.setBounds(428, 7, 100, 20);
		panelPlayersListPL.add(btnResetFormPL);

		lblAgeFromPL = new JLabel("From");
		lblAgeFromPL.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeFromPL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAgeFromPL.setBounds(248, 12, 40, 15);
		panelPlayersListPL.add(lblAgeFromPL);

		txtAgeFromPL = new JTextField();
		txtAgeFromPL.setColumns(10);
		txtAgeFromPL.setBounds(290, 10, 40, 20);
		panelPlayersListPL.add(txtAgeFromPL);

		lblAgeToPL = new JLabel("To");
		lblAgeToPL.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeToPL.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAgeToPL.setBounds(333, 10, 25, 18);
		panelPlayersListPL.add(lblAgeToPL);

		txtAgeToPL = new JTextField();
		txtAgeToPL.setColumns(10);
		txtAgeToPL.setBounds(360, 10, 40, 20);
		panelPlayersListPL.add(txtAgeToPL);

		lblDOBMonthPL = new JLabel("Month");
		lblDOBMonthPL.setHorizontalAlignment(SwingConstants.CENTER);
		lblDOBMonthPL.setBounds(250, 40, 40, 14);
		panelPlayersListPL.add(lblDOBMonthPL);

		comboDOBMonthPL = new JComboBox();
		comboDOBMonthPL.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		comboDOBMonthPL.setBackground(new Color(255, 255, 255));
		comboDOBMonthPL.setForeground(new Color(153, 153, 153));
		comboDOBMonthPL.setModel(new DefaultComboBoxModel(new Integer[] { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }));
		//add this to the array month
		comboDOBMonthPL.setName("");
		comboDOBMonthPL.setBounds(250, 54, 40, 25);
		panelPlayersListPL.add(comboDOBMonthPL);

		lblDOBDayPL = new JLabel("Day");
		lblDOBDayPL.setHorizontalAlignment(SwingConstants.CENTER);
		lblDOBDayPL.setBounds(295, 40, 40, 14);
		panelPlayersListPL.add(lblDOBDayPL);

		comboDOBDayPL = new JComboBox();
		comboDOBDayPL.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		//add this to the array day
		comboDOBDayPL.setBounds(295, 54, 40, 25);
		panelPlayersListPL.add(comboDOBDayPL);

		lblDOBYearPL = new JLabel("Year");
		lblDOBYearPL.setHorizontalAlignment(SwingConstants.CENTER);
		lblDOBYearPL.setBounds(340, 40, 60, 14);
		panelPlayersListPL.add(lblDOBYearPL);

		comboDOBYearPL = new JComboBox();
		comboDOBYearPL.setBounds(340, 54, 60, 25);

		// Array list to create calendar array for the combo box.
		//Creating array of the years, to use in all the other instances of the year selection.
		//Maybe move this somewhere else? as this is a little more global and used in other functions.
		
		ArrayList<Integer> years_tmp = new ArrayList<Integer>();
		years_tmp.add(null);
		for (int years = Calendar.getInstance().get(Calendar.YEAR); years >= 1980; years--) {
			years_tmp.add(years);
		}
		// END - Array list to create calendar array for the combo box.

		comboDOBYearPL.setModel(new DefaultComboBoxModel(years_tmp.toArray()));
		panelPlayersListPL.add(comboDOBYearPL);

		lblCountryPL = new JLabel("Country");
		lblCountryPL.setHorizontalAlignment(SwingConstants.LEFT);
		lblCountryPL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCountryPL.setBounds(10, 61, 72, 18);
		panelPlayersListPL.add(lblCountryPL);

		txtCountryPL = new JTextField();
		txtCountryPL.setColumns(10);
		txtCountryPL.setBounds(81, 59, 72, 20);
		panelPlayersListPL.add(txtCountryPL);
		
		btnEditPlayersDetailsPL = new JButton("Edit");
		btnEditPlayersDetailsPL.setToolTipText("Select one entry to edit it");
		btnEditPlayersDetailsPL.setForeground(Color.WHITE);
		btnEditPlayersDetailsPL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEditPlayersDetailsPL.setBackground(SystemColor.inactiveCaption);
		btnEditPlayersDetailsPL.setBounds(428, 59, 100, 20);
		btnEditPlayersDetailsPL.setVisible(false);
		panelPlayersListPL.add(btnEditPlayersDetailsPL);
		
		btnRemovePlayerPL = new JButton("Remove");
		btnRemovePlayerPL.setVisible(false);
		btnRemovePlayerPL.setForeground(Color.WHITE);
		btnRemovePlayerPL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemovePlayerPL.setBackground(SystemColor.inactiveCaption);
		btnRemovePlayerPL.setBounds(538, 59, 100, 20);
		panelPlayersListPL.add(btnRemovePlayerPL);
		
		
		/* A D D   N E W   P L A Y E R */

		// panel new player
		panelAddPlayerNP = new JPanel();
		panelAddPlayerNP.setName("");
		panelAddPlayerNP.setBackground(Color.WHITE);
		tabbedPane.addTab("New Player", null, panelAddPlayerNP, null);
		panelAddPlayerNP.setLayout(null);

		// labels

		lblEnterNewPlayersNP = new JLabel("Enter New Player's details below:");
		lblEnterNewPlayersNP.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEnterNewPlayersNP.setBounds(10, 11, 364, 23);
		lblEnterNewPlayersNP.setHorizontalAlignment(SwingConstants.CENTER);
		panelAddPlayerNP.add(lblEnterNewPlayersNP);

		lblFirstNameNP = new JLabel("First Name");
		lblFirstNameNP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFirstNameNP.setBounds(10, 45, 82, 14);
		panelAddPlayerNP.add(lblFirstNameNP);

		lblLastNameNP = new JLabel("Last Name");
		lblLastNameNP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastNameNP.setBounds(10, 78, 82, 17);
		panelAddPlayerNP.add(lblLastNameNP);

		lblDateOfBirthNP = new JLabel("Date of birth");
		lblDateOfBirthNP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfBirthNP.setBounds(10, 131, 82, 14);
		panelAddPlayerNP.add(lblDateOfBirthNP);

		lblAddressNP = new JLabel("Address");
		lblAddressNP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddressNP.setBounds(10, 162, 82, 14);
		lblAddressNP.getPreferredSize();
		panelAddPlayerNP.add(lblAddressNP);

		lblMaleFemaleNP = new JLabel("Male/Female");
		lblMaleFemaleNP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaleFemaleNP.setBounds(10, 193, 82, 14);
		panelAddPlayerNP.add(lblMaleFemaleNP);

		lblStartDateNP = new JLabel("Start Date");
		lblStartDateNP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStartDateNP.setBounds(10, 243, 82, 14);
		panelAddPlayerNP.add(lblStartDateNP);

		JLabel lblAgesNp = new JLabel("Age");
		lblAgesNp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAgesNp.setBounds(10, 278, 82, 14);
		panelAddPlayerNP.add(lblAgesNp);

		lblDOBMonthNP = new JLabel("Month");
		lblDOBMonthNP.setHorizontalAlignment(SwingConstants.CENTER);
		lblDOBMonthNP.setBounds(100, 112, 40, 14);
		panelAddPlayerNP.add(lblDOBMonthNP);

		lblDOBDayNP = new JLabel("Day");
		lblDOBDayNP.setHorizontalAlignment(SwingConstants.CENTER);
		lblDOBDayNP.setBounds(145, 112, 40, 14);
		panelAddPlayerNP.add(lblDOBDayNP);

		lblDOBYearNP = new JLabel("Year");
		lblDOBYearNP.setHorizontalAlignment(SwingConstants.CENTER);
		lblDOBYearNP.setBounds(190, 112, 60, 14);
		panelAddPlayerNP.add(lblDOBYearNP);

		lblStartMonthNP = new JLabel("Month");
		lblStartMonthNP.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartMonthNP.setBounds(100, 224, 40, 14);
		panelAddPlayerNP.add(lblStartMonthNP);

		lblStartDayNP = new JLabel("Day");
		lblStartDayNP.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartDayNP.setBounds(145, 224, 40, 14);
		panelAddPlayerNP.add(lblStartDayNP);

		lblStartYearNP = new JLabel("Year");
		lblStartYearNP.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartYearNP.setBounds(190, 224, 60, 14);
		panelAddPlayerNP.add(lblStartYearNP);

		txtFirstNameNP = new JTextField();
		txtFirstNameNP.setBounds(100, 45, 150, 20);
		panelAddPlayerNP.add(txtFirstNameNP);
		txtFirstNameNP.setColumns(10);

		txtLastNameNP = new JTextField();
		txtLastNameNP.setColumns(10);
		txtLastNameNP.setBounds(100, 79, 150, 20);
		panelAddPlayerNP.add(txtLastNameNP);

		comboDOBMonthNP = new JComboBox();
		comboDOBMonthNP
				.setModel(new DefaultComboBoxModel(new Integer[] { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }));
		comboDOBMonthNP.setBounds(100, 126, 40, 25);
		panelAddPlayerNP.add(comboDOBMonthNP);
		
		//add this to some global variable month

		comboDOBDayNP = new JComboBox();
		comboDOBDayNP.setModel(new DefaultComboBoxModel(new Integer[] { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
				14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 }));
		// add this to some global variable day of the month.
		comboDOBDayNP.setBounds(145, 126, 40, 25);
		panelAddPlayerNP.add(comboDOBDayNP);

		comboDOBYearNP = new JComboBox();
		comboDOBYearNP.setModel(new DefaultComboBoxModel(years_tmp.toArray()));
		comboDOBYearNP.setBounds(190, 126, 60, 25);

		panelAddPlayerNP.add(comboDOBYearNP);

		txtAddressNP = new JTextField();
		txtAddressNP.setColumns(10);
		txtAddressNP.setBounds(100, 162, 150, 20);
		panelAddPlayerNP.add(txtAddressNP);

		comboMaleFemaleNP = new JComboBox();
		comboMaleFemaleNP.setModel(new DefaultComboBoxModel(new String[] { "", "Male", "Female" }));
		comboMaleFemaleNP.setBounds(102, 190, 148, 25);
		panelAddPlayerNP.add(comboMaleFemaleNP);

		comboStartMonthNP = new JComboBox();
		comboStartMonthNP.setModel(new DefaultComboBoxModel(
				new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		//add this to some global variable month
		comboStartMonthNP.setName("");
		comboStartMonthNP.setBounds(100, 238, 40, 25);
		panelAddPlayerNP.add(comboStartMonthNP);

		comboStartDayNP = new JComboBox();
		comboStartDayNP.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
				"26", "27", "28", "29", "30", "31" }));
		// add this to some global variable day of the month.
		comboStartDayNP.setBounds(145, 238, 40, 25);
		panelAddPlayerNP.add(comboStartDayNP);

		comboStartYearNP = new JComboBox();
		comboStartYearNP.setBounds(190, 238, 60, 25);

		comboStartYearNP.setModel(new DefaultComboBoxModel(years_tmp.toArray()));
		panelAddPlayerNP.add(comboStartYearNP);

		txtAgeNP = new JTextField();
		txtAgeNP.setBounds(100, 272, 150, 20);
		panelAddPlayerNP.add(txtAgeNP);
		txtAgeNP.setColumns(10);

		btnClearFormNP = new JButton("Clear Form");	// resetting all data in the form and clear table of results //action for this button is in activateActionButtons(). 
		btnClearFormNP.setBounds(255, 44, 97, 23);
		panelAddPlayerNP.add(btnClearFormNP);

		btnTodayNP = new JButton("Today");
		btnTodayNP.setBounds(255, 239, 97, 23);
		panelAddPlayerNP.add(btnTodayNP); // today's date for new players start date //action is in the activateActionButtons() function.
		
		// buttons
		btnAddPlayerNP = new JButton("Add Player");
		btnAddPlayerNP.setBounds(100, 303, 140, 23);
		btnAddPlayerNP.setForeground(SystemColor.text);
		btnAddPlayerNP.setBackground(SystemColor.inactiveCaption);
		panelAddPlayerNP.add(btnAddPlayerNP); //adding new player to the database //action is in activateActionButtons() function.
		
		
		/* E D I T    P L A Y E R */
		
		panelEditPlayerEP = new JPanel();
		panelEditPlayerEP.setToolTipText("Select Player from Player's list to activate this tab.");
		panelEditPlayerEP.setLayout(null);
		panelEditPlayerEP.setName("");
		panelEditPlayerEP.setBackground(Color.WHITE);
		tabbedPane.addTab("Edit Player", null, panelEditPlayerEP, null);
		tabbedPane.setEnabledAt(2, false);//panelEditPlayerEP.setVisible(false);
		
		//labels
		
		lblEditPlayersEP = new JLabel("Edit Player's details:");
		lblEditPlayersEP.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditPlayersEP.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEditPlayersEP.setBounds(10, 11, 364, 23);
		panelEditPlayerEP.add(lblEditPlayersEP);
		
		lblFirstNameEP = new JLabel("First Name");
		lblFirstNameEP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFirstNameEP.setBounds(10, 45, 82, 14);
		panelEditPlayerEP.add(lblFirstNameEP);
		
		lblLastNameEP = new JLabel("Last Name");
		lblLastNameEP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastNameEP.setBounds(10, 78, 82, 17);
		panelEditPlayerEP.add(lblLastNameEP);
		
		lblDateOfBirthEP = new JLabel("Date of birth");
		lblDateOfBirthEP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfBirthEP.setBounds(10, 131, 82, 14);
		panelEditPlayerEP.add(lblDateOfBirthEP);
		
		lblAddressEP = new JLabel("Address");
		lblAddressEP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddressEP.setBounds(10, 162, 82, 14);
		panelEditPlayerEP.add(lblAddressEP);
		
		lblMaleFemaleEP = new JLabel("Male/Female");
		lblMaleFemaleEP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaleFemaleEP.setBounds(10, 193, 82, 14);
		panelEditPlayerEP.add(lblMaleFemaleEP);
		
		lblStartDateEP = new JLabel("Start Date");
		lblStartDateEP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStartDateEP.setBounds(10, 243, 82, 14);
		panelEditPlayerEP.add(lblStartDateEP);
		
		lblAgesEP = new JLabel("Age");
		lblAgesEP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAgesEP.setBounds(10, 278, 82, 14);
		panelEditPlayerEP.add(lblAgesEP);
		
		lblDOBMonthEP = new JLabel("Month");
		lblDOBMonthEP.setHorizontalAlignment(SwingConstants.CENTER);
		lblDOBMonthEP.setBounds(100, 112, 40, 14);
		panelEditPlayerEP.add(lblDOBMonthEP);
		
		lblDOBDayEP = new JLabel("Day");
		lblDOBDayEP.setHorizontalAlignment(SwingConstants.CENTER);
		lblDOBDayEP.setBounds(145, 112, 40, 14);
		panelEditPlayerEP.add(lblDOBDayEP);
		
		lblDOBYearEP = new JLabel("Year");
		lblDOBYearEP.setHorizontalAlignment(SwingConstants.CENTER);
		lblDOBYearEP.setBounds(190, 112, 60, 14);
		panelEditPlayerEP.add(lblDOBYearEP);
		
		lblStartMonthEP = new JLabel("Month");
		lblStartMonthEP.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartMonthEP.setBounds(100, 224, 40, 14);
		panelEditPlayerEP.add(lblStartMonthEP);
		
		lblStartDayEP = new JLabel("Day");
		lblStartDayEP.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartDayEP.setBounds(145, 224, 40, 14);
		panelEditPlayerEP.add(lblStartDayEP);
		
		lblStartYearEP = new JLabel("Year");
		lblStartYearEP.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartYearEP.setBounds(190, 224, 60, 14);
		panelEditPlayerEP.add(lblStartYearEP);
		
		txtFirstNameEP = new JTextField();
		txtFirstNameEP.setColumns(10);
		txtFirstNameEP.setBounds(100, 45, 150, 20);
		panelEditPlayerEP.add(txtFirstNameEP);
		
		txtLastNameEP = new JTextField();
		txtLastNameEP.setColumns(10);
		txtLastNameEP.setBounds(100, 79, 150, 20);
		panelEditPlayerEP.add(txtLastNameEP);
		
		comboDOBMonthEP = new JComboBox();
		comboDOBMonthEP.setModel(new DefaultComboBoxModel(new Integer[] { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }));
		comboDOBMonthEP.setBounds(100, 126, 40, 25);
		panelEditPlayerEP.add(comboDOBMonthEP);
		//add this to the variable month.
		
		comboDOBDayEP = new JComboBox();
		comboDOBDayEP.setModel(new DefaultComboBoxModel(new Integer[] { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
				14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 }));
		//add this to the variable day of the month.
		comboDOBDayEP.setBounds(145, 126, 40, 25);
		panelEditPlayerEP.add(comboDOBDayEP);
		
		comboDOBYearEP = new JComboBox();
		comboDOBYearEP.setModel(new DefaultComboBoxModel(years_tmp.toArray()));
		comboDOBYearEP.setBounds(190, 126, 60, 25);
		panelEditPlayerEP.add(comboDOBYearEP);
		
		comboMaleFemaleEP = new JComboBox();
		comboMaleFemaleEP.setModel(new DefaultComboBoxModel(new String[] { "", "Male", "Female" }));
		//global variable?
		comboMaleFemaleEP.setBounds(102, 190, 148, 25);
		panelEditPlayerEP.add(comboMaleFemaleEP);
		
		txtAddressEP = new JTextField();
		txtAddressEP.setColumns(10);
		txtAddressEP.setBounds(100, 162, 150, 20);
		panelEditPlayerEP.add(txtAddressEP);
		
		comboStartMonthEP = new JComboBox();
		comboStartMonthEP.setModel(new DefaultComboBoxModel(new Integer[] { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }));
		//add this to the variable month.
		comboStartMonthEP.setName("");
		comboStartMonthEP.setBounds(100, 238, 40, 25);
		panelEditPlayerEP.add(comboStartMonthEP);
		
		comboStartDayEP = new JComboBox();
		comboStartDayEP.setModel(new DefaultComboBoxModel(new Integer[] { null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
				14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 }));
		//add this to the variable day of the month.
		comboStartDayEP.setBounds(145, 238, 40, 25);
		panelEditPlayerEP.add(comboStartDayEP);
		
		comboStartYearEP = new JComboBox();
		comboStartYearEP.setModel(new DefaultComboBoxModel(years_tmp.toArray()));
		comboStartYearEP.setBounds(190, 238, 60, 25);
		panelEditPlayerEP.add(comboStartYearEP);
		
		txtAgesEP = new JTextField();
		txtAgesEP.setToolTipText("Age is calculated from DOB.");
		txtAgesEP.setEditable(false);
		txtAgesEP.setColumns(10);
		txtAgesEP.setBounds(100, 272, 150, 20);
		panelEditPlayerEP.add(txtAgesEP);
		
		btnClearDetailsEP = new JButton("Clear Details");// resetting all data in the form and clear table of results // action is defined in activateActionButtons() function.
		btnClearDetailsEP.setBounds(255, 44, 119, 23);
		panelEditPlayerEP.add(btnClearDetailsEP);
		
		btnTodayEP = new JButton("Today");
		btnTodayEP.setBounds(255, 239, 97, 23);
		panelEditPlayerEP.add(btnTodayEP); //Action for this button is in ativateActionButtons() function.
		
		btnUpdateEP = new JButton("Update");		
		btnUpdateEP.setForeground(Color.WHITE);
		btnUpdateEP.setBackground(SystemColor.inactiveCaption);
		btnUpdateEP.setBounds(100, 303, 82, 23);
		panelEditPlayerEP.add(btnUpdateEP);//Updating the database //Action for this button is in ativateActionButtons() function.
		
		btnCancelEP = new JButton("Cancel");
		btnCancelEP.setForeground(Color.WHITE);
		btnCancelEP.setBackground(SystemColor.inactiveCaption);
		btnCancelEP.setBounds(192, 303, 82, 23);
		panelEditPlayerEP.add(btnCancelEP);//Cancelling, no changes //Action for this button is in ativateActionButtons() function.

	}

	private void setupDefaultTable() {

		/*
		 * This is to create table with default data, but I did not want it. I prefer to
		 * have empty table to start with. String[] columnNames = { "First Name",
		 * "Last Name", "Date Of Birth", "Country" }; Object[][] data = { {
		 * "-------------", "-------------","-------------","-------------",
		 * "-------------"}, { "-------------",
		 * "-------------","-------------","-------------", "-------------"} };
		 * 
		 * tableSearchResults = new JTable(data, columnNames);
		 */

		// setting empty data model and table before user searches for data.
		dtm = new DefaultTableModel();
		tableSearchResults = new JTable();
		tableSearchResults.setSelectionBackground(new Color(153, 204, 255));
		tableSearchResults.setModel(dtm);
		
				
	}

	/***
	 *** add action to buttons and activate their functionality
	 ***/
	
	private void activateActionButtons() {

		//***************** PLAYER'S LIST TAB **********************//
	
		//************* searching for data in the database

		btnSearchPL.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {

		// selecting data from database
		OperationsOnDB selection1 = new OperationsOnDB();

		// checking if filter is set in first name, if not doing the default query,
		// otherwise use value form the field.

		if (txtFirstNamePL.getText().equals("") & txtLastNamePL.getText().equals("") & txtCountryPL.getText().equals("") & txtAgeFromPL.equals("")& txtAgeToPL.equals("") & comboDOBYearNP.getSelectedItem() == null) {

		System.out.println("No name selected, running default query to get all rows.\n");

		selection1.selectDataFromDB();
		dtm = selection1.getTableModel();

		if (dtm == null) {
		System.out.println("try again, empty data model");
			} 
		
		else {
				System.out.println("No of columns: " + dtm.getColumnCount() + ", rows number: " + dtm.getRowCount());
			}

		// ---------------applying table model to the table and proper formatting

		tableSearchResults.setModel(dtm);

		DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
		tableRenderer.setHorizontalAlignment(JLabel.CENTER); // Aligning the table data centrally.
		tableSearchResults.setDefaultRenderer(Object.class, tableRenderer);

		}

		else {
			System.out.println("Looking for players with name: " + txtFirstNamePL.getText() + "\n");
			
			int age_from = 0;
			int age_to = 100;
			if(txtAgeFromPL.getText().equals("")== false){age_from = Integer.valueOf(txtAgeFromPL.getText());};
			if(txtAgeToPL.getText().equals("") == false){age_to = Integer.valueOf(txtAgeToPL.getText());};
			

			selection1.selectFilteredDataFromDB(txtFirstNamePL.getText(), txtLastNamePL.getText(), txtCountryPL.getText(), age_from, age_to);

			dtm = selection1.getTableModel();

		
		if (dtm == null) {
			System.out.println("try again, empty data model");
		}
		
		else {
			System.out.println("No of columns: " + dtm.getColumnCount() + ", rows number: " + dtm.getRowCount());
				}

		// ---------------applying table model to the table and proper formatting

		tableSearchResults.setModel(dtm);

		DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
		tableRenderer.setHorizontalAlignment(JLabel.CENTER); // Aligning the table data centrally.
		tableSearchResults.setDefaultRenderer(Object.class, tableRenderer);

		}

		}
		});
		
	//************** resetting all data in the form and clear table of results
		btnResetFormPL.addActionListener(new ActionListener() {

		// function to clear data from the boxes and to clean the table from data.
		public void actionPerformed(ActionEvent e) {
						
		// removing text from all text boxes
		txtFirstNamePL.setText("");
		txtLastNamePL.setText("");
		txtCountryPL.setText("");
		txtAgeFromPL.setText("");
		txtAgeToPL.setText("");
		comboDOBDayPL.setSelectedIndex(0);
		comboDOBMonthPL.setSelectedIndex(0);
		comboDOBYearPL.setSelectedIndex(0);
				
		btnEditPlayersDetailsPL.setVisible(false);
		btnRemovePlayerPL.setVisible(false);
						

		// setting table model to new empty one
		dtm = new DefaultTableModel();
		tableSearchResults.setModel(dtm);
		}
	});

				
//*********************button for editing the results of the query		
		btnEditPlayersDetailsPL.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
			
					//this button is only active when database data is displayed, so this it ok to use tableSearchResults and tableSearchResultsSelectedRow.
				if (tableSearchResults.getSelectionModel().isSelectionEmpty() == false){
					System.out.println("Selected row: " + tableSearchResultsSelectedRow);
				/*	EditPlayer editPlayer = new EditPlayer();
					//frmFootballClub.setVisible(false);
					JDialog d = new JDialog(editPlayer.frame);
					d.setVisible(true);*/
					
					//***************************** START EDIT BLOCK
					//replace this block below with database query based on playerID in the table, to get all data for editing, not only ones displayed in the table.
					/*
					txtFirstNameEP.setText(String.valueOf(tableSearchResults.getValueAt(tableSearchResultsSelectedRow, 0)));
					txtLastNameEP.setText(String.valueOf(tableSearchResults.getValueAt(tableSearchResultsSelectedRow, 1)));
					txtAddressEP.setText(String.valueOf(tableSearchResults.getValueAt(tableSearchResultsSelectedRow, 2)));
					playerID = (int)tableSearchResults.getValueAt(tableSearchResultsSelectedRow, 4);
					System.out.println(playerID);
					*/
					playerID = (int)tableSearchResults.getValueAt(tableSearchResultsSelectedRow, 4);
					System.out.println("Player ID for editing: " + playerID);
					OperationsOnDB record = new OperationsOnDB();
					ArrayList tempList = new ArrayList();
					tempList = record.selectRowDataFromDBforEditing(playerID);
					
					//DATA set in fields.
					txtFirstNameEP.setText((String)tempList.get(0));
					txtLastNameEP.setText((String)tempList.get(1));
					
					//Date of birth
					comboDOBDayEP.setSelectedItem((Integer.valueOf(((String)tempList.get(2)).split("-")[2])));
					comboDOBMonthEP.setSelectedItem((Integer.valueOf(((String)tempList.get(2)).split("-")[1])));
					comboDOBYearEP.setSelectedItem((Integer.valueOf(((String)tempList.get(2)).split("-")[0])));
					txtAddressEP.setText((String)tempList.get(3));
					comboMaleFemaleEP.setSelectedItem((String)tempList.get(4));
					
					//start date
					comboStartDayEP.setSelectedItem((Integer.valueOf(((String)tempList.get(5)).split("-")[2])));
					comboStartMonthEP.setSelectedItem((Integer.valueOf(((String)tempList.get(5)).split("-")[1])));
					comboStartYearEP.setSelectedItem((Integer.valueOf(((String)tempList.get(5)).split("-")[0])));
					
					txtAgesEP.setText((String)tempList.get(6));
					
					
		
					
					//**************************** END EDIT BLOCK		
					
					tabbedPane.setEnabledAt(0, false);
					tabbedPane.setEnabledAt(1, false);
					tabbedPane.setEnabledAt(2, true);
					tabbedPane.setSelectedComponent(panelEditPlayerEP);
					
					
					//JDialog d = new JDialog(editPlayer.frame, "Edit Player's details");
					//d.setVisible(true);
					
					
				}
			
			}
			});	
				
			
			//********* deleting player from the database.
		btnRemovePlayerPL.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (tableSearchResults.getSelectionModel().isSelectionEmpty() == false){
					System.out.println("Selected row: " + tableSearchResultsSelectedRow);
					playerID = (int)tableSearchResults.getValueAt(tableSearchResultsSelectedRow, 4);
					System.out.println(playerID);
				// selecting data from database
				OperationsOnDB remove1 = new OperationsOnDB();
				int id = playerID;
				remove1.removeRecordFromDB(id);}
				
			}
		});


//***************** NEW PLAYER TAB **********************//
				//*******************button to clear all data in the new player form.
		btnClearFormNP.addActionListener(new ActionListener() {

		// function to clear data from the boxes and to clean the table from data.
		public void actionPerformed(ActionEvent e) {

			// removing text from all text boxes
			txtFirstNameNP.setText("");
			txtLastNameNP.setText("");
			txtAddressNP.setText("");
			txtAgeNP.setText("");
			comboDOBDayNP.setSelectedIndex(0);
			comboDOBMonthNP.setSelectedIndex(0);
			comboDOBYearNP.setSelectedIndex(0);
			comboMaleFemaleNP.setSelectedIndex(0);
			comboStartDayNP.setSelectedIndex(0);
			comboStartMonthNP.setSelectedIndex(0);
			comboStartYearNP.setSelectedIndex(0);
			
			//txtAgesPL.setText("");

			}
				});

		//**********function to set todays date on button click
		btnTodayNP.addActionListener(new ActionListener() {
					
		public void actionPerformed(ActionEvent e) {

		comboStartDayNP.setSelectedIndex(LocalDate.now().getDayOfMonth());
		comboStartMonthNP.setSelectedIndex(LocalDate.now().getMonthValue());
		comboStartYearNP.setSelectedItem(LocalDate.now().getYear());
		
		}});

		//**********function to add new player (button click)

		btnAddPlayerNP.addActionListener(new ActionListener() {
					
		public void actionPerformed(ActionEvent e) {

			String fn = "";
			String ln = "";
			String addr = "";
			int doby = 0;
			int dobm = 0;
			int dobd = 0;
			LocalDate dob = null;
			Boolean valid = true;

			if (txtFirstNameNP.getText().equals("")) {

				// if first name is not filled out, error will occur and query will not run

				valid = false;
				JOptionPane.showMessageDialog(frmFootballClub, "First Name cannot be empty 	field.");

			}

			else if (txtLastNameNP.getText().equals("")) {

				// if last name is not filled out, error will occur and query will not run
				valid = false;
				JOptionPane.showMessageDialog(frmFootballClub, "Last Name cannot be empty field.");
			}

			else if (txtAddressNP.getText().equals("")) {

				// if address name is not filled out, error will occur and query will not run
				valid = false;
				JOptionPane.showMessageDialog(frmFootballClub, "Address cannot be empty	field.");
			}

			else if (comboDOBYearNP.getSelectedItem() == null) {

				// if birth year is not filled out, error will occur and query will not run
				valid = false;
				JOptionPane.showMessageDialog(frmFootballClub, "Year of birth cannot be empty field.");
			}

			else if (comboDOBMonthNP.getSelectedItem() == null) {

				// if birth month is not filled out, error will occur and query will not run
				valid = false;
				JOptionPane.showMessageDialog(frmFootballClub, "Month of birth cannot be empty field.");
			}

			else if (comboDOBDayNP.getSelectedItem() == null) {

				// if birth day is not filled out, error will occur and query will not run
				valid = false;
				JOptionPane.showMessageDialog(frmFootballClub, "Day of birth cannot be empty field.");

			}

			if (valid == true) {

				fn = txtFirstNameNP.getText();
				ln = txtLastNameNP.getText();
				addr = txtAddressNP.getText();
				doby = (int) comboDOBYearNP.getSelectedItem();
				dobm = (int) comboDOBMonthNP.getSelectedItem();
				dobd = (int) comboDOBDayNP.getSelectedItem();
			}
			
			try {
				dob = LocalDate.of(doby, dobm, dobd);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(frmFootballClub, "Invalid date: " + e1.getMessage());
				valid = false;
			}
			
			// If validity check passed, add data to the database (run query), otherwise
			// return error information

			
			if (valid == true) {
				
				Person person = new Person(fn, ln, dob, addr);
				JOptionPane.showMessageDialog(frmFootballClub, "Added new player to the database.");

			}
			/*
			 * //information for debugging. else {
			 * System.out.println("Please correct data and proceed"); }
			 */

			// person.calculateAge((int)comboDOBDayNP.getSelectedItem(),
			// (int)comboDOBMonthNP.getSelectedItem(),
			// (int)comboDOBYearNP.getSelectedItem());

		}
	});

		//***************** Function to remove default content text "Enter here..." from cell when user
		
		// clicks on the cell for entering First Name
	txtFirstNameNP.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			// System.out.println(txtfields[txtFieldsCounter - 1].getClass().getName());
			String text = txtFirstNameNP.getText();
			if (text.equals("Enter here...")) {
				System.out.println(text + txtFirstNameNP.getWidth());
//										txtFirstNameNP.setText("");
				txtFirstNameNP.selectAll();
			} else {
				System.out.println("Sorry error");
			}

		}

	});

		//********** Function to remove default content text "Enter here..." from cell when user
		// clicks on the cell for entering Last Name
	txtLastNameNP.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {

			String text = txtLastNameNP.getText();
			if (text.equals("Enter here...")) {
				System.out.println(text);

				txtLastNameNP.selectAll();
			} else {
				System.out.println("Sorry error");
			}

		}
	});


						
//***************** EDIT PLAYER TAB **********************//
						
	//**************** Updating data in the database
		btnUpdateEP.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			// selecting data from database
			OperationsOnDB update1 = new OperationsOnDB();
			String fn = "";
			String ln = "";
			String addr = "";
			int doby = 0;
			int dobm = 0;
			int dobd = 0;
			LocalDate dob = null;
			Boolean valid = true;

			// checking if filter is set in first name, if not doing the default query,
			// otherwise use value form the field.
			
			fn = txtFirstNameEP.getText();
			ln = txtLastNameEP.getText();
			addr = txtAddressEP.getText();
			int id = playerID; // selected from the table for selected entry
			
			//THis may need check if data is not zero, so the program does not crash. !!!!!!!!!!!! CHECK THIS !!!!!
			doby = (int) comboDOBYearEP.getSelectedItem();
			dobm = (int) comboDOBMonthEP.getSelectedItem();
			dobd = (int) comboDOBDayEP.getSelectedItem();
			
			
			try {
				dob = LocalDate.of(doby, dobm, dobd);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(frmFootballClub, "Invalid date: " + e1.getMessage());
				valid = false;
			}
			
			// If validity check passed, add data to the database (run query), otherwise
			// return error information

			
			if (valid == true) {
				

			update1.updateEntryFromDB(fn, ln, addr, dob, id);

			}
		}
	});
	

//***************** resetting all data in the form and clear table of results
		btnClearDetailsEP.addActionListener(new ActionListener() {

		// function to clear data from the boxes and to clean the table from data.
		public void actionPerformed(ActionEvent e) {

		// removing text from all text boxes
		txtFirstNameEP.setText("");
		txtLastNameEP.setText("");
		txtAddressEP.setText("");
		txtAgesEP.setText("");
		comboDOBDayEP.setSelectedIndex(0);
		comboDOBMonthEP.setSelectedIndex(0);
		comboDOBYearEP.setSelectedIndex(0);
		comboMaleFemaleEP.setSelectedIndex(0);
		comboStartDayEP.setSelectedIndex(0);
		comboStartMonthEP.setSelectedIndex(0);
		comboStartYearEP.setSelectedIndex(0);
				
				}
		});

//************** setting today's date for edit players form.
	btnTodayEP.addActionListener(new ActionListener() {
				
		public void actionPerformed(ActionEvent e) {

		comboStartDayEP.setSelectedIndex(LocalDate.now().getDayOfMonth());
		comboStartMonthEP.setSelectedIndex(LocalDate.now().getMonthValue());
		comboStartYearEP.setSelectedItem(LocalDate.now().getYear());
		
		}});

//**********updating the database with data from edit players form.
		btnUpdateEP.addActionListener(new ActionListener() {
				
		public void actionPerformed(ActionEvent e) {

		System.out.println("test of the update");
		tabbedPane.setSelectedComponent(panelPlayersListPL);
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setEnabledAt(2, false);
		
		}});

//**********canceling, no changes to player data, returning to players list tab.
		btnCancelEP.addActionListener(new ActionListener() {
				
		public void actionPerformed(ActionEvent e) {

		System.out.println("canceling");
		tabbedPane.setSelectedComponent(panelPlayersListPL);
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setEnabledAt(2, false);
		
		}});

}

//***** to validate entry of the date - maybe move outside of this function.
	private void validateDate(int month, int day, int year) {

		boolean isLeap = false;

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0)
					isLeap = true;
				else
					isLeap = false;
			} else
				isLeap = true;
		} else {
			isLeap = false;
		}

		switch (day) {

		case 31:
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
				System.out.println("All OK! - month with 31 days");
			else
				System.out.println("Not OK! - not a month with 31 days");
			break;

		case 30:
			if (month != 2)
				System.out.println("All OK! - month no feb");
			else
				System.out.println("Not OK! - this is feb, max 29 days");

			break;

		case 29:
			if (month != 2 || isLeap)
				System.out.println("All OK! - leap year");
			else
				System.out.println("Not OK! - This is feb, but not a leap year, max is 28 days");
			break;

		default:
			System.out.println("OK");
			break;
		}

	}
}
