// Name: Christopher Sexton
// Date: 2/26/18
// Abstract: Homework 8


public class Homework8 

{

	public static void main(String[] args) 

	{
		// TODO Auto-generated method stub
			try 
			{ 
				
				//FMain #1
				FMyFirstForm frmMain1 = new FMyFirstForm( );
				frmMain1.setVisible( true );
				
			}
		catch ( Exception excError )
		{
			//Display Error Message
			System.out.println(excError.getMessage());
		}
	}

}
