package flightticketbooking;

public class Passenger 
{
        private String name;
        private String address;
	    private String seat;
	    private double amount;
	    
		
		
		
		
		
		public void setName(String name) 
		{
			this.name = name;
		}




		public void setAddress(String address) 
		{
			this.address = address;
		}




		public void setSeat(String seat) 
		{
			this.seat = seat;
		}




		public void setAmount(double amount) 
		{
			this.amount = amount;
		}




		public String getName() 
		{
			return name;
		}

		public String getAddress() 
		{
			return address;
		}

		public String getSeat() 
		{
			return seat;
		}

		public double getAmount() 
		{
			return amount;
		}




		@Override
		public String toString() 
		{
			return "[name=" + name + ", address=" + address + ", seat=" + seat + ", amount=" + amount + "]";
		}
		
		
		
		
	    
	    
	    
	    
	    
	    
	
}
