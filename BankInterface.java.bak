interface BankInterface
{
	//returns account number
	public int openAccount(String fname,String lname,String city,int pin,float amount) throws InvalidAmountException;
	public float withdraw(int accNo,float amount) throws InvalidAmountException,InvalidAccountException;
	public float deposit(int accNo,float amount) throws InvalidAmountException,InvalidAccountException;
	void printTransactions(int accNo) throws InvalidAccountException;
	public void closeAccount(int accNo) throws InvalidAccountException;
}
