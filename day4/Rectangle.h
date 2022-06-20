#ifndef RECTANGLE_H_INCLUDED
#define RECTANGLE_h_INCLUDED
#include<iostream>
#include<cmath>

using std::string;
using std::cout;

class Rectangle
{
       private: 

           int *left;
           int *top;
           int *width;
           int *height;
           int *area;

       public:

           Rectangle()
           {
               left=new int(0);
               top=new int(0);
               width=new int(0);
               height=new int(0);
               area=new int(0);
           }

           Rectangle( int width,int height )
           {
               this->width=new int(width);   
               this->height=new int(height);
               left=new int(0);
               top=new int(0);  
               this->area=new int(width*height);
           }

           Rectangle( int left,int top,int width,int height )
           {
               this->left=new int(left);
               this->top=new int(top);
               this->width=new int(width);
               this->height=new int(height);
               this->area=new int(width*height);
           }

           Rectangle( float left,float top,float width,float height )
           {
               this->left=new int( round(left)  );
               this->top=new int( round(top) );
               this->width=new int( round(width) );
               this->height=new int( round(height) );
               this->area=new int( round(width)*round(height) );
           }

           Rectangle(const Rectangle &referRect )
           {
               this->left=new int(*referRect.left);
               this->top=new int(*referRect.top);
               this->width=new int(*referRect.width);
               this->height=new int(*referRect.height);
               this->area=new int( (*this->width)*(*this->height)  );                 
           }

           void printValues()
           {
                 cout<<"\nLeft="<<*left<<"\ntop="<<*top<<"\nWidth="<<*width<<"\nHeight="<<*height<<"\nArea="<<*area<<"\n";
           }

          

           ~Rectangle()
           {
               delete(left);
               delete(top);
               delete(width);
               delete(height);

           }

};



#endif