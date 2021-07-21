package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static Queue<Node> queue = new LinkedList<>();

	public static int[][][] arr;
	public static int[][][] dist;

	public static int[] dx = { 0, 0, 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, 0, 0, 1, -1 };
	public static int[] dz = { 1, -1, 0, 0, 0, 0 };

	public static int N, M, H;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[N][M][H];
		dist = new int[N][M][H];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int k = 0; k < M; k++) {
					arr[j][k][i] = Integer.parseInt(st.nextToken());

					if (arr[j][k][i] == 1)
						queue.add(new Node(j, k, i));
				}
			}
		}

		bfs();

		int ans = 0;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (arr[j][k][i] == 0 && dist[j][k][i] == 0) {
						System.out.println(-1);
						System.exit(0);
					}
					
					if (ans < dist[j][k][i])
						ans = dist[j][k][i];
				}
			}
		}

		System.out.println(ans);
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int dir = 0; dir < 6; dir++) {
				int nx = node.x + dx[dir];
				int ny = node.y + dy[dir];
				int nz = node.z + dz[dir];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H)
					continue;

				if (arr[nx][ny][nz] == 0 && dist[nx][ny][nz] == 0) {
					queue.add(new Node(nx, ny, nz));
					dist[nx][ny][nz] = dist[node.x][node.y][node.z] + 1;
				}
			}
		}
	}
}

class Node {
	public int x, y, z;

	Node(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}