#ifndef SBI_H_INCLUDED
#define SBI_H_INCLUDED

#include "Bank.h"


class SBI:public Bank
{
       private:
             
             string bankName="State Bank Of India";
             string establishedDate="11/10/1998";
             string bankType;
             string branch;
             string availableLoans[3]={"Gold Loan","Land Loan","Personal Loan"};
             float interestRate;
             string docReqForGoldLoan="Gold Document";
             string docReqForLandLoan="Land Document";
             string docReqForPersonalLoan="Property Document";


        public:

            SBI(string bankType,string branch,float interestRate)
            {
                this->bankType=bankType;
                this->branch=branch;
                this->interestRate=interestRate;
            }

            string getBankName()
            {
                  return bankName;
            }

            string getEstablishedDate()
            {
                  return establishedDate;
            }  

            string getBankType()
            {
                return bankType;
            }

            string getBranch()
            {
                return branch;
            }

            void getInfo()
            {
                std::cout<< "BankName -"+bankName+"\nEstablished Date -"+establishedDate+"\nBank Type -"+bankType+"\nBranch -"+branch+"\n";
            }

            string* getAvailableLoans()
            {
                return availableLoans;
            }

            float getInterestRate()
            {
                return interestRate;
            }

            string getDocReqForGoldLoan()
            {
                return docReqForGoldLoan;
            }

            string getDocReqForLandLone()
            {
                return docReqForLandLoan;
            }

            string getDocReqForPersonalLone()
            {
                return docReqForPersonalLoan;
            }

};



#endif