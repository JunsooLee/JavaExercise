package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static int[] count;

	public static int tiling(int n) {
		if (n <= 1) {
			return 1;
		}
		if (count[n] > 0)
			return count[n];

		count[n] = tiling(n - 1) + tiling(n - 2);
		count[n] %= 10007;

		return count[n];
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		count = new int[n + 1];

		bw.append(tiling(n) + "\n");
		bw.flush();
	}

}
