package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 연속된 수가 사용되지 않기 위해서는 마지막 자리를 확인하면 된다.
 * n의 마지막에 1이 올 경우 n-1에서 마지막 수는 2,3만 올 수 있고
 * n의 마지막에 2가 올 경우 n-2에서 마지막 수는 1,3만 올 수 있고
 * n의 마지막에 3이 올 경우 n-3에서 마지막 수는 1,2만 올 수 있다.
 * 초기의 1~3은 예외의 경우가 있으므로 직접 구해준 후 나머지는 점화식을 통해 풀 수 있다.
 */

public class Main {
	public static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int div = 1000000009; // div: 방법의 수를 나누는 값
		int limit = 100000; // limit: 정수 n의 최댓값
		
		dp = new int[limit + 1][4]; // dp[i][j]: 정수 i를 만드는데 마지막 자리의 숫자는 j인 방법의 개수
		dp[1][1] = dp[2][2] = dp[3][3] = dp[3][1] = dp[3][2] = 1;
		
		for (int i = 4; i <= limit; i++) {
			for (int j = 1; j <= 3; j++) {

				if (j == 1)
					dp[i][j] = dp[i - 1][2] + dp[i - 1][3];
				else if (j == 2)
					dp[i][j] = dp[i - 2][1] + dp[i - 2][3];
				else
					dp[i][j] = dp[i - 3][1] + dp[i - 3][2];
				
				dp[i][j] %= div;
			}
		}
		
		int loop = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= loop; tc++) {
			int n = Integer.parseInt(br.readLine());
			int answer = 0;
			
			for (int i = 1; i <= 3; i++) {
				//정수 n을 나타낼 수 있는 방법, 각각 끝자리가 1,2,3으로 끝나는 경우를 더해주면 됨.
				answer += dp[n][i];
				answer %= div;
			}
			
			bw.append(answer+"\n");
		}
		
		bw.flush();
	}
}
