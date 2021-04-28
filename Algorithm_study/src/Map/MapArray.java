package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapArray {

	public static void main(String[] args) {
		
		int[] nums = {1,1,2,2,2,3,5,5,5,5};
		int k =2; //���� �󵵼� ���� ���� 2(k)�� ���
		System.out.println(new MapArray().topFrequent(nums,k));
	}

	public List<Integer> topFrequent(int[]nums , int k){
		//1. ���� �׸�
		Map<Integer,Integer> map = new HashMap<>();
		List<Integer>[] list = new List[nums.length+1]; // value���� index�� �Ǵ� ����Ʈ
		List<Integer>result = new ArrayList<>();
		
		//2. �ʿ��ٰ� getOrDefault ����Ͽ� �� �ֱ�
		for(int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		//3. List (value�� index�� �ǵ���)
		for(Integer key : map.keySet()) {
			int topFrequent = map.get(key);
			if(list[topFrequent] ==null) list[topFrequent] = new ArrayList<>();
			list[topFrequent].add(key);
		}
		
		//4. List���� �̾Ƴ��� k=2��  , null�� �ƴ� �ڿ��� 2���� �ε��� 
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
