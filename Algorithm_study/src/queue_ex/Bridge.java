package queue_ex;

import java.util.LinkedList;
import java.util.Queue;

public class Bridge {
	//프로그래머스 .스택/큐.다리를 지나는 트럭 알고리즘 풀이...
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int truck_weights[] = {7,4,5,6};
		new Bridge().solution(bridge_length, weight, truck_weights);

	}
	
	class Truck{
		int t_weigth;
		int count;
		
		public Truck(int t_weight, int count) {
			this.t_weigth = t_weight;
			this.count = count;
		}
	}
	
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int total = 0; 
        int start = 0;
        int now_weight = 0;
        Queue<Truck> bridge = new LinkedList<>();
        
        bridge.offer(new Truck((truck_weights[start]),0));
        total++;
        now_weight += truck_weights[start];
        while(!bridge.isEmpty()) {
        	while(bridge.peek().count < bridge_length) {
        		System.out.println("11111111111  "+ bridge.peek().t_weigth );
        		System.out.println("~~~~~~~~~~~~~~~~~~~~~~" + bridge.peek().count);
        		
    			bridge.peek().count++;
    			total++;        	
        		
        		if(now_weight + truck_weights[start+1] <= weight && start+1<truck_weights.length && !bridge.contains(truck_weights[start+1])) {
        			start++;
        			System.out.println("+++++++++ " + start);
	    			bridge.offer(new Truck((truck_weights[start]),0));
	    			now_weight += truck_weights[start];       			
        		}
        	}
        	System.out.println("00000000000000000" + bridge.peek().count);
        	bridge.poll();
        	now_weight -= truck_weights[start];  
        	if(now_weight + truck_weights[start+1] <= weight && start+1<truck_weights.length) {
    			start++;
    			System.out.println("+++++++++ " + start);
    			bridge.offer(new Truck((truck_weights[start]),0));
    			now_weight += truck_weights[start];
    			
    		}
        	      	
        }
        System.out.println("~8888888888888888888~" + total);
        return total;
    }

}

