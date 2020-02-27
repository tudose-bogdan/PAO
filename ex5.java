
public class ex5
{
   
 public static int prim(int n)
 {
  if(n==2)
  return 1;
  
  if(n==0 || n==1)
  return 0;
  
  for(int i=2;i<=n/2;i++)
  {
     if(n%i == 0)
     return 0;
      
    }
     
    return 1; 
  }

       
  public static void main(String args[])
  {
     int n = 16;
     
     int r = prim(n);
     
     System.out.println(r);
  
      
    
      
     
      
   }
}
