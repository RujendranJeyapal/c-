#ifndef LOAN_H_INCLUDED
#define LOAN_H_INCLUDED

#include<iostream>


using std::string;

class Loan
{

          public:
               virtual string* getAvailableLoans(){}
               virtual float getInterestRate(){}
               virtual string getDocReqForGoldLoan(){}
               virtual string getDocReqForLandLone(){}
               virtual string getDocReqForPersonalLone(){}

};


#endif