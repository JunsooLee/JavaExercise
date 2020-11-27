package study;

import java.util.Scanner;

public class Main {
	
	public static boolean isPrime(int N) {
		if(N == 1)
			return false;
		for(int j=2; j<N; j++) {
			if(N%j == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		for(int i=N; i<M+1; i++) {
			if(isPrime(i))
				System.out.println(i);
		}
		sc.close();
	}
}
