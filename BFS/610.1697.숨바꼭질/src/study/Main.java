package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static Queue<Integer> queue = new LinkedList<>();
	public static int[] visited;

	public static int N, K;

	public static int bfs() {
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (cur == K) {
				return visited[cur];
			}

			int[] tmp = { cur + 1, cur - 1, cur * 2 };

			for (int i = 0; i < 3; i++) {
				int next = tmp[i];

				if (next >= 0 && next < 100001 && visited[next] == -1) {
					queue.offer(next);
					visited[next] = visited[cur] + 1;
				}
			}

		}

		return -1;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new int[1000001];

		Arrays.fill(visited, -1);

		queue.offer(N);
		visited[N] = 0;
		System.out.println(bfs());
	}

}
