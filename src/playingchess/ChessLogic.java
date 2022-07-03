package playingchess;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;


    


public class ChessLogic 
{
	
	  private LinkedHashMap<String,String> chessBoard=new LinkedHashMap<>();
	  
	  FileStorage callFile=new FileStorage();
	 
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
      
      
      public boolean moveCoins( String source,String destination ) throws CustomException 
      {
    	   String coin=chessBoard.get(source);
    	   String desCoin=chessBoard.get(destination);
    	 

    	   if( source.equals( "e1" )  &&  coin.equals("W_K") )
    	   {
    		   
    		    if( ( destination.equals( "g1" )  || destination.equals("c1") ) 
    		    			 &&  whiteKingMovement==0  && !isCheckForGivenWhiteKing( "e1" ) ) 
    		    { 
    		    	  
    		          whiteKingPosition=destination;
    		   
    		           if( destination.equals("g1") && whiteRookRightMovement==0  &&
    		        		   !isCheckForGivenWhiteKing("f1") &&  !isCheckForGivenWhiteKing("g1") )
    		           {
    	
    		        	   alterChessBoard( "h1" , " " );
    		    	       alterChessBoard( "f1" , "W_R" );
    		        	   
    		           } 	
    		           
    		          
    		    
    		           else if( destination.equals("c1")  &&  whiteRookLeftMovement==0 &&
    		        		    !isCheckForGivenWhiteKing("d1") &&  !isCheckForGivenWhiteKing("c1") )
    		           {

    		        	   alterChessBoard( "a1" , " " );
   		    	           alterChessBoard( "d1" , "W_R" );
    		           }
    		           
    		           else
    		           {
    		        	   throw new CustomException( "Don't move this coin" );
    		           }
    		           
    		    }  
    		           ++whiteKingMovement;
    	   }
    	 
    	 
    	   else if( source.equals( "e8" )  &&  coin.equals("B_K") )
      	   
    	   {
    		   
               if( ( destination.equals( "g8" )  || destination.equals("c8") ) 
          			 &&  blackKingMovement==0  && !isCheckForGivenBlackKing( "e8" ) )
               {
    		           blackKingPosition=destination;
    		   
    		           if( destination.equals("g8") && blackRookLeftMovement==0 &&
    		        		   !isCheckForGivenBlackKing("f8") &&  !isCheckForGivenBlackKing("g8")  )
    		           {   		        	   
    		        	    
    		    	
    		        	   alterChessBoard("h8"," ");
   		    	           alterChessBoard("f8","B_R");
    		           } 	
    		    
    		           else if( destination.equals("c8")  && blackRookRightMovement==0 && 
    		        		   !isCheckForGivenBlackKing("d8") &&  !isCheckForGivenBlackKing("c8") )
    		           {
    		        	    
    		    	      
    		        	    alterChessBoard("a8"," ");
  		    	            alterChessBoard("d8","B_R");
    		           }
    		           
    		           else
    		           {
    		        	   throw new CustomException( "Don't move this coin" );
    		           }
                
               }
    		           ++blackKingMovement;
    	   
    	   }
    	   
    	 
    		   
    	 
	    	        
    	   alterChessBoard( source , " " );
    	   alterChessBoard( destination , coin );
           
    	   
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
    	   
    	   if( desCoin.equals(" ") )
    	   {   
    	        callFile.recordFile(  coin+" at "+source+" has been moved to "+destination   );
    	   }
    	   else
    	   {
    		    callFile.recordFile(  coin+" at "+source+" has been captured "+desCoin+" at "+destination   );
    	   }
    	   
    	       return true;
    	 
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
	  
	  private List<String> getKingMoves( String position ,String coin ) throws CustomException 
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
		  
		  
		  if(  coin.startsWith("W")  && whiteKingMovement==0  )
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
		  
		  
		  if(  coin.startsWith("B")  && blackKingMovement==0  )
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
	  
	  
	  public String getCoins( String position ) throws CustomException
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
				
		  
		    if(  availableMoves.contains(move) ||  availableMoves.contains(move+" can be capture")  )
		    {
				  return true;
	        }
		    
		    if( move.contains("help")   )
		    {
		    	 return isExistInList( availableMoves , move.charAt(0)+""+move.charAt(1)  );
		    }
			
		    throw new CustomException( "Please enter the position only in list" );
	  }
	  
