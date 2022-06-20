#ifndef NESTEDNAMESPACE_H_INCLUDED
#define NESTEDNAMESPACE_H_INCLUDED

namespace mathsolutions
{
    
     
            inline namespace addtwonumbers
            {
                  int add(int a,int b)
                  {
                         return a+b;
                  } 

                  float add(float a,float b)
                  {
                         return a+b;
                  }

                  double add(double a,double b)
                  {
                         return a+b;
                  }

                  long add(long a,long b)
                  {
                         return a+b;
                  }

            }


            inline namespace subtwonumbers
            {
                  int subtract(int a,int b)
                  {
                         return a-b;
                  } 

                  float subtract(float a,float b)
                  {
                         return a-b;
                  }

                  double subtract(double a,double b)
                  {
                         return a-b;
                  }

                  long subtract(long a,long b)
                  {
                         return a-b;
                  }

            }


              
            inline namespace multwonumbers
            {
                  int multiple(int a,int b)
                  {
                         return a*b;
                  } 

                  float multiple(float a,float b)
                  {
                         return a+b;
                  }

                  double multiple(double a,double b)
                  {
                         return a+b;
                  }

                  long multiple(long a,long b)
                  {
                         return a+b;
                  }

            }  

            inline namespace divtwonumbers
            {
                  int divide(int a,int b)
                  {
                         return a/b;
                  } 

                  float divide(float a,float b)
                  {
                         return a/b;
                  }

                  double divide(double a,double b)
                  {
                         return a/b;
                  }

                  long divide(long a,long b)
                  {
                         return a/b;
                  }

            }

    
    

}


#endif