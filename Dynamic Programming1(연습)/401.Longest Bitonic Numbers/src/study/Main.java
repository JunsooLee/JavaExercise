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

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[][] dp = new int[N][2];
		int max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			dp[i][0] = 1;
			
			for (int j = 0; j < i; j++) {
				if (num[j] < num[i]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
				}
			}
		}
		
		for (int i = N - 1; 0 <= i; i--) {
			dp[i][1] = 1;
			
			for (int j = N - 1; i < j; j--) {
				if (num[j] < num[i]) {
					dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			int tmp = dp[i][0] + dp[i][1] - 1; //오름차순과 내림차순을 더할 때 기준 값이 중복되므로 1을 빼줘야한다.

			max = Math.max(max, tmp);
		}

		bw.append(max + "\n");
		bw.flush();
	}

}
