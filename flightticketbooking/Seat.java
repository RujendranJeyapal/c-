package flightticketbooking;

public class Seat 
{
        private String seatNo;
        private String seatType;
        
        public Seat(String seatNo,String seatType)
        {
        	this.seatNo=seatNo;
        	this.seatType=seatType;
        }
        
        public String getSeatNo()
        {
        	return seatNo;
        }
        
        public String getSeatType()
        {
        	return seatType;
        }

		
		public String toString() 
		{
			return seatNo + "," + seatType;
		}
        
        
        
}
