package study;

import java.util.Scanner;

public class Main {

	public static int GCD(int n, int m) {
		int tmp = 0;

		if (n % m == 0) 
			return m;
		else
			tmp = GCD(m, n % m);
		return tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		System.out.println(GCD(A, B));
		System.out.println((A * B) / GCD(A, B));
		
		sc.close();
	}
}
