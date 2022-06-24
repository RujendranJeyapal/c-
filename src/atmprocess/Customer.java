package atmprocess;

public class Customer 
{
      private String accountHolderName;
      private long accountNumber;
      private int pinNumber;
      private double accountBalance;
      
      
	    public Customer(String accountHolderName, long accountNumber, int pinNumber, double accountBalance) 
	    {
	
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.pinNumber = pinNumber;
		this.accountBalance = accountBalance;
		
	    }
	    
	    


		public void setAccountBalance(double accountBalance) 
		{
			this.accountBalance = accountBalance;
		}




		public String getAccountHolderName() 
		{
			return accountHolderName;
		}


		public long getAccountNumber() 
		{
			return accountNumber;
		}


		public int getPinNumber() 
		{
			return pinNumber;
		}


		public double getAccountBalance()
		{
			return accountBalance;
		}


		
		public String toString() 
		{
			return "[AccountHolderName=" + accountHolderName + ", AccountNumber=" + accountNumber
					+ ", PinNumber=" + pinNumber + ", AccountBalance=" + accountBalance + "]";
		}
		
		
	    
	    
	    
      
      
      
}
