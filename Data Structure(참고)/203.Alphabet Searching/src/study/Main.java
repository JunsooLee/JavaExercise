package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] count = new int[26];
		int index = 0;
		String str = br.readLine();
		
		Arrays.fill(count, -1);
		
		for(char c: str.toCharArray()) {
			if(count[c-97] == -1) {
				count[c-97] = index;
			}
			index++;
		}
		
		for(int i=0; i<count.length; i++) {
			bw.append(count[i]+" ");
		}
		
		bw.flush();
	}
}
