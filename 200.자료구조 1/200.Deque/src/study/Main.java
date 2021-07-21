package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		String str;

		int number = 0;
		int loop = Integer.parseInt(br.readLine());

		for (int i = 0; i < loop; i++) {
			str = br.readLine();

			if (str.contains("push_back")) {
				number = Integer.parseInt(str.split(" ")[1]);
				deque.addLast(number);
			} else if (str.contains("push_front")) {
				number = Integer.parseInt(str.split(" ")[1]);
				deque.addFirst(number);
			} else if (str.contains("pop_front")) {
				if (!deque.isEmpty())
					System.out.println(deque.pollFirst());
				else
					System.out.println(-1);
			} else if (str.contains("pop_back")) {
				if (!deque.isEmpty())
					System.out.println(deque.pollLast());
				else
					System.out.println(-1);
			} else if (str.contains("size")) {
				System.out.println(deque.size());
			} else if (str.contains("empty")) {
				if (deque.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
			} else if (str.contains("front")) {
				if (!deque.isEmpty())
					System.out.println(deque.getFirst());
				else
					System.out.println(-1);
			} else {
				if (!deque.isEmpty())
					System.out.println(deque.getLast());
				else
					System.out.println(-1);
			}
		}
		br.close();
	}
}
