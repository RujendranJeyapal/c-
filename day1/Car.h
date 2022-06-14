#ifndef CAR_H_INCLUDED
#define CAR_H_INCLUDED

#include<iostream>
#include "Vehicle.h"

using std::ostream;

class Car :public Vehicle
{
       private:
           int noOfPersons;
           string carType; 
            int noOfWheels=4;

        public:
          
          Car(string vehicleType,string brand,string model,string color,int mileage,double price,int noOfpersons,string carType) : Vehicle(vehicleType,brand,model,color,mileage,price)        
          {
              this->noOfPersons=noOfPersons;
              this->carType= carType;

          }

          int getNoOfWheels()
          {
               return noOfWheels;
          }


          int getNoOfPersons()
          {
               return noOfPersons;
          }

          string getCarType()
          {
                return carType;
          }
         


                 
        


};

#endif