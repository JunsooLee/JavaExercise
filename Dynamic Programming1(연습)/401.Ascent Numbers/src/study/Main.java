package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int MOD = 10007;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		long[][] num = new long[N + 1][10];
		long answer = 0;

		for (int i = 0; i < 10; i++) {
			num[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for(int k=0; k<=j; k++) {
					num[i][j] += num[i-1][k];
				}
				num[i][j] %= MOD;
			}
		}

		for (int i = 0; i < 10; i++) {
			answer += num[N][i];
		}
		answer %= MOD;

		bw.append(answer + "\n");
		bw.flush();
	}

}
