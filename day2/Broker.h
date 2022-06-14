#ifndef BROKER_H_INCLUDED
#define BROKER_H_INCLUDED

#include "Bank.h"

class Broker
{
        
     public:
         Bank compareInterestRate(Bank &bank1,Bank &bank2)
         {
                   
                Loan loan1=bank1;
                Loan loan2=bank2;

                if(  loan1.getInterestRate() < loan2.getInterestRate() ) 
                {
                        return bank1;
                }

                              return bank2;
         }

};



#endif