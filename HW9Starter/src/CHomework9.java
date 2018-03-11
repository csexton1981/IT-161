// ------------------------------------------------------------------------------------------
// Name: 	 Christopher Sexton
// Class: 	 IT-161-200 
// Abstract: Homework 8 - Introduction to Forms and Controls
// ------------------------------------------------------------------------------------------

// ------------------------------------------------------------------------------------------
// Imports
// 
// No imports
// ------------------------------------------------------------------------------------------


public class CHomework9
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
			FMain1 frmMain1 = new FMain1( );

			frmMain1.setVisible( true );

		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}		
	}
}