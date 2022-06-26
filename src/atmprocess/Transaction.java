package atmprocess;

public class Transaction 
{
       private long accountNo;
       private int transactionNumber;
       private String description;
       private String transactionType;
       private double amount;
       private double closingBalance;
       
       
	   public Transaction(long accountNo, int transactionNumber, String description , String transactionType, 
			   double amount,
			double closingBalance) 
	   {
	
		this.accountNo = accountNo;
		this.transactionNumber = transactionNumber;
		this.description=description;
		this.transactionType = transactionType;
		this.amount = amount;
		this.closingBalance = closingBalance;
		
	   }


	   public long getAccountNo() 
	   {
		  return accountNo;
	   }


	   public int getTransactionNumber() 
	   {
		   return transactionNumber;
	   }

	   public String getDescription()
	   {
		   return description;
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
