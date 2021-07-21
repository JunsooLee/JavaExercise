package study;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>();
		Scanner sc = new Scanner(System.in);

		int loop = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < loop; i++) {
			String str = sc.nextLine();
			if ((2 <= str.length()) && (str.length() <= 50)) {
				int count = 0;
				for (int j = 0; j < str.length(); j++) {
					String ps = str.substring(j, j + 1);
					if (ps.contains("(")) {
						stack.push(ps);
					} else {
						if (stack.isEmpty() == false) {
							stack.pop();
							count++;
						}
					}
				}
				if (count == Math.round((float) str.length() / 2))
					System.out.println("YES");
				else
					System.out.println("NO");
			} else {
				i--;
				continue;
			}
			stack.clear();
		}
		sc.close();
	}
}
