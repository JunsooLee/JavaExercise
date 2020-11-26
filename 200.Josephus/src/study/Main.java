package study;

import java.util.Scanner;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		String str;
		String sentences = "<";
		
		int N, k;
		
		str = sc.nextLine();
		N = Integer.parseInt(str.split(" ")[0]);
		k = Integer.parseInt(str.split(" ")[1]);
		
		for(int i=0; i<N; i++) {
			queue.offer(i+1);
		}

		while(queue.size()!=1) {
			for(int i=0; i<k-1; i++) {
				queue.offer(queue.poll());
			}
			sentences = sentences.concat(queue.poll()+", ");
		}
		sentences = sentences.concat(queue.poll() + ">");
		
		System.out.println(sentences);
		
		sc.close();
	}

}
