package playingchess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileStorage 
{
       private File chessRecords=new File("Moving Records.txt");
       
       
      
       
       
       public void recordFile( String moves )
       {
    	   try
    	   (
    	     FileWriter writer=new FileWriter( chessRecords,true);
    	     BufferedWriter buffer=new BufferedWriter( writer );
    	   )
    	   {
    		     buffer.append(moves+"\n");
    	   }
    	   catch (IOException e) 
    	   {
			
			e.printStackTrace();
		   }
    	   
       }
       
       
}
