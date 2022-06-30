package playingchess;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;


    


public class ChessLogic 
{
	
	  private LinkedHashMap<String,String> chessBoard=new LinkedHashMap<>();
	 
	  private int whiteKingMovement=0;
	  
	  private int blackKingMovement=0;
	  
	  private int whiteRookRightMovement=0;
	  
	  private int whiteRookLeftMovement=0;
	  
	  private int blackRookRightMovement=0;
	  
	  private int blackRookLeftMovement=0;
	  
	  
	  private String whiteKingPosition="e1";
	  
	  private String blackKingPosition="e8";
	  
	  public void initialSetup()
	  {
		   chessBoard.put( "a8" , "B_R" );
		   chessBoard.put( "b8" , "B_N" );
		   chessBoard.put( "c8" , "B_B" );
		   chessBoard.put( "d8" , "B_Q" );
		   chessBoard.put( "e8" , "B_K" );
		   chessBoard.put( "f8" , "B_B" );
		   chessBoard.put( "g8" , "B_N" );
		   chessBoard.put( "h8" , "B_R" );
		   
		   chessBoard.put( "a7" , "B_P" );
		   chessBoard.put( "b7" , "B_P" );
		   chessBoard.put( "c7" , "B_P" );
		   chessBoard.put( "d7" , "B_P" );
		   chessBoard.put( "e7" , "B_P" );
		   chessBoard.put( "f7" , "B_P" );
		   chessBoard.put( "g7" , "B_P" );
		   chessBoard.put( "h7" , "B_P" );
		   
		   
		   chessBoard.put( "a6" , " " );
		   chessBoard.put( "b6" , " " );
		   chessBoard.put( "c6" , " " );
		   chessBoard.put( "d6" , " " );
		   chessBoard.put( "e6" , " " );
		   chessBoard.put( "f6" , " " );
		   chessBoard.put( "g6" , " " );
		   chessBoard.put( "h6" , " " );
		   
		   
		   chessBoard.put( "a5" , " " );
		   chessBoard.put( "b5" , " " );
		   chessBoard.put( "c5" , " " );
		   chessBoard.put( "d5" , " " );
		   chessBoard.put( "e5" , " " );
		   chessBoard.put( "f5" , " " );
		   chessBoard.put( "g5" , " " );
		   chessBoard.put( "h5" , " " );
		   
		   
		   chessBoard.put( "a4" , " " );
		   chessBoard.put( "b4" , " " );
		   chessBoard.put( "c4" , " " );
		   chessBoard.put( "d4" , " " );
		   chessBoard.put( "e4" , " " );
		   chessBoard.put( "f4" , " " );
		   chessBoard.put( "g4" , " " );
		   chessBoard.put( "h4" , " " );
		   
		   
		   chessBoard.put( "a3" , " " );
		   chessBoard.put( "b3" , " " );
		   chessBoard.put( "c3" , " " );
		   chessBoard.put( "d3" , " " );
		   chessBoard.put( "e3" , " " );
		   chessBoard.put( "f3" , " " );
		   chessBoard.put( "g3" , " " );
		   chessBoard.put( "h3" , " " );
		   
		   
		   chessBoard.put( "a2" , "W_P" );
		   chessBoard.put( "b2" , "W_P" );
		   chessBoard.put( "c2" , "W_P" );
		   chessBoard.put( "d2" , "W_P" );
		   chessBoard.put( "e2" , "W_P" );
		   chessBoard.put( "f2" , "W_P" );
		   chessBoard.put( "g2" , "W_P" );
		   chessBoard.put( "h2" , "W_P" );
		   
		   
		   chessBoard.put( "a1" , "W_R" );
		   chessBoard.put( "b1" , "W_N" );
		   chessBoard.put( "c1" , "W_B" );
		   chessBoard.put( "d1" , "W_Q" );
		   chessBoard.put( "e1" , "W_K" );
		   chessBoard.put( "f1" , "W_B" );
		   chessBoard.put( "g1" , "W_N" );
		   chessBoard.put( "h1" , "W_R" );
		   
		   
	  }
	   
	
	
     
      public List<String> getMoves(String position) throws CustomException
      {
    	  
    	  String coin=getCoins( position );
    	  	     
    	  if(  coin.endsWith("P") )
    	  {
    		     return getPawnMoves( position );    
    	  }
    	
    	  if( coin.endsWith("K") )
    	  {
    		     return getKingMoves( position,coin );
    	  }
    	  
    	  if( coin.endsWith("Q") )
    	  {
    		     return getQueenMoves( position );
    	  }
    	
    	  if( coin.endsWith("N") )
    	  {
    		     return getKnightMoves( position );
    	  }
    	 
    	  if( coin.endsWith("B" ) )
    	  {
    		    return getBishopMoves( position );
    	  }
    	  
    	  return getRookMoves( position );
      }
      
      
      public void moveCoins( String source,String destination ) 
      {
    	   String coin=chessBoard.get(source);
    	 
    	   chessBoard.put( source," " );
    	   chessBoard.put(destination, coin);
    	 
    	   if( coin.equals("W_K") )
    	   {
    		   
    		      if( whiteKingMovement==0 )
    		      {	  
    		    	  
    		          whiteKingPosition=destination;
    		   
    		          if( destination.equals("g1") && whiteRookRightMovement==0  )
    		          {
    		    	       chessBoard.put("h1"," ");
    		    	       chessBoard.put("f1","W_R");
    		           } 	
    		    
    		           if( destination.equals("c1")  &&  whiteRookLeftMovement==0 )
    		           {
    		               chessBoard.put("a1"," ");
   		    	           chessBoard.put("d1","W_R");
    		           }
    		           
    		      }
    		           ++whiteKingMovement;
    	   }
    	 
    	 
    	   if( coin.equals("B_K") )
    	   {
    		   
                if( blackKingMovement==0 )
                {	
    		           blackKingPosition=destination;
    		   
    		           if( destination.equals("g8") && blackRookLeftMovement==0   )
    		           {
    		    	        chessBoard.put("h8"," ");
    		    	        chessBoard.put("f8","B_R");
    		           } 	
    		    
    		           if( destination.equals("c8")  && blackRookRightMovement==0  )
    		           {
    		    	        chessBoard.put("a8"," ");
   		    	            chessBoard.put("d8","B_R");
    		           }
                } 
    		           ++blackKingMovement;
    	   }
    	   
    	   
    	   
    	   if( source.equals( "h1" ) && coin.equals( "W_R" )  )
    	   {
    		         ++whiteRookRightMovement;
    	   }
    	   

    	   if( source.equals( "a1" ) && coin.equals( "W_R" )  )
    	   {
    		         ++whiteRookLeftMovement;
    	   }
    	   

    	   if( source.equals( "h8" ) && coin.equals( "W_B" )  )
    	   {
    		         ++blackRookLeftMovement;
    	   }
    	   

    	   if( source.equals( "a8" ) && coin.equals( "W_B" )  )
    	   {
    		         ++blackRookRightMovement;
    	   }
    	   
    	   
    	   
    	   
    	 
      }
      
      
     
