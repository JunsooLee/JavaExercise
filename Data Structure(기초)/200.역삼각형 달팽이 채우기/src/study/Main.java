package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/68645 ���� ����
 * ���� ��ܿ��� ���� �����Ͽ� �Ʒ��� ���ﰢ�� ������� ������ ä��⸦ �����Ѵ�.
 * �迭�� ũ��� N*N�̸� 0����� ���ʴ�� ����Ѵ�.
 */
public class Main {
	public static int[][] arr;
	public static int[] answer;

	public static int N;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		answer = new int[N * (N + 1) / 2];

		int x = N, y = -1, count = 1;

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (i % 3 == 0) {
					x--;
					y++;
				} else if (i % 3 == 1) {
					y--;
				} else if (i % 3 == 2) {
					x++;
				}

				arr[y][x] = count;
				count++;
			}
		}
		
		int k = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-i; j++) {
				answer[k] = arr[i][j];
				System.out.print(answer[k]+", ");
			}
		}
	}

}
