import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.Date;
class Account 
{
	int pin,accNo=1000;
	String fname,lname,city;
	float amount;
	TreeSet<Transaction> transactions=null;
	//	Account(String fname,String lname,String city,int pin,float amount)
	Account(String fname,String lname,String city,int pin,float amount)
	{
		this.fname=fname;
		this.lname=lname;
		this.city=city;
		this.pin=pin;
		this.amount=amount;
		transactions=new TreeSet<Transaction>();
	}
	public void setTransactionW(String type,Date date,float balance,float withdraw)
	{
		Transaction t=new Transaction(type,date,balance,withdraw);
		t.amount=balance+withdraw;
		transactions.add(t);
		System.out.println(this.accNo);
		t.setType(type);
		t.setBalance(balance);
		t.setAmount(t.amount);
		DBUtil.enterTransaction(this.accNo,t);
	}
	public void setTransactionD(String type,Date date,float balance,float deposit)
	{
		Transaction t=new Transaction(type,date,balance,deposit);
		//Transaction t=new Transaction();
		t.amount=balance-deposit;
		transactions.add(t);
		//System.out.println(this.accNo);
		t.setType(type);
		t.setBalance(balance);
		t.setAmount(t.amount);
		DBUtil.enterTransaction(this.accNo,t);
	}
	public int hashCode()
	{
		return accNo;
	}
	public boolean equals(Object obj)
	{
		if(obj instanceof Account)
		{
			Account acct=(Account)obj;
			if(this.accNo==acct.accNo)
			return true;
		}
			return false;
	}
	public String toString()
	{
		return fname+" "+lname+" "+city+" "+pin+" "+amount;
	}
	public int getAccNo()
	{
		return accNo;
	}
}
