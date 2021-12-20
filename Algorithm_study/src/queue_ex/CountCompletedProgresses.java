package queue_ex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class CountCompletedProgresses {
	//프로그래머스 .스택/큐.기능개발 알고리즘 풀이..
	public static void main(String[] args) {
		int progresses[] = {93,30,55};
		int speeds[] = {1,30,5};
		new CountCompletedProgresses().solution(progresses, speeds);
 	}
	
    public List<Integer> solution(int[] progresses, int[] speeds) {
    	List<Integer> answer = new ArrayList<>();
        int count =0;
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++) {
            if((100-progresses[i])%speeds[i] == 0){
                que.offer((100-progresses[i])/speeds[i]);
            }else{
                 que.offer((100-progresses[i])/speeds[i]+1);
            }
        }

        System.out.println(que);
        while(!que.isEmpty()) {
        	count++;
        	int a = que.poll();
        	while(!que.isEmpty() && que.peek()<=a) {
        		que.poll();
        		count++;
        	}
        	System.out.println("~~~~~~~~~~~~" + count);
        	answer.add(count);
        	count=0;

        }
        return answer;

    }
}
