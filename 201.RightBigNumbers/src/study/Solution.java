package study;

import java.util.*;
import java.io.*;
 
public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> s = new Stack<>();
        
        int n = Integer.parseInt(bf.readLine());
        int[] a = new int[n];
        int[] ans = new int[n];
        String[] temp = bf.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(temp[i]);
        }
        
        // 0번째 인덱스를 Stack에 미리 설정해줌      
        s.push(0);

        for (int i = 1; i < n; i++) {
            // 반복문에 들어올 때 스택이 비어있으면 인덱스 저장 
            if (s.isEmpty()) {
                s.push(i);
            }
            
            // 비어있지 않고 숫자가 인덱스 가장 위쪽 숫자보다 클 경우
            while (!s.isEmpty() && a[s.peek()] < a[i]) {
                // 정답 배열 중 스택의 가장 위쪽 숫자와 같은 인덱스에 i번째 숫자를 넣는다 
                ans[s.pop()] = a[i];
            }
            // 다음번에 비교할 숫자를 stack에 집어넣는다
            s.push(i);
        }
        
        // 반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌 때 까지
        while (!s.empty()) {
            // stack에 쌓인 index에 -1을 넣음
            ans[s.pop()] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}