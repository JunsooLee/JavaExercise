package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * �ڵ�: https://steady-coding.tistory.com/59
 * ���ͽ�Ʈ�� �˰���: https://gaybee.tistory.com/34
 * �ش� ������ bfs�����̸鼭 ���ͽ�Ʈ�� �����̱� ������ ���ͽ�Ʈ�� �˰��� ���θ� �� �ʿ䰡 �־��
 * �켱�� �켱 ���� queue�� Ȱ���Ͽ� ����������, �켱 ���� queue ���� ������ �ʿ䰡 ����.
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
	public int cnt; // �μ� ���� ����

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
