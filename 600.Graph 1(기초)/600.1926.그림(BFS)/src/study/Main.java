package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static Queue<Node> queue;

	public static int N, M, num = 0, max = 0;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, -1, 0, 1 };

	public static void bfs(int x, int y) {

		queue = new LinkedList<>();
		queue.add(new Node(x, y));
		
		int area = 0;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			area++;

			for (int dir = 0; dir < 4; dir++) {
				int tmpX = node.x + dx[dir];
				int tmpY = node.y + dy[dir];

				if (tmpX < 0 || tmpY < 0 || tmpX >= N || tmpY >= M)
					continue;

				if (visited[tmpX][tmpY] == true || arr[tmpX][tmpY] == 0)
					continue;

				visited[tmpX][tmpY] = true;
				queue.add(new Node(tmpX, tmpY));
			}
		}
		
		num++;
		
		if(area >1 ) {
			area--;
		}
		
		max = Math.max(area, max);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}

		System.out.println(num + "\n" + max);
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
