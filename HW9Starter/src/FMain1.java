// ----------------------------------------------------------------------
// Name: FMain1
// Abstract: a basic windows modeless form
// ----------------------------------------------------------------------


// ----------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------
import java.awt.*;			// Basic windows functionality
import java.awt.event.*;	// Event processing
import javax.swing.*;		// Supplemental windows functionality


@SuppressWarnings("serial")
public class FMain1 extends JFrame implements ActionListener
{
	// Row #1
	private JButton m_btn1 = null;
	private JButton m_btn2 = null;
	private JButton m_btn3 = null;
	private JButton m_btnPlus = null;
	
	// Row #2
	private JButton m_btn4 = null;
	private JButton m_btn5 = null;
	private JButton m_btn6 = null;
	private JButton m_btnMinus = null;
	
	// Row #3
	private JButton m_btn7 = null;
	private JButton m_btn8 = null;
	private JButton m_btn9 = null;
	private JButton m_btnMultiply = null;
	
	// Row #4
	private JButton m_btn0 = null;
	private JButton m_btnDecimal = null;
	private JButton m_btnDivide = null;
		
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
	// Name: FMain2
	// Abstract: the default constructor
	// ----------------------------------------------------------------------
	public FMain1( )
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
			int intHeight = 250;
			int intWidth = 240;
	
			// Title
			setTitle( "Homework 8 - FMain #2" );
	
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
	
			// Row #1
			m_btn1			= AddButton3( this, this, "1",  20,  20, 35, 45 );
			m_btn2			= AddButton3( this, this, "2",  20,  70, 35, 45 );
			m_btn3			= AddButton3( this, this, "3",  20, 120, 35, 45 );
			m_btnPlus		= AddButton3( this, this, "+",  20, 170, 35, 45 );

			// Row #2
			m_btn4			= AddButton3( this, this, "4",  70,  20, 35, 45 );
			m_btn5			= AddButton3( this, this, "5",  70,  70, 35, 45 );
			m_btn6			= AddButton3( this, this, "6",  70, 120, 35, 45 );
			m_btnMinus		= AddButton3( this, this, "-",  70, 170, 35, 45 );
			
			// Row #3
			m_btn7			= AddButton3( this, this, "7", 120,  20, 35, 45 );
			m_btn8			= AddButton3( this, this, "8", 120,  70, 35, 45 );
			m_btn9			= AddButton3( this, this, "9", 120, 120, 35, 45 );
			m_btnMultiply	= AddButton3( this, this, "*", 120, 170, 35, 45 );
			
