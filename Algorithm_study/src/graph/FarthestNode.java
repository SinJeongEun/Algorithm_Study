package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.graph;

import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode {
    static Queue<Integer> que;
    static  boolean visit[];
    static int[][]edges;
    static int N;

    public int solution(int n, int[][] edge) {
        visit= new boolean[n+1];
        edges = new int[n+1][n+1];
        N=n;

        for(int[]e : edge) {
           edges[e[0]][e[1]] = 1;
            edges[e[1]][e[0]] = 1;
        }

        que = new LinkedList<>();
        que.offer(1);
        visit[1] = true;
        int answer = bfs();

        return answer;
    }

    public int bfs(){
        int qSize = 0;
        while (!que.isEmpty()){
            qSize = que.size();
            for(int s=0;s<qSize;s++){
                int now =que.poll();
                for(int i=1;i<N+1;i++){
                    if(visit[i]) continue;
                    if(edges[now][i]==1 && !visit[i]){
                        que.offer(i);
                        visit[i] = true;
                    }
                }
            }

        }
        return qSize; // 마지막 큐 사이즈가 가장 먼 노드의 개수임
    }
}
