package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long count = 0;
		long N = Long.parseLong(br.readLine());
		
		for(long i=1; i<=N; i++) {
			long tmp = i;
			while(tmp != 0) {
				count++;
				tmp = tmp / 10;
			}
		}
		bw.append(count+"\n");
		bw.flush();
	}

}
