package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static long GCD(long m, long n) {
		long tmp=0;
		
		if(m % n == 0)
			return n;
		
		tmp = GCD(n, m%n);
		
		return tmp;
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int loop = Integer.parseInt(br.readLine());
		int num = 0;
		String str;
		
		for(int i=0; i<loop; i++) {
			str = br.readLine();
			num = Integer.parseInt(str.split(" ")[0]);
			
			long sum = 0;
			long[] nums = new long[num];
			
			for(int j=0; j<num; j++) {
				nums[j] = Long.parseLong(str.split(" ")[j+1]);
			}
			
			for(int j=0; j<num - 1; j++) {
				for(int k=j+1; k<num; k++) {
					sum += GCD(nums[j], nums[k]);
				}
			}
			bw.append(Long.toString(sum)+"\n");
		}
		bw.flush();
	}
}
