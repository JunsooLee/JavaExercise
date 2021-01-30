package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*수를 나열해보니 규칙이 보였음
 * 1 2 4 7 13 24 44 순으로
 * n이 3이상인 수부터는 F(n) = F(n-1) + F(n-2) + F(n-3)의 규칙
 * */

public class Main {

	public static int Count(int[] count, int n) {
		if (0 < n && n < 3)
			return n;

		if (count[n] > 0)
			return count[n];

		count[n] = Count(count, n - 1) + Count(count, n - 2) + Count(count, n - 3);

		return count[n];
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int loop = Integer.parseInt(br.readLine());

		for (int i = 0; i < loop; i++) {
			int num = Integer.parseInt(br.readLine());
			int[] count = new int[num + 1];
			count[0] = 1;

			bw.append(Count(count, num) + "\n");
		}

		bw.flush();
	}

}
