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
		int[] num = new int[n];
		int[] dp = new int[n];
		int min = 0;
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());

			if (num[i] < 0) {
				min = Math.min(min, num[i]);
			}
		}
		
		dp[0] = num[0];
		max = dp[0];

		for (int i = 1; i < n; i++) {
			if (num[i] == min) {
				dp[i] = dp[i - 1];
				continue;
			}

			dp[i] = Math.max(num[i], dp[i - 1] + num[i]);

			max = Math.max(max, dp[i]);
		}

		bw.append(max + "\n");
		bw.flush();
	}

}
