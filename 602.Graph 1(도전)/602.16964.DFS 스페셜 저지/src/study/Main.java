package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * https://velog.io/@hyeon930/BOJ-16964-DFS-%EC%8A%A4%ED%8E%98%EC%85%9C-%EC%A0%80%EC%A7%80-Java
 * BFS에서 했던 것처럼 잘 해보자... 주의점은 똑같이 같은 부모에 있는 자식 노드의 순서에 따라 다양한 값이 생길 수 있다는 점. 다 따져줘야함
 */
public class Main {
	public static ArrayList<Integer>[] adj;
	public static boolean[] visited;
	public static int[] answer, arr;

	public static boolean flag;
	public static int N, idx;

	public static void dfs(int num) {
		HashSet<Integer> set = new HashSet<>();

		if (visited[num])
			return;

		visited[num] = true;

		for (int i = 0; i < adj[num].size(); i++) {
			int tmp = adj[num].get(i);

			if (visited[tmp])
				continue;

			set.add(tmp);
		}

		if (set.size() == 0)
			return;

		if (set.contains(answer[idx])) {
			dfs(answer[idx++]);
		} else {
			flag = false;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		adj = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		answer = new int[N];
		flag = true;
		idx = 1;

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adj[from].add(to);
			adj[to].add(from);
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}

		dfs(1);

		if (flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
