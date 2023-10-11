/**
 *
 * @author VolitionalGod
 */
 
import java.util.Scanner;

public class DayTeller {

    private int day,month,i,check[];
    private long year,index;
    private String ad1[];
    Scanner s = new Scanner(System.in);
    
    DayTeller()
    {
        day=month=i=0;
        year=index=0;
        ad1 = new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        check = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};        
    }
        
    public void getYear()
    {
        do
        {
        System.out.print("Enter the year (>= 1) : ");
        year = s.nextLong();
        }while(year<=0);      
    }
    
    public void setLeap()
    {
        if(year%4==0 && year%100!=0 || year%400==0)
        {
            check[1]+=1;
        }
    }
    
    public void getMonth()
    {
        do
        {
        System.out.print("Enter the month (>= 1 AND <=12) : ");
        month = s.nextInt();
        }while(month<=0 || month>=13);        
    }
    
    public void getDay()           
    {
        do
        {
        System.out.print("Enter the day (>= 1 AND <="+check[month-1]+") : ");
        day = s.nextInt();
        }while(day<=0 || day>check[month-1]);        
    }
    
    public void genIndex()
    {
        index = day + (year-1) + ((year-1)/4) - ((year-1)/100) + ((year-1)/400);
        for(i=month-2;i>=0;i--)
        {
            index += check[i];
        }
        index %= 7;
    }
    
    public void displayDay()
    {
        System.out.println(day+"/"+month+"/"+year+" is a "+ad1[(int)index]+".");        
    }    
        
    
    public static void main(String[] args) {
        
        DayTeller obj = new DayTeller();
        obj.getYear();
        obj.setLeap();
        obj.getMonth();
        obj.getDay();
        obj.genIndex();
        obj.displayDay();                
    }
}
