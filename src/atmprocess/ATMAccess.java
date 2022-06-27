package atmprocess;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ATMAccess 
{

	public static void main(String[] args) 
	{
		Scanner input=new Scanner( System.in );
		
		
        ATMDrive callDrive=new ATMDrive();
        
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
		        	          
	                 	      if( callDrive.pinNumberCheck(accountNo, pinNo) )
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
		        	     try 
		        	     {
		        	        System.out.println("Enter the amount to withdrawn(Amount should be above 100 and below 10000)");
		        	        int amount=input.nextInt(); 
					
						    if( callDrive.isValidAmount(amount, accountNo) && callDrive.withDrawMoney(amount, accountNo) )
						    {
							        System.out.println("WithDraw Amount Successfully");
						    }
					     }		        	     
		        	     catch (CustomException ex) 
		        	     {
						    System.out.println( ex.getMessage() );
					     }
		        	     catch(InputMismatchException ex)
		         		 {
		         			System.out.println("Enter Number Only...!");
		         		 }
		        	   
		        	     break;
		        	     
		        	     
		           case 3:
		        	     
		        	     try
		                 {
		        	     System.out.println("Enter the Transfer Account Number");
		        	     long receiverAccNo=input.nextLong();
		        	     
		        	     System.out.println("Enter the amount");
		        	     int amount=input.nextInt();
		        	     
		        	     if( callDrive.isValidAmountForTransaction(amount, accountNo) && callDrive.transferMoney(amount, accountNo, receiverAccNo) )
		        	     {
		        	    	 System.out.println("Amount Transfer Successfully");
		        	     }
		        	     
		                 }
		        	     catch (CustomException ex) 
		        	     {
						    System.out.println( ex.getMessage() );
					     }
		        	     catch(InputMismatchException ex)
		         		 {
		         			System.out.println("Enter Number Only...!");
		         		 }
 		        	     
		        	     break;
		        	     
		           case 4:
		        	   
		        	         System.out.println( callDrive.getATMBalance() );
		        	     break;
		        	     
		           case 5:
		        	   
					    try 
					    {
						    List< String > transList= callDrive.getTranasaction(accountNo);
						    
						   
						    
						    int size=transList.size();
						    
						   
						    
						    if( transList.isEmpty() )
						    {
						    	System.out.println("No Transaction");
						    }
						    
						    
						    
						    else if( size<=10 )
						    {
						    	 System.out.println("Transaction Number\t\t\tDescription\t\t\tTransaction Type\t\t\tAmount\t\t\tClosing Balance");
						    	   for( int i=0;i<size;i++ )
						    	   {
						    		   System.out.println( transList.get(i) );
						    	   }
						    }
						    
						    else
						    {
						    	
						    	 System.out.println("Transaction Number\t\t\tDescription\t\t\tTransaction Type\t\t\tAmount\t\t\tClosing Balance");
						    	   for( int i=size-10;i<size;i++ )
						    	   {
						    		   System.out.println( transList.get(i) );
						    	   }
						    	   
						    	      
						    }
						    
						    
					    }
					    catch (CustomException ex) 
					    {
						    System.out.println( ex.getMessage() );
					    }
					    break;
		        	     
		           default:
		        	     
                       
                         break;
                         
		         
		                 
		    }    
	}
	

}
