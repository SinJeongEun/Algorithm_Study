package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {

		public int solution(int[][] jobs) {
			PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); //처리시간 순서대로
			Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); //시작시간 순서대로

			int answer = 0;
			int current = 0; //현재 시간
			int i = 0;
			while (i < jobs.length || !q.isEmpty()) {
				while (i < jobs.length && jobs[i][0] <= current) {
					q.add(new int[]{jobs[i][0], jobs[i][1]});
					i++;
				}

				if (q.isEmpty()) { //큐가 비어있다. -> 현재 실행할 수 있는 작업이 없다.
					current = jobs[i][0]; //다음 작업의 시작시간으로 이동한다.
				} else {
					int[] temp = q.poll();
					answer += current + temp[1] - temp[0]; //요청 ~ 종료시간
					System.out.println(current + " " + temp[0] + " " + temp[1]);
					current += temp[1];
				}
			}
			return answer / jobs.length;

		}

}

