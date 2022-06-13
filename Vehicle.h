#ifndef VEHICLE_H_INCLUDED
#define VEHICLE_H_INCLUDED

#include<iostream>

using std::string;
using std::ostream;

class Vehicle
{
        private:
          string vehicleType,brand,model,color;    
          int mileage;
          double price;

          public :

              Vehicle(string vehicleType,string brand,string model,string color,int mileage,double price)
              {
                     this->vehicleType=vehicleType;
                     this->brand=brand;
                     this->model=model;
                     this->color=color;
                     this->mileage=mileage;
                     this->price=price;

              }

              string getVehicleType()
              {
                     return vehicleType;
              }

             
              string getBrand()
              {
                    return brand;
              }

              

              string getModel()
              {
                     return model;
              }

          

              string getColor()
              {
                   return color;
              }

            

              int getMileage()
              {
                   return mileage;
              }

           

              double getPrice()
              {
                    return price;
              }


              virtual int getNoOfWheels()=0;


              friend void operator<<(ostream &output,Vehicle &vehicle )
              {


                     
                output<<"Vehicle Type  :"<<vehicle.getVehicleType()<<"\n";
                output<<"Brand   :"<<vehicle.getBrand()<<"\n";
                output<<"Model   :"<<vehicle.getModel()<<"\n";
                output<<"Colour  :"<<vehicle.getColor()<<"\n";
                output<<"Mileage  :"<<vehicle.getMileage()<<"\n";
                output<<"Price    :"<<vehicle.getPrice()<<"\n";


             }

              /*friend*/ bool operator<(/*Vehicle &vehicle1,*/Vehicle &vehicle2)
             {
                      if( this->getPrice() < vehicle2.getPrice()  )
                      {
                            return true;
                      }

                      return false;
             }

              /*friend*/ bool operator>(/*Vehicle &vehicle1,*/Vehicle &vehicle2)
             {
                     if( this->getPrice()>vehicle2.getPrice() )
                     {
                              return true;
                     }  

                     return false;
             }


};


#endif