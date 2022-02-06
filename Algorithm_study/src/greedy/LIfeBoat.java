package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.greedy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LIfeBoat {
    static int boat = 0;
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> dq = new ArrayDeque<>();
        for(int w : people) dq.add(w);

        int sum = 0;
        while(!dq.isEmpty()){
            sum = dq.peekFirst() + dq.peekLast();
            if(sum <= 100){
                dq.pollFirst();
                dq.pollLast();
                boat++;
            }else {
                dq.pollLast();
                boat++;
            }
        }
        answer = boat;
        return answer;
    }
}
