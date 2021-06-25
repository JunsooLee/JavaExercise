package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * Current point에 인접한 node들을 Hashset에 넣은 후 정답에 해당하는 index가 있을 경우에 queue에 넣는 방식으로 진행.
 * https://velog.io/@hyeon930/BOJ-16940-BFS-%EC%8A%A4%ED%8E%98%EC%85%9C-%EC%A0%80%EC%A7%80-Java
 */

public class Main {
	public static ArrayList<ArrayList<Integer>> adj;
	public static Queue<Integer> queue;
	public static boolean[] visit;
	public static int[] answer;
	public static String str;

	public static int N;

	public static boolean bfs() {
		int idx = 1;
		HashSet<Integer> set = new HashSet<>();

		while (!queue.isEmpty()) {
			set.clear();

			int cur = queue.poll();

			for (int next : adj.get(cur)) {
				if (visit[next])
					continue;

				set.add(next);
				visit[next] = true;
			}

			int size = set.size();

			for (int i = idx; i < idx + size; i++) {
				if (set.contains(answer[i]))
					queue.offer(answer[i]);
				else
					return false;
			}

			idx += size;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		queue = new LinkedList<>();
		visit = new boolean[N + 1];
		answer = new int[N];

		adj = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());

			adj.get(tmp1).add(tmp2);
			adj.get(tmp2).add(tmp1);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}

		if (answer[0] != 1) {
			System.out.println(0);
			return;
		}

		queue.offer(1);
		visit[1] = true;

		if (bfs())
			System.out.println(1);
		else
			System.out.println(0);
	}
}
