// ----------------------------------------------------------------------
// Name: DAddTeam
// Abstract: Add a team
// ----------------------------------------------------------------------


// ----------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------
import java.awt.*;						// Basic windows functionality
import java.awt.event.*;				// Event processing
import javax.swing.*;					// Supplemental windows functionality
import Utilities.*;
import Utilities.CMessageBox.enuIconType;
import Utilities.CUserDataTypes.udtTeamType;


@SuppressWarnings("serial")
public class DAddTeam extends JDialog implements ActionListener
{
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Controls
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Declare the controls in the order they appear (top to bottom, left to right)
	@SuppressWarnings("unused")
	private JLabel m_lblTeam = null;
	private CTextBox m_txtTeam = null;

	@SuppressWarnings("unused")
	private JLabel m_lblMascot = null;
	private CTextBox m_txtMascot = null;

	@SuppressWarnings("unused")
	private JLabel m_lblRequiredField = null;
	
	private JButton m_btnOK = null;
	private JButton m_btnCancel = null;

	
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
	// Name: DAddTeam
	// Abstract: the default constructor
	// ----------------------------------------------------------------------
	public DAddTeam( JFrame frmParent )
	{
		super( frmParent, true );	// true = modal
		
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
			int intHeight = 175;
			int intWidth = 285;
			
			// Title
			setTitle( "Add Team" );
			
			// Size
			setSize( intWidth, intHeight );
			
			// Center screen
			CUtilities.CenterOwner( this );
			
			// No resize
			setResizable( false );
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
			// Manually position and size controls
			CUtilities.ClearLayoutManager( this );
			
			// Team
			m_lblTeam = CUtilities.AddLabel( this, "Team:*", 25, 20 );
			m_txtTeam = CUtilities.AddTextBox( this, "", 21, 75, 25, 185, 50 );
	
			// Mascot
			m_lblMascot = CUtilities.AddLabel( this, "Mascot:*", 55, 20 );
			m_txtMascot = CUtilities.AddTextBox( this, "", 51, 75, 25, 185, 50 );
	
			// Required
			m_lblRequiredField = CUtilities.AddRequiredFieldLabel( this, 77, 70 );

			// m_btnOK
			m_btnOK = CUtilities.AddButton( this, this, "OK", 'O', 100, 30, 30, 100 );
	
			// m_btnCancel
			m_btnCancel = CUtilities.AddButton( this, this, "Cancel", 'C', 100, 155, 30, 100 );
		}
		catch( Exception expError )
		{
			// Display Error Message
			CUtilities.WriteLog( expError );
		}
	}
	


	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// ActionListener
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------

    
    // ----------------------------------------------------------------------
	// Name: actionPerformed
	// Abstract: Event handler for control click events
	// ----------------------------------------------------------------------
	@Override
	public void actionPerformed( ActionEvent aeSource )
	{
		try
		{
				 if( aeSource.getSource( ) == m_btnOK )	    	btnOK_Click( );
			else if( aeSource.getSource( ) == m_btnCancel )	    btnCancel_Click( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}


	// ----------------------------------------------------------------------
	// Name: btnOK_Click
	// Abstract: Add the team to the database
	// ----------------------------------------------------------------------
	private void btnOK_Click( )
	{
		try
		{
			// Is the form data good?
			if( IsValidData( ) == true )
			{
				// Did it save to the database?
				if( SaveData( ) == true )
				{
					// Yes, all done
					setVisible( false );
				}
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: IsValidData
	// Abstract: Check all the data and warn the user if it's bad
	// ----------------------------------------------------------------------
	private boolean IsValidData( )
	{
		// Assume data is good.  Easier to code that way.
		boolean blnIsValidData = true;
		
		try
		{
			String strErrorMessage = "Please correct the following error(s):\n";
			
			// Trim textboxes
			CUtilities.TrimAllFormTextBoxes( this );
			
			// Team
			if( m_txtTeam.getText( ).equals( "" ) == true )
			{
				strErrorMessage += "-Team cannot be blank\n";
				blnIsValidData = false;
			}

			// Mascot
			if( m_txtMascot.getText( ).equals( "" ) == true )
			{
				strErrorMessage += "-Mascot cannot be blank\n";
				blnIsValidData = false;
			}
			
			// Bad data?
			if( blnIsValidData == false )
			{
				// Yes, warn the user
				CMessageBox.Show( this, strErrorMessage, 
								  getTitle( ) + " Error", enuIconType.Warning );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return blnIsValidData;
	}
	
	
	// ----------------------------------------------------------------------
	// Name: SaveData
	// Abstract: Get the data off of the form and save it to the database
	// ----------------------------------------------------------------------
	private boolean SaveData( )
	{
		boolean blnResult = false;
		
		try
		{
			// Make a suitcase for moving data
			udtTeamType udtNewTeam = new CUserDataTypes( ).new udtTeamType( );
			
			// Load suitcase with data from form
			udtNewTeam.intTeamID = 0; 	// Don't know it yet so set to 0
			udtNewTeam.strTeam = m_txtTeam.getText( );
			udtNewTeam.strMascot = m_txtMascot.getText( );
			
			// We are busy
			CUtilities.SetBusyCursor( this, true );
			
			// Try to save the data
			blnResult = CDatabaseUtilities.AddTeamToDatabase( udtNewTeam );
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
		
		return blnResult;
	}
	
	
	// ----------------------------------------------------------------------
	// Name: btnCancel_Click
	// Abstract: Cancel the add team
	// ----------------------------------------------------------------------
	private void btnCancel_Click( )
	{
		try
		{
			setVisible( false );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
}




