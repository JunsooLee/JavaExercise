package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	public static int[][] arr;
	public static int[][] visit;

	public static int N, M, day = Integer.MIN_VALUE;

	public static void bfs() {
		Queue<Node> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && visit[i][j] == 0) {
					queue.add(new Node(j, i));
					visit[i][j] = 1;
				}
			}
		}

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = tmp.x + dx[dir];
				int ny = tmp.y + dy[dir];

				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;

				if (arr[ny][nx] == 0 && visit[ny][nx] == 0) {
					queue.add(new Node(nx, ny));
					visit[ny][nx] = visit[tmp.y][tmp.x] + 1;
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visit = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0 && visit[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}

				day = (day < visit[i][j]) ? visit[i][j] : day;
			}
		}

		System.out.println(day - 1);
	}

}

class Node {
	public int x;
	public int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}