package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static StringBuilder sb = new StringBuilder();

	public static int[] arr, num;
	public static boolean[] visit;

	public static int N, M;

	public static void dfs(int depth) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val + " ");
			}
			sb.append("\n");

			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;

				if (depth == 0) {
					arr[depth] = num[i];
					dfs(depth + 1);
				} else {
					if (arr[depth - 1] < num[i]) {
						arr[depth] = num[i];
						dfs(depth + 1);
					}
				}

				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N];
		num = new int[N];
		arr = new int[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0);

		System.out.println(sb);
	}

}
