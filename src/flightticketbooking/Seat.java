package flightticketbooking;

public class Seat 
{
        private String seatNo;
        private String seatType;
        private String status;
        
        public Seat(String seatNo,String seatType,String status)
        {
        	this.seatNo=seatNo;
        	this.seatType=seatType;
        	this.status=status;
        }
        
        
        
        public void setStatus(String status) 
        {
			this.status = status;
		}



		public String getSeatNo()
        {
        	return seatNo;
        }
        
        public String getSeatType()
        {
        	return seatType;
        }
        
        public String getStatus()
        {
        	return status;
        }

		
		public String toString() 
		{
			return seatNo + "," + seatType+","+status;
		}
        
        
        
}
