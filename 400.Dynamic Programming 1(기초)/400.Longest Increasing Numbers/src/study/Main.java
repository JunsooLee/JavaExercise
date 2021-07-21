package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] count = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			count[i] = 1;

			for (int j = 0; j < i; j++) {
				// j��° ���Ұ� i��° ���Һ��� �����鼭 i��° count�� j��° count+1 ������ �������
				if (nums[j] < nums[i] && count[i] < count[j] + 1) {
					count[i] = count[j] + 1; // j��° ������ +1 ���� i��° count�� �ȴ�.
				}
			}
		}

		// �ִ�(�ִ� ����) Ž��
		int max = -1;

		for (int i = 0; i < N; i++) {
			if (max < count[i])
				max = count[i];
		}

		bw.append(max + "\n");

		int value = max;
		Stack<Integer> stack = new Stack<>();

		for (int i = N-1; 0 <= i; i--) {
			if (value == count[i]) {
				stack.push(nums[i]);
				value--;
			}
		}
		
		while(!stack.isEmpty()) {
			bw.append(stack.pop()+" ");
		}
		
		bw.flush();
	}

}
