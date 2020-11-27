package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Correct {
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            long num1 = Integer.parseInt(st.nextToken());
            long num2 = Integer.parseInt(st.nextToken());
            
            long gcd = getGCD(Math.max(num1, num2), Math.min(num1, num2));
            sb.append(num1*num2/gcd+ "\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
 
    // 유클리드 호제법
    public static long getGCD(long a, long b) {
        while(b > 0) {
            long tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }
}