package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://velog.io/@hyeon930/BOJ-2146-%EB%8B%A4%EB%A6%AC-%EB%A7%8C%EB%93%A4%EA%B8%B0-Java
 * BFS를 활용하여 우선 섬을 Numbering 하여 섬을 나눠준다.
 * 그 후, 각 정점들을 돌며 numbering이 된 정점을 Queue에 넣고 BFS 알고리즘을 사용하여 해당 정점과 다른 섬의 정점의 거리를 구함.
 * -1을 제외한 함수 리턴값들 중 최소값을 찾는다.
 * 
 */

public class Main {
	public static Queue<Node> queue;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static int N, answer;

	public static void numbering() {
		int number = 2;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] || arr[i][j] == 0)
					continue;

				arr[i][j] = number;
				queue.offer(new Node(j, i));
				visited[i][j] = true;

				while (!queue.isEmpty()) {
					Node cur = queue.poll();

					for (int dir = 0; dir < 4; dir++) {
						int nx = cur.x + dx[dir];
						int ny = cur.y + dy[dir];

						if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx] || arr[ny][nx] == 0)
							continue;

						if (arr[ny][nx] == 1) {
							queue.offer(new Node(nx, ny));
							arr[ny][nx] = number;
							visited[ny][nx] = true;
						}
					}
				}

				number++;
			}
		}
	}

	public static void init() {
		queue.clear();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
	}

	public static int findShortestBridge(int start) {
		int dist = -1;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Node cur = queue.poll();

				if (arr[cur.y][cur.x] != 0 && arr[cur.y][cur.x] != start) {
					return dist;
				}

				for (int dir = 0; dir < 4; dir++) {
					int nx = cur.x + dx[dir];
					int ny = cur.y + dy[dir];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N)
						continue;

					if (visited[ny][nx] || arr[ny][nx] == start)
						continue;

					queue.offer(new Node(nx, ny));
					visited[ny][nx] = true;
				}
			}
			dist++;
		}
		
		return -1;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		queue = new LinkedList<>();
		arr = new int[N][N];
		visited = new boolean[N][N];
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		numbering();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0)
					continue;

				init();

				queue.offer(new Node(j, i));
				visited[i][j] = true;

				int dist = findShortestBridge(arr[i][j]);

				if (dist == -1)
					continue;

				answer = (answer > dist) ? dist : answer;
			}
		}

		System.out.println(answer);
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
