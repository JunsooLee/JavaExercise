package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class UsingStack {
	
	public static void print(Stack<Character> stack) {
		while(!stack.empty()) {
			System.out.print(stack.peek());
			stack.pop();
		}
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==' ') {
				print(stack);
				System.out.print(str.charAt(i));
			}else {
				stack.push(str.charAt(i));
			}
		}
		
		print(stack);
	}

}
