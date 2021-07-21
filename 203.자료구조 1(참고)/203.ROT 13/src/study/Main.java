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
		
		String str = br.readLine();
		
		for(char c: str.toCharArray()) {
			char tmp;
			
			if('a'<=c && c<='m') {
				tmp = (char) (c + 13);
			}else if('n'<=c && c<='z') {
				tmp = (char) (c - 13);
			}else if('A'<=c && c<='M') {
				tmp = (char) (c + 13);
			}else if('N'<=c && c<='Z') {
				tmp = (char) (c - 13);
			}else {
				tmp = c;
			}
			
			bw.append(tmp);
		}
		bw.flush();
	}
}