			// Row #4
			m_btn0			= AddButton3( this, this, "0", 170,  20, 35, 95 );
			m_btnDecimal	= AddButton3( this, this, ".", 170, 120, 35, 45 );
			m_btnDivide		= AddButton3( this, this, "/", 170, 170, 35, 45 );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	
	// ----------------------------------------------------------------------
	// Name: AddButton2
	// Abstract: Add a button to the form - version #2
	// ----------------------------------------------------------------------
	public void AddButton2( Container conParent, String strCaption, 
		      				int intTop, int intLeft, int intHeight, int intWidth  )
	{
		try
		{
			// Create instance
			JButton btnNewButton = new JButton( strCaption );

			// Add to parent container
			conParent.add( btnNewButton );

			// Set position and size (left, top, width, height)
			btnNewButton.setBounds( intLeft, intTop, intWidth, intHeight );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	// ----------------------------------------------------------------------
	// Name: AddButton3
	// Abstract: Add a button to the form - version #2
	// ----------------------------------------------------------------------
	public JButton AddButton3( Container conParent, ActionListener alParent,
							   String strCaption, 
							   int intTop, int intLeft, 
		      				   int intHeight, int intWidth  )
	{
		// Always try to make instance inside a try/catch block so it's easier to debug
		JButton btnNewButton = null;
		
		try
		{
			// Create instance
			btnNewButton = new JButton( strCaption );

			// Add to parent container
			conParent.add( btnNewButton );

			// Set position and size (left, top, width, height)
			btnNewButton.setBounds( intLeft, intTop, intWidth, intHeight );
			
			// Does the parent want to know about events?
			if( alParent != null )
			{
				// Yes, it does
				btnNewButton.addActionListener( alParent );
			}
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return btnNewButton;
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
			// Your code here
			//CMessageBox.Show( “It worked”, “Event Logic Test” );
			
			// VB.Net Event Procedure Names: <Control Name>_<Event Type>

			// ---------- Row #1 ----------
			     if( aeSource.getSource( ) == m_btn1 )			btn1_Click( );
			else if( aeSource.getSource( ) == m_btn2 )			btn2_Click( );
			else if( aeSource.getSource( ) == m_btn3 )			btn3_Click( );
			else if( aeSource.getSource( ) == m_btnPlus )		btnPlus_Click( );

			// ---------- Row #2 ----------
			else if( aeSource.getSource( ) == m_btn4 )			btn4_Click( );
			else if( aeSource.getSource( ) == m_btn5 )			btn5_Click( );
			else if( aeSource.getSource( ) == m_btn6 )			btn6_Click( );
			else if( aeSource.getSource( ) == m_btnMinus )		btnMinus_Click( );

			// ---------- Row #3 ----------
			else if( aeSource.getSource( ) == m_btn7 )			btn7_Click( );
			else if( aeSource.getSource( ) == m_btn8 )			btn8_Click( );
			else if( aeSource.getSource( ) == m_btn9 )			btn9_Click( );
			else if( aeSource.getSource( ) == m_btnMultiply )	btnMultiply_Click( );

			// ---------- Row #4 ----------
			else if( aeSource.getSource( ) == m_btn0 )			btn0_Click( );
			else if( aeSource.getSource( ) == m_btnDecimal )	btnDecimal_Click( );
			else if( aeSource.getSource( ) == m_btnDivide )		btnDivide_Click( );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	// ----------------------------------------------------------------------
	// Name: btn1_Click
	// Abstract: Button 1 click event
	// ----------------------------------------------------------------------
	public void btn1_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button #1", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: btn2_Click
	// Abstract: Button 2 click event
	// ----------------------------------------------------------------------
	public void btn2_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button #2", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: btn3_Click
	// Abstract: Button 3 click event
	// ----------------------------------------------------------------------
	public void btn3_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button #3", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	
	// ----------------------------------------------------------------------
	// Name: btnPlus_Click
	// Abstract: Button plus click event
	// ----------------------------------------------------------------------
	public void btnPlus_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button Plus", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	// endregion
	
	// region "Controls: Row #2 - 4, 5, 6, Minus"
	
	// ----------------------------------------------------------------------
	// Name: btn4_Click
	// Abstract: Button 4 click event
	// ----------------------------------------------------------------------
	public void btn4_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button #4", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: btn5_Click
	// Abstract: Button 5 click event
	// ----------------------------------------------------------------------
	public void btn5_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button #5", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: btn6_Click
	// Abstract: Button 6 click event
	// ----------------------------------------------------------------------
	public void btn6_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button #6", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	
	// ----------------------------------------------------------------------
	// Name: btnMinus_Click
	// Abstract: Button Minus click event
	// ----------------------------------------------------------------------
	public void btnMinus_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button Minus", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	// endregion
	
	// region "Controls: Row #3 - 7, 8, 9, Multiply"
	
	// ----------------------------------------------------------------------
	// Name: btn7_Click
	// Abstract: Button 7 click event
	// ----------------------------------------------------------------------
	public void btn7_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button #7", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: btn8_Click
	// Abstract: Button 8 click event
	// ----------------------------------------------------------------------
	public void btn8_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button #8", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: btn9_Click
	// Abstract: Button 9 click event
	// ----------------------------------------------------------------------
	public void btn9_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button #9", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	
	// ----------------------------------------------------------------------
	// Name: btnMultiply_Click
	// Abstract: Button Multiply click event
	// ----------------------------------------------------------------------
	public void btnMultiply_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button Multiply", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	// endregion
	
	// region "Controls: Row #4 - 0, Decimal, Divide"
	
	// ----------------------------------------------------------------------
	// Name: btn0_Click
	// Abstract: Button 0 click event
	// ----------------------------------------------------------------------
	public void btn0_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button #0", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: btnDecimal_Click
	// Abstract: Button decimal click event
	// ----------------------------------------------------------------------
	public void btnDecimal_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button Decimal", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}
	
	
	// ----------------------------------------------------------------------
	// Name: btnDivide_Click
	// Abstract: Button Divide click event
	// ----------------------------------------------------------------------
	public void btnDivide_Click( )
	{
		try
		{
			CMessageBox.Show( "You clicked button Divide", "Click Event" );
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
	}

	// endregion

}