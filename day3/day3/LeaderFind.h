#ifndef LEADERFIND_H_INCLUDED
#define LEADERFIND_H_INCLUDED
#include<iostream>
using std::cout;

static int sum=0;

static     int position=0;
class LeaderFind
{

   public: 

     void getGroup(int **city,int *group,int rowSize,int colSize)
     {
           
               bool **visited=(bool**)malloc(rowSize*sizeof(bool*));
 
               for(int i=0; i<rowSize; i++)
               {
                   visited[i]=(bool*)malloc(colSize*sizeof(bool));
     
               }
  
  

             

               for( int i=0;i<rowSize;i++ )
               {
                     for( int j=0;j<colSize;j++ )
                     {
                           if( city[i][j]!=0 && !visited[i][j]  )
                           {
                                    addBuildings( city,visited,i,j,rowSize,colSize  );

                                    group[position++]=sum;

                                    sum=0;
                           }

                     }
               }
                 
                  free(visited);    
                  
     }
             

         
  
            



     void addBuildings( int **city,bool **bolArray,int row,int col,int rowSize,int colSize  )
     {
                       
              int rowMove[]={1,-1,0,0};
              int colMove[]={0,0,1,-1};

              sum+=city[row][col];

              bolArray[row][col]=true;

              for( int dirc=0;dirc<4;dirc++ )
              {

                   int movRow=row+rowMove[dirc];
                   int movCol=col+colMove[dirc];

                      if( movRow>=0 && movRow<rowSize && movCol>=0 && movCol<colSize 
                               && city[movRow][movCol]!=0 && !bolArray[movRow][movCol] )

                      { 
                             addBuildings( city,bolArray,movRow,movCol,rowSize,colSize );
                      } 
                     

              }


     }


     int findLeader(int* group)
     {

          int output=group[0];
        
           for( int i=1;i<position;i++ )
           {
                  if( output<group[i]  )
                  {
                        output=group[i];
                  }
           }
               
              return output;
     }


};


#endif