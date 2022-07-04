package fooddelivery;

public class Customer
{
        private String customerId;
        private String time;
        
        
		public Customer(String customerId,  String time) 
		{
	
			this.customerId = customerId;
			this.time = time;
			
		}


		public String getCustomerId() 
		{
			return customerId;
		}



		public String getTime() 
		{
			return time;
		}
        
		
        
        
}
