package bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class TravelRoot {	
	static ArrayList<String> result = new ArrayList<String>();
	 public static void main(String[] args) {
	    	String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
	    	TravelRoot s = new TravelRoot();
	    	s.solution(tickets);
	    }
	    
	    public String[] solution(String[][] tickets) {

	        //방문경로를 저장하기위한 배열
	        Boolean[] visited = new Boolean[tickets.length];
	        Arrays.fill(visited, Boolean.FALSE);
	        
	        //깊이탐색 시작
	        dfs(visited, "ICN", "", tickets, 0);
	        
	        //알파벳순서로 가장 빠른 경로를 가져오기 위한 정렬
	        //모든 경우의 수를 result에 저장되어 있으니 정렬 후 가장 앞에 있는 배열을 출력한다.
	        Collections.sort(result);
	        
	        String[] answer = result.get(0).split(",");
	        return answer;
	    }
	    
	    static void dfs(Boolean[] visited, String station, String path, String[][] tickets, int index)  {
			if("".equals(path)) {
				path = station;
			}else {
				path = path + ","+ station;
			}		
			
			if(index == tickets.length) {
				result.add(path);
				System.out.println("/////  " +result);
			}
			
			for(int i=0; i<tickets.length; i++) {
	                        //사용하지 않은 티켓이고 가는 경로가 있을 경우
				if(!visited[i] && tickets[i][0].equals(station)) {
					visited[i] = true;
					for(boolean a : visited) {
						System.out.println(a + " ");
					}
//					System.out.println("-------------------------------------------");
					dfs(visited, tickets[i][1], path, tickets, index+1);
					// 같은 방문지가 있는 경우, 다른 방문지를 돌기위해 false로 설정
					visited[i] = false;
//					System.out.println("****** " + i + "     " + index);
//					System.out.println("******" + result);
				}
			}
		}
	}