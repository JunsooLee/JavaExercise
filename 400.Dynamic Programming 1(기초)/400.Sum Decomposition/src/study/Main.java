package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public final static int MAX = 201;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[][] dp = new long[MAX][MAX]; // dp[K][N] N을 만들기 위해서 필요한 K개의 정수를 의미함

		for (int i = 0; i < MAX; i++) {
			dp[i][0] = 1; // 몇 개의 정수를 사용하든 0을 만드는 방법은 모두 1가지임
			dp[1][i] = 1; // 어떤 정수를 만들든 1개만 사용하는 경우는 자기자신 1가지 뿐임
		}

		for (int i = 1; i < MAX; i++) {
			dp[2][i] = i + 1; // 2개의 정수를 사용해서 N을 만드는 방법은 규칙을 보면 N+1개가 있다
		}
		
		
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
			}
		}
		
		bw.append(Long.toString(dp[K][N]));
		bw.flush();
	}

}
