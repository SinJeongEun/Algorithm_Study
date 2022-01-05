package bfs_dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TravelRoot {	
		public static void main(String[] args) {
			String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
			new TravelRoot().solution(tickets);
		}
		
	    public String[] solution(String[][] tickets) {
	        String[] answer = {};
	        int count = 0;
	        int length = tickets.length + 1;

	        Map<String[],Integer> airport = new HashMap<>();
	        Queue que = new LinkedList<>();
	        for(String[] a : tickets ){
	        	airport.put(a, 0);
	        	if(a[0] == "ICN") {
	        		que.offer(a);
	        		airport.put(a, airport.getOrDefault(a, 0)+1);
	        	}
	        }
	        
	        bfs(airport, count, length, answer,que);
	        return answer;
	    }
	    
	    public void bfs( Map<String[],Integer> airport,int count, int length,String[] answer,Queue que) {
	    	while(!que.isEmpty()) {
	    		String[] now = (String[]) que.poll();
	    		3
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    		
	    	}
	    	
	    }
	    
	    
	

}
