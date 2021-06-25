package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://velog.io/@hyeon930/BOJ-14226-%EC%9D%B4%EB%AA%A8%ED%8B%B0%EC%BD%98-Java
 */

public class Main {
	public static Queue<Node> queue;
	// 현재 화면의 상태가 같더라도 클립보드의 상태가 다르면 다음 결과가 달라질 수 있기 때문에 2차원 배열로 설정
	public static boolean[][] visited;

	public static int S;

	public static int bfs() {
		int time = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			time++;

			for (int i = 0; i < size; i++) {
				Node now = queue.poll();

				int[] tmp = { now.cnt, now.cnt + now.clip, now.cnt - 1 };

				for (int j = 0; j < tmp.length; j++) {
					int next = tmp[j];

					if (next == S)
						return time;

					switch (j) {
					// 현재 화면을 클립보드에 복사
					case 0:
						// 현재 화면에 이모티콘이 없을 경우 넘어감
						if (next == 0)
							continue;

						queue.offer(new Node(next, next));
						break;
					// 클립보드의 이모티콘을 현재 화면에 붙여넣기
					case 1:
						// 현재 화면 + 클립보드의 이모티콘 수가 최대를 넘어가거나 이미 방문했거나 클립보드에 0개의 이모티콘이 있을 경우 넘어감
						if (next > 1000 || visited[next][now.clip] || now.clip == 0)
							continue;

						visited[next][now.clip] = true;
						queue.offer(new Node(next, now.clip));
						break;
					// 현재 화면에서 이모티콘 하나 삭제
					case 2:
						// 이미 방문 했거나 삭제하여 0개가 될 경우 넘어감
						if (visited[next][now.clip] || next == 0)
							continue;

						visited[next][now.clip] = true;
						queue.offer(new Node(next, now.clip));
						break;
					}
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = Integer.parseInt(br.readLine());

		visited = new boolean[1001][1001];
		queue = new LinkedList<>();

		// 현재 화면에 1개의 이모티콘과 클립 보드에 0개의 이모티콘이 존재하는 초기 상태
		visited[1][0] = true;
		queue.offer(new Node(1, 0));
		System.out.println(bfs());
	}

}

class Node {
	// 현재 화면의 상태(cnt)와 클립보드의 상태(clip)을 동시에 저장해야함
	public int cnt;
	public int clip;

	public Node(int cnt, int clip) {
		this.cnt = cnt;
		this.clip = clip;
	}
}
