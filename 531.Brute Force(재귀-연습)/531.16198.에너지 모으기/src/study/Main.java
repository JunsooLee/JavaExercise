package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<Integer> list = new ArrayList<>();

	public static int N, max = Integer.MIN_VALUE;

	public static void backTracking(int energy) {
		if (list.size() == 2) {
			max = Math.max(energy, max);
			return;
		}

		for (int i = 1; i < list.size() - 1; i++) {
			int tmp = list.get(i);
			int sum = list.get(i - 1) * list.get(i + 1);

			list.remove(i);
			backTracking(sum + energy);
			list.add(i, tmp);
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		backTracking(0);

		System.out.println(max);
	}

}
