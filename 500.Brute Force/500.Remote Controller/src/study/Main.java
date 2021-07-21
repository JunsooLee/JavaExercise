package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static List<Integer> list = new ArrayList<>();

	public static int check(int num) {
		int length = 0;

		if (num == 0) {
			// List�� 0�� ���� �Ǿ������� 0�� �ƴϸ� 1�� ��ȯ�Ѵ�.
			return list.contains(num) ? 0 : 1;
		}

		while (num > 0) {
			// List�� ���峭 ��ȣ�� ���ԵǾ� �ִٸ� 0�� ��ȯ�Ͽ� ������ �� ������ �ǹ��Ѵ�.
			if (list.contains(num % 10))
				return 0;

			length++;
			num /= 10;
		}

		return length;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
		int min = Math.abs(N - 100);

		// ��ư�� �ϳ��� ���峪�� ���� ��� StringTokenizer�� �̸� ����ϸ� NullPointer Error�� �߻��ϹǷ� ���ǹ��� �ϳ� �������ش�.
		if (M > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < M; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}

		// N�� �ִ� ���� 500000�� �������� ������ ���� Search�� ���� �Ʒ����� ���� Search�� ���� �����Ƿ� 1000000�� ����
		for (int i = 0; i <= 1000000; i++) {
			int length = check(i);

			if (length > 0)
				// length�� ���� ��ư�� ���� ���̰� N-i�� +�� - ��ư�� ���� Ƚ����.
				// min���� �ּڰ��� ���ؼ� min�� ����
				min = Math.min(min, length + Math.abs(N - i));
		}

		bw.append(min + "\n");
		bw.flush();
	}

}
