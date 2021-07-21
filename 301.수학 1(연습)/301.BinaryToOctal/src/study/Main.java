package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static int BinToOct(String str) {
		int num = 4;
		int tmp = 0;

		for (int i = 0; i < 3; i++) {
			tmp += Character.getNumericValue(str.charAt(i)) * num;
			num /= 2;
		}

		return tmp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		for(int i=0; i<str.length()%3; i++) {
			str = '0' + str;
		}

		for (int i = 0; i < str.length() / 3; i++) {
			sb.append(BinToOct(str.substring(3*i, 3*(i+1))));
		}
		
		System.out.println(sb.toString());
	}

}
