package study;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int value = 1;

		for(int i=0; i<n; i++) {
			value = value * (i+1);
		}
		
		System.out.println(value);
		
		sc.close();
	}
}
