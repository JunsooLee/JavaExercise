package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Correct {
    public static boolean[] primeNum;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int startNum = Integer.parseInt(st.nextToken());
        int endNum = Integer.parseInt(st.nextToken());
        
        primeNum = new boolean[endNum+1];
        getPrimeNum(); // �����佺�׳׽��� ü�� �Ҽ��� ���Ѵ�.
        
        StringBuilder sb = new StringBuilder();
        for(int i = startNum; i <= endNum; i++) {
            if(!primeNum[i]) {
                sb.append(i + "\n");
            }
        }
        
        System.out.println(sb.toString());
        
        br.close();
    }
    
    public static void getPrimeNum() {
        primeNum[1] = true;
        
        for(int i= 2; i < primeNum.length; i++) {
            for(int j = 2; i*j < primeNum.length; j++) {
                primeNum[i*j] = true;
            }
        }
    }
}