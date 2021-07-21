package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		int[][] num = new int[n][n];
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < i + 1; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = num[0][0];
		dp[1][0] = dp[0][0] + num[1][0];
		dp[1][1] = dp[0][0] + num[1][1];

		for (int i = 2; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + num[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + num[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num[i][j];
				}
			}
		}

		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, dp[n - 1][i]);
		}

		bw.append(answer + "\n");
		bw.flush();
	}

}
