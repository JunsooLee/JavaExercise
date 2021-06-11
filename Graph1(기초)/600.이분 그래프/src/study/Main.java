package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://jellyinghead.tistory.com/14
 * 이분 그래프의 개념을 이해하고, group을 나눠서 체크(0: 아직 방문 X, 1, 2: 방문하여 각 그룹으로 나눔)
 */

public class Main {
	public static Queue<Integer> queue;
	public static ArrayList<Integer>[] list;
	public static int[] group;

	public static int K, V, E;

	public static void bfs() {
		queue = new LinkedList<>();

		for (int i = 1; i <= V; i++) {
			if (group[i] == 0) {
				queue.add(i);
				group[i] = 1;
			}

			while (!queue.isEmpty()) {
				int tmp = queue.poll();

				for (int j = 0; j < list[tmp].size(); j++) {
					if (group[list[tmp].get(j)] == 0) {
						queue.add(list[tmp].get(j));
					}

					if (group[list[tmp].get(j)] == group[tmp]) {
						System.out.println("NO");
						return;
					}

					if (group[tmp] == 1 && group[list[tmp].get(j)] == 0)
						group[list[tmp].get(j)] = 2;
					else if (group[tmp] == 2 && group[list[tmp].get(j)] == 0)
						group[list[tmp].get(j)] = 1;
				}
			}
		}

		System.out.println("YES");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			list = new ArrayList[V + 1];
			group = new int[V + 1];

			for (int i = 0; i <= V; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int tmp1 = Integer.parseInt(st.nextToken());
				int tmp2 = Integer.parseInt(st.nextToken());

				list[tmp1].add(tmp2);
				list[tmp2].add(tmp1);
			}

			bfs();
		}
	}

}
