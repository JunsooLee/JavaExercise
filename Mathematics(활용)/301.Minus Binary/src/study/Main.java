package study;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int input = scanner.nextInt();

        if (input == 0) {
            System.out.println(0);
        } else {
            while (input != 1) {
                sb.append(Math.abs(input % -2));
                input = (int)Math.ceil((double) input / (-2));
            }

            sb.append(input);

            System.out.println(sb.reverse());
            
            scanner.close();
        }
    }
}