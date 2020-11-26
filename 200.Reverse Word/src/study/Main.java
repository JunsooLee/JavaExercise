package study;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = new String();
		String[] splitedStr;
		int loop;
		
		loop = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<loop; i++) {
			str = sc.nextLine();
			
			splitedStr = str.split(" ");
			for(int j=0; j<splitedStr.length; j++) {
				splitedStr[j] = (new StringBuffer(splitedStr[j])).reverse().toString();
				System.out.print(splitedStr[j]+" ");
			}
		}
		sc.close();
	}

}
