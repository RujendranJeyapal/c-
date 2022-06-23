package flightticketbooking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.LinkedHashMap;

public class FileStorage 
{
	    private File folder=new File("FLIGHTS");
        private File flightA112Path=new File("FLIGHTS/Flight-A112-Chennai-Mumbai.txt");
        private File flightA113Path=new File("FLIGHTS/Flight-A113-Chennai-Kolkatha.txt");
        private File flightA114Path=new File("FLIGHTS/Flight-A114-Chennai-Delhi.txt");
        
        
        public String[] getFlightNames()
        {
        	return folder.list();
        }
       
        
        
        public void updateFile(Flight flight)
        {
        	if( flight.getFlightNo().equals("A112") )
        	{
        		updateFileA112(flight);
        	}
        	
        	if( flight.getFlightNo().equals("A113") )
        	{
        		updateFileA113(flight);
        	}
        	
        	if( flight.getFlightNo().equals("A114") )
        	{
        		updateFileA114(flight);
        	}
        	
        }
  
        
        public void updateFileA112(Flight flightA112)
        {
        	
        	createFolder();
              
         
        	try(FileWriter writer=new FileWriter(flightA112Path);
        			BufferedWriter buffer = new BufferedWriter(writer);
        	   )
        	{
					LinkedHashMap<String,Seat> businessSeatList=flightA112.getBusinessSeats();	
					
					writeBusiness(buffer,businessSeatList);
					
			
					buffer.write("\n\n\n");
					
					LinkedHashMap<String,Seat> economySeatList=flightA112.getEconomySeats();
					
					writeEconomy(buffer, economySeatList);			
			} 
        	catch (IOException e) 
        	{				
				    e.printStackTrace();
			}
        	
          }
        
        
        public void updateFileA113(Flight flightA113)
        {
        	createFolder();
        
          
        	try(FileWriter writer=new FileWriter(flightA113Path);
        			BufferedWriter buffer = new BufferedWriter(writer);)
        	{
        		    LinkedHashMap<String,Seat> businessSeatList=flightA113.getBusinessSeats();	
				
				    writeBusiness(buffer,businessSeatList);
				
		
				    buffer.write("\n\n\n");
				
				    LinkedHashMap<String,Seat> economySeatList=flightA113.getEconomySeats();
				
				    writeEconomy(buffer, economySeatList);				
			} 
        	catch (IOException e) 
        	{	
				    e.printStackTrace();
			}
        	
          
        }
        
        public void updateFileA114(Flight flightA114)
        {
        	createFolder();
        	
           	
        	try(FileWriter writer=new FileWriter(flightA114Path);
        			BufferedWriter buffer = new BufferedWriter(writer);)
        	{
        		    LinkedHashMap<String,Seat> businessSeatList=flightA114.getBusinessSeats();
 				
				    writeBusiness(buffer, businessSeatList);			
			} 
        	catch (IOException e) 
        	{
				
				e.printStackTrace();
			}
         	
           	
        }
        
        public String readFileA112()
        {
        	
        	String output="";
        	      try( 
        	    		  FileReader reader=new FileReader(flightA112Path);
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
        	      
        	      return output;
        	     
         }
        
        
         
        public String readFileA113()
        {
        	
        	String output="";
        	      try( 
        	    		  FileReader reader=new FileReader(flightA113Path);
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
        	      
        	      return output;
        	     
         } 
        
        
        
        public String readFileA114()
        {
        	
        	String output="";
        	      try( 
        	    		  FileReader reader=new FileReader(flightA114Path);
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
        	      
        	      return output;
        	     
         } 
        
        
        private void writeBusiness(BufferedWriter buffer,LinkedHashMap<String,Seat> businessSeatList) throws IOException
        {
        	int i=0;
        	
        	Object[] keys= businessSeatList.keySet().toArray();
			
			while( i<businessSeatList.size() )
			{
			    buffer.write(businessSeatList.get( keys[i++] )+"  "
			                +businessSeatList.get( keys[i++] )+"    "
			                +businessSeatList.get( keys[i++] )+"  "
			    		    +businessSeatList.get( keys[i++] )+"  "
			                +businessSeatList.get( keys[i++] )+"    "
			    		    +businessSeatList.get( keys[i++] )+"  "
			                +businessSeatList.get( keys[i++] )+"\n"
			                );	
			
			} 	
        }
        
        private void writeEconomy(BufferedWriter buffer,LinkedHashMap<String,Seat> economicSeatList)throws IOException
        {
        	int j=0;
        	
        	Object[] keys= economicSeatList.keySet().toArray();
			
			while( j<economicSeatList.size() )
			{
                buffer.write(economicSeatList.get( keys[j++] )+"  "
                		    +economicSeatList.get( keys[j++] )+"  "
                		    +economicSeatList.get( keys[j++] )+"    "
                		    +economicSeatList.get( keys[j++] )+"  "
                		    +economicSeatList.get( keys[j++] )+"  "
                		    +economicSeatList.get( keys[j++] )+"  "
                		    +economicSeatList.get( keys[j++] )+"    "
                		    +economicSeatList.get( keys[j++] )+"  "
                		    +economicSeatList.get( keys[j++] )+"  "
                		    +economicSeatList.get( keys[j++] )+"  "
                		    +economicSeatList.get( keys[j++] )+"\n"
                		    );					
			}
        }
        
        private void createFolder()
        {
        	if( !folder.exists() )
        	{
        		folder.mkdir();
        	}
        }
         
	
}
