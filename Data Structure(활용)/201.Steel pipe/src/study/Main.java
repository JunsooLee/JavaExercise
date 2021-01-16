package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		
		String str = br.readLine();
		int count = 0;
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='(') {
				stack.push(str.charAt(i));
			}
			else {
				stack.pop();
				if(str.charAt(i-1)=='(') {
					count += stack.size();
				}else {
					count += 1;
				}	
			}
		}
		System.out.println(count);
	}

}
