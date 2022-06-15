#ifndef BROKER_H_INCLUDED
#define BROKER_H_INCLUDED

#include<iostream>

#include "Bank.h"

class Broker
{
        
     public:
         Bank * compareInterestRate(Bank &bank1,Bank &bank2)
         {
                   
                Loan *loan1=&bank1;
                Loan *loan2=&bank2;

                if(  loan1->getInterestRate() < loan2->getInterestRate() ) 
                {
                        return &bank1;
                }

                              return &bank2;
         }

         Bank* compareInterestRate(Bank &bank1,Bank &bank2,Bank &bank3)
         {
               Loan *loan1=&bank1;
               Loan *loan2=&bank2;
               Loan *loan3=&bank3;
               
               if( ( loan1->getInterestRate()<loan2->getInterestRate() ) &&  (loan1->getInterestRate()<loan3->getInterestRate()) )
               {
                      return &bank1;
               }

               else if( ( loan2->getInterestRate()<loan1->getInterestRate() ) && loan2->getInterestRate()<loan3->getInterestRate()  )
               {
                      return &bank2;
               }

                      return &bank3;

         }

         Bank* compareInterestRate(Bank  *banks[],int size)
         {
                      Bank *output=banks[0];
                     int i,j;
                   //  size= /**(banks+1)-(*banks)*/      sizeof(banks)/sizeof( banks[0] );
                     Loan *loans[size];

                     for( i=0;i<size;i++ )
                     {
                            loans[i]=banks[i];
                     }
                     
                     float minimum=loans[0]->getInterestRate();
                  
                      
                      for(j=1;j<size;j++)
                      {
                            
                             if( loans[j]->getInterestRate()<minimum  )
                             {
                                      output=banks[j];
                                      minimum=loans[j]->getInterestRate();

                             }
                         

                      }
                      
                            return output;

                           
         }


         void getBankInfo(Bank &bank)
         {
                      bank.getInfo();
         }

         void getBankInfo(Bank *bank[],int size)
         {
                int i;
              
                for( i=0;i<size;i++ )
                {
                       getBankInfo( *bank[i] );
                }

               
         }

};



#endif