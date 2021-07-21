package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < cnt; i++) {
			String input = br.readLine();
			if (input.contains("push")) {
				int input2 = Integer.parseInt(input.split(" ")[1]);
				stack.push(input2);
			} else if (input.equals("pop")) {
				System.out.println(stack.isEmpty() ? -1 : stack.pop());
			} else if (input.equals("size")) {
				System.out.println(stack.size());
			} else if (input.equals("empty")) {
				System.out.println(stack.isEmpty() ? 1 : 0);
			} else if (input.equals("top")) {
				System.out.println(stack.isEmpty() ? -1 : stack.peek());
			}
		}
		br.close();
	}
}