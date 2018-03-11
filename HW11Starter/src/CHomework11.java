// --------------------------------------------------------------------------------
// Name: Christopher Sexton
// Class: IT-161-200 (Java #1)
// Abstract: Homework 11 
// --------------------------------------------------------------------------------

// --------------------------------------------------------------------------------
// Import
// --------------------------------------------------------------------------------
import Utilities.*;
// --------------------------------------------------------------------------------
// Name: CHomework11
// Abstract: This class ...
// --------------------------------------------------------------------------------

public class CHomework11
{
	// --------------------------------------------------------------------------------
	// Name: main
	// Abstract: This is where the program starts.  
	// --------------------------------------------------------------------------------
	public static void main( String astrCommandLine[] )
	{
		try
		{
			// FMain #1
			FMain frmMain1 = new FMain( );
			frmMain1.setVisible( true );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}		
	}
}
