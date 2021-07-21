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
		long[][] dp = new long[N][2];

		if (N == 1)
			bw.append(1 + "\n");
		
		else {
			dp[0][1] = 1;
			dp[1][0] = 1;

			for (int i = 2; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					if (j == 1) {
						dp[i][j] = dp[i - 1][j - 1];
					} else {
						dp[i][j] = dp[i - 1][j] + dp[i - 1][j + 1];
					}
				}
			}

			long answer = 0;

			for (int i = 0; i < 2; i++) {
				answer += dp[N - 1][i];
			}

			bw.append(answer + "\n");
		}
		
		bw.flush();
	}

}
