#include "Rectangle.h"

using std::cout;
using std::cin;

int main()
{
        Rectangle rectangle1;
       
        

        rectangle1.printValues();
         
        int left,top,width,height;

        cout<<"Enter left value of Ractangle\n";
        cin>>left;
       
        cout<<"Enter top value of Ractangle\n";
        cin>>top;

        cout<<"Enter width of Ractangle\n";
        cin>>width;

        cout<<"Enter height of Ractangle\n";
        cin>>height;

        Rectangle rectangle2(left,top,width,height);

        rectangle2.printValues();

        cout<<"Enter width of Ractangle\n";
        cin>>width;

        cout<<"Enter height of Ractangle\n";
        cin>>height;

        Rectangle rectangle3(width,height);

        rectangle3.printValues();


        float left1,top1,width1,height1;

        cout<<"Enter left value of Ractangle(use decimal values)\n";
        cin>>left1;
       
        cout<<"Enter top value of Ractangle(use decimal values)\n";
        cin>>top1;

        cout<<"Enter width of Ractangle(use decimal values)\n";
        cin>>width1;

        cout<<"Enter height of Ractangle(use decimal values)\n";
        cin>>height1;

        Rectangle rectangle4(left1,top1,width1,height1);

        rectangle4.printValues();

        cout<<"Copy Constructor";

        Rectangle rectangle=rectangle2;

        rectangle.printValues();

        return 0;
}