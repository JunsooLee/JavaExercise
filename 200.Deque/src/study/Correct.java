package study;

import java.util.*; 

public class Correct { 
	
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        StringBuilder sb = new StringBuilder(); 
        LinkedList<String> deque = new LinkedList<>(); 
        
        int n = Integer.parseInt(sc.nextLine()); 
        String command[][] = new String[n][]; 
        
        for(int i=0; i<n; i++){ 
            command[i] = sc.nextLine().split("\\s"); // "스페이스 바"로 구분 
           
            switch (command[i][0]) { 
                case "push_front": 
                    deque.push(command[i][1]); 
                    break; 
                case "push_back" : 
                    deque.add(command[i][1]); 
                    break; 
                case "pop_front" : 
                    sb.append(deque.isEmpty() ? "-1\n" : deque.poll()+"\n"); 
                    break; 
                case "pop_back" : 
                    sb.append(deque.isEmpty() ? "-1\n" : deque.pollLast()+"\n"); 
                    break; 
                case "size" : 
                    sb.append(deque.size()+"\n"); 
                    break; 
                case "empty" : 
                    sb.append(deque.isEmpty() ? "1\n" : "0\n");
                    break; 
                case "front" : 
                    sb.append(deque.isEmpty() ? "-1\n" : deque.peekFirst()+"\n"); 
                    break; 
                case "back" : sb.append(deque.isEmpty() ? "-1\n" : deque.peekLast()+"\n"); 
                    break; 
            } 
        } 
        System.out.print(sb); 
        sc.close();
    } 
}