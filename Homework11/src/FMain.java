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
// import java.sql.*;						// All things SQL


@SuppressWarnings({ "serial", "unused" })
public class FMain extends JFrame implements ActionListener, WindowListener
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
	// private Connection m_conAdministrator = null;
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
			
			// Listen for window events
			this.addWindowListener( this );
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
			// m_btnOpenDatabaseConnection 	= CUtilities.AddButton( this, this, "Open Database Connection",   20, 20,  35, 250 );
			// Load Teams Button
			m_btnLoadTeamsList			 	= CUtilities.AddButton( this, this, "Load Teams List",   65, 20,  35, 250 );
			// Teams List
			m_lstTeams						= CUtilities.AddListBox( this,                                   110, 20, 280, 250 );
			// Close
			// m_btnCloseDatabaseConnection 	= CUtilities.AddButton( this, this, "Close Database Connection",   400, 20,  35, 250 );
			
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	// ----------------------------------------------------------------------
	// Name: WindowListener
	// ----------------------------------------------------------------------	
	
	// Name: Window Opened
	// Purpose: Opens a connection to the database.  Since the form is visible now, we need to ensure that a connection
	// is opened and setting the busy cursor while you're connecting to the database so the user knows something is going on
	// under the covers.  
	
	public void windowOpened( WindowEvent weSource )
	{
		try
		{
			// We are busy
			CUtilities.SetBusyCursor( this, true );

			// Can we connect to the database?
			if( CDatabaseUtilities.OpenDatabaseConnection( ) == false )
			{
				
				// No, warn the user ...
				CMessageBox.Show( "Database connection error.\n" +
								  "The application will close.\n", 
								  getTitle( ) + " Error" );

				
				// and close the form/application
				this.dispose( );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		finally
		{
			// We are NOT busy
			CUtilities.SetBusyCursor( this, false );
		}
	}		
	
	
	// ----------------------------------------------------------------------
	// Name: windowClosed
	// Abstract: Close the connection to the database
	//			Triggered when this.dispose( ) but NOT by clicking X button
	//			in the Window Title Bar
	// ----------------------------------------------------------------------
	public void windowClosed( WindowEvent weSource )
	{
		try
		{
			CleanUp( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	
	// ----------------------------------------------------------------------
	// Name: windowClosing
	// Abstract: Close the connection to the database
	//			Triggered clicking X button in the Window Title Bar
	//			but NOT by this.dispose( )
	// ----------------------------------------------------------------------
	public void windowClosing( WindowEvent weSource )
	{
		try
		{
			CleanUp( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	// ----------------------------------------------------------------------
	// Name: CleanUp
	// Abstract: Close the connection to the database
	// ----------------------------------------------------------------------
	public void CleanUp( )
	{
		try
		{
			CDatabaseUtilities.CloseDatabaseConnection( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// Don't care
	public void windowActivated( WindowEvent weSource ) { }
	public void windowDeactivated( WindowEvent weSource ) { }
	public void windowIconified( WindowEvent weSource ) { }
	public void windowDeiconified( WindowEvent weSource ) { }	



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
			
				 //if( aeSource.getSource( ) == m_btnOpenDatabaseConnection ) 	btnOpenDatabaseConnection2_Click( );
				 
				 if ( aeSource.getSource( ) == m_btnLoadTeamsList ) btnLoadTeamsList_Click( );
					
				 //if( aeSource.getSource( ) == m_btnCloseDatabaseConnection ) 	btnCloseDatabaseConnection_Click( );
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
			CDatabaseUtilities.LoadListBoxFromDatabase( "TTeams", "strTeam", m_lstTeams );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
}
	
