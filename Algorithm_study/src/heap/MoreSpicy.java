package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MoreSpicy {

	public static void main(String[] args) {
		int[] scoville = {3,9,2,10,12,1};
		int K = 7;
		new MoreSpicy().solution(scoville, K);

	}
	
	public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer>que = new PriorityQueue<>();                
        
        for(int s : scoville) {
        	que.offer(s);
        }              
        
        while(que.peek() < K) {
        	if(que.size() < 2) return -1;
        	int now = que.peek();        	
        	
        	int d1 = que.poll();
        	int d2 = que.poll();
        	int mix = d1 + d2 * 2;
        	
        	que.offer(mix);
        	answer++;
        }
        System.out.print(answer);
        
        return answer;
    }

}
