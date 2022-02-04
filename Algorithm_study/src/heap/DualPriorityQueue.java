package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class DualPriorityQueue {
    public List<Integer> solution(String[] operations) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> que = new PriorityQueue<>(); // 오름차순

        for(String a : operations) {

            //명령어와 데이터 읽기
            String[] now = a.split(" ");

            if (now[0].equals("I")) {
                que.offer(Integer.parseInt(now[1]));
            }

            else if (now[0].equals("D")) {
                //큐가 비면,,,?
                if(!que.isEmpty()) {
                    //큐에서 최댓값 삭제
                    if (now[1].equals("1")) {
                        List<Integer> tmp = que.stream().collect(Collectors.toList());
                        Collections.sort(tmp);
                        //최댓값
                        int max = tmp.get(tmp.size() - 1);
                        que.remove(max);

                    }
                    //큐에서 최솟값 삭제
                    else que.poll();
                }
                else continue;
            }
        }
        List<Integer> list = que.stream().collect(Collectors.toList());
        Collections.sort(list);
        if(list.size()>0){
            answer.add(list.get(list.size() - 1));
            answer.add(list.get(0));
        }
       else{
           answer.add(0);
            answer.add(0);
        }

        return answer;
    }
}
