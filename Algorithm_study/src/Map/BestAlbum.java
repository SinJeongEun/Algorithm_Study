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
	
	public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String,List<Inform>> map = new HashMap<>();
        Map<Integer,String> _sort = new HashMap<>(); //수록곡이 가장 많은 장르순으로 정렬을 위함
        
        for(int i=0;i<genres.length;i++) {
//        	System.out.println(i);
        	List<Inform> tmp = new ArrayList<>();
        	if(map.containsKey(genres[i])) {
        		tmp = map.get(genres[i]);
        		tmp.add(new Inform(i,plays[i]));
        	}else tmp.add(new Inform(i,plays[i]));
        	
        	map.put(genres[i], tmp);
        	
        }
               
        for(String key : map.keySet()) {   
        	int _size = map.get(key).size();
        	_sort.put(_size, key);
        	
        	//각 장르별 가장 많이 재생된 노래, 재생 수가 같은 경우 고유번호가 낮은 노래부터
        	Collections.sort(map.get(key),
        			(a,b)-> a.plays == b.plays ? a.index - b.index : b.plays - a.plays);
        	
        	//가장 수록곡이 많은 장르순으로 정렬
        	Collections.sort(_sort.get(key),(a,b)->b-a);
        }
        
        
        
        
        //출력  *****수록곡이 가장 많은 key부터 출력하도록 구현하기!!!
        for(String key : map.keySet()) {
        	System.out.println(key + " : " );
        	map.get(key)
			.forEach((a) -> System.out.print(a.index + ", " + a.plays + "  "));
        	System.out.println();
        }
        
        
        
        
        
        return answer;
    }

}
