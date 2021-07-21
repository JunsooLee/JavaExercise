package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int[] price;
	public static int[] answer;

	public static int calculate(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if(answer[i] != 0)
					answer[i] = Math.min(answer[i], answer[i - j] + price[j]);
				else
					answer[i] = answer[i - j] + price[j];
			}
		}
		return answer[n];
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		price = new int[N + 1];
		answer = new int[N + 1];
		StringTokenizer st = new StringTokenizer(str, " ");

		for (int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(answer, 0);

		bw.append(calculate(N) + "\n");
		bw.flush();
	}

}
