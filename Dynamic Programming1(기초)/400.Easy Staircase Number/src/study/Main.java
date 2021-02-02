package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * �� ������ 123�� ������ ���� ���ϴ� ������ ����� ������� Ǯ�� ��
 * 2���� �迭�� ����Ͽ� �ڸ���, �ڸ����� �迭�� �����
 * ù �ڸ����� 0�� ������ 1~9������ ���ڰ� 1���� �ۿ� �� �� �����Ƿ� �� �迭�� 1�� ���� ����
 * �ι�° �ڸ������ʹ� �ڸ����� 0�̰ų� 9�� ��츦 �����ϰ� ��� ������ �� �ڸ����� +1�� ���̳� -1�� ���� �� �� ����
 */
 
public class Main {
	
	final static long mod = 1000000000;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][10]; //dp[i][j]���� i�� �ڸ��� �����ʺ��� ù ��° �ڸ���, j�� �� �ڸ����� �� �� �ִ� �� 0~9
		
		// ù ��° �ڸ����� ����� ���� 1���ۿ� ���� (0�� ó���� �� �� �����Ƿ� ���� 1~9����)
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1; 
		}
		
		// �� ��° �ڸ������� N���� Ž�� 
		for(int i = 2; i <= N; i++) {
			// i��° �ڸ����� �ڸ������� Ž�� (0~9) 
			for(int j = 0; j < 10; j++) {
				// j=0, �ڸ����� 0�� ��� ���� �ڸ������� 1�� �� �� ����
				if(j == 0) {
					dp[i][0] = dp[i - 1][1] % mod;
				}
				// j=9, �ڸ����� 9�� ��� ���� �ڸ����� 8�� ����
				else if (j == 9) {
					dp[i][9] = dp[i - 1][8] % mod;
				}
				// �� ���� ��� ���� �ڸ����� �ڸ��� +1, -1 �� ������ ���� �� 
				else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
				}
			}
		}
		
		long result = 0;
		
		// �� �ڸ��������� ����� ���� ��� �����ش�. 
		for(int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		
		System.out.println(result % mod);
	}
 
}