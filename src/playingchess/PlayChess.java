package playingchess;





public class PlayChess 
{
        public static void main( String[] args )
        {
        	   
        	 ChessLogic callLogic=new ChessLogic();
        	 
        	 callLogic.initialSetup();
        	 
        	try {
				callLogic.getMoves("c1");
			} catch (CustomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	   
        }
}
