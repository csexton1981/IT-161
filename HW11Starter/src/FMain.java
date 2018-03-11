// ----------------------------------------------------------------------
// Name: Christopher Sexton
// Date: March 11, 2018
// Class: IT-161-200
// Name: FMain
// Abstract: Homework #10 - Database Programming #1 - Open, Load, Close
// ----------------------------------------------------------------------


// ----------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------
import java.awt.*;						// Basic windows functionality
import java.awt.event.*;				// Event processing
import javax.swing.*;					// Supplemental windows functionality
import Utilities.*;
import java.sql.*;						// All things SQL


@SuppressWarnings({ "serial", "unused" })
public class FMain extends JFrame implements ActionListener
{
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Controls
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------

	// Declare variables in the order that they appear
	private JButton m_btnOpenDatabaseConnection = null;
	private JButton m_btnLoadTeamsList = null;
	private JButton m_btnCloseDatabaseConnection = null;
	
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Properties
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Never make public properties.  
	// Make protected or private with public get/set methods
	private Connection m_conAdministrator = null;
	private CListBox m_lstTeams = null;
	
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Methods
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	
	// ----------------------------------------------------------------------
	// Name: FMain
	// Abstract: the default constructor
	// ----------------------------------------------------------------------
	public FMain( )
	{
		try
		{
			Initialize( );
			
			AddControls( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	


	// ----------------------------------------------------------------------
	// Name: Initialize
	// Abstract: Set the form properties
	// ----------------------------------------------------------------------
	private void Initialize( )
	{
		try
		{
			int intHeight = 480;
			int intWidth = 295;
	
			// Title
			setTitle( "HW11 - Add to Databases - F.Lastname" );
	
			// Size
			setSize( intWidth, intHeight );
	
			// Center screen
			CUtilities.CenterScreen( this );
	
			// No resize
			setResizable( false );
	
			// Exit application close (instead of just hiding/visible = false)
			setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	
	// ----------------------------------------------------------------------
	// Name: AddControls
	// Abstract: Add all the form controls
	// ----------------------------------------------------------------------
	public void AddControls( )
	{
		try
		{
			// Clear layout manager so we can manually size and position controls
			this.setLayout( null );
	
			// Open
			m_btnOpenDatabaseConnection 	= CUtilities.AddButton( this, this, "Open Database Connection",   20, 20,  35, 250 );
			// Load Teams Button
			m_btnLoadTeamsList			 	= CUtilities.AddButton( this, this, "Load Teams List",   65, 20,  35, 250 );
			// Teams List
			m_lstTeams						= CUtilities.AddListBox( this,                                   110, 20, 280, 250 );
			// Close
			m_btnCloseDatabaseConnection 	= CUtilities.AddButton( this, this, "Close Database Connection",   400, 20,  35, 250 );
			
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	
	// ----------------------------------------------------------------------
	// Name: actionPerformed
	// Abstract: Event handler for control click events
	// ----------------------------------------------------------------------
	@Override
	public void actionPerformed( ActionEvent aeSource )
	{
		try
		{
			// VB.Net Event Procedure Names: <Control Name>_<Event Type>
			
				 if( aeSource.getSource( ) == m_btnOpenDatabaseConnection ) 	btnOpenDatabaseConnection2_Click( );
				 
				 if ( aeSource.getSource( ) == m_btnLoadTeamsList ) btnLoadTeamsList_Click( );
					
				 if( aeSource.getSource( ) == m_btnCloseDatabaseConnection ) 	btnCloseDatabaseConnection_Click( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	// ----------------------------------------------------------------------
	// Name: btnOpenDatabaseConnection2_Click
	// Abstract: Open a connection to the database
	//			The support for the JDBC-ODBC bridge has been removed from
	//			JDK1.8 and JRE8.
	//
	//			Use UCanAccess, an open-source JDBC driver, instead.
	//			Include the following jar files in your code:
	//				ucanaccess-2.0.7.jar
	//				jackcess-2.0.4.jar
	//					commons-lang-2.6.jar
	//					commons-logging-1.1.3.jar
	//				hsqldb.jar
	//
	//			To include those files select "Project / Properties / Java Build Path"
	//			from the menu.  Click on the "Libraries" tab.  Click "Add External JARs".
	//			Browse to the above jar files, which should be in a directory in your
	//			project (e.g. JDBC-to-MSAccess).  Select all five files and click
	//			"Open".  Click "OK".
	//
	//			You must also have either have MS Access 2010 install or download and
	//			install "Microsoft Access Database Engine 2010" which can be found 
	//			for free at:
	//
	//				https://www.microsoft.com/en-us/download/details.aspx?id=13255
	//
	//			Do not match to your operating system.  Download the version 
	//			(32 or 64 bit) that matches the version of your JRE.  
	// ----------------------------------------------------------------------
	public void btnOpenDatabaseConnection2_Click( )
	{
		try
		{
			String strConnectionString = "";

			// Server name/port, IP address/port or path for file based databases like MS Access
			// System.getProperty( "user.dir" ) => Current working directory from where
			// application was started
			strConnectionString = "jdbc:ucanaccess://" + System.getProperty( "user.dir" ) 
								+ "\\Database\\TeamsAndPlayers1.accdb";

			// Open a connection to the database
			m_conAdministrator = DriverManager.getConnection( strConnectionString );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	// ----------------------------------------------------------------------
	// Name: btnLoadTeamsList_OnClick
	// Abstract: Load the team list
	// ----------------------------------------------------------------------
	private void btnLoadTeamsList_Click( )
	{
		try
		{
			String strSelect = "";
			Statement sqlCommand = null;
			ResultSet rstTTeams = null;
			String strTeam = "";
			
			// Clear list to avoid duplicate entry
			m_lstTeams.Clear( );
			
			// Build the SQL string
			strSelect = "SELECT strTeam" 
					  + " FROM TTeams" 
					  + " ORDER BY strTeam";

			// Retrieve the all the records
			sqlCommand = m_conAdministrator.createStatement( );
			rstTTeams = sqlCommand.executeQuery( strSelect );

			// Loop through all the records
			while( rstTTeams.next( ) == true )
			{
				// Get Name from current row, which should be the first, and only, column
				strTeam = rstTTeams.getString( 1 );

				// Add the item to the list (0 = id, strTeam = text to display, false = don't select)
				m_lstTeams.AddItemToList( 0, strTeam, false );
			}
			
			// Clean up
			rstTTeams.close( );
			sqlCommand.close( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	
	// ----------------------------------------------------------------------
	// Name: btnCloseDatabaseConnection_Click
	// Abstract: Close the connection to the database
	// ----------------------------------------------------------------------
	public void btnCloseDatabaseConnection_Click( )
	{
		try
		{
			// Is there a connection object?
			if( m_conAdministrator != null )
			{
				// Yes, close the connection if not closed already
				if( m_conAdministrator.isClosed( ) == false ) 
				{
					// Clear list to avoid duplicate entry
					//m_lstTeams.Clear( );
					m_conAdministrator.close( );
					m_lstTeams.Clear( );
					
					// Prevent JVM from crashing
					m_conAdministrator = null;
				}
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
}