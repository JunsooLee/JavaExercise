package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static long GCD(long n, long m) {
		long tmp = 0;

		if (n % m == 0) {
			return m;
		}

		tmp = GCD(m, n % m);

		return tmp;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Long> stack = new Stack<>();

		String seeker = br.readLine();
		int n = Integer.parseInt(seeker.split(" ")[0]);
		long s = Long.parseLong(seeker.split(" ")[1]);

		String hider = br.readLine();
		long[] hide = new long[n];

		for (int i = 0; i < n; i++) {
			hide[i] = Long.parseLong(hider.split(" ")[i]);
			hide[i] = Math.abs(hide[i] - s);
		}

		stack.push(hide[0]);
		
		for (int i = 1; i < hide.length; i++) {
			stack.push(GCD(stack.pop(), hide[i]));
		}

		System.out.println(stack.pop());
	}
}
