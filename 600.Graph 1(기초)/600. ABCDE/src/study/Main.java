package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://herong.tistory.com/entry/BOJ-13023-ABCDE-Graph
 * 
 * 문제의 조건을 만족하는 A, B, C, D, E의 친구관계가 있으면 1 출력
 * 
 * ArrayList[]를 통해 친구 관계를 관리하고 dfs를 사용하여 탐색.
 */

public class Main {

	public static int N, M, ans;
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;

	public static void dfs(int i, int depth) {
		if (depth == 5 || ans == 1) {
			ans = 1;
			return;
		}

		visited[i] = true;

		for (int j = 0; j < graph[i].size(); j++) {
			int tmp = graph[i].get(j);

			if (!visited[tmp]) {
				visited[tmp] = true;

				dfs(tmp, depth + 1);

				visited[tmp] = false;
			}
		}

		visited[i] = false;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			graph[tmp1].add(tmp2);
			graph[tmp2].add(tmp1);
		}

		ans = 0;

		for (int i = 0; i < N; i++) {
			dfs(i, 1);
			
			if (ans == 1)
				break;
		}

		System.out.println(ans);
	}

}
