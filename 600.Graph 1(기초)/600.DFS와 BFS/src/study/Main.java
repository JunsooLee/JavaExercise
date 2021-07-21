package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://m.blog.naver.com/lm040466/221787478911
 * dfs는 단순히 인접행렬로만으로도 구현 가능하지만
 * bfs는 Queue를 활용하여 확인한다.
 * https://baaaaaaaaaaaaaaaaaaaaaaarkingdog.tistory.com/729
 * BFS 설명: https://blog.encrypted.gg/941
 * DFS 설명: https://blog.encrypted.gg/942
 */

public class Main {
	public static int N, M, V;
	public static int[][] arr;
	public static boolean[] visit;

	public static void dfs(int idx) {
		visit[idx] = true;

		System.out.print(idx + " ");

		for (int i = 1; i < N + 1; i++) {
			if (arr[idx][i] == 1 && visit[i] == false)
				dfs(i);
		}
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(V);

		visit[V] = true;

		System.out.print(V + " ");

		while (!queue.isEmpty()) {
			int tmp = queue.poll();

			for (int j = 1; j <= N; j++) {
				if (arr[tmp][j] == 1 && visit[j] == false) {
					queue.offer(j);
					visit[j] = true;
					System.out.print(j + " ");
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];
		visit = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			arr[tmp1][tmp2] = 1;
			arr[tmp2][tmp1] = 1;
		}

		dfs(V);

		visit = new boolean[N + 1];
		System.out.println();

		bfs();
	}

}
