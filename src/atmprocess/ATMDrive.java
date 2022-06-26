package atmprocess;

import java.util.List;

public class ATMDrive
{
	    ATM atm=ATM.OPERATEATM;
           
	    private FileStorage callFile=new FileStorage();
	    
	    ATMManagement callCache=new ATMManagement();
	    private int transactionNo;
	    
	    
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
	    	nullCheck(customer,"Account Number");
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
	    
	    
	    public boolean pinNumberCheck(long accountNo,int pinNo) throws CustomException
	    {
	    	  if( getCustomer(accountNo).getPinNumber() == pinNo )
	    	  {
	    		  return true;
	    	  }
	    	  
	    	  return false;
	    }
	    
	    public boolean isValidAmountForTransaction(int amount,long accountNo) throws CustomException
	    {
	    	if( amount<100 || amount>10000 )
	    	{
	    		throw new CustomException( "Amount limit should between 100 and 10000..!" );
	    	}
	    	
	    	if( getCustomer(accountNo).getAccountBalance() < amount )
	    	{
	    		throw new CustomException( "Amount limit exceed..!" );
	    	}
	    	
	    	return true;
	    }
	    		    
	    
	    public boolean isValidAmount(int amount,long accountNo) throws CustomException
	    {
	    	isValidAmountForTransaction(amount,accountNo);
	    	
	    	if( amount%100!=0 )
	    	{
	    		throw new CustomException( "Amount should only multiples of 2000,500 & 100" );
	    	}
	    	
	    	return true;
	    }
	    
	    public boolean transferMoney(double amount,long fromAccNo,long toAccNo) throws CustomException
	    {
	    	
	    	if( fromAccNo==toAccNo )
	    	{
	    		throw new CustomException( "Don't self Transfer" );
	    	}
	    	
	    	Customer sender=getCustomer( fromAccNo );
	    	Customer receiver=getCustomer( toAccNo );
	    	
	    	sender.setAccountBalance( sender.getAccountBalance()-amount );
	    	receiver.setAccountBalance( receiver.getAccountBalance()+amount );
	    	
	    	addCustomer( sender );
	    	addCustomer( receiver );
	    	
	    	Transaction senderTrans=new Transaction( fromAccNo,transactionNo++,"Transfer to "+toAccNo,"Debit",amount,sender.getAccountBalance() );
	    	Transaction receiverTrans=new Transaction( toAccNo,transactionNo++,"Transfer from "+fromAccNo,"Credit",amount,receiver.getAccountBalance() );
	    	
	    	callFile.addTransaction(senderTrans);
	        callFile.addTransaction(receiverTrans);
	        
	        return true;
	    	
	    }
	   
	
	    public ATMDrive()
	    {
	    	     callCache.setCustomersMap( callFile.readCustomerFile() );
	    	   
	    	     atm=callFile.readATMFile();
	    	     
	    	     transactionNo=callFile.readTransNumber();
	    }
	    
	    
	    public List<String> getTranasaction(long accountNo) throws CustomException
	    {
	    	  getCustomer(accountNo);
	    	  
	    	  return callFile.readTransaction(accountNo);
	    }
	
	    
}
