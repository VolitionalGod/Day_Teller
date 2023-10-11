#include<iostream.h>
#include<stdlib.h>
#include<conio.h>
int main()
{
const char *ad_1[]={"Sunday","Monday","Tuesday","Wednesday","Thursday",
                    "Friday","Saturday",};
char *tmp;
long int year;
int month,day,check[]={31,0,31,30,31,30,31,31,30,31,30,31},i;
do
{
clrscr();
do
{
cout<<"Enter the year (>=1) : ";
cin>>tmp;
year=atol(tmp);
}while(year<1);
if((year%4==0 && year%100!=0) || year%400==0)
{
check[1]=29;
}
else
{
check[1]=28;
}
do
{
cout<<"\nEnter the month (>=1 && <=12) : ";
cin>>tmp;
month=atoi(tmp);
}while(month<1 || month>12);
do
{
cout<<"\nEnter the day (>=1 && <="<<check[month-1]<<") : ";
cin>>tmp;
day=atoi(tmp);
}while(day<1 || day>check[month-1]);
cout<<"\nThe day "<<day<<"/"<<month<<"/"<<year<<" is a ";
year+=day-1+((year-1)/4)-((year-4)/100)+((year-1)/400);
for(i=month-2;i>=0;i--)
{
year+=check[i];
}
cout<<ad_1[year%7]<<".";
gotoxy(32,25);
cout<<"Press escape to exit, any other key to continue.";
}while(getch()!=27);
return(0);
}
