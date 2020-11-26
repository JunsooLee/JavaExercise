package study;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		String str;
		String[] tmp;

		int loop = sc.nextInt();
		sc.nextLine();
		if ((1 <= loop) && (loop <= 10000)) {
			for (int i = 0; i < loop; i++) {
				str = sc.nextLine();
				if (str.contains("push")) {
					tmp = str.split(" ");
					queue.add(Integer.parseInt(tmp[1]));
				} else if (str.contains("pop")) {
					if (!queue.isEmpty())
						System.out.println(queue.poll());
					else
						System.out.println(-1);
				} else if (str.contains("size")) {
					System.out.println(queue.size());
				} else if (str.contains("empty")) {
					if(queue.isEmpty())
						System.out.println(1);
					else
						System.out.println(0);
				} else if (str.contains("front")) {
					System.out.println(queue.getFirst());
				} else {
					System.out.println(queue.getLast());
				}
			}

		}
		sc.close();
	}
}
