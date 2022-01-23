package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class DiskController {
	
	class Job{
		 int start;
		 int time;
		
		public Job(int start,int time) {
			this.start = start;
			this.time = time;
		}		
	}

	public static void main(String[] args) {
		int[][]jobs = {{0, 3},{1, 9}, {2, 6}};
		new DiskController().solution(jobs);

	}
	
	 public int solution(int[][] jobs) {
	        int answer = 0;
	        int count = 0;
	        //��û�ð� ������������ ����
	        Arrays.sort(jobs,(a,b)->a[0]==b[0]?a[1]-b[1] : a[0]-b[0]);
	        
//	        for(int[] a : jobs)System.out.println(a[0] + " " + a[1]);
	       	        
	        //��� ť
	        Queue<Job> wait = new PriorityQueue<>( new Comparator<Job>(){
				@Override
				public int compare(Job a, Job b) {
					if(a.start == b.start) return a.time - b.time;
					else return a.start - b.start;			
				}
			});
	        
	        for(int[] a : jobs) {
//	        	System.out.println(a[0] + " " + a[1]);
	        	Job job = new Job(a[0],a[1]);
	        	wait.offer(job);
	        }
	        
	        
	        //���� ť
	        Queue<Job>que = new LinkedList<>();	       
	        
	        
	        
	        while(!wait.isEmpty()) {
	        	//��� ť���� ��� �켱������ �����ؾ� ��. count�� ������� �Ǹ� ��������� ���� ���� ������
	        	que.offer(wait.poll());
	        	System.out.println("~~~~~~~` ");
	        	while(!que.isEmpty()) {
		        	Job now = que.peek();
		        	if(count >= now.start) {
		        		count -= now.start + now.time;
		        		que.poll();
		        		System.out.println("~~~~~~~` " + count);
		        	}	        
		        }
	        }
	        
	        
	        System.out.println(count/jobs.length);
	        
	        return answer;
	    }

	

}
