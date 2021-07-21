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
	// ���� ȭ���� ���°� ������ Ŭ�������� ���°� �ٸ��� ���� ����� �޶��� �� �ֱ� ������ 2���� �迭�� ����
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
					// ���� ȭ���� Ŭ�����忡 ����
					case 0:
						// ���� ȭ�鿡 �̸�Ƽ���� ���� ��� �Ѿ
						if (next == 0)
							continue;

						queue.offer(new Node(next, next));
						break;
					// Ŭ�������� �̸�Ƽ���� ���� ȭ�鿡 �ٿ��ֱ�
					case 1:
						// ���� ȭ�� + Ŭ�������� �̸�Ƽ�� ���� �ִ븦 �Ѿ�ų� �̹� �湮�߰ų� Ŭ�����忡 0���� �̸�Ƽ���� ���� ��� �Ѿ
						if (next > 1000 || visited[next][now.clip] || now.clip == 0)
							continue;

						visited[next][now.clip] = true;
						queue.offer(new Node(next, now.clip));
						break;
					// ���� ȭ�鿡�� �̸�Ƽ�� �ϳ� ����
					case 2:
						// �̹� �湮 �߰ų� �����Ͽ� 0���� �� ��� �Ѿ
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

		// ���� ȭ�鿡 1���� �̸�Ƽ�ܰ� Ŭ�� ���忡 0���� �̸�Ƽ���� �����ϴ� �ʱ� ����
		visited[1][0] = true;
		queue.offer(new Node(1, 0));
		System.out.println(bfs());
	}

}

class Node {
	// ���� ȭ���� ����(cnt)�� Ŭ�������� ����(clip)�� ���ÿ� �����ؾ���
	public int cnt;
	public int clip;

	public Node(int cnt, int clip) {
		this.cnt = cnt;
		this.clip = clip;
	}
}
