package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int CountToMakingOne(int N, int count) {
		
		if (N < 2) {
			return count;
		}
		
		return Math.min(CountToMakingOne(N / 2, count + 1 + (N % 2)), CountToMakingOne(N / 3, count + 1 + (N % 3)));
 
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		bw.append(CountToMakingOne(N,0)+"\n");
		bw.flush();
	}
	
}
