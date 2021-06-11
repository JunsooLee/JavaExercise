package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static Queue<Node> queue = new LinkedList<>();
	public static ArrayList<Integer> list = new ArrayList<>();
	public static StringBuilder sb = new StringBuilder();
	public static int[][] arr, visit;
	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static int N, count = 0;

	public static void bfs() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num = 0;

				if (arr[i][j] == 1 && visit[i][j] == 0) {
					queue.add(new Node(i, j));
					visit[i][j] = 1;
					num = 1;
					count++;
				}

				while (!queue.isEmpty()) {
					Node tmp = queue.poll();
					for (int dir = 0; dir < 4; dir++) {
						int nx = tmp.x + dx[dir];
						int ny = tmp.y + dy[dir];

						if (nx < 0 || nx >= N || ny < 0 || ny >= N)
							continue;

						if (arr[nx][ny] == 1 && visit[nx][ny] == 0) {
							queue.add(new Node(nx, ny));
							visit[nx][ny] = 1;
							num++;
						}
					}
				}

				if (num > 0)
					list.add(num);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < N; j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}

		bfs();

		System.out.println(count);
		Collections.sort(list);
		
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i));
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
