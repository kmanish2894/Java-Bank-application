import java.io.*;
import java.util.*;
import java.sql.*;
public class ConnPool  
{
	
	static
	{
		Vector<Connection> connections=new Vector<Connection>();
		Properties props=new Properties();
		try
		{
			props.load(new FileReader("DB.properties"));
			String driverclass=props.getProperty("driver");
			String username=props.getProperty("username");
			String password=props.getProperty("password");
			String url=props.getProperty("url");
			Class.forName(driverclass);
			for(int i=0;i<5;i++)
			{
				connections.add(DriverManager.getConnection(url,username,password));
			}
		}
		catch (FileNotFoundException e)
		{
			e.getMessage();
		}
		catch (IOException e)
		{
			e.getMessage();
		}
		catch (SQLException e)
		{
			e.getMessage();
		}
		catch (ClassNotFoundException e)
		{
			e.getMessage();
		}
	}
			
}
