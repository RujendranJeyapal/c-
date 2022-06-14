
#include "HDFC.h"
#include "SBI.h"
#include "ICICI.h"
#include "IB.h"

#include "Broker.h"

using std::cout;

int main()
{
       HDFC hdfc1("private","Bodinayakanur",5.8);

       SBI sbi1("public","Theni",5);

       ICICI icici1("public","Madurai",7);

       IB ib("public","Thevaram",8.2);

       Broker callBroker;

      
         
         

       cout<<callBroker.compareInterestRate(hdfc1,sbi1).getBankName() ;  
      
       

       return 0;
}