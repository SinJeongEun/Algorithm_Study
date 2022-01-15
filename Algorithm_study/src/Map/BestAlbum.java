package Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BestAlbum {
	class Inform{
		int index;
		int plays;
		
		public Inform(int index, int plays) {
			this.index = index;
			this.plays = plays;
		}
	}

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		new BestAlbum().solution(genres, plays);
	}
	
	public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String,List<Inform>> map = new HashMap<>();
        Map<String,Integer> types = new HashMap<>();//���ϰ��� ���� ���� �帣������ ������ ����
        
        for(int i=0;i<genres.length;i++) {
        	List<Inform> tmp = new ArrayList<>();
        	if(map.containsKey(genres[i])) {
        		tmp = map.get(genres[i]);
        		tmp.add(new Inform(i,plays[i]));  
        		
        	}else tmp.add(new Inform(i,plays[i]));
        	
        	//�� �帣�� ���ϰ�� ����
        	map.put(genres[i], tmp);
        	
        	//�� �帣�� �� ��� Ƚ�� ����
        	types.put(genres[i], types.getOrDefault(genres[i],0)+plays[i]);
        	
        }
               
        for(String key : map.keySet()) {          	
        	//�� �帣�� ���� ���� ����� �뷡, ��� ���� ���� ��� ������ȣ�� ���� �뷡����
        	Collections.sort(map.get(key),
        			(a,b)-> a.plays == b.plays ? a.index - b.index : b.plays - a.plays);  
        	
        	//�� �帣�� ����2� �����
        	
        }
        
        //��� Ƚ���� ���� ���� �帣������ ����
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(types.entrySet());
        Collections.sort(entries,(a,b) -> b.getValue()- a.getValue());
        
//        for(Map.Entry<String, Integer> entry : entries) {
//        	System.out.println(entry.getKey() + " ~~~ "+ entry.getValue() );
//        }
        
        //���  *****���ϰ��� ���� ���� key���� ����ϵ��� �����ϱ�!!!
        for(Map.Entry<String, Integer> entry : entries) {
        	//�׽�Ʈ�� ��¹�
//        	System.out.println(entry.getKey() + " : " );
//        	map.get(entry.getKey())
//			.forEach((a) -> System.out.print(a.index + ", " + a.plays + "  "));
//        	System.out.println();
        	
        	//answer�� index ����
        	map.get(entry.getKey())
        	.stream()
        	.limit(2)
			.forEach((a) -> answer.add(a.index));
               	
        }
        
        System.out.print(answer);
       
        return answer;
    }

}
