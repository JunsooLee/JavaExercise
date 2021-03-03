package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] dp = new int[N];
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(dp, 1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if ((num[i] < num[j]) && (dp[i] <= dp[j])) {
					dp[i] = dp[j] + 1;
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
