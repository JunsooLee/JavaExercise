package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static int MAX = 1000000;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop = Integer.parseInt(br.readLine());

		boolean[] isPrime = new boolean[MAX + 1];
		for (int i = 2; i <= MAX; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i <= MAX; i++) {
			for (int j = i * 2; j <= MAX; j += i) {
				if (!isPrime[j])
					continue;
				
				isPrime[j] = false;
			}
		}

		for (int k = 0; k < loop; k++) {
			int n = Integer.parseInt(br.readLine());
			int count = 0;
			
			if (n == 0)
				break;
			
			for (int i = 2; i <= n / 2; i++) {
				if (isPrime[i] && isPrime[n - i]) {
					count++;
				}
			}
			
			bw.append(count+"\n");
		}
		
		bw.flush();
	}
}
