package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * 7���� ���ؼ� ã�� ������� Sum���� 2���� ���� ���� 100�� ����� ����� �ξ� ����.
 * Brute force��� �ص� �����ϰԸ� �������� ����
 */

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] dwarf = new int[9];
		int sum = 0;
		int num1 = 0;
		int num2 = 0;
		int tmp;
		boolean ok = false;

		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			sum += dwarf[i];
		}

		Arrays.sort(dwarf);

		for (int i = 0; i < 9; i++) {
			for (int j = i; j < 9; j++) {
				tmp = sum;
				tmp = tmp - dwarf[i] - dwarf[j];

				if (tmp == 100) {
					ok = true;
					num2 = j;
					break;
				}
			}

			if (ok == true) {
				num1 = i;
				break;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (i == num1 || i == num2)
				continue;

			bw.append(dwarf[i] + "\n");
		}

		bw.flush();
	}

}
