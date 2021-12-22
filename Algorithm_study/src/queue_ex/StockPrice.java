package queue_ex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StockPrice {

	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		new StockPrice().solution(prices);

	}
	public List<Integer> solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        
        for(int p : prices) {
        	que.offer(p);
        }
        
        while(!que.isEmpty()) {
        	int now = que.poll();
        	int count =0;
        	
        	for(int price : que) {
        		if(now <= price) {
        			System.out.println("now: " + now + "ū��: " + price);
        			count++;
        		}else {
        			count++; //1�� �ڿ� �ֽ� ������ �������Ƿ�
        			break;
        		}
        	}
        	answer.add(count);
        	System.out.println(count);
        	
        }
        System.out.println(answer);
        return answer;
    }

}
