// ------------------------------------------------------------------------------------------
// Name: 	 Chris Sexton
// Class: 	 IT-161 Java 1
// Abstract: Homework 13 - Database Programming #4 - Delete
// ------------------------------------------------------------------------------------------

// ------------------------------------------------------------------------------------------
// Imports
// ------------------------------------------------------------------------------------------
import Utilities.*;


public class CHomework13
{
	// --------------------------------------------------------------------------------
	// Name: main
	// Abstract: This is where the program starts.  
	// --------------------------------------------------------------------------------
	public static void main( String astrCommandLine[] )
	{
		try
		{
			// FMain
			FMain frmMain = new FMain( );

			frmMain.setVisible( true );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}		
	}
}







