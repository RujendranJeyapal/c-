package playingchess;

import java.util.List;
import java.util.Scanner;

public class PlayChess 
{
        public static void main( String[] args )
        {
        	   
           Scanner input=new Scanner( System.in );
        	
           ChessLogic callLogic=new ChessLogic();
        	 
           callLogic.initialSetup();
       
           callLogic.printBoard();
        	 
           while( true )	 
           {	
        		String whitePosition="";
        		String whiteMove="";
        		List<String> availableMovesForWhite=null;
        	 
        		while( true )
         		{	 
         			  try
                      {
        	                  System.out.println("White move");
        	                  whitePosition=input.nextLine();
        	                         	                  
        	                  availableMovesForWhite=callLogic.getMoves( whitePosition );
        	                  
        	                  if( callLogic.isCoinIsSame(whitePosition,"W") && callLogic.emptyCheck(availableMovesForWhite) )
        	                  {
        	                	  break;
        	                  }
        	                  
        		      } 
         		      catch( CustomException ex )
    	              {
    		                  System.out.println( ex.getMessage() );
    	              }
         		}
        		
        		
        		while( true )
        		{
        		       try
        		       {
        	                  
        	      
        	                  System.out.println("Available Moves are\n"+availableMovesForWhite);
        	     
        	                  whiteMove=input.nextLine();
        	     
        	                  if(  callLogic.isExistInList( availableMovesForWhite,whiteMove ) )
        	                  {
        	                	  
        	                	     callLogic.moveCoins( whitePosition, whiteMove );
        	             	     
                                     callLogic.printBoard();
                                     
        	        	             break;
        	        	             
        	                  }
      
        		        }            
                        catch( CustomException ex )
               	        {
               		         System.out.println( ex.getMessage() );
               	        }
        		       
        		}
        		
        		
        		
        	    String blackPosition="";
        	    List<String> availableMovesForBlack=null;
        	    String blackMove="";
        	    
        	     
        	    while( true )
        	    {	 
        	    	  try 
        	    	  {
        	                 System.out.println("Black move");
        	                 blackPosition=input.nextLine();
        	     
        	                
        	                 
        	                 availableMovesForBlack=callLogic.getMoves( blackPosition );
        	                 
        	                 if( callLogic.isCoinIsSame(blackPosition,"B") && callLogic.emptyCheck(availableMovesForBlack) )
        	                 {
        	        	          break;
        	                 }
        	                 
        	                
        	                 
        	    	  }   
        	          catch( CustomException ex )
   	                  {
   		                     System.out.println( ex.getMessage() );
   	                  }
        	    }
        	     
        	    while( true )
        	    {
        	    	  try
        	    	  {       	                  
        	      
        	                  System.out.println("Available Moves are\n"+availableMovesForBlack);
        	     
        	                  blackMove=input.nextLine();
        	     
        	                  if( callLogic.isExistInList( availableMovesForBlack,blackMove ) )
        	                  {
        	                	  
        	                     	callLogic.moveCoins( blackPosition, blackMove);
         	 	         	     
    	                            callLogic.printBoard();
                            	  
        	                    	break;
        	                  }
        	                  
        	    	  }   
        	    	  catch( CustomException ex )
        	          {
        		              System.out.println( ex.getMessage() );
        	          }      	  
        	    	        
        	    }
        	                 
        	     
        
        	
           }	   
        }
}
