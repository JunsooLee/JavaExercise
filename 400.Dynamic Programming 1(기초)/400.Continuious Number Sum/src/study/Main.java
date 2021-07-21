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
		int max;
		int[] nums = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		dp[0] = nums[0];
		max = nums[0];

		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

			if (max < dp[i])
				max = dp[i];
		}

		bw.append(max + "\n");
		bw.flush();
	}
}
