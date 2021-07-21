package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	/*
	 * https://velog.io/@pss407/%EB%B0%B1%EC%A4%8016947-%EC%84%9C%EC%9A%B8-%EC%A7%80
	 * %ED%95%98%EC%B2%A0-2%ED%98%B8%EC%84%A0
	 */
	public static ArrayList<Integer>[] list;
	public static boolean[] circle;
	public static int[] ans;

	public static int N;

	public static int bfs(int v) {
		Queue<Pair> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		queue.add(new Pair(v, 0));
		visited[v] = true;

		while (!queue.isEmpty()) {
			Pair tmp = queue.poll();

			if (circle[tmp.v])
				return tmp.cnt;

			for (int i = 0; i < list[tmp.v].size(); i++) {
				int e = list[tmp.v].get(i);

				if (!visited[e]) {
					visited[e] = true;
					queue.add(new Pair(e, tmp.cnt + 1));
				}
			}
		}

		return 0;
	}

	public static boolean dfs(int before, int v, int start) {
		circle[v] = true;

		for (int i = 0; i < list[v].size(); i++) {
			int e = list[v].get(i);

			if (!circle[e]) {
				if (dfs(v, e, start))
					return true;
			}

			else if (e != before && e == start)
				return true;
		}

		circle[v] = false;

		return false;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		circle = new boolean[N + 1];
		ans = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			list[tmp1].add(tmp2);
			list[tmp2].add(tmp1);
		}

		for (int i = 1; i <= N; i++) {
			if (dfs(i, i, i))
				break;
		}

		for (int i = 1; i <= N; i++) {
			if (circle[i])
				continue;

			int cnt = bfs(i);
			ans[i] = cnt;
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}

class Pair {
	public int v;
	public int cnt;

	public Pair(int v, int cnt) {
		this.v = v;
		this.cnt = cnt;
	}
}