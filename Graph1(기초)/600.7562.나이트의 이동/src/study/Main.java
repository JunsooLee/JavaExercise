package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 }, dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
	public static int[][] arr;
	public static int[][] visit;

	public static int T, I, X, Y, N, M;

	public static void bfs() {
		Queue<Node> queue = new LinkedList<>();

		if (X == N && Y == M) {
			sb.append(0 + "\n");
			return;
		}

		queue.add(new Node(X, Y));

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();

			for (int dir = 0; dir < 8; dir++) {
				int nx = tmp.x + dx[dir];
				int ny = tmp.y + dy[dir];

				if (nx < 0 || nx >= I || ny < 0 || ny >= I)
					continue;
				if (visit[ny][nx] == 0) {
					queue.add(new Node(nx, ny));
					visit[ny][nx] = visit[tmp.y][tmp.x] + 1;
				}

				if (nx == N && ny == M) {
					sb.append(visit[ny][nx] + "\n");
					return;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			I = Integer.parseInt(br.readLine());
			arr = new int[I][I];
			visit = new int[I][I];

			st = new StringTokenizer(br.readLine(), " ");
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			bfs();
		}
		
		System.out.println(sb);
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