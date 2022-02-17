package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.dynamic_programming;

public class GoSchool {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int M = m;
        int N = n;
        int[][]map = new int[N][M];
        System.out.println("--"+0%1000000007);
        for(int i=0;i<M;i++) map[0][i]=1;
        for(int j=0;j<N;j++) map[j][0]=1;
        for(int[]a : puddles){
            map[a[1]-1][a[0]-1] = -1;
            if(a[1]-1 == 0)for(int i=a[0]-1;i<M;i++) map[0][i]=-1;
           if(a[0]-1 == 0) for(int j=a[1]-1;j<N;j++) map[j][0]=-1;
        }

        if(N==1) map[0][M-1]=0;
        for(int b=1;b<N;b++){
            for(int c=1;c<M;c++){
                if(map[b][c] ==-1) continue;
                int left = map[b][c-1]==-1?0:map[b][c-1];
                int top = map[b-1][c]==-1?0:map[b-1][c];
                map[b][c] = left+top % 1000000007;
            }
        }
//        for(int b=0;b<N;b++){
//            for(int c=0;c<M;c++){
//               System.out.print( map[b][c] );
//            }
//            System.out.println();
//        }
        answer=map[N-1][M-1];
        return answer;
    }
}
