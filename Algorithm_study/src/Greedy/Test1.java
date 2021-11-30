package Greedy;
import java.util.Arrays;

public class Test1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int student[] = new int [n];

        Arrays.fill(student, 1); // 모든 학생에게 체육복이 있다고 가정
        for(int l : lost) student[l-1] -= 1;
        for(int r : reserve) student[r-1] += 1;

        for(int i = 0; i<n; i++){
            if(student[i] >= 1) continue;
            
            if(i >0 && student[i-1] > 1){
                student[i-1] -= 1;
                student[i] += 1;
            }
            else if(i+1 < student.length && student[i+1] > 1){
                student[i+1] -= 1;
                student[i] += 1;
            }
        }
        return (int)Arrays.stream(student)
                .filter(i -> i>0)
                .count();

    }
}