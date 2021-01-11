package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<Integer>();

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] answer = new int[n];
		int[] b = new int[1000001];
		String[] temp = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(temp[i]);
			b[a[i]]++;
		}

		stack.push(0);

		for (int i = 1; i < n; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
			}

			while (!stack.isEmpty() && b[a[stack.peek()]] < b[a[i]]) {
				answer[stack.pop()] = a[i];
			}
			stack.push(i);
		}
		while (!stack.empty()) {
			answer[stack.pop()] = -1;
		}

		for (int i = 0; i < n; i++) {
			bw.write(answer[i] + " ");
		}
		bw.write("\n");
		bw.flush();
	}
}
