package playingchess;
import java.util.InputMismatchException;
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
	         				  
	     	    		          else if( callLogic.isStaleMateForWhiteKing()  )
	        	    		      {
	        	    		    	    System.out.println("Stalemate For WhiteKing");
	        	    		    	    return;
	        	    		      }
	        	    		     
	        	    		      else if( callLogic.isMatchDraw() )
	        	    		      {
	        	    		    	   return;
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
	        	                	   
	        	                	    String coin=callLogic.getCoins( whitePosition );
		        	                	  
		        	                    if( coin.endsWith("P") && whitePosition.endsWith("7") && whiteMove.endsWith("8")  )
		        	                	{
		        	                		     pawnPromotion( whitePosition ,input , callLogic , coin );
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
	        	    		     
	        	    		     else if( callLogic.isStaleMateForBlackKing()  )
	        	    		     {
	        	    		    	   System.out.println("Stalemate For BlackKing");
	        	    		    	   return;
	        	    		     }
	        	    		     
	        	    		     else if( callLogic.isMatchDraw() )
	        	    		     {
	        	    		    	    return;
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
	        	                	  
	        	                	  String coin=callLogic.getCoins(blackPosition);
	        	                	  
	        	                	  if( coin.endsWith("P") && blackPosition.endsWith("2") && blackMove.endsWith("1")  )
	        	                	  {
	        	                		     pawnPromotion( blackPosition ,input , callLogic , coin );
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
	        
	        static void pawnPromotion( String position , Scanner input , ChessLogic callLogic ,String coin)
	        {
	        	boolean condition=true;
	        	
	        	
	        	
	        	
	        	while( condition )
	        	{
	        	     System.out.println("Press 1--> Queen\nPress 2--> Kinght\nPress 3--> Bishop\nPress 4-->Rook");
	        	     
	        	     
	        	     int option=0;
	        	     
	        	     try
	        	     {
	        	         option=input.nextInt();
	        	         input.nextLine();
	        	     }
	        	     catch( InputMismatchException ex )
	        	     {
	        	    	 System.out.println("Enter Number Only");
	        	     }
	        	     
  	        	     switch(  option )
	        	     {
	        	          case  1:
	        	        	  
	        	        	   if(  coin.startsWith("W")  )
	        	               {
	        	        	        callLogic.alterChessBoard(position,"W_Q");
	        	               }  
	        	        	   
	        	        	   else
	        	        	   {
	        	        		   callLogic.alterChessBoard(position,"B_Q");
	        	        	   }
	        	        	   condition=false;
	        	        	   break;
	        	        	   
	        	          case 2:
	        	        	  
	        	        	   if(  coin.startsWith("W")  )
	        	               {
	        	        	        callLogic.alterChessBoard(position,"W_N");
	        	               }  
	        	        	   
	        	        	   else
	        	        	   {
	        	        		   callLogic.alterChessBoard(position,"B_N");
	        	        	   }
	        	        	   condition=false;
	        	        	   break;
	        	        	   
	        	        	   
	        	          case 3:
	        	        	  
	        	        	   if(  coin.startsWith("W")  )
	        	               {
	        	        	        callLogic.alterChessBoard(position,"W_B");
	        	               }  
	        	        	   
	        	        	   else
	        	        	   {
	        	        		   callLogic.alterChessBoard(position,"B_B");
	        	        	   }
	        	        	   condition=false;
	        	        	   break;   
	        	        	   
	        	          case 4:
	        	        	  
	        	        	   if(  coin.startsWith("W")  )
	        	               {
	        	        	        callLogic.alterChessBoard(position,"W_R");
	        	               }  
	        	        	   
	        	        	   else
	        	        	   {
	        	        		   callLogic.alterChessBoard(position,"B_R");
	        	        	   }
	        	        	   condition=false;
	        	        	   break;   
	        	        	   
	        	        default:
	        	        	
	        	        	   System.out.println("Choose Given Number Only");
	        	        	   break;
	        	        	  
	        	     }
	        	 
	        	}
	        }
	        
}

