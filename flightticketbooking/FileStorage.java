package flightticketbooking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileStorage 
{
	    private File folder=new File("FLIGHTS");
        private File flightA112Path=new File("FLIGHTS/Flight-A112-Chennai-Mumbai.txt");
        private File flightA113Path=new File("FLIGHTS/Flight-A113-Chennai-Kolkatha.txt");
        private File flightA114Path=new File("FLIGHTS/Flight-A114-Chennai-Delhi.txt");
        
        private void createFolder()
        {
        	if( !folder.exists() )
        	{
        		folder.mkdir();
        	}
        }
  
        
        public void updateFileA112(Flight flightA112)
        {
        	
        	createFolder();
        	
        	try(FileWriter writer=new FileWriter(flightA112Path);
        			BufferedWriter buffer = new BufferedWriter(writer);)
        	{
					List<Seat> economySeatList=flightA112.getEconomySeats();	
					
					writeEconomy(buffer,economySeatList);
					
			
					buffer.write("\n\n\n");
					
					List<Seat> businessSeatList=flightA112.getBusinessSeats();
					
					writeBusiness(buffer, businessSeatList);			
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
        		    List<Seat> economySeatList=flightA113.getEconomySeats();	
				
				    writeEconomy(buffer,economySeatList);
				
		
				    buffer.write("\n\n\n");
				
				    List<Seat> businessSeatList=flightA113.getBusinessSeats();
				
				    writeBusiness(buffer, businessSeatList);				
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
        		    List<Seat> businessSeatList=flightA114.getBusinessSeats();
 				
				    writeBusiness(buffer, businessSeatList);			
			} 
        	catch (IOException e) 
        	{
				
				e.printStackTrace();
			}
        	
        	
        }
        
        public FileStorage()
        {
        	 List<Seat> economicClassSeats=getEconomicClass();
        	 List<Seat> businessClassSeats=getBusinessClass();
        	 
        	 Flight flightA112=new Flight( "A112","Chennai","Mumbai",true,true,
        			 economicClassSeats,businessClassSeats );
     	    
     	     updateFileA112(flightA112);
     	     
     	     Flight flightA113=new Flight( "A113","Chennai","Kolkatha",true,true,
     	    		 economicClassSeats,businessClassSeats);
     	     
     	     updateFileA113(flightA113);
     	     
     	     Flight flightA114=new Flight( "A114","Chennai","Delhi",true,false,
    	    		 null,businessClassSeats);
     	     
     	    updateFileA114(flightA114);
        }
        
        private List<Seat> getEconomicClass()
        {
            List<Seat> seatList=new ArrayList<>();
        	
        	 String types;
        	
        	     for( int i=1;i<=12;i++ )
        	     {
        	    	    for( char j='A';j<='G';j++ )
        	    	    {
        	    	    	     if( j=='A' || j=='G' )
        	    	    	     {
        	    	    	    	 types="W";
        	    	    	     }
        	    	    	     
        	    	    	     else if( j=='D' )
        	    	    	     {
        	    	    	    	 types="M";
        	    	    	     }
        	    	    	     
        	    	    	     else
        	    	    	     {
        	    	    	    	 types="A";
        	    	    	     }
        	    	    	
        	    	             seatList.add( new Seat(i+"_"+j,types) );	  
        	    	    }
        	     }
        	     
        	     return seatList;
        }
        
        private List<Seat> getBusinessClass()
        {
        	 List<Seat> seatList=new ArrayList<>();
        	 
        	 String types;
        	 
        	   for( int i=1;i<=20;i++ )
        	   {
        		   for( char j='A';j<='K';j++ )
        		   {
        			       if( j=='A' || j=='K' )
        			       {
        			    	   types="W";
        			       }
        			       
        			       else if( j=='C' || j=='D' || j=='G' || j=='H' )
        			       {
        			    	   types="A";
        			       }
        			       
        			       else
        			       {
        			    	   types="M";
        			       }
        			       
        			       seatList.add( new Seat(i+"_"+j,types) );
        			    
        		   }
        	   }
        	   
        	   return seatList;
        }
        
        
        
        
        private void writeEconomy(BufferedWriter buffer,List<Seat> economySeatList) throws IOException
        {
        	int i=0;
			
			while( i<economySeatList.size() )
			{
			    buffer.write(economySeatList.get(i++)+"  "
			                +economySeatList.get(i++)+"    "
			                +economySeatList.get(i++)+"  "
			    		    +economySeatList.get(i++)+"  "
			                +economySeatList.get(i++)+"    "
			    		    +economySeatList.get(i++)+"  "
			                +economySeatList.get(i++)+"\n"
			                );	
			
			} 	
        }
        
        private void writeBusiness(BufferedWriter buffer,List<Seat> businessSeatList)throws IOException
        {
        	int j=0;
			
			while( j<businessSeatList.size() )
			{
                buffer.write(businessSeatList.get(j++)+"  "
                		    +businessSeatList.get(j++)+"  "
                		    +businessSeatList.get(j++)+"    "
                		    +businessSeatList.get(j++)+"  "
                		    +businessSeatList.get(j++)+"  "
                		    +businessSeatList.get(j++)+"  "
                		    +businessSeatList.get(j++)+"    "
                		    +businessSeatList.get(j++)+"  "
                		    +businessSeatList.get(j++)+"  "
                		    +businessSeatList.get(j++)+"  "
                		    +businessSeatList.get(j++)+"\n"
                		    );					
			}
        }
         
	
}
