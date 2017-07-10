import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.Date;
class KmitBank implements BankInterface 
{
	Set<Account> accounts=new HashSet<Account>();
	int accounter=1;
	public int openAccount(String fname,String lname,String city,int pin,float amount) throws InvalidAmountException
	{
		if(amount < 0.0f)
		{
			throw new InvalidAmountException(amount);
		}
	//	System.out.println("hello zensar");
		Account acct=new Account(fname,lname,city,pin,amount);
		acct.accNo+=accounter++;
		accounts.add(acct);
		//System.out.println(accounts);
		//return acct.accNo;
		DBUtil.storeAccount(acct);
		return 0;
	}
	public void closeAccount(int accno) throws InvalidAccountException
	{
		for(Account check:accounts)
		{
			if(check.hashCode()==accno)
			{
				accounts.remove(check);
				break;
			}
		}
		System.out.println(accounts);
		DBUtil.closeAccount(accno);
	}
	public float withdraw(int accno,float withdraw) throws InvalidAmountException,InvalidAccountException
	{
		float balance=DBUtil.withdraw(accno,withdraw);
		Iterator<Account> it=accounts.iterator();
		while(it.hasNext())
		{
			Account check=(Account)it.next();
			int v=check.accNo;
			if(accno==v)
			{
				try
				{
					if((check.amount)<withdraw)
						throw new InvalidAmountException(withdraw);
				}
				catch (InvalidAmountException e)
				{
					System.out.println("Invalid Amount");
				}
				Date d=new Date();
				check.amount=balance;
				check.setTransactionW("withdraw",d,balance,withdraw);
				break;
			}
		}
		return balance;
	}
	public float deposit(int accno,float deposit) throws InvalidAmountException,InvalidAccountException
	{
		float balance=DBUtil.deposit(accno,deposit);
		System.out.println(balance+"hello djnj");
		Iterator<Account> it=accounts.iterator();
		while(it.hasNext())
		{
			Account check=(Account)it.next();
			int v=check.accNo;
			if(accno==v)
			{
				Date d=new Date();
				check.amount=balance;
				check.setTransactionD("deposit",d,balance,deposit);
				break;
			}
		}
		return balance;
	}
	public void printTransactions(int accNo) throws InvalidAccountException
	{
		DBUtil.printTran(accNo);
	}
}
