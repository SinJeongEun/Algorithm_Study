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
        final int truck_total = truck_weights.length;
        Queue<Truck> bridge = new LinkedList<>();
        
        bridge.offer(new Truck((truck_weights[start]),1));
        now_weight += truck_weights[start];
        while(!bridge.isEmpty()) {
        	while(bridge.peek().count <= bridge_length) {
        		bridge.forEach(t->t.count++);
    			total++;      			
        		
        		if(start+1<truck_total && now_weight + truck_weights[start+1] <= weight && bridge.size() < bridge_length) {     			
        			Truck go =new Truck((truck_weights[++start]),1);
	    			bridge.offer(go);
	    			now_weight += go.t_weigth;       			
        		}
        	}
        	Truck t = bridge.poll();
        	now_weight -= t.t_weigth;  
        	if(start+1<truck_total && now_weight + truck_weights[start+1] <= weight && bridge.size() < bridge_length) {   					
    			Truck go =new Truck((truck_weights[++start]),1);
    			bridge.offer(go);
    			now_weight += go.t_weigth;        			
    		}      	      	
        }
        total++;
        System.out.println("~~" + total);
        return total;
    }

}

