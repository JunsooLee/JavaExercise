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
		int dp[][] = new int[n][2]; //0�� 1���� ���� �������� �ʴ� ��, 1�� 1���� ���� �����ϴ� ��

		for(int i = 0; i < n; i++)
			array[i] = Integer.parseInt(st.nextToken());

		int max = array[0];
		dp[0][0] = array[0];
		dp[0][1] = array[0];

		for(int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i-1][0] + array[i], array[i]); //���� �������� ���� ��쿡�� ���� �հ� �ڽ��� ���� ���� �ڽ� �߿��� MAX���� �����Ѵ�.
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+array[i]); //���� �����ϴ� ��쿡�� �ڱ� �ڽ��� �������� �ʴ� ���(�տ��� ���� ���ŵ� ���)�� �ڱ� �ڽ��� �����ϴ� ��� �߿��� MAX���� ����.
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}

		bw.append(max+"\n");
		bw.flush();
	}

}
