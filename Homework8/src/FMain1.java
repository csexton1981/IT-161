// Name: Christopher Sexton
// Date: 2/26/2018
// Abstract: My First Form

//----------------------------------------------------------------------
//Imports
//----------------------------------------------------------------------

//this imports JButton, JFrame
import javax.swing.*;

@SuppressWarnings("serial")

public class FMain1 extends JFrame
{
	// ----------------------------------------------------------------------
	// Name: FMain
	// Abstract: the default constructor
	// ----------------------------------------------------------------------
	public FMain1 ( )
	{
		int intHeight = 500;
		int intWidth = 500;

		setTitle ( "Homeowrk 8 - Christopher Sexton Main #1" );
		
		setSize( intWidth, intHeight );  
		
		setResizable( false );
		
		this.setLocationRelativeTo( null );
		
		// Very important or we get zombies (undead application)
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// Clear layout manager so we can manually size and position controls
		// comment this line out and test your program - you will see a large button
				
		// Create instance
		JButton btnTest = new JButton( "Test Chris' Button" );

		// Add to form
		this.add(btnTest);
		
		// Set position and size (left, top, width, height)
		btnTest.setBounds( 100, 100, 200, 35 );
		
		this.setLayout( null );  // Death to layout manager overlords!
		
		
	}
	
}