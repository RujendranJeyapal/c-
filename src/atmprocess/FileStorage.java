package atmprocess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileStorage 
{
     
	  private File atmFile=new File("ATM.txt");
	  private File customerFile=new File( "Customer.txt" );
	  private File transactionNoFile=new File("LastTransactionNumber.txt");
	  
	  public void writeATMFile(ATM atm)
	  {
		     try
		     (
		         FileWriter write=new FileWriter(atmFile);
		         BufferedWriter buffer=new BufferedWriter(write);
		     )
		     {
		    	 buffer.write("Denomination\t\t\tNumber\t\t\t\tValue\n");    
		    	 buffer.write("2000\t\t\t\t"+atm.getNoOf2000()+"\t\t\t\t"+2000*atm.getNoOf2000()+"\n");
		    	 buffer.write("500\t\t\t\t"+atm.getNoOf500()+"\t\t\t\t"+500*atm.getNoOf500()+"\n");
		    	 buffer.write("100\t\t\t\t"+atm.getNoOf100()+"\t\t\t\t"+100*atm.getNoOf100()+"\n\n\n");
		    	 buffer.write("Total Amount available in the ATM=Rs."+atm.getTotal());
		     }
		     catch( IOException ex )
		     {
		    	 ex.printStackTrace();
		     }
		         
	  }
	  
	  
	  
	  public ATM readATMFile()
	  {
		     ATM atm=ATM.OPERATEATM;
		  
		  if( atmFile.exists() )   
		  {   
		     try
		     (
		         FileReader reader=new FileReader(atmFile);
		         BufferedReader buffer=new BufferedReader(reader);
		     )
		     {
		    	   String temp=buffer.readLine();
		    	   
		    	   temp=buffer.readLine();

                   for( int i=0;i<3;i++ )
                   {
                	    String array[]=temp.split("\t\t\t\t");   
                	    
                	    if( i==0 )
                	    {
                	    	atm.setNoOf2000( Integer.parseInt( array[1] ) );
                	    }
                	    
                	    if( i==1 )
                	    {
                	    	atm.setNoOf500( Integer.parseInt( array[1] ) );
                	    }
                	    
                	    if( i==2 )
                	    {
                	    	atm.setNoOf100( Integer.parseInt( array[1] ) );
                	    }
                	    
                	    temp=buffer.readLine();
                	    
                   }
                   
                   
                   
		      }
		      catch( IOException ex )
		      {
		    	   ex.printStackTrace();
		      }
		   } 
		     
		     return atm;
	  }
	  
	  public void createTransFile(File transFile)
	  {
		  try
		  {
		      if( !transFile.exists() )
		      {
			       transFile.createNewFile();
			       
			       FileWriter writer= new FileWriter( transFile );
			       writer.write("Transaction Number\t\t\tDescription\t\t\tTransaction Type\t\t\tAmount\t\t\tClosing Balance\n");
			       writer.close();
		      }
		  }
		  catch( IOException ex )
	      {
	    	   ex.printStackTrace();
	      }
		
	  }
	  
	  public void addTransaction(List<Transaction> transactionList)
	  {
		  
		  for( int i=0;i<transactionList.size();i++ )
		  {
			   Transaction transaction=transactionList.get(i);
			  
		       File transFile=new File( transaction.getAccountNo()+".txt" );
		       createTransFile(transFile);
		  
		       try
		       (
			        FileWriter write=new FileWriter(transFile,true);	 
			        BufferedWriter buffer=new BufferedWriter( write );  
		       )
		       {
		               buffer.append(transaction.getTransactionNumber()+"\t\t\t\t"+
		                         transaction.getDescription()+"\t\t\t\t"+
		    		             transaction.getTransactionType()+"\t\t\t\t"+
		                         transaction.getAmount()+"\t\t\t\t"+
		    		             transaction.getClosingBalance()+"\n");
		   
		                storeTransNumber( transaction.getTransactionNumber() );
		       }
		       catch( IOException ex )
	           {
	    	         ex.printStackTrace();
	           }
		  }
	  }
	  
	  public void addCustomer(Map<Long,Customer> customerInfo)
	  {
		      try 
		      (       	     			    	
				 FileWriter writer=new FileWriter( customerFile );
		         BufferedWriter buffer=new BufferedWriter( writer );
			  )	 
		      {
				 buffer.write("AccountNumber\t\t\tName\t\t\t\tPin Number\t\t\tAccountBalance\n");
				 
				 for( Long key:customerInfo.keySet() )
				 {
					   Customer customer=customerInfo.get(key);
					   
					   buffer.write(customer.getAccountNumber()+"\t\t\t\t"
					               +customer.getAccountHolderName()+"\t\t\t\t"
							       +customer.getPinNumber()+"\t\t\t\t"
					               +customer.getAccountBalance()+"\n");
				 }
				 
				 
			  }
		      catch (IOException e) 
		      {
					
					e.printStackTrace();
			  }
		     
	  }
	  
	  public Map<Long,Customer> readCustomerFile()
	  {
		     Map<Long,Customer> customersMap=new HashMap<>();
		     
		     if( isCusFileExist() )
		     {
		    	    try
		    	    (
		    	    		FileReader reader=new FileReader(customerFile);
		    	    		BufferedReader buffer=new BufferedReader(reader);
		    	    )
		    	    {
		    	    	   String temp=buffer.readLine();
		    	    	   
		    	    	         temp=buffer.readLine();
		    	    	         
		    	    	        while( temp!=null )
		    	    	        {
		    	    	        	     String array[]=temp.split("\t\t\t\t");
		    	    	        	     Customer customer=new Customer( array[1],Long.parseLong( array[0] ), 
		    	    	        	    		 Integer.parseInt( array[2] ) 
		    	    	        	    		  ,Double.parseDouble( array[3] ) );
		    	    	        	     
		    	    	        	     customersMap.put( customer.getAccountNumber(), customer );
		    	    	        	     temp=buffer.readLine();
		    	    	        }
		       
		    	    	         
		    	    }
		    	    catch (IOException e) 
				    {		
							e.printStackTrace();
					}
		     }
		     
		     
		     return customersMap;
	  }
	  
	  public String getCustomerFile()
	  {
		  String output ="";
		     
		     if( isCusFileExist() )
		     {
		    	    try
		    	    (
		    	    		FileReader reader=new FileReader(customerFile);
		    	    		BufferedReader buffer=new BufferedReader(reader);
		    	    )
		    	    {
		    	    	 String temp=buffer.readLine();
		    	    	
		    	    	 
		    	    	 while( temp!=null )
		    	    	 { 
		    	    	      output+=temp+"\n";  
		    	    	      temp=buffer.readLine();
		    	    	 }
		       
		    	    	         
		    	    }
		    	    catch (IOException e) 
				    {		
							e.printStackTrace();
					}
		     }
		     
		     return output;
		   
	  }
	  
	  
	  public String getATMFile()
	  {
		  
		 String output=""; 
		  if( atmFile.exists() )   
		  {   
		     try
		     (
		         FileReader reader=new FileReader(atmFile);
		         BufferedReader buffer=new BufferedReader(reader);
		     )
		     {
		    	   String temp=buffer.readLine();
		    	   
		    	  while( temp!=null )
		    	  {
		    		  output+=temp+"\n";
		    		  temp=buffer.readLine();
		    	  }
                   
		      }
		      catch( IOException ex )
		      {
		    	   ex.printStackTrace();
		      }
		   } 
		     
		     return output;
	  }
	  
	  public void storeTransNumber(int transactionNumber)
	  {
		  try
		  (
		    FileWriter writer=new FileWriter(transactionNoFile);
		  )
		  {
			  writer.write(transactionNumber+"");
		  }
		  catch( IOException ex )
	      {
	    	   ex.printStackTrace();
	      }
	  }
	  
	  public List<String> readTransaction(long accountNo)
	  {
		  List<String> transList=new ArrayList<>();
		  
		  File transFile=new File( accountNo+".txt" );
		  
		  if( transFile.exists() )
		  {
			  try
		      (
		         FileReader reader=new FileReader(transFile);
		    	 BufferedReader buffer=new BufferedReader( reader );	  
		      )
		      {
			       String temp=buffer.readLine();
			         temp=buffer.readLine();
			         
			        while( temp!=null )
			        {
			        	transList.add(temp);
			        	 temp=buffer.readLine();
			        }
			         
		      }
		      catch( IOException ex )
	          {
	    	      ex.printStackTrace();
	          }
		  }
		  
		  return transList;
	  }
	  
	  public int readTransNumber()
	  {
		  int transactionNo=1001;
		  
		  if( transactionNoFile.exists() )
		  {  
		      try
		      (
		         FileReader reader=new FileReader(transactionNoFile);
		    	 BufferedReader buffer=new BufferedReader( reader );	  
		      )
		      {
			           transactionNo=Integer.parseInt( buffer.readLine() );
		      }
		      catch( IOException ex )
	          {
	    	      ex.printStackTrace();
	          }
		  }   
		  
		  return transactionNo;
	  }
	  
	  public boolean isCusFileExist()
	  {
		  if( customerFile.exists() )
		  {
			  return true;
		  }
		  
		  return false;
	  }
	  
	
}
