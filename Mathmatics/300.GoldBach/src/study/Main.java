package study;

import java.util.Scanner;

public class Main {

	public static boolean isPrime(int N) {
		if (N == 1)
			return false;
		for (int j = 2; j < N; j++) {
			if (N % j == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int tmp = 0;
		int num = sc.nextInt();
		sc.nextLine();

		while (num != 0) {
			for (int i = 2; i < num; i++) {
				if (isPrime(i)) {
					tmp = num - i;
					if (isPrime(tmp)) {
						System.out.println(num + " = " + i + " + " + tmp);
						break;
					}
				}
			}
			num = sc.nextInt();
		}
		sc.close();
	}
}
