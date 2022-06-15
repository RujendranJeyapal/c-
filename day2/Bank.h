#ifndef BANK_H_INCLUDED
#define BANK_H_INCLUDED

#include<iostream>
#include "Loan.h"

using std::string;

class Bank:public Loan
{
      
       public:
           virtual string getBankName(){}
       
           virtual string getEstablishedDate(){}
           virtual string getBankType(){}
           virtual string getBranch(){}
           virtual void getInfo(){}      

};

#endif