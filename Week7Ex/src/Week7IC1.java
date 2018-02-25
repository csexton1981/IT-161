// Name: Christopher Sexton
// Date: 2/21/18
// Abstract: Week 7 InClass 1

public class Week7IC1 {

	public static void main(String[] args)
	{
		try 
		{
			// FMain #1
			FMyFirstForm frmMain1 = new FMyFirstForm( );
			// Put this code in for the class to form an error
			
			//int intTest = 0;
			//intTest = 1/0;
			//System.out.println( intTest * 1 );			
			frmMain1.setVisible( true );
			//FMyFirstForm frmMain1
			
		}
		catch ( Exception excError )
		{
			// Display Error Message if needed
			System.out.println( excError.getMessage());
		}
	}

}
