
#include "HDFC.h"
#include "SBI.h"
#include "ICICI.h"
#include "IB.h"

#include "Broker.h"
#include<array>

using std::cout;

int main()
{
       HDFC hdfc("private","Bodinayakanur",5.8);

       SBI sbi("public","Theni",5);

       ICICI icici("public","Madurai",7);

       IB ib("public","Thevaram",8.2);

       Broker callBroker;

      
         
         

       cout<<callBroker.compareInterestRate(hdfc,icici)->getBankName()<<"\n" ;  
      
       cout<<callBroker.compareInterestRate(sbi,icici,ib)->getBankName()<<"\n" ;  

       Bank *banks[]={&hdfc,&sbi,&icici,&ib};
                 
       

      cout<<callBroker.compareInterestRate(banks,4)->getBankName()<<"\n" ; 

       callBroker.getBankInfo(hdfc);

       callBroker.getBankInfo(sbi);

       callBroker.getBankInfo(icici);
       callBroker.getBankInfo(ib);

       callBroker.getBankInfo(banks,4);


       return 0;
}