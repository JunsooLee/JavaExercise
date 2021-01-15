package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int[] count = new int[26];
		
		for(char c: str.toCharArray()) {
			count[c-97]++;
		}
		
		for(int i=0; i<count.length; i++) {
			bw.append(count[i]+" ");
		}
		
		bw.flush();
	}
}
