
import java.util.Scanner;

public class ex2
{
 public static void main(String args[]){
     
          
        Scanner input = new Scanner(System.in);
        int number1;       
        int number2; 
      
        System.out.print( "Input1: " );       
        number1 = input.nextInt();  
 
        System.out.print( "Input2: " );       
        number2 = input.nextInt();              
        
        if ( number1 == number2 )           
            System.out.printf( "%d == %d\n", number1, number2 );  
        if ( number1 != number2 )          
            System.out.printf( "%d != %d\n", number1, number2 );  
        if ( number1 < number2 )          
            System.out.printf( "%d < %d\n", number1, number2 );  
        if ( number1 > number2 )          
            System.out.printf( "%d > %d\n", number1, number2 );  
        if ( number1 <= number2 )          
            System.out.printf( "%d <= %d\n", number1, number2 );  
        if ( number1 >= number2 )          
            System.out.printf( "%d >= %d\n", number1, number2 );  
    }
     
     
    }
        