	  private boolean isContainsInList( List<String> availableMoves, String move )
	  {
		    if(  availableMoves.contains(move) ||  availableMoves.contains( move+" can be capture") )
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
	  
	   
	  private boolean isCheckForGivenWhiteKing( String kingPosition ) throws CustomException
	  {
	    
		  for(  String position:chessBoard.keySet() )
		  {	 
		       
			    String coin=chessBoard.get(position);
			  
		        if( coin.startsWith("B")  && 
		        	isContainsInList( getMoves( position ),kingPosition )  )
		        {
		    	    	 return true;
		        }
		        
		  }  	  
	                     return false;
	  }
	  
	  private boolean isCheckForGivenBlackKing( String kingPosition ) throws CustomException
	  {
	    
		  for(  String position:chessBoard.keySet() )
		  {	 
		  
			  String coin=chessBoard.get(position);
			  
		      if( coin.startsWith("W")  && 
		    		 
		    		  isContainsInList( getMoves( position ),kingPosition )  )
		      {
		    	    	 return true;
		      }
		      
		  }  	  
	                     return false;
	  }
	  
	  
	
	
	  public boolean isBlackKingCheck() throws CustomException 
	  {
		    
			  
			  if(  isCheckForGivenBlackKing( blackKingPosition )  )
			  {
				  return true;
			  }
		
		  
		      return false;
	  }
	  
	  
	  public boolean isWhiteKingCheck() throws CustomException 
	  {
		  
			  if(  isCheckForGivenWhiteKing( whiteKingPosition )  )
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
		    	  String coin=" ";
		    	  String move=allMoves.get(i);
		    	  String temp=move.split(" ")[0];
		    	  boolean condition=false;
		    	  
		    	  if( move.contains(" can be capture") )
		    	  {
		    		    condition=true;
                       		    		  
		    		    
		    		    coin=chessBoard.get(temp);		    		    
		    		    alterChessBoard( temp , "W_K" );
		    		    
		    	  }
		    	  
		    	  if( ! isCheckForGivenWhiteKing( move )  )
		    	  {
		    		  if( condition )
		    		  {
		    			  alterChessBoard( temp , coin );
		    		  }
		    		  
		    		  return false;
		    	  }
		    	  
		    	  
		    	  if( condition )
	    		  {
		    		  alterChessBoard( temp , coin );
	    		  }
		    	  
		    	  
		      }	 
		      
		     
 		    	  
		      return true;
	  }
	  
