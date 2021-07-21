package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int w, h;
	public static int[] dx = { 1, -1, 0, 0, -1, -1, 1, 1 };
	public static int[] dy = { 0, 0, 1, -1, -1, 1, -1, 1 };
	public static int[][] arr;
	public static boolean[][] visit;

	public static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		int count = 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (arr[i][j] == 1 && !visit[i][j]) {
					queue.add(new Node(j, i));
					visit[i][j] = true;
					count++;
				}

				while (!queue.isEmpty()) {
					Node tmp = queue.poll();

					for (int dir = 0; dir < 8; dir++) {
						int nx = tmp.x + dx[dir];
						int ny = tmp.y + dy[dir];

						if (nx < 0 || nx >= w || ny < 0 || ny >= h)
							continue;

						if (arr[ny][nx] == 1 && !visit[ny][nx]) {
							queue.add(new Node(nx, ny));
							visit[ny][nx] = true;
						}
					}
				}
			}
		}

		System.out.println(count);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (h == 0 && w == 0)
				break;

			arr = new int[h][w];
			visit = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs();
		}

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