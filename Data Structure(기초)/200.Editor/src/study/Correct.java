package study;

import java.io.*;
import java.util.Stack;
 
public class Correct {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Character> lStack = new Stack<Character>();
        Stack<Character> rStack = new Stack<Character>();
        
        String input = br.readLine();
        
        for (int i = 0; i < input.length(); i++) {
            lStack.push(input.charAt(i));
        }
        // ���� ���ÿ� ����Ʈ�� ���� ����
 
        String nStr = br.readLine();
        int n = Integer.parseInt(nStr);
        // ù ������ �а�
 
        // ù ���ο��� �Է¹��� ���θ�ŭ �ݺ�
        for (int i = 0; i < n; i++) {
 
            String command = br.readLine();
            // ��ɾ� �Է� ����
 
            // �����̵�
            if (command.startsWith("L")) {
                // Ŀ���� �� ������ �ƴϸ�
                if(!lStack.empty()) {
                    rStack.push(lStack.pop());
                }
            // ������ �̵�
            } else if (command.startsWith("D")) {
                // Ŀ���� �� �������� �ƴϸ�
                if(!rStack.empty()) {
                    lStack.push(rStack.pop());
                }
            // Ŀ�� ���� ���� ����
            } else if (command.startsWith("B")) {
                
                // Ŀ���� �� ������ �ƴϸ�
                if(!lStack.empty()) {
                    lStack.pop();
                }
                
            // Ŀ�� ���� ���� �߰�
            } else if (command.startsWith("P")) {
                
                String[] pCommand = command.split(" ");
                
                lStack.push(pCommand[1].toCharArray()[0]);
 
            }
 
        }
 
        // lStack�� �������� ������ �������� �ű��
        while(!lStack.empty()) {
            rStack.push(lStack.pop());
        }
 
        // rStack�� ��������
        while(!rStack.empty()) {
            //���
            bw.write(rStack.pop());
        }
 
        br.close();
        bw.flush();
        bw.close();
        // reader�� writer�� �ݴ´�
    }
 
}