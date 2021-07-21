package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int count = 1;
		int e = 1;
		int s = 1;
		int m = 1;

		while (true) {
			if (15 < e)
				e = 1;
			if (28 < s)
				s = 1;
			if (19 < m)
				m = 1;

			if ((e == E) && (s == S) && (m == M))
				break;

			e++;
			s++;
			m++;
			count++;
		}

		bw.append(count + "\n");
		bw.flush();
	}

}
