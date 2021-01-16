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
		
		long num1 = Long.parseLong(str.split(" ")[0] + str.split(" ")[1]);
		long num2 = Long.parseLong(str.split(" ")[2] + str.split(" ")[3]);
		
		bw.append(Long.toString(num1 + num2));
		bw.flush();
	}
}
