package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 코드: https://steady-coding.tistory.com/59
 * 다익스트라 알고리즘: https://gaybee.tistory.com/34
 * 해당 문제는 bfs문제이면서 다익스트라 문제이기 때문에 다익스트라 알고리즘 공부를 할 필요가 있어보임
 * 우선은 우선 순위 queue를 활용하여 구현했으나, 우선 순위 queue 또한 공부할 필요가 있음.
 */

public class Main {
	public static PriorityQueue<Node> queue;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static int N, M;

	public static void bfs() {
		queue = new PriorityQueue<>();

		queue.offer(new Node(1, 1, 0));
		visited[1][1] = true;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.x == M && cur.y == N) {
				System.out.println(cur.cnt);
				return;
			}

			for (int dir = 0; dir < 4; dir++) {
				int sx = cur.x + dx[dir];
				int sy = cur.y + dy[dir];

				if (sx < 1 || sx > M || sy < 1 || sy > N)
					continue;

				if (!visited[sy][sx]) {
					visited[sy][sx] = true;

					if (arr[sy][sx] == 1) {
						queue.offer(new Node(sx, sy, cur.cnt + 1));
					} else {
						queue.offer(new Node(sx, sy, cur.cnt));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();

			for (int j = 1; j <= M; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j - 1));
			}
		}

		bfs();

	}

}

class Node implements Comparable<Node> {
	public int x;
	public int y;
	public int cnt; // 부순 벽의 갯수

	Node(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return cnt - o.cnt;
	}

}
