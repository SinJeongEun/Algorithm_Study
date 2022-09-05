package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.queue_ex;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;
import java.io.*;

public class TwoQueues {
    //프로그래머스 - 두 큐 합 같게 만들
//    길이가 같은 두 개의 큐를 나타내는 정수 배열 queue1, queue2가 매개변수로 주어집니다.
//    각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수를 return 하도록 solution 함수를 완성해주세요.
//    단, 어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 경우, -1을 return 해주세요.
    static Queue<Integer> que1 = new LinkedList<>();
    static Queue<Integer> que2 = new LinkedList<>();
    static long sum1=0;
    static long sum2=0;
    public int solution(int[] queue1, int[] queue2) {
        for(int s : queue1) {
                que1.offer(s);
                sum1 += s;
            }

            for(int s : queue2) {
                que2.offer(s);
                sum2 += s;
            }

            int answer = test(que1, que2);
            return answer;

        }

        public static int test(Queue<Integer> a, Queue<Integer> b) {
            int count = 0;
            while(sum1 != sum2) {
                count++;

                if(count > (a.size() + b.size()) * 2) return -1;

                if(sum1 > sum2) {
                    int val = a.poll();
                    sum1 -= val;
                    sum2 += val;
                    b.offer(val);
                }else {
                    int val = b.poll();
                    sum2 -= val;
                    sum1 += val;
                    a.offer(val);
                }

            }
            return count;
        }
}


