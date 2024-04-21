package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 20055번
public class RobotOnContainerBelt {
    static int[] arr;
    static boolean[] robot;
    static int n,k;
    static int start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp[] = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        k = Integer.parseInt(tmp[1]);

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        robot = new boolean[n];
        start = 0;
        end = n;

        int result = startContainer();

        System.out.println(result);
    }

    static private int startContainer() {
        int count = 0;
        while (k > 0) {
            count++;
            moveBelt();
            moveRobot();
            loadRobot();
        }

        return count;
    }

    public static void moveBelt() {
        start--;
        end--;
        if(start == -1)
            start = 2*n-1;
        if(end == -1)
            end = 2*n-1;

        for(int i = n-2; i >= 0; i--) {
            if(robot[i]) {
                robot[i] = false;
                if(i+1 < n-1)
                    robot[i+1] = true;
            }
        }
    }

    public static void moveRobot() {
        for(int i = n-2; i >= 0; i--) {
            if(robot[i]) {
                int next = start+i+1;
                if(next >= 2*n)
                    next -= 2*n;
                if(!robot[i+1] && arr[next] >= 1) {
                    robot[i] = false;
                    if(i+1 < n-1)
                        robot[i + 1] = true;
                    arr[next]--;
                    if(arr[next] == 0)
                        k--;
                }
            }
        }
    }

    public static void loadRobot() {
        if(!robot[0] && arr[start] > 0) {
            robot[0] = true;
            arr[start]--;
            if(arr[start] == 0)
                k--;
        }
    }

}
