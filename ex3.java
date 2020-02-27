import java.util.Scanner;
public class ex3
{
    public static void main(String args[]){
        
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int sum = 0;
        for(int i=15;i<=n;i+=3)
        {
            if(i%3==0 && i%5==0)
            sum+=i;
            
        }
        
        System.out.println(sum);
        
        
        
        
        
        
        
    }
    
  

    
}
