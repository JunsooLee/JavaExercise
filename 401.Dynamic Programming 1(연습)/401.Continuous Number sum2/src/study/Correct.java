package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Correct {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int array[] = new int[n];
		int dp[][] = new int[n][2]; //0은 1개의 수를 제거하지 않는 합, 1은 1개의 수를 제거하는 합

		for(int i = 0; i < n; i++)
			array[i] = Integer.parseInt(st.nextToken());

		int max = array[0];
		dp[0][0] = array[0];
		dp[0][1] = array[0];

		for(int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i-1][0] + array[i], array[i]); //수를 제거하지 않을 경우에는 이전 합과 자신을 더한 값과 자신 중에서 MAX값을 선택한다.
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+array[i]); //수를 제거하는 경우에는 자기 자신을 제거하지 않는 경우(앞에서 수가 제거된 경우)와 자기 자신을 제거하는 경우 중에서 MAX값을 고른다.
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}

		bw.append(max+"\n");
		bw.flush();
	}

}
