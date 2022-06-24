package atmprocess;

public class ATMDrive
{
	    ATM atm=ATM.OPERATEATM;
           
	    private FileStorage callFile=new FileStorage();
	    
	    ATMManagement callCache=new ATMManagement();
	    
	    
	    
	    private void nullCheck(Object object,String value)throws CustomException
	    {
	    	   if( object==null )
	    	   {
	    		   throw new CustomException(value +" is Wrong");
	    	   }
	    }
	    
	    
	
	    public void feedMoneyToATM(int countOf2000,int countOf500,int countOf100)
	    {	              
	             atm.setNoOf2000(countOf2000);
	             atm.setNoOf500(countOf500);
	             atm.setNoOf100(countOf100);	             
	             callFile.writeATMFile(atm);           
	    }
	    
	    public void addCustomer(Customer customer)
	    {
	    	     callCache.addCustomer(customer);
	    	     callFile.addCustomer( callCache.getCustomersMap() );
	    }
	    
	    public boolean isCusFileExist()
	    {
	    	return callFile.isCusFileExist();
	    }
	    
	    public Customer getCustomer(long accNo)throws CustomException 
	    {
	    	Customer customer=callCache.getCustomer(accNo);
	    	nullCheck(customer,"Account");
	    	return customer;
	    }
	    
	    public String getCusDetails()
	    {
	    	return callFile.getCustomerFile();
	    }
	    
	    public String getATMBalance()
	    {
	    	return callFile.getATMFile();
	    }
	    
	    
	    public boolean isAccHere(long accountNo,int pinNo) throws CustomException
	    {
	    	  if( getCustomer(accountNo).getPinNumber() == pinNo )
	    	  {
	    		  return true;
	    	  }
	    	  
	    	  return false;
	    }
	    
	    
	    public boolean isValidAmount(int amount,long accountNo) throws CustomException
	    {
	    	if( amount<100 && amount>10000 )
	    	{
	    		throw new CustomException( "Amount limit should between 100 and 10000..!" );
	    	}
	    	
	    	if( getCustomer(accountNo).getAccountBalance() < amount )
	    	{
	    		throw new CustomException( "Amount limit exceed..!" );
	    	}
	    	
	    	if( amount%100!=0 )
	    	{
	    		throw new CustomException( "Amount should only multiples of 2000,500 & 100" );
	    	}
	    	
	    	return true;
	    }
	   
	
	    public ATMDrive()
	    {
	    	     callCache.setCustomersMap( callFile.readCustomerFile() );
	    	   
	    	     atm=callFile.readATMFile();
	    }
	
	    
}
