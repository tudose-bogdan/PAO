
public class ex7
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
        
   public static int cmmfp(int n)
   {
       int i = 0; 
       int r = 0;
       for(i=0;i<=n/2;i++)
       {
           
           if(prim(i)==1 && i>r && n%i==0)
           r = i;
        }
       
       return r;
    }
    
    
  public static void main(String args[])
  {
     int n = 15;
     
     int rez =  cmmfp(n);
     
     System.out.println(rez);
  
    
      
     
      
   }
}
