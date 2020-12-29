package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue queue = new LinkedList();
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String newStr = str.replace(" ", "");
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(Integer.valueOf(newStr.charAt(i)) <newStr.charAt(j)) {
					queue.add(newStr.charAt(j));
				}
			}
			if(!queue.isEmpty())
				System.out.print(queue.peek() + " ");
			else
				System.out.print(-1 + " ");
			
			queue.clear();
		}
	}
}
