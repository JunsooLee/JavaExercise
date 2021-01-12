package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int b = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> que = new LinkedList<>();

		int cnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < cnt; i++) {

			String a = br.readLine();
			if (a.contains("push")) {
				b = Integer.parseInt(a.split(" ")[1]);
				que.add(b);
			} else if (a.contains("front")) {
				System.out.println(que.isEmpty() ? -1 : que.peek());
			} else if (a.contains("back")) {
				System.out.println(que.isEmpty() ? -1 : b);
			} else if (a.contains("size")) {
				System.out.println(que.size());
			} else if (a.contains("pop")) {
				System.out.println(que.isEmpty() ? -1 : que.poll());
			} else if (a.contains("empty")) {
				System.out.println(que.isEmpty() ? 1 : 0);
			}
		}
		br.close();
	}
}