	  public boolean isBlackKingCheckMate() throws CustomException
	  {
		      List<String> allMoves=getMoves( blackKingPosition );
		      
		      for(  int i=0;i<allMoves.size();i++ )
		      {
		    	  
		    	  String coin=" ";
		    	  String move=allMoves.get(i);
		    	  String temp=move.split(" ")[0];
		    	  boolean condition=false;
		    	  
		    	  if( move.contains(" can be capture") )
		    	  {
		    		    condition=true;
                       		    		  
		    		    
		    		    coin=chessBoard.get(temp);		    		    
		    		    alterChessBoard( temp , "B_K" );
		    		    
		    	  }
		    	  
		    	  
		    	  if( ! isCheckForGivenBlackKing( allMoves.get(i)  ) )
		    	  {
		    		  if( condition )
		    		  {
		    			  alterChessBoard( temp , coin );
		    		  }
		    		  
		    		  
		    		  return false;
		    	  }
		    	  
		    	  if( condition )
	    		  {
		    		  alterChessBoard( temp , coin );
	    		  }
		    	  
		      }	 
 		    	  
		     return true;
	  }
	  
	  
	  public boolean isWhiteMoveAvailable(String source,List<String> destinations ) throws CustomException
	  {
		  
		  
		  for( int i=0;i<destinations.size();i++  )
		  {
			  
			  
			  
			  if( whiteMoveCheck( source,destinations.get(i) )  )
			  {
				  return true;
			  }
			 
			     
		  }
		   return false;
		  
	  }
	  
	  
	  public boolean whiteMoveCheck(String source, String destination ) throws CustomException  
	  {
		         String coin=chessBoard.get(source);
		         
		         String temp=whiteKingPosition;
		         
		       
		      
		         
		         if( destination.contains(" can be capture") )
			     {
			    	 destination=destination.split(" ")[0];
			     }
			     
			     String desCoin=chessBoard.get(destination);

			     
			     alterChessBoard( source , " " );
		 	     alterChessBoard( destination , coin );
			     
			     if( coin.endsWith("K") )
		         {
		        	  whiteKingPosition=destination; 
		         }
			     
			     if( !isWhiteKingCheck()  )
			     {
	
			    	  alterChessBoard( source ,coin );
			    	  alterChessBoard( destination ,desCoin  );
			    	 
			    	 
			    	  if( coin.endsWith("K") )
			    	  { 
			    	     whiteKingPosition=temp;
			    	  }
			    	  
			    	 return true;
			     }

			     
			      alterChessBoard( source ,coin );
		    	  alterChessBoard( destination ,desCoin  );
		    	 
		    	 
		    	  if( coin.endsWith("K") )
		    	  { 
		    	     whiteKingPosition=temp;
		    	  }
		      
		    	 return false;
	  }
	  
	 
	  
	  
	  public boolean isBlackMoveAvailable(String source,List<String> destinations ) throws CustomException
	  {
		 
		  
		  for( int i=0;i<destinations.size();i++  )
		  {
			   if(  blackMoveCheck( source,  destinations.get(i) ) )
			   {
				    return true;
			   }
			 
		  }
		  
	          	  return false;
		 
	  }
	  
	  
	  
	  
	  public boolean blackMoveCheck(String source, String destination ) throws CustomException  
	  {
		        String coin=chessBoard.get(source);
		      
		        String temp=blackKingPosition;
		      
		        if( destination.contains(" can be capture") )
			     {
			    	 destination=destination.split(" ")[0];
			     }
			     
			     String desCoin=chessBoard.get(destination);

			     alterChessBoard( source , " " );
		 	     alterChessBoard( destination , coin );
			     
			     if( coin.endsWith("K")  )
			     {
			    	    blackKingPosition=destination;
			     }
			     
			     if( !isBlackKingCheck()  )
			     {
			    	
			    	 
			    	  alterChessBoard( source ,coin );
			    	  alterChessBoard( destination ,desCoin  );
			    	 
			    	  if( coin.endsWith("K") )
			    	  { 
			    	     blackKingPosition=temp;
			    	  }
			    	 
			    	 return true;
			     }
			     
			
			     
			         alterChessBoard( source ,coin );
		    	     alterChessBoard( destination ,desCoin  );
		    	 
		    	 
		    	     if( coin.endsWith("K") )
		    	     { 
		    	        blackKingPosition=temp;
		    	     }
		      
		    	     return false;
	  }
	  
	  
	  public boolean isAllWhiteMovesAvai() throws CustomException
	  {
		  for( String position:chessBoard.keySet()  )
		  {
			  String coin=chessBoard.get(position);
			  
			  if( coin.startsWith("W")  &&  isWhiteMoveAvailable( position , getMoves( position )  )   )
			  {
				  return true;
			  }
			  
		  }
		  
		  return false;
	  }
	  
	  
	  public boolean isAllBlackMovesAvai() throws CustomException
	  {
		  for( String position:chessBoard.keySet()  )
		  {
			  String coin=chessBoard.get(position);
			  
			  if( coin.startsWith("B")  &&   isBlackMoveAvailable( position , getMoves( position )  )   )
			  {
				  return true;
			  }
			  
		  }
		  
		  return false;
	  }
	  
	  
	  public List<String> getHelpForWhiteCoin( String source , String destination  ) throws CustomException
	  {
		  List<String> help=new ArrayList<>();
		  	
		  String temp=whiteKingPosition;
		  
		  String yourCoin=chessBoard.get( source );
			 
		  String desCoin=chessBoard.get( destination );
		 
	
 	        
 	        alterChessBoard( source , " " );
 	        alterChessBoard( destination , yourCoin );
 	        
 	         if( yourCoin.endsWith("K") )
	         { 
	        	  whiteKingPosition=destination;
	         }
 	        
 	        if(  isWhiteKingCheck() )
            {
 	              help.add( "Your King Will be check..!" );  
 	              
 	            
 	              
 	             alterChessBoard( source , yourCoin  );
  	             alterChessBoard( destination , desCoin );
 	              
 	             if( yourCoin.endsWith("K") )
 		         { 
 		        	  whiteKingPosition=temp;
 		         }
 	           
 	              return help;
            }
 	        
		  
	        for( String key:chessBoard.keySet() )
		    {
   	 
			      String coin=chessBoard.get( key );  	      
			        	 
		           if( coin.startsWith("B")  )
		           {
 
		        	       List<String> moves=getMoves( key );
		        	       
		        	       for(  int i=0;i<moves.size();i++  )
		        	       {
 
		        	    	      if( moves.get(i).contains( destination+" can be capture" )  )
		        	    	      {
		        	    	    	    help.add(  "The "+coin+" in "+key+" can capture your "+yourCoin  );
		        	    	      }
		        	       }
		           }
			        	 
		    }
	        
	       
	        
	        alterChessBoard( source , yourCoin  );
	        alterChessBoard( destination , desCoin );
		  
	         if( yourCoin.endsWith("K") )
	         { 
	        	  whiteKingPosition=temp;
	         }
	        
		    return help;
	  }
	  
	  
	  public List<String> getHelpForBlackCoin( String source , String destination  ) throws CustomException
	  {
		    List<String> help=new ArrayList<>();
		    String temp=blackKingPosition;
		  	  
		    String yourCoin=chessBoard.get( source );
		 
		    String desCoin=chessBoard.get( destination );
		 
		 
		    
		    alterChessBoard( source," " );
		    alterChessBoard( destination , yourCoin );
   	        
   	        if( yourCoin.endsWith("K") )
   	        {
   	        	 blackKingPosition=destination;
   	        }
   	        
   	        if(  isBlackKingCheck() )
            {
   	              help.add( "Your King Will be check..!" );  
   	              
   	         
   	              
   	              alterChessBoard( source , yourCoin  );
   	              alterChessBoard( destination , desCoin );
   	              
   	             if( yourCoin.endsWith("K") )
      	         { 
      	        	  blackKingPosition=temp;
      	         }
   	           
   	              return help;
            }
   	        
		  
	        for( String key:chessBoard.keySet() )
		    {
     	 
			      String coin=chessBoard.get( key );  	      
			        	 
		           if( coin.startsWith("W")  )
		           {
		        	   
		        	       
		        	   
		        	       List<String> moves=getMoves( key );
		        	       
		        	       for(  int i=0;i<moves.size();i++  )
		        	       {
		        	    	     
		        	    	     
		        	    	      
		        	    	      if( moves.get(i).contains( destination+" can be capture" )  )
		        	    	      {
		        	    	    	    help.add(  "The "+coin+" in "+key+" can capture your "+yourCoin  );
		        	    	      }
		        	       }
		           }
			        	 
		    }
	
	        
	        alterChessBoard( source , yourCoin  );
	        alterChessBoard( destination , desCoin );
		  
	         if( yourCoin.endsWith("K") )
 	         { 
 	        	  blackKingPosition=temp;
 	         }
	        
		    return help;
	  }
	  
