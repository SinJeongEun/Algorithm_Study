package Sort;

import java.util.PriorityQueue;

public class PriorityQueue_test {

	public static void main(String[] args) {
		PriorityQueue_test a = new PriorityQueue_test();
		int[] sticks = {1, 8, 2, 5};
		
		System.out.println(a.pqStricks(sticks));

	}

	public int pqStricks(int[] sticks) {
		PriorityQueue <Integer> pq = new PriorityQueue<>();
		for(int i : sticks) {
			pq.offer(i);
		}
		
		int sum = 0;
		while(pq.size() > 1) {
			int twoSum = pq.poll() + pq.poll();
			sum += twoSum;
			pq.offer(twoSum);
		}
		
		return sum;
	}

}
