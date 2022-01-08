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

	        //�湮��θ� �����ϱ����� �迭
	        Boolean[] visited = new Boolean[tickets.length];
	        Arrays.fill(visited, Boolean.FALSE);
	        
	        //����Ž�� ����
	        dfs(visited, "ICN", "", tickets, 0);
	        
	        //���ĺ������� ���� ���� ��θ� �������� ���� ����
	        //��� ����� ���� result�� ����Ǿ� ������ ���� �� ���� �տ� �ִ� �迭�� ����Ѵ�.
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
	                        //������� ���� Ƽ���̰� ���� ��ΰ� ���� ���
				if(!visited[i] && tickets[i][0].equals(station)) {
					visited[i] = true;
					for(boolean a : visited) {
						System.out.println(a + " ");
					}
//					System.out.println("-------------------------------------------");
					dfs(visited, tickets[i][1], path, tickets, index+1);
					// ���� �湮���� �ִ� ���, �ٸ� �湮���� �������� false�� ����
					visited[i] = false;
//					System.out.println("****** " + i + "     " + index);
//					System.out.println("******" + result);
				}
			}
		}
	}