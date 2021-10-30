package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindNetworks {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean []visit = new boolean[n];

        for(int i=0;i<n;i++){
            if(visit[i]) continue;
            answer++;

            //i번째와 연결된 모든곳을 찾는다
            visitAll(computers,visit,i,n);
        }
        return answer;
    }

    void visitAll(int[][]computers, boolean[]visit, int i, int n){
    	//bfs
    	Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        while(!queue.isEmpty()){
            int c = queue.poll();

            for(int j=0;j<n;j++){
                if(visit[j]) continue;

                if(computers[c][j] == 1){
                    visit[j] = true;
                    queue.offer(j);
                }
            }
        }
        
      //dfs
    	Stack<Integer> stack = new Stack<>();
    	stack.push(i);
        while(!stack.isEmpty()){
            int c = stack.pop();

            for(int j=0;j<n;j++){
                if(visit[j]) continue;

                if(computers[c][j] == 1){
                    visit[j] = true;
                    stack.push(j);
                }
            }
        }
    }
}