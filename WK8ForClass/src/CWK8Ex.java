// --------------------------------------------------------------------------------
// Name: <Your Name>
// Class: IT-161 Java #1
// Abstract: This homework ...
// --------------------------------------------------------------------------------

// --------------------------------------------------------------------------------
// Import
// --------------------------------------------------------------------------------
import Utilities.*;
// --------------------------------------------------------------------------------
// Name: CHomework?
// Abstract: This class ...
// --------------------------------------------------------------------------------

public class CWK8Ex
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
			// Display frmMain1
			frmMain1.setVisible( true );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}		
	}
}