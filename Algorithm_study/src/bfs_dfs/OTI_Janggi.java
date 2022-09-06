package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class OTI_Janggi {
    static int AnswerN;
    static int N = 10;
    static int X,Y;
    static int directions[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            String[][]map = new String[N][N];
            //담기
            for(int i=0; i<N;i++) {
                String[] str = br.readLine().split(" ");

                for(int j=0;j<N;j++) {
                    map[i][j] = str[j];
                    if(map[i][j].equals("X")){
                        System.out.println("sdfsf");
                        Y = i;
                        X = j;
                    }
                }
            }
            AnswerN = bfs(X, Y, map);

            System.out.println("#"+test_case+" "+AnswerN);
        }
    }

    public static int bfs(int x, int y, String[][]map) {
        boolean visited[][] = new boolean [N][N];
        visited[y][x] = true;
        Queue<int[]> que= new LinkedList<>();
        int count = 0;
        que.add(new int[]{y,x,0});

        while(!que.isEmpty()) {
            int now[] = que.poll();

            for(int d=now[2]; d<4;d++) {
                int a = now[0] + directions[d][0];
                int b = now[1] + directions[d][1];
                if(a>=0 && a<N && b>=0 && b<N && map[a][b].equals("H") && !visited[a][b]){
                    System.out.println(a + "--> " + b +" " + d);
                    visited[a][b] = true;
                    que.add(new int[] {a,b,d});
                    count++;
                }

            }
        }
        return count;
    }

}