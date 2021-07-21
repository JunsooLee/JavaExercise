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
			// List에 0이 포함 되어있으면 0을 아니면 1을 반환한다.
			return list.contains(num) ? 0 : 1;
		}

		while (num > 0) {
			// List에 고장난 번호가 포함되어 있다면 0을 반환하여 선택할 수 없음을 의미한다.
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

		// 버튼이 하나도 고장나지 않을 경우 StringTokenizer를 미리 사용하면 NullPointer Error가 발생하므로 조건문을 하나 설정해준다.
		if (M > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < M; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}

		// N의 최대 범위 500000을 기준으로 위에서 부터 Search할 수도 아래에서 부터 Search할 수도 있으므로 1000000의 범위
		for (int i = 0; i <= 1000000; i++) {
			int length = check(i);

			if (length > 0)
				// length는 숫자 버튼을 누른 수이고 N-i는 +나 - 버튼을 누른 횟수임.
				// min과의 최솟값을 구해서 min에 저장
				min = Math.min(min, length + Math.abs(N - i));
		}

		bw.append(min + "\n");
		bw.flush();
	}

}