	  private List<String> getPawnMoves( String position ) 
      {
		     List<String> movingPlaces=new ArrayList<>();
		  
    	     
		     
		     char col=position.charAt(0);
		     
		     if( chessBoard.get(position).startsWith("W") )
		     {
		                 int row=Integer.parseInt( position.charAt(1)+"" ) +1;
		     
		                 if(  isCoinNotHere( position,col+""+row ) && !isCapturedCoinHere( position,col+""+row)   )
		                 {     			    	     
	    	                    movingPlaces.add( col+""+row  );
	    	     
	    	                   if(  position.endsWith("2") && isCoinNotHere( position,col+""+(row+1) ) && 
	    	                		   !isCapturedCoinHere( position,col+""+(row+1)  )  )
 	                           {  	    	   
 	    	                         movingPlaces.add( col+""+(row+1) );
 	                           }
		                 }              
    	     
                         if(!position.startsWith("h")  && isCapturedCoinHere( position,(char)(col+1)+""+row )  )
                         {
            	                    movingPlaces.add( (char)(col+1) +""+row+" can be capture"  );
                         }
             
                         if( !position.startsWith("a")  && isCapturedCoinHere( position,(char)(col-1) +""+row )  )
                         {
                                    movingPlaces.add( (char)(col-1) +""+row+" can be capture"  );
                         }
    	     
		     }       
		     
		     
		     if( chessBoard.get(position).startsWith("B") )
		     {
		    	 
		    	    int row=Integer.parseInt( position.charAt(1)+"" ) -1;
	    
		   	        if(  isCoinNotHere( position,col+""+row )  && !isCapturedCoinHere( position,col+""+row)    )
		   	        {
		   	             movingPlaces.add( col+""+row  );
		   	             
		   	            if(  position.endsWith("7") && isCoinNotHere( position,col+""+(row-1) ) &&  
		   	            		!isCapturedCoinHere( position,col+""+(row-1)  )  )
		     	        {
		     	        	movingPlaces.add( col+""+(row-1) );
		     	        }
		   	        }   
		   	        
		   	        if( !position.startsWith("h")  &&  isCapturedCoinHere( position,(char)(col+1)+""+row )  )
		            {
		        	    movingPlaces.add( (char)(col+1) +""+row+" can be capture"  );
		            }
		         
		            if( !position.startsWith("a")  && isCapturedCoinHere( position,(char)(col-1) +""+row )  )
		            {
		                movingPlaces.add( (char)(col-1) +""+row+" can be capture"  );
		            }
		   	     
		     }
		     
		     
    	                          return movingPlaces;
    	     
      }
	
	  
	  
