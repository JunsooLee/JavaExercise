package study;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] splitedStr;
		int count = sc.nextInt();
		sc.nextLine();

		int curser = str.length();

		for (int i = 0; i < count; i++) {
			String temp = sc.nextLine();

			if (temp.contains("L")) {
				if (curser != 0) {
					curser--;
				}
			} else if (temp.contains("D")) {
				if (curser != str.length()) {
					curser++;
				}

			} else if (temp.contains("B")) {
				if (curser != 0) {
					if (curser == str.length())
						str = str.substring(0, curser - 1);
					else
						str = str.substring(0, curser - 1).concat(str.substring(curser, str.length()));
					curser--;
				}
			} else {
				splitedStr = temp.split(" ");
				if (curser == 0) {
					str = splitedStr[1].concat(str);
				} else if (curser == str.length()) {
					str = str.concat(splitedStr[1]);
				} else {
					String tmp = str.substring(curser, str.length());
					str = str.substring(0, curser).concat(splitedStr[1]);
					str = str.concat(tmp);
				}
				curser++;
			}
		}
		System.out.println(str);
	}
}
