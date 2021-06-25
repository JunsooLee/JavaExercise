package study;

import java.io.*;
import java.util.*;


class Main {
    static int N = 0;
    static int K;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());
        if(N >= K)
            System.out.println(N-K);
        else
            System.out.println(bfs(N, K));
    }

    static int bfs(int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        int[] arr = new int[100001];//체크 및 저장
        Arrays.fill(arr, -1);

        q.add(N);
        arr[N] = 0;

        while(!q.isEmpty()) {
            int now = q.poll();
            if(now == K)
                return arr[now];
            int tmp = now * 2;
            while(tmp <= 100000 && arr[tmp] == -1) {
                arr[tmp] = arr[now];
                q.add(tmp);
                tmp *= 2;
            }

            for(int i=0; i<2; i++) {
                int next;
                if(i == 0)
                    next = now - 1;
                else
                    next = now + 1;
                if(0 <= next && next <= 100000) {
                    if(arr[next] == -1) {
                        q.add(next);
                        arr[next] = arr[now] + 1;
                    }
                }
            }
        }
        return 0;
    }
}