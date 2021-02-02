package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * ���ӵ� ���� ������ �ʱ� ���ؼ��� ������ �ڸ��� Ȯ���ϸ� �ȴ�.
 * n�� �������� 1�� �� ��� n-1���� ������ ���� 2,3�� �� �� �ְ�
 * n�� �������� 2�� �� ��� n-2���� ������ ���� 1,3�� �� �� �ְ�
 * n�� �������� 3�� �� ��� n-3���� ������ ���� 1,2�� �� �� �ִ�.
 * �ʱ��� 1~3�� ������ ��찡 �����Ƿ� ���� ������ �� �������� ��ȭ���� ���� Ǯ �� �ִ�.
 */

public class Main {
	public static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int div = 1000000009; // div: ����� ���� ������ ��
		int limit = 100000; // limit: ���� n�� �ִ�
		
		dp = new int[limit + 1][4]; // dp[i][j]: ���� i�� ����µ� ������ �ڸ��� ���ڴ� j�� ����� ����
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
				//���� n�� ��Ÿ�� �� �ִ� ���, ���� ���ڸ��� 1,2,3���� ������ ��츦 �����ָ� ��.
				answer += dp[n][i];
				answer %= div;
			}
			
			bw.append(answer+"\n");
		}
		
		bw.flush();
	}
}
