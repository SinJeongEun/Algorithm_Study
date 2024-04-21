package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HideNSeek3 {
    static class Point {
        int idx;
        int time;

        public Point(int idx,int time){
            this.idx = idx;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);

        bfs(n, k);

    }

    private static void bfs(int start, int end) {
        Queue<Point> que = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int[] directions = {-1, 1};

        que.add(new Point(start, 0));
        visited[start] = true;

        while (!que.isEmpty()) {
            Point now = que.poll();
            if(now.idx == end) {
                System.out.println(now.time);
                return;
            }

            int teleporation = now.idx * 2;
            if(teleporation < 100001 && !visited[teleporation]) {
                visited[teleporation] = true;
                que.add(new Point(teleporation, now.time));
            }

            for(int dir : directions) {
                int next = now.idx + dir;
                if(next > -1 && next < 100001 && !visited[next]) {
                    visited[next] = true;
                    que.add(new Point(next, now.time + 1));
                }
            }

        }
    }
}
