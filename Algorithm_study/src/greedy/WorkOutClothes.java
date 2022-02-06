package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.greedy;

import java.util.Arrays;

public class WorkOutClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n];
        Arrays.fill(students,1);

        //잃어버린 학생 -1
        for(int i=0;i<lost.length;i++){
            students[lost[i]-1] --;
        }
        //여분이 있는 학생 +1
        for(int i=0;i<lost.length;i++){
            students[reserve[i]-1] ++;
        }

        for(int i=1;i<students.length;i++){
            if(students[i] <1 ){
                if(students[i-1] -1 > 0) {
                    students[i-1]--;
                    students[i]++;
                }else if(students[i+1] - 1 >0){
                    students[i+1]--;
                    students[i]++;
                }
            }
        }

        for(int a : students)System.out.println(a);



        return (int) Arrays.stream(students)
                .filter((a)-> a>0)
                .count();
    }
}
