package fooddelivery;

import java.util.Map;

public class FoodDeliveryDrive 
{
	
	
	  FoodDeliveryManagement callCache=new FoodDeliveryManagement();
	  
	  private int bookingId=1;
      
	  
	  public void setExecutive( int count )
	  {
		  for( int i=1;i<=count;i++ )
		  {
			  DeliveryExecutive executive=new DeliveryExecutive();
			  
			  executive.setExecutive("DE"+i);
			  
			  callCache.addExecutives(executive);
			  
		  }
	  }
	  
	  
	  
	  
	  public boolean isTimeFormat( String time ) throws CustomException
	  {
		  if( !time.contains(":")  )
		  {
			  throw new CustomException( "Enter time Format...!" );
		  }
		  
		  String array[]=time.split(":");
		  
		  if(  array[0].length()!=2  || array[1].length()!=2 || Integer.parseInt( array[0] )<=0 ||  Integer.parseInt( array[0])>12 
				  ||  Integer.parseInt( array[1] )<0 || Integer.parseInt( array[1] )>=60 )
		  {
			     throw new CustomException( "Enter time Format...!" );
		  }
		  
		  
		  return true;
		  
	  }
	  
	  
	  
	  public String book(  Customer customer , String destination , String restaurant ) throws CustomException
	  {
		  
		     String executiveName=isBookInSameLocation( customer , destination ,restaurant )  ;
		     
		     if( executiveName!=null )
		     {
		    	   return executiveName;
		     }
		     
		     DeliveryExecutive executive=getLowestEarnExecutive(  customer.getTime() );
		     
		     if( executive==null )
		     {
		    	 throw new CustomException("All Executives are Busy"); 
		     }
		     
		     String parkingTime=getTimeFormat( convertToMin( customer.getTime() )+15  );
		     
		     String returnTime=getTimeFormat( convertToMin( customer.getTime() )+45  );
		     
		     executive.setAlloances(10);
		     executive.setDeliveryCharges(50);
		     executive.setFreeTime(  returnTime  );
		     
		     Booking book=new Booking( bookingId++ , executive,  customer , restaurant ,parkingTime, destination,returnTime
		    		 ,50,10);
		     
		     callCache.addBooking(book);
		     
		     return executive.getExecutive();
		    
	  }
	  
	  
      private String isBookInSameLocation( Customer customer , String destination , String restaurant  )
	  {
		   Map<Integer,Booking>  allBookings=getAllBookings();
		  
		   for( Integer bookingId : allBookings.keySet()  )
		   {
			   Booking book=allBookings.get( bookingId );
			   
			   String time=book.getParkingTime();
			   
			   if( 
					      ( convertToMin( customer.getTime())-convertToMin( time )<=15) 
					      &&  destination.equals( book.getDestinationPoint() ) 
					      &&  restaurant.equals(  book.getRestaurant() )
					      &&  book.getOrder()<=5  
			     )
			   {
				   book.setCustomers(customer);
				   book.setDeliveryCharge(5);
				   
				   DeliveryExecutive executive=book.getExecutive();
				   
				   executive.setDeliveryCharges(5);

				   
				   
				   return executive.getExecutive();
			   }
			  
		   }
		   
		   return null;
		   
	  }
	  
	  
	  private int convertToMin(  String time  )
	  {
		    String array[]=time.split(":");
		    
		    int hour=Integer.parseInt( array[0]  );
		    
		    if( hour==12 )
		    {  
		    	  hour=0;
		    }
		    
		    String temp[]=array[1].split(" ");
		    
		    int mins=(hour*60)+ Integer.parseInt( temp[0] );
		    
		    if( time.contains("PM")  )
		    {
		    	mins+=720;
		    }
		    
		    return  mins;
		    
	  }
	  
	  private String getTimeFormat( int mins )
	  {
		    int hour=mins/60;
		    Object min=mins%60;
		    
		    int temp=hour;
		    
		    if( temp==0 )
		    {
		    	temp=12;
		    }
		    
		    while(  temp>12  )
		    {
		    	temp-=12;
		    	
		    }
		    
		   
		    
		    if((int) min<10 )
		    {
		    	min=0+""+min;
		    }
		    
		    String time=temp+":"+min;
		    
		    if(  ( mins>=720 && mins<1440  )    )
		    {
		    	time+=" PM";
		    }
		    
		    else
		    {
		    	time+=" AM";
		    }
		    
		    return time;
		  
	  }
	
      
	  public DeliveryExecutive getLowestEarnExecutive(  String time  )
	  {
		   double maximum=Double.MAX_VALUE;
		   
		   DeliveryExecutive output=null;
		  
		   Map<String,DeliveryExecutive>  allExecutives=getAllDeliveryExecutives();  
		   
		   for( String executive : allExecutives.keySet()  )
		   {
			        
			   
			   DeliveryExecutive deliveryExecutive=allExecutives.get( executive );
			   
			   String executiveFreeTime= deliveryExecutive.getFreeTime() ;
			   
			   if( ( executiveFreeTime==null  || convertToMin( time )>=convertToMin( executiveFreeTime )  ) 
					   &&   maximum>deliveryExecutive.getDeliveryCharges()  )
			   {
				   maximum=deliveryExecutive.getDeliveryCharges();
				   output=deliveryExecutive;
			   }
			   
		   }
		   
		   return output;
	  }
	  
	  public Map<String, DeliveryExecutive> getAllDeliveryExecutives() 
	  {
		   return callCache.getAllDeliveryExecutives();
	  }
	  
	  
	  public Map<Integer,Booking> getAllBookings() 
	  {
		     return callCache.getAllBookings();
	  }
	   
	
}
