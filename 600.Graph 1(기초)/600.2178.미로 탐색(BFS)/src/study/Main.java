package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static Queue<Node> queue;

	public static int N, M;
	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static int[][] arr, dist;
	public static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visit = new boolean[N][M];
		dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}

		dist[0][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && !visit[i][j])
					bfs(i, j);
			}
		}

		System.out.println(dist[N - 1][M - 1]);
	}

	public static void bfs(int x, int y) {
		queue = new LinkedList<>();
		queue.add(new Node(x, y));

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = node.x + dx[dir];
				int ny = node.y + dy[dir];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (arr[nx][ny] == 0 || visit[nx][ny])
					continue;

				queue.add(new Node(nx, ny));
				visit[nx][ny] = true;
				dist[nx][ny] = dist[node.x][node.y] + 1;
			}
		}
	}

}

class Node {
	public int x, y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
