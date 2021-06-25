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
			
			// ����Ŭ�� �� ������ ť�� ������(=leaf node�� ����)��ŭ �ݺ��Ͽ� depth(=�ɸ��� �ð�)�� ���ϰ�
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				int[] next = { cur + 1, cur - 1, cur * 2 };

				for (int j = 0; j < 3; j++) {

					if (next[j] >= 0 && next[j] <= Max && ways[next[j]] == -1) {
						// ways���� ���� ��θ� �����Ͽ� Ʈ��ŷ�� �� �ְ� �Ѵ�.
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
			// ways�� visited�� ��� ������ ������ �� -1�� ��� �湮���� ���� ���� ����
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
