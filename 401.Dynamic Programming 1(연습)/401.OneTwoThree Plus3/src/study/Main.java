package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static int MAX = 1000001;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		double[] dp = new double[MAX];
		int loop, num;

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i < MAX; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
			dp[i] %= 1000000009;
		}
		
		loop = Integer.parseInt(br.readLine());
		
		for(int i=0; i<loop; i++) {
			num = Integer.parseInt(br.readLine());
			bw.append((int)dp[num]+"\n");
		}
		
		bw.flush();
	}

}
