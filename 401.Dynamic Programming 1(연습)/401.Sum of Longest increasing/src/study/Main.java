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
		int[] dp = new int[N];
		long answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = num[0];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (num[j] < num[i]) {
					dp[i] = Math.max(dp[i], dp[j] + num[i]);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[i]);
		}

		bw.append(answer + "\n");
		bw.flush();
	}

}
