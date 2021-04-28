package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapArray {

	public static void main(String[] args) {
		
		int[] nums = {1,1,2,2,2,3,5,5,5,5};
		int k =2; //가장 빈도수 많은 숫자 2(k)개 출력
		System.out.println(new MapArray().topFrequent(nums,k));
	}

	public List<Integer> topFrequent(int[]nums , int k){
		//1. 담을 그릇
		Map<Integer,Integer> map = new HashMap<>();
		List<Integer>[] list = new List[nums.length+1]; // value값이 index가 되는 리스트
		List<Integer>result = new ArrayList<>();
		
		//2. 맵에다가 getOrDefault 사용하여 값 넣기
		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		//3. List (value가 index가 되도록)
		for(Integer key : map.keySet()) {
			int topFrequent = map.get(key);
			if(list[topFrequent] ==null) list[topFrequent] = new ArrayList<>();
			list[topFrequent].add(key);
		}
		
		//4. List에서 뽑아내기 k=2개  , null이 아닌 뒤에서 2개의 인덱스 
		for(int last = list.length-1; last>=0; last--) {
			if(list[last] != null) {
				for(int i=0; i<list[last].size() && result.size() < k; i++){
					result.add(list[last].get(i));
				}
			}
		}
		return result;
	}

}
