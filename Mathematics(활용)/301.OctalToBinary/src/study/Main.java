package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static String OctToBin(int n) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			sb.append(n % 2);
			n = n / 2;
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		String tmp = "";

		for (char c : str.toCharArray()) {
			tmp += OctToBin(Character.getNumericValue(c));
		}

		if (tmp.charAt(0) == '0' && tmp.charAt(1) == '0') {
			tmp = tmp.substring(2, tmp.length());
		} else if (tmp.charAt(0) == '0') {
			tmp = tmp.substring(1, tmp.length());
		}

		bw.append(tmp);
		bw.flush();
	}

}
