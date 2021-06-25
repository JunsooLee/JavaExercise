package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://velog.io/@lre12/%EB%B0%B1%EC%A4%80-13549%EB%B2%88-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%883
 * 텔레포트의 경우 시간이 들지 않기 때문에 잘 생각해야한다.
 */

public class My {
	public static Queue<Integer> queue;
	public static int[] ways;

	public static int N, K;

	public static int bfs() {
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (cur == K) {
				return ways[cur];
			}

			int telpo = cur * 2;

			while (telpo <= 100000 && ways[telpo] == -1) {
				ways[telpo] = ways[cur];
				queue.add(telpo);
				telpo *= 2;
			}

			int[] tmp = { cur - 1, cur + 1 };

			for (int i = 0; i < 2; i++) {
				int next = tmp[i];

				if (next >= 0 && next <= 100000) {
					if (ways[next] == -1) {
						queue.offer(next);
						ways[next] = ways[cur] + 1;
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

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		queue = new LinkedList<>();
		ways = new int[100001];

		Arrays.fill(ways, -1);

		if (N >= K) {
			System.out.println(N - K);
		} else {
			queue.offer(N);
			ways[N] = 0;
			System.out.println(bfs());
		}
	}

}
