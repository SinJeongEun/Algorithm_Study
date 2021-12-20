package queue_ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Priority_Printer {

	//프로그래머스 .스택/큐.프린터 알고리즘 풀이...
	public static void main(String[] args) {
		int priorities[] = {1, 1, 9, 1, 1, 1};
		int location = 0;
		new Priority_Printer().solution(priorities, location);

	}
	class Task{
		int location;
		int priority;
		
		public Task(int location, int priority) {
			this.location =location;
			this.priority = priority;
		}
	}

    public int solution(int[] priorities, int location) {
        int answer=0;
        List<Integer> list = new ArrayList<>();
        for(int p : priorities) list.add(p);
        Collections.sort(list,(a,b)->b-a);
                   
        //큐에 담기
        Queue<Task> que = new LinkedList<>();
        for(int i=0;i<priorities.length;i++) {
        	que.offer(new Task(i,priorities[i]));
        }

        //우선순위대로 poll
        int count =0;
        while(!que.isEmpty()) {
        	Task cur = que.poll();
        	if(cur.priority < list.get(0)) {
        		que.offer(cur);
         	}
        	else if(cur.priority == list.get(0)) {
        		count++;
        		list.remove(0);
        		if(cur.location == location) {
        			answer = count;
        			System.out.println(answer);
        		}
        	}
        	
        	
        }      
        return answer;
    }


}
