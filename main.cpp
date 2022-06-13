#include<iostream>

#include "Bike.h"
#include "Car.h"

using std::cout;

int main()
{
     Car car1("Diesel","XXX","YYY","black",200,100000,4,"SUV");

     Car car2("Petrol","AAA","BBB","white",200,500000,4,"Sedan");

     Bike bike1("Petrol","XXX","YYY","black",200,150000,90,"Scooter");

     Bike bike2("EV","AAA","BBB","white",200,140000,90,"Motorbike");

          cout<<"Car Details\n";
           
           cout<<car1;
           
           cout<<car2;


          cout<<"Bike Details\n";

          cout<<bike1;

          cout<<bike2;


      if(  car1<car2 )
      {
          cout<<"price of car1 is less than price of car2\n";
      }    
       

      else
      {
          cout<<"price of car1 is greater than price of car2\n";
      }   

      if( bike1<bike2 )
      {
          cout<<"price of bike1 is less than price of bike2\n";
      }

      else
      {
          cout<<"price of bike1 is greater than price of bike2\n";
      } 

      if( car1<bike1 )
      {
          cout<<"price of car1 is less than price of bike1\n";
      }

      else
      {
          cout<<"price of car1 is greater than price of bike1\n";
      } 

      if( car2<bike2 )
      {
          cout<<"price of car2 is less than price of bike2\n";
      }

      else
      {
          cout<<"price of car2 is greater than price of bike2\n";
      } 
      
      if( car1<bike2 )
      {
          cout<<"price of car1 is less than price of bike2\n";
      }

      else
      {
          cout<<"price of car1 is greater than price of bike2\n";
      } 


      if( car2<bike1 )
      {
          cout<<"price of car2 is less than price of bike1\n";
      }

      else
      {
          cout<<"price of car2 is greater than price of bike1\n";
      } 
      
      cout<<"No of Wheels in car1 :"<<car1.getNoOfWheels()<<"\n"; 
      
      cout<<"No of Wheels in car2 :"<<car2.getNoOfWheels()<<"\n"; 

      cout<<"No of Wheels in bike1 :"<<bike1.getNoOfWheels()<<"\n"; 

      cout<<"No of Wheels in bike2 :"<<bike2.getNoOfWheels()<<"\n"; 
      
      


     return 0;
}

