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
	    
	    private boolean ATMCheck( int noOf2000,int noOf500,int noOf100 ) throws CustomException
	    {  
	    	
	    	if( noOf2000>atm.getNoOf2000()  || noOf500>atm.getNoOf500()  || noOf100>atm.getNoOf100() )
	    	{
	    		      throw new CustomException( "ATM has no money" );
	    	}
	    	
	    	
	    	return true;
	    }
	    
	    public boolean withDrawMoney(double amount,long accNo) throws CustomException
	    {
	    	
	    	  if( amount<=5000 )
	    	  {
	    		  withDrawGreaterThan5000(amount,accNo);
	    	  }
	    	  
	    	  else
	    	  {
	    		  withDrawLessThan5000(amount,accNo);
	    	  }
	    	
	    	  return true;
	    }
	    
	    
	    private boolean withDrawLessThan5000(double amount,long accNo) throws CustomException
	    {
	    	int noOf2000=0;
	    	int noOf500=0;
	    	int noOf100=0;
	    	
	    	double temp=amount;
	    	
	    	
	    	if( temp>5000 )
	    	{
	    		  
	    		for( int i=0;i<2;i++ )
	    		{
	    			++noOf2000;
	    			temp-=2000;
	    		}
	    		
	    		for( int i=0;i<2;i++ )
	    		{
	    			++noOf500;
	    			temp-=500;
	    		}
	    		
	    		for( int i=0;i<10;i++ )
	    		{
	    			++noOf100;
	    			temp-=100;
	    			
	    			  if( temp==0 )
	    			  {
	    				  break;
	    			  }
	    			
	    		}		
	    		
	    		
	    		while(  temp>0 )
	    		{
	    			
	    			 ++noOf500;  
	    			temp-=500;
	    		}
	    			
	    	    ATMCheck( noOf2000,noOf500,noOf100 );
   		       
   		        Customer customer=getCustomer( accNo );
   		       
   		        customer.setAccountBalance( customer.getAccountBalance()-amount  );
   		       
   		        addCustomer( customer );
   		       
   		        feedMoneyToATM( -noOf2000, -noOf500, -noOf100);
   		        
   		        Transaction transaction=new Transaction( accNo,transactionNo++,"Cash Withdrawal","Debit",amount,customer.getAccountBalance() );
   		        
   		        callFile.addTransaction(transaction);
	    		
	    	}
	    	
	    	    return true;
	    	
	    	
	    }
	    
	    private boolean withDrawGreaterThan5000(double amount,long accNo) throws CustomException
	    {
	    	int noOf2000=0;
	    	int noOf500=0;
	    	int noOf100=0;
	    	
	    	double temp=amount;
	    	
	    	   if( temp<=5000 )
	    	   {
	    		       while(  temp>3000 )
	    		       {
	    		    	    ++noOf2000;
	    		    	    temp-=2000;
	    		       }
	    		       
	    		       while( temp>1000 )
	    		       {
	    		    	   ++noOf500;
	    		    	   temp-=500;
	    		       }
	    		       
	    		       while( temp>0 )
	    		       {
	    		    	   ++noOf100;
	    		    	   temp-=100;
	    		       }
	    		    
	    		       
	    		       ATMCheck( noOf2000,noOf500,noOf100 );
	    		       
	    		       Customer customer=getCustomer( accNo );
	    		       
	    		       customer.setAccountBalance( customer.getAccountBalance()-amount  );
	    		       
	    		       addCustomer( customer );
	    		       
	    		       feedMoneyToATM( -noOf2000, -noOf500, -noOf100);
	    		       
	    		       Transaction transaction=new Transaction( accNo,transactionNo++,"Cash Withdrawal","Debit",amount,customer.getAccountBalance() );
	      		        
	      		       callFile.addTransaction(transaction);
	    		       
	    		   
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