	  private List<String> getRookMoves( String position ) 
	  {
		  List<String> movingPlaces=new ArrayList<>();
		  
		  int rowMoves[]= {1,-1,0,0};
		  int colMoves[]= {0,0,1,-1};
		  
		  for( int i=0;i<4;i++ )
		  {
			 
			  char col=(char) ( position.charAt(0)+colMoves[i] );
			  
			  int row=( Integer.parseInt( position.charAt(1)+"" )+rowMoves[i] );
			  
			  while( row>0 && row<=8 && col>='a' && col<='h' )
			  {			     
				  
				  if( !isCoinNotHere( position,col+""+row  ) )
				  {
					  break;
				  }
			      
				  if( isCapturedCoinHere( position,col+""+row ) )
			      {			    	   
			    	   movingPlaces.add( col+""+row+" can be capture"  );
			    	   break;
			      }
			       
			      else
			      {
			           movingPlaces.add( col+""+row  );
			      }
			       
			       col+=colMoves[i] ;
				  
				   row+=rowMoves[i] ;
			      
			  }
			  
		  }
		  
		  return movingPlaces;
	  }
	  
	  private List<String> getBishopMoves( String position  ) 
	  {
		  List<String> movingPlaces=new ArrayList<>();
		  
		  int rowMoves[]= {1,-1,1,-1};
		  int colMoves[]= {1,-1,-1,1};
		  
		  for( int i=0;i<4;i++ )
		  {
			 
			  char col=(char) ( position.charAt(0)+colMoves[i] );
			  
			  int row=( Integer.parseInt( position.charAt(1)+"" )+rowMoves[i] );
			  
			  while( row>0 && row<=8 && col>='a' && col<='h' )
			  {			      
			      
				   if( !isCoinNotHere( position,col+""+row  ) )
				   {
					   break;
				   }
				  
			     
			       
			       if( isCapturedCoinHere( position,col+""+row ) )
			       {			    	   
			    	   movingPlaces.add( col+""+row+" can be capture"  );
			    	   break;
			       }
			       
			       else
			       {
			           movingPlaces.add( col+""+row  );
			       }		    	 
 			       
			       col+=colMoves[i] ;
				  
				   row+=rowMoves[i] ;
			      
			  }
			  
		  }
		  
		  return movingPlaces;
		  
	  }
	  
	  
	  private List<String> getKnightMoves( String position )
	  {
		  List<String> movingPlaces=new ArrayList<>();
		  
		  int rowMoves[]= {1,1,-1,-1,2,2,-2,-2};
		  int colMoves[]= {2,-2,2,-2,1,-1,1,-1};
		  
		  for( int i=0;i<8;i++ )
		  {
			 
			  char col=(char) ( position.charAt(0)+colMoves[i] );
			  
			  int row=( Integer.parseInt( position.charAt(1)+"" )+rowMoves[i] );
			  
			  if( row>0 && row<=8 && col>='a' && col<='h' && isCoinNotHere( position,col+""+row  ) )
			  {			         				  		       
			       
			       if( isCapturedCoinHere( position,col+""+row ) )
			       {			    	   
			    	   movingPlaces.add( col+""+row+" can be capture"  );
			       }
			       
			       else
			       {
			           movingPlaces.add( col+""+row  );
			       }
			  }

			  
		  }
		  
		  return movingPlaces;
		  
	  }
	  
