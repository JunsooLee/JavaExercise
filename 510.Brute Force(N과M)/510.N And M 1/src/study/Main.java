package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Backtracking의 기초적인 문제
 * visited를 통해 해당 depth의 노드를 방문했는지 아닌지를 확인
 */
public class Main {
	public static int[] arr;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visited = new boolean[N];
		
		dfs(N, M, 0);
		
		System.out.println(sb);
	}

	public static void dfs(int N, int M, int depth) {
		if (depth == M) { // 구하고자 하는 수열의 원소 갯수를 다 찾을 경우
			for (int val : arr) {
				sb.append(val + " ");
			}

			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				dfs(N, M, depth + 1);
				visited[i] = false;
			}
		}
	}

}
