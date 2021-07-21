package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static long CountTwo(long n) {
		long cnt = 0;
		
		for(long i=2; i<=n; i*=2) {
			cnt += (n/i);
		}
		return cnt;
	}
	
	public static long CountFive(long n) {
		long cnt = 0;
		
		for(long i=5; i<=n; i*=5) {
			cnt += (n/i);
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		long n = Long.parseLong(str.split(" ")[0]);
		long m = Long.parseLong(str.split(" ")[1]);
		
		long cnt2 = 0; 
		long cnt5 = 0;
		
		cnt5 = CountFive(n) - CountFive(n-m) - CountFive(m);
		cnt2 = CountTwo(n) - CountTwo(n-m) - CountTwo(m);
		
		System.out.println(Math.min(cnt2, cnt5));
		
		br.close();
	}
}