	  private List<String> getKingMoves( String position ,String coin ) 
	  {
		  List<String> movingPlaces=new ArrayList<>();
		  
		  int rowMoves[]= {1,-1,0,0,1,-1,1,-1};
		  int colMoves[]= {0,0,1,-1,1,1,-1,-1};
		  
		  for( int i=0;i<8;i++ )
		  {
			 
			  char col=(char) ( position.charAt(0)+colMoves[i] );
			  
			  int row=( Integer.parseInt( position.charAt(1)+"" )+rowMoves[i] );
			  
			  if( row>0 && row<=8 && col>='a' && col<='h' && isCoinNotHere( position,col+""+row  ) )
			  {			         
				  if( isCapturedCoinHere( position,col+""+row ) )
			       {			    	   
			    	   movingPlaces.add( col+""+row+" can be capture"  );
			    	   break;
			       }
			       
			       else
			       {
			           movingPlaces.add( col+""+row  );
			       }  
				  
			  }
			   
		  }
		  
		  char col=position.charAt(0);
		  
		  int row=Integer.parseInt( position.charAt(1)+"");
		  
		  
		  if(  coin.startsWith("W")  && whiteKingMovement==0   )
		  {
			  if( 
				   chessBoard.get(  (char) (col+1)+""+row ).equals(" ") &&
				   chessBoard.get(  (char) (col+2)+""+row ).equals(" ") &&
				   whiteRookRightMovement==0 &&
				   chessBoard.get( "h1" ).equals("W_R")		    
				)
			    {
				   movingPlaces.add( (char)  (col+2)+""+row  ); 
			    }
			  
			  
			  if( 
				   chessBoard.get( (char)  (col-1)+""+row ).equals(" ") &&
				   chessBoard.get( (char)  (col-2)+""+row ).equals(" ") &&
				   chessBoard.get( (char)  (col-3)+""+row ).equals(" ") &&
				   whiteRookLeftMovement==0 &&
				   chessBoard.get( "a1" ).equals("W_R")
					    
			    )
				{
				   movingPlaces.add(  (char) (col-2)+""+row  ); 
				}
			  
		  }
		  
		  
		  if(  coin.startsWith("B")  && blackKingMovement==0   )
		  {
			  if( 
				  chessBoard.get( (char)  (col+1)+""+row ).equals(" ") &&
				  chessBoard.get( (char)  (col+2)+""+row ).equals(" ") &&
				  blackRookLeftMovement==0 &&
				  chessBoard.get( "h8" ).equals("B_R")
				    
				)
			    {
				   movingPlaces.add(  (char) (col+2)+""+row  ); 
			    }
			  
			  
			  if( 
				   chessBoard.get(  (char) (col-1)+""+row ).equals(" ") &&
				   chessBoard.get(  (char) (col-2)+""+row ).equals(" ") &&
				   chessBoard.get(  (char) (col-3)+""+row ).equals(" ") &&
				   blackRookRightMovement==0 &&
				   chessBoard.get( "a8" ).equals("B_R")
					    
			    )
				{
				   movingPlaces.add(  (char) (col-2)+""+row  ); 
				}
			  
		  }
		  
		  return movingPlaces;
		  
	  }
	  
