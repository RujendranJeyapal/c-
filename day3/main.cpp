

#include "LeaderFind.h"
using std::cin;
using std::cout;


int main()
{
    
          int row,col;
          cout<<"Enter row\n";
          cin>>row;

         cout<<"\nEnter colums\n";
         cin>>col;

         int **city=(int**)malloc(row*sizeof(int*));
 
         for(int i=0; i<row; i++)
         {
             city[i]=(int*)malloc(col*sizeof(int));  
         }

         for( int i=0;i<row;i++ )
         {
              for( int j=0;j<col;j++ )
              {
                  cin>>city[i][j];
              }
        }

        int *group=(int*)malloc((row*col)*sizeof(int));

        LeaderFind callFindLeader;

        callFindLeader.getGroup(city,group,row,col);

        cout<<"Groups are:";

        for( int i=0;i<(row*col); i++ )
        {
              if( group[i]!=0 )
              {
                  cout<<group[i]<<" ";
              }
        }

         cout<<"\nThe Leader of the group is: "<<callFindLeader.findLeader(group)<<"\n";

         free(city);
         free(group);

}