	  public boolean isStaleMateForWhiteKing() throws CustomException
	  {
		    
		     for(  String position:chessBoard.keySet()  )
		     {
		    	 
		    	 String coin=chessBoard.get( position );
		    	 
		    	   if( coin.startsWith("W")  && ! getMoves(position).isEmpty() && isWhiteMoveAvailable( position,getMoves(position) )  )
		    	   {
		    		   return false;
		    	   }
		     }
		   
		     return true;
	  }
	  
	  
	  public boolean isStaleMateForBlackKing() throws CustomException
	  {
		    
		     for(  String position:chessBoard.keySet()  )
		     {
		    	 
		    	   String coin=chessBoard.get( position );
		    	 
		    	   if( coin.startsWith("B")  && ! getMoves(position).isEmpty() && isBlackMoveAvailable( position,getMoves(position) )  )
		    	   {
		    		   return false;
		    	   }
		     }
		   
		     return true;
	  }
	  
	  
	  public boolean isMatchDraw() throws CustomException
	  {
		  List<String> blackCoins=new ArrayList<>();
		  List<String> whiteCoins=new ArrayList<>();
		  
		     for( String position:chessBoard.keySet()  )
		     {
		    	 String coin=chessBoard.get(position);
		    	 
		    	 if( coin.startsWith("W") )
		    	 {
		    		  whiteCoins.add(coin);
		    	 }
		    	 
		    	 if( coin.startsWith("B") )
		    	 {
		    		  blackCoins.add(coin);
		    	 }
		    	 
		     }
		     
		     
		     if(  blackCoins.size()==1 && blackCoins.contains("B_K")  && whiteCoins.size()==1 && whiteCoins.contains("W_K")  ) 
		     {
		    	 throw new CustomException( "Match Drawn" );
		     }
		     
		     return false;
		     
	  }
	  
	  public void alterChessBoard(String position,String coin)
	  {
		  chessBoard.put( position , coin );
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
