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
		
		String str = br.readLine();
		String[] strings = new String[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			strings[i] = str.substring(i, str.length());
		}
		
		Arrays.sort(strings);
		
		for(int i=0; i<str.length(); i++) {
			bw.append(strings[i]+"\n");
		}
		
		bw.flush();
	}

}
