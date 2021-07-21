package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static char[][] arr;
	public static boolean[][] cycle;
	public static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };

	public static int N, M;

	public static boolean isCycle(int px, int py, int nx, int ny, int sx, int sy) {
		cycle[ny][nx] = true;

		for (int dir = 0; dir < 4; dir++) {
			int tx = nx + dx[dir];
			int ty = ny + dy[dir];

			if (tx < 0 || tx >= M || ty < 0 || ty >= N) {
				continue;
			}

			if (!cycle[ty][tx] && arr[ty][tx] == arr[ny][nx]) {
				if (isCycle(nx, ny, tx, ty, sx, sy))
					return true;
			}

			if (tx != px && ty != py && tx == sx && ty == sy && arr[ty][tx] == arr[ny][nx])
				return true;
		}

		cycle[ny][nx] = false;

		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new char[N][M];
		cycle = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();

			for (int j = 0; j < M; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (isCycle(j, i, j, i, j, i)) {
					System.out.println("Yes");
					System.exit(0);
				}
			}
		}

		System.out.println("No");
	}
}
