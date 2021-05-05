package Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest2 {

	public static void main(String[] args) {
		int k = 2;
		String[] words = {"a", "b", "c", "a", "b", "c", "a"};
		PriorityQueueTest2 a = new PriorityQueueTest2();
		System.out.println(a.solve(words, k));
	}

	public List<String> solve(String words[], int k){
		//1. ���� ����
		List <String> result = new ArrayList<>();
		Map<String,Integer> map = new HashMap<>();
		
		//2. ���
		for(String w : words) {
			map.put(w, map.getOrDefault(w, 0) + 1);
		}
		
		//3.pq �����
		Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b)->
		a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) :
		b.getValue() - a.getValue());  //�󵵼�(value)�� ������ ���ĺ���(��������)  ,  �󵵼��� ����2�� -> ��������
		
		// pq�� ����
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.offer(entry);
		}
		
		//�󵵼� ���� ���� k�� ���
		while(k>0) {
			result.add(pq.poll().getKey());
			k--;
		}
		
		return result;		
	}
}
