package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Double> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		double[] num = new double[N];
		
		for(int i=0; i<N; i++) {
			num[i] = Double.parseDouble(br.readLine());
		}
		
		for(char c: str.toCharArray()) {
			if('A' <= c && c <= 'Z') {
				stack.push(num[c - 65]);
			}else {
				double tmp1 = stack.pop();
				double tmp2 = stack.pop();
				
				switch(c) {
				case '+':
					stack.push(tmp2 + tmp1);
					break;
				case '-':
					stack.push(tmp2 - tmp1);
					break;
				case '*':
					stack.push(tmp2 * tmp1);
					break;
				case'/':
					stack.push(tmp2 / tmp1);
					break;
				}
			}
		}
		System.out.printf("%04.2f", stack.pop());
	}
}
