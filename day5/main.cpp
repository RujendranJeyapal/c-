#include "NameSpace.h"
#include "NestedNameSpace.h"

using namespace print;

using namespace mathsolutions;

using std::cout;
using std::cin;
using std::endl;

namespace temp=mathsolutions::addtwonumbers;

int main()
{
        print::NameSpace r;  

        
        
        r.run();

        int number1,number2;

        cout<<"\nEnter first Number for Math Operation\n";
        cin>>number1;

        cout<<"\nEnter Second Number for Math Operation\n";
        cin>>number2;


        cout<<"Addition :"<<temp::add(number1,number2)<<endl;
        cout<<"Subtraction :"<<subtwonumbers::subtract(number1,number2)<<endl;
        cout<<"Multiplication :"<<multwonumbers::multiple(number1,number2)<<endl;
        cout<<"Division :"<<divtwonumbers::divide(number1,number2)<<endl;

          
        cout<<"This is Inline Functions\n";

        cout<<"Addition :"<<add(number1,number2)<<endl;
        cout<<"Subtraction :"<<subtract(number1,number2)<<endl;
        cout<<"Multiplication :"<<multiple(number1,number2)<<endl;
        cout<<"Division :"<<divide(number1,number2)<<endl;


          

        return 0;
}