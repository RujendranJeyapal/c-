#ifndef BIKE_H_INCLUDED
#define BIKE_H_INCLUDED

#include<iostream>
#include "Vehicle.h"

using std::ostream;

 
class Bike : public Vehicle
{
       private:
          int weight;
          string bikeType;
          int noOfWheels=2;

       public:

           Bike(string vehicleType,string brand,string model,string color,int mileage,double price,int weight,string bikeType):Vehicle(vehicleType,brand,model,color,mileage,price) 
           {
                   this->weight=weight;
                   this->bikeType=bikeType;
           }   

           int getWeight()
           {
               return weight;
           }
             
           string getBikeType()
           {
               return bikeType;
           }  

           int getNoOfWheels()
           {
                return noOfWheels;
           }

          


};


#endif