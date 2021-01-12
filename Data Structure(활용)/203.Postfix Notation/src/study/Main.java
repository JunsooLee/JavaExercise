package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	// 차량기지 알고리즘과 스택을 활용하여 중위 표기법을 후위 표기법으로 변경
	// 각 연산자에 우선순위를 지정해주는 함수가 필요함
	static int precedence(char ch) {
		if (ch == '(')
			return 0;
		if (ch == '+' || ch == '-')
			return 1;
		else
			return 2;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();

		String str = br.readLine();
		for (char c: str.toCharArray()) {
			if('A'<= c && c <= 'Z') {
				bw.append(c);
			}else if(c == '(') {
				stack.push(c);
			}else if(c == ')') {
				char tmp = stack.pop();
				
				while(tmp!='(') {
					bw.append(tmp);
					tmp = stack.pop();
				}
			}else {
				while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
					bw.append(stack.pop());
				}
				
				stack.push(c);
			}
		}
		
		while (!stack.isEmpty()) {
			bw.append(stack.pop());
		}
		
		bw.append("\n");
		bw.flush();
	}

}
