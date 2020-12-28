package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static void print(Stack st) {
		while (!st.empty()) {
			System.out.print(st.peek());
			st.pop();
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack stack = new Stack();
		
		String str = br.readLine();
		boolean check = false;
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '<') {
				check = true;
				print(stack);
				System.out.print(str.charAt(i));
			}else if(str.charAt(i) == '>') {
				check = false;
				System.out.print(str.charAt(i));
			}else if(check == true) {
				System.out.print(str.charAt(i));
			}else {
				if(str.charAt(i) ==' ') {
					print(stack);
					System.out.print(str.charAt(i));
				}else {
					stack.push(str.charAt(i));
				}
			}
		}
		print(stack);
	}

}
