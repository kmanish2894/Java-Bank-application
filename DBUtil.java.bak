import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.Date;
public class DBUtil 
{
	static PreparedStatement createtable,insertstmt,deletestmt,updatestmt,selectstmt,inserttran;
	static Statement st,st1,print;
	static Connection conn;
	static String query,update;
	static Properties props;
	static
	{
		props=new Properties();
		String driverclass,url,username,password;
		try
		{
			props.load(new FileReader("DB.properties"));
			driverclass=props.getProperty("driver");
			url=props.getProperty("url");
			username=props.getProperty("username");
			password=props.getProperty("password");
			Class.forName(driverclass);
			conn=DriverManager.getConnection(url,username,password);
			st=conn.createStatement();
			st1=conn.createStatement();
			print=conn.createStatement();
			insertstmt=conn.prepareStatement("insert into account (accno,fname,lname,city,pin,amount) values(?,?,?,?,?,?)");
			inserttran=conn.prepareStatement("insert into transaction (accno,type,date,amount,balance,decide) values(?,?,?,?,?,?)");
			deletestmt=conn.prepareStatement("delete from account where accno=?");
			updatestmt=conn.prepareStatement("update account set amount=? where accno=?");
		//	selectstmt=conn.prepareStatement("select * from...");
		//	update="create table account(accno int(10),fname varchar(10),lname varchar(20),city varchar(10),pin int(10),amount decimal(10,2))";
		//	int t=st.executeUpdate(update);
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
	public static void storeAccount(Account acct)
	{
		try
		{
			insertstmt.setInt(1,acct.getAccNo());
			insertstmt.setString(2,acct.fname);
			insertstmt.setString(3,acct.lname);
			insertstmt.setString(4,acct.city);
			insertstmt.setInt(5,acct.pin);
			insertstmt.setFloat(6,acct.amount);
			insertstmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.getMessage();
		}
	}
	public static void closeAccount(int accno)
	{
		try
		{
			deletestmt.setInt(1,accno);
			deletestmt.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	public static float withdraw(int accno,float withdraw)
	{
		ResultSet rs=null;
		float amt=0;
		query="select amount from account where accno="+accno;
		try
		{
			rs=st.executeQuery(query);
			rs.next();//opens the resultset
			amt=rs.getFloat(1);
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		//System.out.println(amt);
		amt=amt-withdraw;
		try
		{
			updatestmt.setFloat(1,amt);
			updatestmt.setInt(2,accno);
			updatestmt.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return amt;
	}
	public static float deposit(int accno,float deposit)
	{
		ResultSet rs=null;
		float amt=0;
		query="select amount from account where accno="+accno;
		try
		{
			rs=st1.executeQuery(query);
			rs.next();//opens the resultset
			amt=rs.getFloat(1);
			System.out.println(amt);
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		amt=amt+deposit;
		System.out.println(amt);
		try
		{
			updatestmt.setFloat(1,amt);
			updatestmt.setInt(2,accno);
			updatestmt.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return amt;
	}
	public static void enterTransaction(int accno,Transaction t)
	{
		//System.out.println("enter trans");
		try
		{
					//System.out.println("enter trans try block");
			inserttran.setInt(1,accno);
			inserttran.setString(2,t.getType());
			inserttran.setString(3,null);
			inserttran.setFloat(4,t.getAmount());
			inserttran.setFloat(5,t.getBalance());
			inserttran.setFloat(6,t.getTypeamount());
			inserttran.executeUpdate();
					//System.out.println("after execute updat");
		}
		catch (SQLException e)
		{
					//System.out.println("enter trans exception");
					e.printStackTrace();
		}
	}
	public static void printTran(int accno)
	{
		ResultSet rs=null;
		try
		{
			rs=print.executeQuery("select * from transaction where accno="+accno);
			System.out.println("Recent Transactions");
			System.out.println("Accno Type Date Amount Balance Amount");
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getString(3)+" ");
				System.out.print(rs.getFloat(4)+" ");
				System.out.print(rs.getFloat(5)+" ");
				System.out.println(rs.getFloat(6));
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
