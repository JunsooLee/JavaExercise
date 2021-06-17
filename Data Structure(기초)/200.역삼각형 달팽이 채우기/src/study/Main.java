package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/68645 문제 변형
 * 우측 상단에서 부터 시작하여 아래로 역삼각형 모양으로 달팽이 채우기를 진행한다.
 * 배열의 크기는 N*N이며 0행부터 차례대로 출력한다.
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
