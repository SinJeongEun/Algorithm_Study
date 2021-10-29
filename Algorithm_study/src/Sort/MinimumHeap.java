package Sort;

import java.util.PriorityQueue;
import java.util.Queue;

//최소힙 사용으로 자동 정렬, 시간복잡도 O(n)
public class MinimumHeap {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> dishes = new PriorityQueue<>();
        for(int value : scoville){
            dishes.add(value);
        }

       while(dishes.peek() < K){
           if(dishes.size() < 2) return -1;

           int d1 = dishes.poll();
           int d2 = dishes.poll();
           int mix = d1 + d2 * 2;
           dishes.offer(mix);

           answer += 1;
       }
        return answer;
    }
}