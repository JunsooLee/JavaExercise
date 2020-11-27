package study;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] numbers;

		int N = sc.nextInt();
		sc.nextLine();
		int[] number = new int[N];
		int count = 0;
		
		numbers = sc.nextLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(numbers[i]);
		}

		for (int i = 0; i < N; i++) {
			boolean isPrime = true;
			
			if(number[i] == 1)
				isPrime = false;
			
			for (int j = 2; j < number[i]; j++) {
				if (number[i] % j == 0) {
					isPrime = false;
					break;
				}
				
			}
			if(isPrime)
				count++;
		}
		System.out.println(count);
		sc.close();
	}
}
