// ----------------------------------------------------------------------
// Name: Christopher Sexton
// Date: 2/21/18
// Class Name: 
// Abstract: the starting form for our windows application
// ----------------------------------------------------------------------


// ----------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------
//this imports JButton, JFrame

import javax.swing.*;


@SuppressWarnings("serial")
public class FMyFirstForm extends JFrame
{
	// ----------------------------------------------------------------------
	// Name: FMain
	// Abstract: this is the default constructor
	// ----------------------------------------------------------------------

		public FMyFirstForm( )
		{
		
		int intHeight = 500;
		int intWidth = 500;

		setTitle ("This class is tougher than I thought");
		
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