	  private List<String> getQueenMoves( String position ) 
	  {
		     List<String> queenMoves=getRookMoves( position );
		     
		     queenMoves.addAll( getBishopMoves( position ) );
		  
		     return  queenMoves;
	  }
	  
	  
	  private String getCoins( String position ) throws CustomException
	  {
             String coin=chessBoard.get(position);
    	  
    	     if( coin==null || coin.equals(" ") )
    	     {
    		        throw new CustomException("Choose the correct position");
    	     }
    	  
    	     return coin;
	  }
	  
	  private boolean isCoinNotHere( String fromPosition , String toPosition ) 
	  {
		    
		    
		    if(  chessBoard.get( fromPosition ).startsWith( "W" ) && chessBoard.get( toPosition ).startsWith("W")  )
		    {
		    	 return false;
		    }
		    
		    if( chessBoard.get( fromPosition ).startsWith( "B" ) && chessBoard.get( toPosition ).startsWith("B")  )
		    {
		    	 return false;
		    }
		    
		    return true;
	  }
	  
	  
	  private boolean isCapturedCoinHere( String fromPosition , String toPosition ) 
	  {
		    
		    
		    if(  chessBoard.get( fromPosition ).startsWith( "W" ) && chessBoard.get( toPosition ).startsWith("B")  )
		    {
		    	 return true;
		    }
		    
		    if( chessBoard.get( fromPosition ).startsWith( "B" ) && chessBoard.get( toPosition ).startsWith("W")  )
		    {
		    	 return true;
		    }
		    
		    return false;
	  }
	  
	  public boolean isCoinIsSame(String position,String coin) throws CustomException
	  {
		  if( !getCoins( position ).startsWith(coin) )
		  {
			 throw new CustomException( "Choose your coin only...!" );
		  }
		  
		  return true;
	  }
	  
	  

	  public boolean isExistInList(List<String> availableMoves, String move) throws CustomException
	  {
			if( ! isContainsInList( availableMoves,move) ) 
			{
				  throw new CustomException( "Please enter the position only in list" );
			}
			
			return true;			
	  }
	  
	  private boolean isContainsInList( List<String> availableMoves, String move )
	  {
		    if(  availableMoves.contains(move) ||  availableMoves.contains(move+" can be capture") )
			{
				  return true;
			}
			
			return false;
	  }
		  
	  public boolean emptyCheck( List<String> availableMoves ) throws CustomException
	  {
		   if(  availableMoves.isEmpty() )
		   {
			     throw new CustomException( "Choose Another Coin..!" );   
		   }
		   
		   return true;
	  }
	  
	   
	  private boolean isCheckForWhiteKingGivenPosition( String kingPosition ) throws CustomException
	  {
	    
		  for(  String position:chessBoard.keySet() )
		  {	 
		       
			    String coin=chessBoard.get(position);
			  
		        if( coin.startsWith("B")  && !coin.equals(" ") &&  isContainsInList( getMoves( position ),kingPosition )  )
		        {
		    	    	 return true;
		        }
		  }  	  
	                     return false;
	  }
	  
	  private boolean isCheckForBlackKingGivenPosition( String kingPosition ) throws CustomException
	  {
	    
		  for(  String position:chessBoard.keySet() )
		  {	 
		  
			  String coin=chessBoard.get(position);
			  
		      if( coin.startsWith("W")  && !coin.equals(" ") &&  isContainsInList( getMoves( position ),kingPosition )  )
		      {
		    	    	 return true;
		      }
		  }  	  
	                     return false;
	  }
	  
	  
	  
	  
	  private boolean isEscapeForWhiteKingGivenPosition( String kingPosition ) throws CustomException
	  {
	    
		  for(  String position:chessBoard.keySet() )
		  {	 
		       
			    String coin=chessBoard.get(position);
			  
		        if( coin.startsWith("W")  && !coin.equals(" ") &&  isContainsInList( getMoves( position ),kingPosition )  )
		        {
		    	    	 return true;
		        }
		  }  	  
	                     return false;
	  }
	  
