package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://velog.io/@kjh107704/%EA%B7%B8%EB%9E%98%ED%94%84-%EC%97%B0%EA%B2%B0-%EC%9A%94%EC%86%8C
 */

public class Main {
	public static int N, M;
	public static int count = 0;
	public static int[][] arr;
	public static boolean[] visited;

	public static void dfs(int idx) {
		if (visited[idx]) {
			return;
		} else {
			visited[idx] = true;

			for (int i = 1; i <= N; i++) {
				if (arr[idx][i] == 1)
					dfs(i);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			arr[tmp1][tmp2] = 1;
			arr[tmp2][tmp1] = 1;
		}

		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}

		System.out.println(count);
	}

}
