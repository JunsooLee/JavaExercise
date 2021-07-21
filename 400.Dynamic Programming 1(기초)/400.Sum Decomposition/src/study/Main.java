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
		long[][] dp = new long[MAX][MAX]; // dp[K][N] N�� ����� ���ؼ� �ʿ��� K���� ������ �ǹ���

		for (int i = 0; i < MAX; i++) {
			dp[i][0] = 1; // �� ���� ������ ����ϵ� 0�� ����� ����� ��� 1������
			dp[1][i] = 1; // � ������ ����� 1���� ����ϴ� ���� �ڱ��ڽ� 1���� ����
		}

		for (int i = 1; i < MAX; i++) {
			dp[2][i] = i + 1; // 2���� ������ ����ؼ� N�� ����� ����� ��Ģ�� ���� N+1���� �ִ�
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