	  private boolean isEscapeForBlackKingGivenPosition( String kingPosition ) throws CustomException
	  {
	    
		  for(  String position:chessBoard.keySet() )
		  {	 
		  
			  String coin=chessBoard.get(position);
			  
		      if( coin.startsWith("B")  && !coin.equals(" ") &&  isContainsInList( getMoves( position ),kingPosition )  )
		      {
		    	    	 return true;
		      }
		  }  	  
	                     return false;
	  }
	  
	  
	  
	  public boolean isEscapeForBlackKingCurrentPosition() throws CustomException 
	  {
		    
			  
			  if(  isEscapeForBlackKingGivenPosition( blackKingPosition )  )
			  {
				  return false;
			  }
		
		  
		      return true;
	  }
	  
	  
	  public boolean isEscapeForWhiteKingCurrentPosition() throws CustomException 
	  {
		  
			  if(  isEscapeForWhiteKingGivenPosition( whiteKingPosition )  )
			  {
				  return false;
			  }
					     
		  		  		  
		      return true;
	  }
	  
	  
	  public boolean isCheckForBlackKingCurrentPosition() throws CustomException 
	  {
		    
			  
			  if(  isCheckForBlackKingGivenPosition( blackKingPosition )  )
			  {
				  return true;
			  }
		
		  
		      return false;
	  }
	  
	  
	  public boolean isCheckForWhiteKingCurrentPosition() throws CustomException 
	  {
		  
			  if(  isCheckForWhiteKingGivenPosition( whiteKingPosition )  )
			  {
				  return true;
			  }
					     
		  		  		  
		      return false;
	  }
	 
	  
	  public boolean isWhiteKingCheckMate() throws CustomException
	  {
		      List<String> allMoves=getMoves( whiteKingPosition );
		      
		      for(  int i=0;i<allMoves.size();i++ )
		      {
		    	  if(  isCheckForWhiteKingGivenPosition( allMoves.get(i)  ) )
		    	  {
		    		  return true;
		    	  }
		      }	 
 		    	  
		      return false;
	  }
	  
	  public boolean isBlackKingCheckMate() throws CustomException
	  {
		      List<String> allMoves=getMoves( blackKingPosition );
		      
		      for(  int i=0;i<allMoves.size();i++ )
		      {
		    	  if(  isCheckForBlackKingGivenPosition( allMoves.get(i)  ) )
		    	  {
		    		  return true;
		    	  }
		      }	 
 		    	  
		      return false;
	  }
	  
	  
	  
	  public void applyAllMoves(String source,List<String> availableMovesForBlack) 
	  {
			for( int i=0;i<availableMovesForBlack.size();i++  )
			{
				   moveCoins( source,availableMovesForBlack.get(i) );
			}
	  }

	  
	  
	  
	 
	  public void printBoard()
	  {
		  int i=0;
		  int j=8;
		  
		  System.out.println( "\ta\tb\tc\td\te\tf\tg\th" );
		  
		  Object key[]=chessBoard.keySet().toArray();
		  
		  while( i<chessBoard.size() )
		  {
			   System.out.println(
					                (j--)+"\t"+
					                chessBoard.get( key[i++] )+"\t"+
		                            chessBoard.get( key[i++] )+"\t"+
					                chessBoard.get( key[i++] )+"\t"+
		                            chessBoard.get( key[i++] )+"\t"+
					                chessBoard.get( key[i++] )+"\t"+
		                            chessBoard.get( key[i++] )+"\t"+
					                chessBoard.get( key[i++] )+"\t"+
		                            chessBoard.get( key[i++] )
		                         );
		  }
		  
		  
	  }




	



     
}
