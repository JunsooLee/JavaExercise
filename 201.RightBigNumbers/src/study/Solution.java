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
        
        // 0��° �ε����� Stack�� �̸� ��������      
        s.push(0);

        for (int i = 1; i < n; i++) {
            // �ݺ����� ���� �� ������ ��������� �ε��� ���� 
            if (s.isEmpty()) {
                s.push(i);
            }
            
            // ������� �ʰ� ���ڰ� �ε��� ���� ���� ���ں��� Ŭ ���
            while (!s.isEmpty() && a[s.peek()] < a[i]) {
                // ���� �迭 �� ������ ���� ���� ���ڿ� ���� �ε����� i��° ���ڸ� �ִ´� 
                ans[s.pop()] = a[i];
            }
            // �������� ���� ���ڸ� stack�� ����ִ´�
            s.push(i);
        }
        
        // �ݺ����� �� ���� ���Դµ� ������ ������� �ʴٸ� �� �� ����
        while (!s.empty()) {
            // stack�� ���� index�� -1�� ����
            ans[s.pop()] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}