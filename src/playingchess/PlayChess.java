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
	        		
	        		
	        		String blackPosition="";
	          	    List<String> availableMovesForBlack=null;
	          	    String blackMove="";
	          	    
	        	 
	        		while( true )
	         		{	 
	         			  try
	                      {
	         				  

	     	    		          if( callLogic.isWhiteKingCheck()  )
	     	    		          {
	     	    		    	         System.out.println("White King is Check..");
	     	    		    	 
	     	    		    	        if( callLogic.isWhiteKingCheckMate()  && !callLogic.isAllWhiteMovesAvai() )
	     	    		    	        {
	     	    		    	        	System.out.println(" and CheckMate ");
	     	    		    	        	return;
	     	    		    	        }       	    		    	 
	     	    		          }
	         				  
	         				  
	        	                  System.out.println("White move");
	        	                  whitePosition=input.nextLine();
	        	                  
	        	                  
	        	                  if( whitePosition.equals("exit") )
	        	                  {
	        	                	  return;
	        	                  }
	        	                         	                  
	        	                  availableMovesForWhite=callLogic.getMoves( whitePosition );
	        	                  
	        	                  if( !callLogic.isWhiteMoveAvailable(whitePosition, availableMovesForWhite) )
	        	                  {
	        	                	   
	        	                	    continue;
	        	                  }
	     
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
	        	     
	        	                  
	        	                  if( whiteMove.equals("exit") )
	        	                  {
	        	                	  return;
	        	                  }
	        	                  
	        	                  if(  callLogic.isExistInList( availableMovesForWhite,whiteMove ) )
	        	                  {
	        	                	    if( whiteMove.contains("--help")  )   
	        	                	    {
	        	                	    	List<String> help=callLogic.getHelpForWhiteCoin( whitePosition ,whiteMove.charAt(0)+""+whiteMove.charAt(1)  );
	        	                	    	
	        	                	    	printHelp( help );
	        	                	    	
	        	                	    	continue;
	        	                	    	
	        	                	    }	        	                	  
	        	                	  
	        	                	    if( !callLogic.whiteMoveCheck(whitePosition, whiteMove)  )
		        	                    {
		        	                	    System.out.println("Choose Another Move");
		        	                	    continue;
		        	                    }
	        	                	   
	        	                	  
	        	                	    if(! callLogic.moveCoins( whitePosition, whiteMove ) )
	        	                	    {
	        	                	    	  continue;
	        	                	    }
	        	             	     
	                                     callLogic.printBoard();
	                                     
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
	        	    		  
	        	    		     
	        	    		  
	        	    		     if(  callLogic.isBlackKingCheck()  )
	        	    		     {
	        	    		    	 System.out.println("Black King is Check..");
	        	    		    	 
	        	    		    	        if( callLogic.isBlackKingCheckMate() && !callLogic.isAllBlackMovesAvai()  )
	        	    		    	        {
	        	    		    	        	System.out.println(" and CheckMate ");
	        	    		    	        	return;
	        	    		    	        }       	    		    	 
	        	    		     }
	        	    		  
	        	                 System.out.println("Black move");
	        	                 
	        	                 blackPosition=input.nextLine();
	        	                 
	        	                 if( blackPosition.equals( "exit" ) )
	        	                 {
	        	                	    return;
	        	                 }
	        	                 
	        	                 availableMovesForBlack=callLogic.getMoves( blackPosition );
	        	                 
	        	                 
	        	                 if( !callLogic.isBlackMoveAvailable(blackPosition, availableMovesForBlack) )
	        	                  {
	        	                	   
	        	                	    continue;
	        	                  }
	        	               
	        	                 
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
	        	     
	        	                  if( blackMove.equals( "exit" ) )
		        	              {
		        	                	    return;
		        	              }
	        	                  
	        	                  
	        	                  
	        	                  
	        	                  
	        	                  if( callLogic.isExistInList( availableMovesForBlack,blackMove ) )
	        	                  {
	        	                	  
	        	                	  if( blackMove.contains("--help")  )   
	        	                	  {
	        	                	    	List<String> help=callLogic.getHelpForBlackCoin( blackPosition , blackMove.charAt(0)+""+blackMove.charAt(1)  );
	        	                	    	
	        	                	    	printHelp( help );
	        	                	    	
	        	                	    	continue;
	        	                	    	
	        	                	  }	
	        	                	  
	        	                	  
	        	                	  if( !callLogic.blackMoveCheck(blackPosition, blackMove)  )
		        	                  {
		        	                	  System.out.println("Choose Another Move");
		        	                	  continue;
		        	                  }
	        	                	  
	        	                	  
	        	                     
	        	                	  if( ! callLogic.moveCoins( blackPosition, blackMove) )
	        	                	  {
	        	                		  continue;
	        	                	  }
	         	 	         	     
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
	        
	        
	        static void printHelp(  List<String> help )
	        {
	        	int size=help.size();
    	    	
    	    	if( size==0 )
    	    	{
    	    		System.out.println("Safe Place");
    	    	}
    	    	
    	    	else
    	    	{
    	    		
    	    		  for( int i=0;i<size;i++ )
    	    		  {
    	    			  System.out.println(help.get(i));
    	    		  }
    	    	}
	     }
	        
}

