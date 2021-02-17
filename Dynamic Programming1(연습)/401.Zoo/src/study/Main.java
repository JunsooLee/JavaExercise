package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][N + 1];
		int answer = 0;

		for (int i = 1; i <= N; i++) {
			dp[i][0] = 1;
			dp[i][1] = 2 * i;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= i; j++) {
				for (int k = 2; k <= j; k++) {
					dp[i][j] += (2 * (2 * (k - 2) + 1)) % 9901;
				}
			}
		}

		for (int i = 0; i <= N; i++) {
			answer += dp[N][i];
			answer = answer % 9901;
		}

		bw.append(answer + "\n");
		bw.flush();
	}

}
