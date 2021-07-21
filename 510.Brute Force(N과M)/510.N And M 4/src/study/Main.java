package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static StringBuilder sb = new StringBuilder();

	public static int[] arr;
	public static int N, M;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];

		dfs(0);

		System.out.println(sb);
	}

	public static void dfs(int depth) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val + " ");
			}

			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (depth == 0) {
				arr[depth] = i + 1;
				dfs(depth + 1);
			} else {
				if (arr[depth - 1] <= i + 1) {
					arr[depth] = i + 1;
					dfs(depth + 1);
				}
			}
		}
	}
}
