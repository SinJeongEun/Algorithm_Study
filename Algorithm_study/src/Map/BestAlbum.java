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
        Map<String,Integer> types = new HashMap<>();//수록곡이 가장 많은 장르순으로 정렬을 위함
        
        for(int i=0;i<genres.length;i++) {
        	List<Inform> tmp = new ArrayList<>();
        	if(map.containsKey(genres[i])) {
        		tmp = map.get(genres[i]);
        		tmp.add(new Inform(i,plays[i]));  
        		
        	}else tmp.add(new Inform(i,plays[i]));
        	
        	//각 장르별 수록곡들 삽입
        	map.put(genres[i], tmp);
        	
        	//각 장르별 총 재생 횟수 삽입
        	types.put(genres[i], types.getOrDefault(genres[i],0)+plays[i]);
        	
        }
               
        for(String key : map.keySet()) {          	
        	//각 장르별 가장 많이 재생된 노래, 재생 수가 같은 경우 고유번호가 낮은 노래부터
        	Collections.sort(map.get(key),
        			(a,b)-> a.plays == b.plays ? a.index - b.index : b.plays - a.plays);  
        	
        	//각 장르별 상위2곡만 남기기
        	
        }
        
        //재생 횟수가 가장 많은 장르순으로 정렬
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(types.entrySet());
        Collections.sort(entries,(a,b) -> b.getValue()- a.getValue());
        
//        for(Map.Entry<String, Integer> entry : entries) {
//        	System.out.println(entry.getKey() + " ~~~ "+ entry.getValue() );
//        }
        
        //출력  *****수록곡이 가장 많은 key부터 출력하도록 구현하기!!!
        for(Map.Entry<String, Integer> entry : entries) {
        	//테스트용 출력문
//        	System.out.println(entry.getKey() + " : " );
//        	map.get(entry.getKey())
//			.forEach((a) -> System.out.print(a.index + ", " + a.plays + "  "));
//        	System.out.println();
        	
        	//answer에 index 삽입
        	map.get(entry.getKey())
        	.stream()
        	.limit(2)
			.forEach((a) -> answer.add(a.index));
               	
        }
        
        System.out.print(answer);
       
        return answer;
    }

}
