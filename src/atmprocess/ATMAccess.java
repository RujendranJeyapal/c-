package atmprocess;


import java.util.InputMismatchException;

import java.util.Scanner;

public class ATMAccess 
{

	public static void main(String[] args) 
	{
		Scanner input=new Scanner( System.in );
		
		
        ATMDrive callDrive=new ATMDrive();
        
      
       
        
        
        boolean condition=true;
        
        while( condition )
        {
		System.out.println("Press 1-->Load Cash to ATM\n"
				         + "Press 2-->Show Customer Details\n"
				         + "Press 3-->Show ATM operations");

		
		int choice=0;
		
		try
		{
		         choice=input.nextInt();
		}
		catch(InputMismatchException ex)
		{
			     System.out.println("Enter Number Only...!");
		}
		
		
		           switch( choice )
	               {
		           
		           case 1:
		               
		        	   try
		        	   {
		        	       
		    	           System.out.println("Enter No of 2000's");
		    	           int countOf2000=input.nextInt();
		    	
		    	           System.out.println("Enter No of 500's");
		    	           int countOf500=input.nextInt();
		    	
		    	           System.out.println("Enter No of 100's");
		    	           int countOf100=input.nextInt();
		    	
		    	           callDrive.feedMoneyToATM(countOf2000, countOf500, countOf100);		    	           		    	    
		        	   }
		        	   catch(InputMismatchException ex)
		       		   {
		       			    System.out.println("Enter Number Only...!");
		       		   }
		        	   
		    	           break;
		    	           
		           case 2:
		        	         
		        	       if( !callDrive.isCusFileExist() )   
		        	       {
		        	   
		        	             Customer customer1=new Customer( "Suresh",101,2543,25234 );
		               
		                         Customer customer2=new Customer( "Ganesh",102,5432,34123 );
		               
		                         Customer customer3=new Customer( "Magesh",103,7854,26100  );
		               
		                         Customer customer4=new Customer( "Naresh",104,2345,80000 );
		               
		                         Customer customer5=new Customer( "Harish",105,1907,103401 );
		        
		                         callDrive.addCustomer(customer1);
		                         callDrive.addCustomer(customer2);
		                         callDrive.addCustomer(customer3);
		                         callDrive.addCustomer(customer4);
		                         callDrive.addCustomer(customer5);
		                   
		        	       }
		        	      
		        	       System.out.println( callDrive.getCusDetails() );
		        	      
		        	      
		        	       break;
		        	      
		        	      
		           case 3:
		        	   
		        	       ATMAccess callMine=new ATMAccess();
		        	       
		        	       try
		        	       {
		        	          System.out.println("Enter your Account Number");
		        	          long accountNo=input.nextLong();
		        	       
		        	          System.out.println("Enter your 4 Dight PIN number");
		        	          int pinNo=input.nextInt();
		        	          
	                 	      if( callDrive.isAccHere(accountNo, pinNo) )
	                 	      {
		        	               callMine.handleATMProcess(input,callDrive,accountNo,pinNo);
	                 	      }
	                 	      else
	                 	      {
	                 	    	   System.out.println(" Your PINNumber is wrong ");
	                 	      }
		        	       }
		        	       catch( InputMismatchException ex )
		        		   {
		        				System.out.println("Enter Number Only...!");
		        		   }
		        	       catch( CustomException ex )
		        	       {
		        	    	    System.out.println( ex.getMessage() );
		        	       }
		        	   
		        	       break;
		    	
		    	   default:
		    		       
		    		       condition=false;
		    		       break;
		    	
		    	
		}
		
		
		           
        }          
	}
	
	void handleATMProcess(Scanner input,ATMDrive callDrive,long accountNo,int pinNo)
	{
		    boolean condition=true;
		    
		    while( condition )
		    {
		                 System.out.println("Press 1-->Check Balance\n"
		                                  + "Press 2-->Withdraw Money\n"
		                                  + "Press 3-->Transfer Money\n"
		                                  + "Press 4-->Check ATM Balance\n"
		                                  + "Press 5-->Ministatement");
		                 
		                 int choice=0;
		                 
		                 try
		                 {
		                    choice=input.nextInt();
		                 }
		                 catch(InputMismatchException ex)
		         		 {
		         			System.out.println("Enter Number Only...!");
		         		 }
		                 
		         switch( choice )
		         {
		         
		           case 1:
		        	      
		        	     try
		        	     {
		        	         System.out.println("Balance :"+callDrive.getCustomer(accountNo).getAccountBalance() );
		        	     }
		        	     catch( CustomException ex )
		        	     {
		        	    	 System.out.println( ex.getMessage() );
		        	     }
		        	   
		        	     break;
		        	     
		        	     
		           case 2:
		        	   
		        	        System.out.println("Enter the amount to withdrawn(Amount should be above 100 and below 10000)");
		        	        int amount=input.nextInt();
		        	   
		        	     break;
		        	     
		        	     
		           case 3:
		        	   
		        	     break;
		        	     
		           case 4:
		        	   
		        	         System.out.println( callDrive.getATMBalance() );
		        	     break;
		        	     
		           default:
		        	     
                         condition=false;
                         break;
                         
		         }
		                 
		    }    
	}
	

}
