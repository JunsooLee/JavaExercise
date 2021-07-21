package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int max = 1;
	public static int N;

	public static void swapRight(char[][] arr, int row, int col) {
		char tmp = arr[row][col];
		arr[row][col] = arr[row][col + 1];
		arr[row][col + 1] = tmp;

		check(arr);

		tmp = arr[row][col];
		arr[row][col] = arr[row][col + 1];
		arr[row][col + 1] = tmp;
	}

	public static void swapUnder(char[][] arr, int row, int col) {
		char tmp = arr[row][col];
		arr[row][col] = arr[row + 1][col];
		arr[row + 1][col] = tmp;

		check(arr);

		tmp = arr[row][col];
		arr[row][col] = arr[row + 1][col];
		arr[row + 1][col] = tmp;
	}

	public static void check(char[][] arr) {

		for (int i = 0; i < N; i++) {
			int count = 1;

			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] == arr[i][j + 1]) {
					count++;
				} else {
					count = 1;
				}

				max = Math.max(max, count);
			}
		}

		for (int i = 0; i < N; i++) {
			int count = 1;

			for (int j = 0; j < N - 1; j++) {
				if (arr[j][i] == arr[j + 1][i]) {
					count++;
				} else {
					count = 1;
				}

				max = Math.max(max, count);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		char[][] candy = new char[N][N];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();

			for (int j = 0; j < N; j++) {
				candy[i][j] = tmp.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				// 가로로 찾을 때와 세로로 찾을 때 탐색해야하는 크기가 달라지는 점 유의
				swapRight(candy, i, j);
				swapUnder(candy, j, i);
			}
		}

		bw.append(max + "\n");
		bw.flush();
	}

}
