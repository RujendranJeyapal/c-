package atmprocess;

public class Transaction 
{
       private int accountNo;
       private int transactionNumber;
       private String transactionType;
       private double amount;
       private double closingBalance;
       
       
	   public Transaction(int accountNo, int transactionNumber, String transactionType, 
			   double amount,
			double closingBalance) 
	   {
	
		this.accountNo = accountNo;
		this.transactionNumber = transactionNumber;
		this.transactionType = transactionType;
		this.amount = amount;
		this.closingBalance = closingBalance;
		
	   }


	   public int getAccountNo() 
	   {
		  return accountNo;
	   }


	   public int getTransactionNumber() 
	   {
		   return transactionNumber;
	   }


	   public String getTransactionType() 
	   {
		   return transactionType;
	   }


       public double getAmount() 
       {
		   return amount;
	   }


	   public double getClosingBalance() 
	   {
		   return closingBalance;
	   }
	   
	   
       
       
       
       
       
}
