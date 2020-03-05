package lab2;

import java.util.Scanner;

public class ex1 {

	
	public static void main(String[] args) {
		
		
		int[] grades = new int[20];
		
		int sum = 0;
		int i = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		for(; i<grades.length;++i)
		{
			int val = scanner.nextInt();
			
			if(val == -1)
			{
				break;
			}
			
			grades[i] = val;
			sum += val;
		}
		
		
		scanner.close();
		
		System.out.println("the avg is: " + sum/i);
		
		
	}
	
}

