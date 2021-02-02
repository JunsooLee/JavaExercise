package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 이 문제도 123의 합으로 수를 구하는 문제와 비슷한 방식으로 풀면 됨
 * 2차원 배열을 사용하여 자릿수, 자릿값의 배열을 만들고
 * 첫 자릿수는 0을 제외한 1~9까지의 숫자가 1번씩 밖에 올 수 없으므로 각 배열을 1의 값을 넣음
 * 두번째 자릿수부터는 자릿값이 0이거나 9일 경우를 제외하고 모든 수들은 앞 자릿값의 +1의 값이나 -1의 값이 올 수 있음
 */
 
public class Main {
	
	final static long mod = 1000000000;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][10]; //dp[i][j]에서 i는 자릿수 오른쪽부터 첫 번째 자릿수, j는 그 자릿수에 올 수 있는 값 0~9
		
		// 첫 번째 자릿수는 경우의 수가 1개밖에 없음 (0은 처음에 올 수 없으므로 제외 1~9까지)
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1; 
		}
		
		// 두 번째 자릿수부터 N까지 탐색 
		for(int i = 2; i <= N; i++) {
			// i번째 자릿수의 자릿값들을 탐색 (0~9) 
			for(int j = 0; j < 10; j++) {
				// j=0, 자릿값이 0일 경우 이전 자릿수에서 1만 올 수 있음
				if(j == 0) {
					dp[i][0] = dp[i - 1][1] % mod;
				}
				// j=9, 자릿값이 9일 경우 이전 자릿수는 8만 가능
				else if (j == 9) {
					dp[i][9] = dp[i - 1][8] % mod;
				}
				// 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 갯수의 합이 됨 
				else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
				}
			}
		}
		
		long result = 0;
		
		// 각 자릿값마다의 경우의 수를 모두 더해준다. 
		for(int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		
		System.out.println(result % mod);
	}
 
}