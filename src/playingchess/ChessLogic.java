package playingchess;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;


    


public class ChessLogic 
{
	
	 LinkedHashMap<String,String> chessBoard=new LinkedHashMap<>();
	 
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
    	  
    	  String coins=getCoins( position );
    	  	     
    	  if(  coins.equals("W_P") )
    	  {
    		     return getPawnMovesForWhite( position );    
    	  }
    	  
    	  if( coins.equals("B_P") )
    	  {
    		     return getPawnMovesForBlack( position );
    	  }	  
    	
    	  if( coins.endsWith("K") )
    	  {
    		     return getKingMoves( position );
    	  }
    	  
    	  if( coins.endsWith("Q") )
    	  {
    		     return getQueenMoves( position );
    	  }
    	
    	  if( coins.endsWith("N") )
    	  {
    		     return getKnightMoves( position );
    	  }
    	 
    	  if( coins.endsWith("B" ) )
    	  {
    		    return getBishopMoves( position );
    	  }
    	  
    	  return getRookMoves( position );
      }
      
      
      
     
	  private List<String> getPawnMovesForWhite( String position ) throws CustomException
      {
		     List<String> movingPlaces=new ArrayList<>();
		  
    	     
		     int row=Integer.parseInt( position.charAt(1)+"" ) +1;
		     
		     if( row<=8  && !isCoinHere( position,position.charAt(0)+""+row ) && !getCoins( position.charAt(0)+""+row ).startsWith("B")  )
		     {     			    	     
	    	         movingPlaces.add( position.charAt(0)+""+row  );
		     }   
    	        
    	     
    	     if(  position.endsWith("2") )
    	     {  	    	 
  
    	    	 movingPlaces.add( position.charAt(0) +""+(row+1) );
    	     }
    	     
    	     return movingPlaces;
    	     
      }
	  
	  private List<String> getPawnMovesForBlack( String position ) throws CustomException
	  {
		    List<String> movingPlaces=new ArrayList<>();
		    
		    int row=Integer.parseInt( position.charAt(1)+"" ) -1;
		    
   	        if( row>=1  && !isCoinHere( position,position.charAt(0)+""+row ) && !getCoins( position.charAt(0)+""+row ).startsWith("W") )
   	        {
   	             movingPlaces.add( position.charAt(0)+""+row  );
   	        }
   	     
   	        if(  position.endsWith("7") )
   	        {
   	        	movingPlaces.add( position.charAt(0) +""+(row-1) );
   	        }
   	     
   	        return movingPlaces;
		  
	  }
	  
	  
	  private List<String> getRookMoves( String position ) throws CustomException
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
				  
				  if( !isCoinHere( position,col+""+row  ) )
				  {
					  break;
				  }
			      
			       movingPlaces.add( col+""+row  );
			       
			       col+=colMoves[i] ;
				  
				   row+=rowMoves[i] ;
			      
			  }
			  
		  }
		  
		  return movingPlaces;
	  }
	  
	  private List<String> getBishopMoves( String position  ) throws CustomException
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
			      
				   if( !isCoinHere( position,col+""+row  ) )
				   {
					   break;
				   }
				  
			       movingPlaces.add( col+""+row  );
			       
			       col+=colMoves[i] ;
				  
				   row+=rowMoves[i] ;
			      
			  }
			  
		  }
		  
		  return movingPlaces;
		  
	  }
	  
	  
	  private List<String> getKnightMoves( String position ) throws CustomException
	  {
		  List<String> movingPlaces=new ArrayList<>();
		  
		  int rowMoves[]= {1,1,-1,-1,2,2,-2,-2};
		  int colMoves[]= {2,-2,2,-2,1,-1,1,-1};
		  
		  for( int i=0;i<8;i++ )
		  {
			 
			  char col=(char) ( position.charAt(0)+colMoves[i] );
			  
			  int row=( Integer.parseInt( position.charAt(1)+"" )+rowMoves[i] );
			  
			  if( row>0 && row<=8 && col>='a' && col<='h' && !isCoinHere( position,col+""+row  ) )
			  {			         				  
			       movingPlaces.add( col+""+row  );    
			  }
			  
		  }
		  
		  return movingPlaces;
		  
	  }
	  
	  private List<String> getKingMoves( String position  ) throws CustomException
	  {
		  List<String> movingPlaces=new ArrayList<>();
		  
		  int rowMoves[]= {1,-1,0,0,1,-1,1,-1};
		  int colMoves[]= {0,0,1,-1,1,1,-1,-1};
		  
		  for( int i=0;i<8;i++ )
		  {
			 
			  char col=(char) ( position.charAt(0)+colMoves[i] );
			  
			  int row=( Integer.parseInt( position.charAt(1)+"" )+rowMoves[i] );
			  
			  if( row>0 && row<=8 && col>='a' && col<='h' && !isCoinHere( position,col+""+row  ) )
			  {			         
			       movingPlaces.add( col+""+row  );    
			  }
			  
		  }
		  
		  return movingPlaces;
		  
	  }
	  
	  private List<String> getQueenMoves( String position ) throws CustomException
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
	  
	  private boolean isCoinHere( String fromPosition , String toPosition ) throws CustomException
	  {
		    
		    
		    if( getCoins( fromPosition ).startsWith( "W" ) && getCoins( toPosition ).startsWith("W")  )
		    {
		    	 return false;
		    }
		    
		    if( getCoins( fromPosition ).startsWith( "B" ) && getCoins( toPosition ).startsWith("B")  )
		    {
		    	 return false;
		    }
		    
		    return true;
	  }
	  
     
}
