public class ex6
{
   
  public static int fib(int n)
  {
   
   if(n==0 || n==1)
    return 1;
   
   int t1 = 1;
   int t2 = 1;
   
   int i = 3;
   int t = 0;
   while(i<=n)
   {
    t = t1 + t2;
    
    t1 = t2;
    
    t2 = t;
    
    i++;
   }
   
   return t;
     
  }
  
  
  
  
      
  public static void main(String args[])
  {
     
     int n =7;
     
     int rez = fib(n);
     
     System.out.println(rez);
      
    
      
     
      
   }

}
