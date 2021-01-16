package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			int[] counter = new int[4];
			String str = br.readLine();
			
			if(str == null)
				break;
			
			for(char c: str.toCharArray()) {
				if('0' <= c && c <= '9') {
					counter[2]++;
				}else if('a' <= c && c <= 'z') {
					counter[0]++;
				}else if('A' <= c && c <= 'Z') {
					counter[1]++;
				}else if(c == ' ') {
					counter[3]++;
				}
			}
			
			for(int i=0; i<4; i++) {
				bw.append(counter[i] + " ");
			}
			bw.flush();
		}
	}
}
