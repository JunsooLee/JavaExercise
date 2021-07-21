package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://velog.io/@hyeon930/BOJ-13913-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88-4-Java
 */

public class Main {
	public static final int Max = 100000;

	public static Queue<Integer> queue;
	public static int[] ways;

	public static int N, K, time;

	public static int bfs() {
		int depth = 0;

		while (!queue.isEmpty()) {
			depth++;
			int size = queue.size();
			
			// 싸이클이 돌 때마다 큐의 사이즈(=leaf node의 갯수)만큼 반복하여 depth(=걸리는 시간)을 구하고
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				int[] next = { cur + 1, cur - 1, cur * 2 };

				for (int j = 0; j < 3; j++) {

					if (next[j] >= 0 && next[j] <= Max && ways[next[j]] == -1) {
						// ways에는 이전 경로를 저장하여 트랙킹할 수 있게 한다.
						ways[next[j]] = cur;

						if (next[j] == K)
							return depth;

						queue.offer(next[j]);
					}
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N != K) {
			// ways는 visited와 경로 역추적 역할을 함 -1일 경우 방문하지 않은 경우로 생각
			ways = new int[Max + 1];
			queue = new LinkedList<>();

			Arrays.fill(ways, -1);
			queue.offer(N);

			time = bfs();
			sb.append(time + "\n");

			int[] result = new int[time + 1];
			int before = K;
			for (int i = time; i >= 0; i--) {
				result[i] = before;
				before = ways[before];
			}

			for (int i = 0; i <= time; i++) {
				sb.append(result[i] + " ");
			}

		} else {
			sb.append(0 + "\n" + K);
		}

		System.out.println(sb.toString());
	}
}
