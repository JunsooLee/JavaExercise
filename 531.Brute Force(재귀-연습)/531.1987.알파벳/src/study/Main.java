package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 처음에는 bfs문제로 생각하고 풀었지만, 그렇게 풀 경우에 같은 block이라도 돌아가는 경우가 있기 떄문에
 * 제대로 값이 나오지가 않았음.
 * 한 block에서 4방향을 검사하여 방문하지 않으면 dfs를 사용하여 계속 탐색하는 방법을 사용해야함.
 */

public class Main {
	public static char[][] arr;
	public static boolean[] visited;
	public static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static int R, C, max = Integer.MIN_VALUE;

	public static void dfs(int x, int y, int depth) {
		visited[arr[y][x] - 65] = true;

		for (int dir = 0; dir < 4; dir++) {
			int cx = x + dx[dir];
			int cy = y + dy[dir];

			if (cx < 0 || cx >= C || cy < 0 || cy >= R)
				continue;

			if (!visited[arr[cy][cx] - 65]) {
				dfs(cx, cy, depth+1);
			}
		}
		
		visited[arr[y][x] - 65] = false;
		max = Math.max(max, depth);
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		visited = new boolean[26];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		dfs(0, 0, 1);

		System.out.println(max);
	}
}