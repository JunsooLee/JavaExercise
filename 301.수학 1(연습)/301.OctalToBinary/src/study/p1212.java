package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1212 {
	static char[] twoCharArr;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String eight = br.readLine();
		char[] eightCharArr = eight.toCharArray();
		
		int twoLen = getPossibleDigitNumber(eightCharArr);
		twoCharArr = new char[twoLen];
		
		int index = twoLen - 1;
		// ���� ù ��° �ڸ�(�ǵ��� ��) ���� Ž�� ���� 
		for(int i = eight.length() - 1; i >= 0; i--) {
			char num = eightCharArr[i];
			index = getTwoDigitNumber(num, index);
		}
		
		System.out.print(new String(twoCharArr));
	}
	
	// 8���� ���� 1�� -> 2���� ���� 3�� ��ȯ
	// 2������ ���� index ���� 
	static int getTwoDigitNumber(char ch, int nowIndex) {
		int num = ch - '0';
		
		// �� 3ȸ �ݺ� 
		for(int i = 0; i < 3; i++) {
			twoCharArr[nowIndex--] = (char) ((num % 2) + '0');
			num /= 2;
			
			if(nowIndex < 0) { // �̹� ��ü 2���������� �˰� �����Ƿ� index�� ���� �Ǵ�.
				break;
			}
		}
		
		return nowIndex;
	}
	
	static int getPossibleDigitNumber(char[] charArr) {
		int len = charArr.length * 3;
		if(len == 0) {
			return 0;
		}
		
		int firstNum = charArr[0] - '0';
		if(firstNum / 4 > 0) { // ù ��° ���ڰ� 3�ڸ� �� ���� 
			return len;
		}
		if(firstNum / 2 > 0) { // ù ��° ���ڰ� 2�ڸ� �� ����
			return len - 1;
		}
		
		return len - 2;
	}
}