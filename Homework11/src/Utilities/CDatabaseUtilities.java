// ----------------------------------------------------------------------
// Name: CDatabaseUtilities
// Abstract: All procedures that directly interact with the database
// ----------------------------------------------------------------------

// ----------------------------------------------------------------------
// Package
// ----------------------------------------------------------------------
package Utilities;


// ----------------------------------------------------------------------
// Imports
// ----------------------------------------------------------------------
import java.sql.*;						// All things SQL
import com.microsoft.sqlserver.jdbc.*;	// Extra credit for connecting to SQL Server


public class CDatabaseUtilities
{
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Properties( never make public )
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	private static Connection m_conAdministrator = null;
	

	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------
	// Methods
	// ----------------------------------------------------------------------
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// Name: OpenDatabaseConnectionMSAccessJRE7
	// Abstract: Open a connection to the database.  MS Access JRE7.
	//			JDK1.7 and JRE7.
	//
	// 			Must either have MS Access 2010 install or download and
	//			install "Microsoft Access Database Engine 2010" which can be
	//			found for free at:
	//
	//				https://www.microsoft.com/en-us/download/details.aspx?id=13255
	//
	//			Do not match to your operating system.  Download the version 
	//			(32 or 64 bit) that matches the version of your JRE.  
	// ----------------------------------------------------------------------
	public static boolean OpenDatabaseConnectionMSAccessJRE7( )
	{
		boolean blnResult = false;
		
		try
		{
			String strConnectionString = "";

			// Provider/driver (what type of database)
			strConnectionString = "jdbc:odbc:;Driver={Microsoft Access Driver (*.mdb, *.accdb)};";

			// Server name/port, IP address/port or path for file based databases like MS Access
			// System.getProperty( "user.dir" ) => Current working directory from where 
			// application was started
			strConnectionString += "DBQ=" + System.getProperty( "user.dir" ) 
								 + "\\Database\\TeamsAndPlayers1.accdb;";

			// User name (seems to ignore this and password)
			strConnectionString += "User ID=admin;";
			
			// Password which, by default, is empty (empty is not the same as null) for MS Access
			strConnectionString += "Password=;";
			
			// Open a connection to the database
			m_conAdministrator = DriverManager.getConnection( strConnectionString );
			
			// Success
			blnResult = true;
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return blnResult;
	}

	
	// ----------------------------------------------------------------------
	// Name: OpenDatabaseConnectionMSAccessJRE8
	// Abstract: Open a connection to the database.  MS Access JRE8.
	//			The support for the JDBC-ODBC bridge has been removed from
	//			JDK1.8 and JRE8.
	//
	//			Use UCanAccess, an open-source JDBC driver, instead.
	//			Include the following jar files in your code:
	//				ucanaccess-2.0.7.jar
	//				jackcess-2.0.4.jar
	//					commons-lang-2.6.jar
	//					commons-logging-1.1.3.jar
	//				hsqldb.jar
	//
	//			To include those files select "Project / Properties / Java Build Path"
	//			from the menu.  Click on the "Libraries" tab.  Click "Add External JARs".
	//			Browse to the above jar files, which should be in a directory in your
	//			project (e.g. JDBC-to-MSAccess).  Select all five files and click
	//			"Open".  Click "OK".
	//
	//			You must also have either have MS Access 2010 install or download and
	//			install "Microsoft Access Database Engine 2010" which can be found 
	//			for free at:
	//
	//				https://www.microsoft.com/en-us/download/details.aspx?id=13255
	//
	//			Do not match to your operating system.  Download the version 
	//			(32 or 64 bit) that matches the version of your JRE.  
	// ----------------------------------------------------------------------
	public static boolean OpenDatabaseConnectionMSAccessJRE8( )
	{
		boolean blnResult = false;
		
		try
		{
			String strConnectionString = "";

			// Server name/port, IP address/port or path for file based databases like MS Access
			// System.getProperty( "user.dir" ) => Current working directory from where
			// application was started
			strConnectionString = "jdbc:ucanaccess://" + System.getProperty( "user.dir" ) 
								+ "\\Database\\TeamsAndPlayers1.accdb";

			// Open a connection to the database
			m_conAdministrator = DriverManager.getConnection( strConnectionString );
			
			// Success
			blnResult = true;
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return blnResult;
	}

	
	// -------------------------------------------------------------------------
	// Name: OpenDatabaseConnectionSQLServer
	// Abstract: Open a connection to the database.  SQL Server.
	//	
	//	Download the drivers.  Search the internet for "Microsoft JDBC Driver 4.0 for SQL Server".  
	//	One the links should be to the Microsoft Site.  For example, 
	//		http://download.microsoft.com/download/0/2/A/02AAE597-3865-456C-AE7F-613F99F850A8/sqljdbc_4.0.2206.100_enu.exe
	//		It's a self-extracting zip file.  All it does is unzip the files.  It doesn't actually install anything.
	//	-Extract the files somewhere
	//	-Add a "Database/SQLServer" directory to your project
	//	-Copy the sqljdbc4.jar file from the enu directory into "Database/SQLServer" directory in your project.
	//		You'll need this file later.
	//	-Copy the sqljdbc_auth.dll file from enu\auth\x86 directory into the "Database/SQLServer" directory in your project.
	//		You'll need this file later.
	//	-You can delete all the other files.  You might want to save the original download file 
	//		in "Database/SQLServer" directory.		
	//	
	//	How to configure Eclipse to use the drivers for just your project:
	//	-Select/open your project in Eclipse
	//	-Choose Project/Properties from the menu
	//	-Select "Java Build Path" in the menu on the left
	//	-Click on the "Libraries" tab on the right
	//	-Click "Add External Jars..."
	//	-Browse to your "sqljdbc4.jar" file which should be in the "Database/SQLServer" folder 
	//		in your project.  If you move your project you'll need to remove the old
	//		jar file and re-add it because Eclipse uses absolute paths instead of relative.
	//	-Click OK
	//	-Click OK
	//	-Add "import com.microsoft.sqlserver.jdbc.*;		// SQL Server specific drivers
	//
	//	How to configure Java to use "Integrated Security" for SQL Server Login
	//	-Copy the sqljdbc_auth.dll from the download above to the 
	//	C:\Program Files (x86)\Java\JDK1.7.???\bin and C:\Program Files (x86)\Java\JRE7\bin directories
	//	-Restart Eclipse.
	//
	//	You may have to enable TCP connections for SQL Server.  
	//		Start/All Programs/SQL Server/Configuration Tools/SQL Server Configuration Manager
	//			SQL Server Network Configuration
	//				Protocols for MSSQLServer
	//					TCP/IP -> Enabled
	//		Stop and restart the SQL Server Service (control panel/admin tools/services/SQL Server) for changes to take affect.
	//
	//	http://stackoverflow.com/questions/6662577/connect-sql-2008-r2-with-java-in-eclipse
	// -------------------------------------------------------------------------
	public static boolean OpenDatabaseConnectionSQLServer( )
	{
		boolean blnResult = false;
		
		try
		{
			SQLServerDataSource sdsTeamsAndPlayers = new SQLServerDataSource( );
			sdsTeamsAndPlayers.setServerName( "localhost" ); // or IP or server name
			sdsTeamsAndPlayers.setPortNumber( 1433 );
			sdsTeamsAndPlayers.setDatabaseName( "dbTeamsAndPlayers" );
			
			// Login Type:
			
				// Windows Integrated
				sdsTeamsAndPlayers.setIntegratedSecurity( true );
				
				// OR
				
				// SQL Server
				//sdsTeamsAndPlayers.setUser( "admin" );
				//sdsTeamsAndPlayers.setPassword( "***" );	// Empty string "" for blank password
			
			// Open a connection to the database
			m_conAdministrator = sdsTeamsAndPlayers.getConnection(  );
			
			// Success
			blnResult = true;
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );

			// Warn about SQL Server JDBC Drivers
			CMessageBox.Show( "Make sure you install the MS SQL Server JDBC drivers.",
							  "CDatabaseUtilities::OpenDatabaseConnectionSQLServer( )" );
		}
		
		return blnResult;
	}

	// ----------------------------------------------------------------------
	// Name: OpenDatabaseConnection
	// Abstract: Open a connection to the database
	//			The support for the JDBC-ODBC bridge has been removed from
	//			JDK1.8 and JRE8.
	//
	//			Use UCanAccess, an open-source JDBC driver, instead.
	//			Include the following jar files in your code:
	//				ucanaccess-2.0.7.jar
	//				jackcess-2.0.4.jar
	//					commons-lang-2.6.jar
	//					commons-logging-1.1.3.jar
	//				hsqldb.jar
	//
	//			To include those files select "Project / Properties / Java Build Path"
	//			from the menu.  Click on the "Libraries" tab.  Click "Add External JARs".
	//			Browse to the above jar files, which should be in a directory in your
	//			project (e.g. JDBC-to-MSAccess).  Select all five files and click
	//			"Open".  Click "OK".
	//
	//			You must also have either have MS Access 2010 install or download and
	//			install "Microsoft Access Database Engine 2010" which can be found 
	//			for free at:
	//
	//				https://www.microsoft.com/en-us/download/details.aspx?id=13255
	//
	//			Do not match to your operating system.  Download the version 
	//			(32 or 64 bit) that matches the version of your JRE.  
	// ----------------------------------------------------------------------	
	
	public static boolean OpenDatabaseConnection( )
	{
		boolean blnResult = false;
		
		try
		{
			String strConnectionString = "";

			// Server name/port, IP address/port or path for file based databases like MS Access
			// System.getProperty( "user.dir" ) => Current working directory from where
			// application was started
			strConnectionString = "jdbc:ucanaccess://" + System.getProperty( "user.dir" ) 
								+ "\\Database\\TeamsAndPlayers1.accdb";

			// Open a connection to the database
			m_conAdministrator = DriverManager.getConnection( strConnectionString );
			
			// Success
			blnResult = true;
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return blnResult;
	}
	
	
	// ----------------------------------------------------------------------
	// Name: CloseDatabaseConnection
	// Abstract: Close the connection to the database
	// ----------------------------------------------------------------------
	public static boolean CloseDatabaseConnection( )
	{
		boolean blnResult = false;
		
		try
		{
			// Is there a connection object?
			if( m_conAdministrator != null )
			{
				// Yes, close the connection if not closed already
				if( m_conAdministrator.isClosed( ) == false ) 
				{
					m_conAdministrator.close( );
					
					// Prevent JVM from crashing
					m_conAdministrator = null;
				}
			}
			
			// Success
			blnResult = true;
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return blnResult;
	}
	
	
	// ----------------------------------------------------------------------
	// Name: LoadListBoxFromDatabase
	// Abstract: Load the target listbox with all name column values from
	//			the specified table
	// ----------------------------------------------------------------------
	public static boolean LoadListBoxFromDatabase( String strTable, 
												   String strNameColumn, 
												   CListBox lstTarget )
	{
		boolean blnResult = false;
		
		try
		{
			String strSelect = "";
			Statement sqlCommand = null;
			ResultSet rstTSource = null;
			String strName = "";
			
			// Clear list
			lstTarget.Clear( );
			
			// Build the SQL string
			strSelect = "SELECT " + strNameColumn 
					  + " FROM " + strTable 
					  + " ORDER BY " + strNameColumn;

			// Retrieve the all the records
			sqlCommand = m_conAdministrator.createStatement( );
			rstTSource = sqlCommand.executeQuery( strSelect );

			// Loop through all the records
			while( rstTSource.next( ) == true )
			{
				// Get Name from current row, which should be the first, and only, column
				strName = rstTSource.getString( 1 );

				// Add the item to the list (0 = id, strTeam = text to display, false = don't select)
				lstTarget.AddItemToList( 0, strName, false );
			}
			
			// Clean up
			rstTSource.close( );
			sqlCommand.close( );

			// Success
			blnResult = true;
		}
		catch( Exception excError )
		{
			// Display Error Message
			CUtilities.WriteLog( excError );
		}
		
		return blnResult;
	}

}