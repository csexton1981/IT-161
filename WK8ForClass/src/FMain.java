// ----------------------------------------------------------------------
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


@SuppressWarnings("serial")
public class FMain extends JFrame
{

	// Declare variables in the order that they appear
	//TG- private JButton m_btnOpenDatabaseConnection = null;
	//TG- private JButton m_btnLoadTeamsList = null;
	//TG- private JButton m_btnCloseDatabaseConnection = null;
	
	private Connection m_conAdministrator = null;
	
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
			// set the Height
			int intHeight = 480;
			// set the width
			int intWidth = 295;
	
			// Title
			setTitle( "WK8IC - Intro to Databases" );
	
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
	
			// Open Button
			
			// Load Teams Button
			
			// Teams List
			
			// Close
			
			
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
				// Check if user clicked on Open Connection
				//TG- if( aeSource.getSource( ) == m_btnOpenDatabaseConnection ) 	btnOpenDatabaseConnection2_Click( );
				// Check if user clicked on Load Teams 
				//TG- if ( aeSource.getSource( ) == m_btnLoadTeamsList ) btnLoadTeamsList_Click( );
				// Check if user clicked on Close Database 	
				//TG- if( aeSource.getSource( ) == m_btnCloseDatabaseConnection ) 	btnCloseDatabaseConnection_Click( );
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
}
