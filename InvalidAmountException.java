import java.io.*;
import java.util.*;
import java.sql.*;
class InvalidAmountException  extends Exception 
{
	float amount=0;
	public InvalidAmountException(float amount)
	{
		this.amount=amount;
	}
	public String toString()
	{
		return "Amount must be a positive number !negative like"+amount;
	}
}
class InvalidAccountException  extends Exception 
{
	public InvalidAccountException()
	{
		System.out.println("Invalid Account");
	}
	public String toString()
	{
		return "Amount must be a valid";
	}
}
