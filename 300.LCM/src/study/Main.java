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

		int loop = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < loop; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			sc.nextLine();
			if ((1 <= A) && (A <= 45000) && (1 <= B) && (B <= 45000))
				System.out.println((A * B) / GCD(A, B));
		}

		sc.close();
	}
}
