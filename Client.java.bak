import java.io.*;
import java.util.*;
import java.sql.*;
public class Client 
{
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");
		BankInterface bank=new KmitBank();
		
		while(true)
		{
			System.out.println("1. Open Account");
			System.out.println("2. Close Account");
			System.out.println("3. Withdraw Amount");
			System.out.println("4. Deposit");
			System.out.println("5. Print 10 Transactions");

			int choice=scan.nextInt();
			switch(choice)
			{
				case 1:
				{
					System.out.println("P1. enter first name");
					String fname=scan.next();
					System.out.println("P1. enter last name");
					String lname=scan.next();
					System.out.println("P1. enter your city");
					String city=scan.next();
					System.out.println("P1. enter pin");
					int pin=scan.nextInt();
					System.out.println("P1. enter amount");
					float amount=scan.nextFloat();
					try
					{
						int accNo=bank.openAccount(fname,lname,city,pin,amount);
					}
					catch (InvalidAmountException e)
					{
						System.out.println("Invalid Amount");
					}
					break;
				}
				case 2:
				{
					System.out.println("P1. enter account number");
					int accdel=scan.nextInt();
					try
					{
						bank.closeAccount(accdel);
					}
					catch (InvalidAccountException e)
					{
						System.out.println("Invalid Account");
					}
					break;
				}
				case 3:
				{
					System.out.println("Enter account number");
					int acno=scan.nextInt();
					System.out.println("Enter Amount to be Withdrawn");
					float withdraw=scan.nextFloat();
					try
					{
						if(withdraw<0)
						throw new InvalidAmountException(withdraw);
					}
					catch (InvalidAmountException e)
					{
						System.out.println(e.getMessage());
					}
					
					float amt=0;
					try
					{
						amt=bank.withdraw(acno,withdraw);
					}
					catch (InvalidAmountException e)
					{
						System.out.println(e.getMessage());
					}
					catch (InvalidAccountException e)
					{
						System.out.println(e.getMessage());
					}
					System.out.println("Balance Remaining : "+amt);

					break;
				}
				case 4:
				{
					System.out.println("Enter account number");
					int acno=scan.nextInt();
					System.out.println("Enter Amount to be Deposited");
					float deposit=scan.nextFloat();
					try
					{
						if(deposit<0)
						throw new InvalidAmountException(deposit);
					}
					catch (InvalidAmountException e)
					{
						System.out.println(e.getMessage());
					}
					
					float amt=0;
					try
					{
						amt=bank.deposit(acno,deposit);
					}
					catch (InvalidAmountException e)
					{
						System.out.println(e.getMessage());
					}
					catch (InvalidAccountException e)
					{
						System.out.println(e.getMessage());
					}
					System.out.println("Balance Remaining : "+amt);
					break;
				}
				case 5:
				{
					System.out.println("Enter account number");
					int ac=scan.nextInt();
					try
					{
						bank.printTransactions(ac);
					}
					catch (InvalidAccountException e)
					{
						System.out.println("Invalid Account");
					}
					
			//			void printTransactions(int accNo) throws InvalidAccountException;
					break;
				}
			}
		}
	}
}
