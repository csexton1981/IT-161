// ----------------------------------------------------------------------
// Name: FMain
// Abstract: Homework #13 - Database Programming #3 - Add
// ----------------------------------------------------------------------


// ----------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------
import java.awt.*;						// Basic windows functionality
import java.awt.event.*;				// Event processing

import javax.swing.*;					// Supplemental windows functionality

import Utilities.*;
import Utilities.CMessageBox.enuIconType;





@SuppressWarnings("serial")
public class FMain extends JFrame implements ActionListener,
											 WindowListener
{
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Controls
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	private JButton m_btnLoadTeamsList = null;
	@SuppressWarnings("unused")
	private JLabel m_lblTeams = null;
	private CListBox m_lstTeams = null;
	private JButton m_btnAdd = null;
	private JButton m_btnEdit = null;
	private JButton m_btnDelete = null;
	private JButton m_btnClose = null;

	
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Properties
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Never make public properties.  
	// Make protected or private with public get/set methods

	
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
			int intHeight = 430;	
			int intWidth = 515;
			
			// Title
			setTitle( "Homework 13 - Delete" );
			
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
	// Name: paint
	// Abstract: Override the paint event to draw grid marks.
	// ----------------------------------------------------------------------
	public void paint( Graphics g )
	{
		super.paint( g );
		
		try
		{
			//CUtilities.DrawGridMarks( this, g );
		}
		catch( Exception expError )
		{
			// Display Error Message
			CUtilities.WriteLog( expError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: AddControls
	// Abstract: Add all the controls to the frame
	// ----------------------------------------------------------------------
	private void AddControls( )
	{
		try
		{				
			// Clear layout manager so we can manually size and position controls
			CUtilities.ClearLayoutManager( this );
	
			// btnLoad
			m_btnLoadTeamsList = CUtilities.AddButton( this, this, 
										    "Load Teams List", 20, 20, 35, 250 );

			// lstTeams
			m_lblTeams = CUtilities.AddLabel( this, "Teams:", 69, 20 );
			m_lstTeams = CUtilities.AddListBox( this, 85, 20, 250, 350 );
			
			// m_btnAdd
			m_btnAdd = CUtilities.AddButton( this, this, "Add", 'A', 110, 390, 30, 100 );
	
			// m_btnEdit
			m_btnEdit = CUtilities.AddButton( this, this, "Edit", 'E', 185, 390, 30, 100 );
	
			// m_btnDelete
			m_btnDelete = CUtilities.AddButton( this, this, "Delete", 'D', 260, 390, 30, 100 );
	
			// m_btnClose
			m_btnClose = CUtilities.AddButton( this, this, "Close", 'C', 355, 145, 30, 200 );
		}
		catch( Exception expError )
		{
			// Display Error Message
			CUtilities.WriteLog( expError );
		}
	}

	
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Window Listener
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// Name: windowOpened
	// Abstract: The window is opened.  Triggered by setVisible( true ).
	// ----------------------------------------------------------------------
	public void windowOpened( WindowEvent weSource )
	{
		try
		{
			// We are busy
			CUtilities.SetBusyCursor( this, true );

			// Can we connect to the database?
			//if( CDatabaseUtilities.OpenDatabaseConnectionMSAccessJRE7( ) == true )
			if( CDatabaseUtilities.OpenDatabaseConnectionMSAccessJRE8( ) == true )
			//if( CDatabaseUtilities.OpenDatabaseConnectionSQLServer( ) == true )
			{	
				// Yes, load the teams list
				CDatabaseUtilities.LoadListBoxFromDatabase( "TTeams", "intTeamID", "strTeam", m_lstTeams );
			}
			else
			{
				// No, warn the user ...
				CMessageBox.Show( this, "Database connection error.\n" +
										"The application will close.\n", 
										getTitle( ) + " Error",
										enuIconType.Error );

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
	// ----------------------------------------------------------------------
	// Action Listener
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------

    // ----------------------------------------------------------------------
	// Name: actionPerformed
	// Abstract: Event handler for control click events
	// ----------------------------------------------------------------------
	public void actionPerformed( ActionEvent aeSource )
	{
		try
		{
				 if( aeSource.getSource( ) == m_btnLoadTeamsList )	btnLoadTeamsList_Click( );
			else if( aeSource.getSource( ) == m_btnAdd )	    	btnAdd_Click( );
			else if( aeSource.getSource( ) == m_btnEdit )	    	btnEdit_Click( );
			else if( aeSource.getSource( ) == m_btnDelete )	    	btnDelete_Click( );
			else if( aeSource.getSource( ) == m_btnClose )			btnClose_Click( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// ----------------------------------------------------------------------
	// Name: btnLoadTeamsList_Click
	// Abstract: Load the teams list
	// ----------------------------------------------------------------------
	private void btnLoadTeamsList_Click( )
	{
		try
		{
			// We are busy
			CUtilities.SetBusyCursor( this, true );
			
			CDatabaseUtilities.LoadListBoxFromDatabase( "TTeams", "intTeamID", "strTeam", m_lstTeams );
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
	// Name: btnAdd_Click
	// Abstract: Add a team
	// ----------------------------------------------------------------------
	private void btnAdd_Click( )
	{
		try
		{
			DAddTeam dlgAddTeam = null;
			
			// Make instance
			dlgAddTeam = new DAddTeam( this );
			
			// Show modally
			dlgAddTeam.setVisible( true );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: btnEdit_Click
	// Abstract: Edit a team
	// ----------------------------------------------------------------------
	private void btnEdit_Click( )
	{
		try
		{
			CMessageBox.Show( this, "Edit Click", "Event Test" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	
// ----------------------------------------------------------------------
// Name: btnDelete_Click
// Abstract: Delete a team
// ----------------------------------------------------------------------
	private void btnDelete_Click( )
	{
		try
		{
			int intSelectedListIndex = 0;
			CListItem liSelectedTeam = null;
			int intSelectedTeamID = 0;
			String strSelectedTeam = "";
			int intConfirm = 0;
			boolean blnResult = false;
			
			// Get the selected index from the list
			intSelectedListIndex = m_lstTeams.GetSelectedIndex( );

			// Is something selected?
			if( intSelectedListIndex < 0 )
			{
				// No, warn the user
				CMessageBox.Show( this, "You must select a Team to delete.", 
								  		"Delete Team Error" );
			}
			else
			{
				// Yes, so get the selected list item ID and name
				liSelectedTeam = m_lstTeams.GetSelectedItem( );
				intSelectedTeamID = liSelectedTeam.GetValue( );
				strSelectedTeam = liSelectedTeam.GetName( );
				
				// Confirm delete
				intConfirm = CMessageBox.Confirm( this, "Are you sure?", 
												  "Delete Team: " + strSelectedTeam );
	
				// Delete?
				if( intConfirm == CMessageBox.intRESULT_YES )
				{
					// Yes, we are busy
					CUtilities.SetBusyCursor( this, true );
					
					// Attempt to delete
					blnResult = CDatabaseUtilities.DeleteTeamFromDatabase( intSelectedTeamID );
					
					// Did it work?
					if( blnResult == true )
					{
						// Yes, remove record.  Next closest record automatically selected.
						m_lstTeams.RemoveAt( intSelectedListIndex );
					}
				}
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
	// Name: btnClose_Click
	// Abstract: Close the form
	// ----------------------------------------------------------------------
	private void btnClose_Click( )
	{
		try
		{
			// Close the form and exit the application
			this.dispose( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

}

