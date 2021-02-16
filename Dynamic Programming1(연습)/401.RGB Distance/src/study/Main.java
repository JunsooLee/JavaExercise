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
		int[][] cost = new int[N][3];
		int[][] dp = new int[N][3];
		int answer;

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");

			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(str[j]);
			}
		}

		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0)
					dp[i][j] = Math.min(dp[i - 1][1] + cost[i][j], dp[i - 1][2] + cost[i][j]);
				else if (j == 1)
					dp[i][j] = Math.min(dp[i - 1][0] + cost[i][j], dp[i - 1][2] + cost[i][j]);
				else if (j == 2)
					dp[i][j] = Math.min(dp[i - 1][0] + cost[i][j], dp[i - 1][1] + cost[i][j]);
			}
		}
		
		answer = dp[N-1][0];
		
		for(int i=0; i<3; i++) {
			if(dp[N-1][i] < answer)
				answer = dp[N-1][i];
		}
		
		bw.append(answer+"\n");
		bw.flush();
	}

}
