package bfs_dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TravelRoot {	
		public static void main(String[] args) {
			String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "SFO"}, {"ATL","ICN"}};
			new TravelRoot().solution(tickets);
		}
		
	    public String solution(String[][] tickets) {
	        StringBuffer  answer = new StringBuffer();
	        int count = 0;
	        int length = tickets.length + 1;
	        boolean visit[] = new boolean [tickets.length];

	        Map<String[],Integer> airport = new HashMap<>();
	        List<String[]>tmp = new ArrayList<>();
	        Queue<String[]> que = new LinkedList<>();
	        
	        for(String[] a : tickets ){
	        	airport.put(a, 0);
	        	if(a[0] == "ICN") {
	        		tmp.add(a);
	        	}
	        }
	        
	        String[] min = tmp.get(0);
	        if(tmp.size() == 1) que.offer(tmp.get(0));
	        else {
	        	
	        	for(String[] a : tmp) {
	        		if(a[1].compareTo(min[1]) < 0) {
	        			min = a;
	        		}
	        	}
	        }
	        
		       
			airport.put(min, airport.getOrDefault(min, 0)+1);
			que.offer(min);
			
			for(String[] key : airport.keySet()) {
				System.out.println("key:" + key[0]+","+key[1] + "values:" + airport.get(key));
			}
	        	
	        bfs(airport, count, length, answer,que);
        	System.out.println("~~~" + answer);
	        return answer.toString();
	    }
	    
	    public void bfs( Map<String[],Integer> airport,int count, int length,StringBuffer answer,Queue<String[]> que) {
	    	
	    	while(!que.isEmpty()) {
	    		
	    		if(answer.length() < length) {
	    			List<String[]>tmp1 = new ArrayList<>();
	    			for(String[] a : que) {
		    			System.out.println("que~~~" + a[0] + a[1]);
		    		}
	    			System.out.println("----");
		    		String[] now = que.poll();
		    		
		    		
		    		for(String[] key : airport.keySet()) {
		    			if(key[0].equals(now[1]) && airport.get(key)==0) {
		    				tmp1.add(key);
		    			}
		    		}
		    		String[] min = tmp1.get(0);
		    		if(tmp1.size() == 1) {
		    			airport.put(tmp1.get(0), airport.getOrDefault(tmp1.get(0), 0)+1);
		    			que.offer(tmp1.get(0));
		    			answer.append(tmp1.get(0)[0]);
		    		}
			        else {
			        	
			        	for(String[] a : tmp1) {
			        		if(a[1].compareTo(min[1]) < 0) {
			        			min = a;
			        		}
			        	}
			        	airport.put(min, airport.getOrDefault(min, 0)+1);
			        	que.offer(min);
			        	answer.append(min[0]);
			        }
		    		System.out.println("000" + answer);
		    		
	    		}
	    		
	    	}
	    	
	    }
	    
	    
	

}
