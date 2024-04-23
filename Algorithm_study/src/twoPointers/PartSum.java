package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1806번
 * 부분합
 * two pointer 방식으로 풀이(누적합으로 풀면 시간초과)
 */
public class PartSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int arr[] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0, left = 0, right = 0;
        int min = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) sum -= arr[left++];
            else if(right == N) break;
            else {
                sum += arr[right++];
            }

            if(sum >= S) {
                min = Math.min(min, right - left);
            }
        }

        System.out.println(min >= Integer.MAX_VALUE ? 0 : min);


        /* 누적합 방식으로 풀이 시 시간 초과 !!
        // 누적합 구하기
        int prefixSum[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(i == 0){
                prefixSum[i] = arr[i];
                continue;
            }
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        // 시작점 기준 누적합이 S 이상이 되는 가장 짧은 길이를 저장한다.
        // 누적합이 S가 되는 순간 저장하고 다음 index로 넘언간다.
        TreeSet<Integer> resultSet = new TreeSet<>();
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = 0; j < prefixSum.length; j++) {
                int prfix = i == 0 ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
                if(prfix >= S) {
                    resultSet.add(j - i + 1);
                    break;
                }
            }
        }
        System.out.println(resultSet.pollFirst());*/
    }
}
