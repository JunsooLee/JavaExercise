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
		int[] dp = new int[N + 1];

		int answer = 0;

		if (N % 2 == 0) {
			dp[0] = 1;
			dp[2] = 3;

			// N이 홀수일 때는 채울 수 없고 짝수일 때만 타일링이 가능하다.
			for (int i = 4; i <= N; i += 2) {
				for (int j = 2; j <= i; j += 2) {
					int standard = 2;

					if (j == 2) {
						standard = 3;
					}

					dp[i] += standard * dp[i - j];
				}
			}

			answer = dp[N];
		}

		bw.append(answer + "\n");
		bw.flush();
	}

}
