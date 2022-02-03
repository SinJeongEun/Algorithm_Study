package com.company.algoritthm_study.Algorithm_study;

import com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.heap.DiskController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiskControllerTest {

    @Test
    void solution() {
        int[][]jobs = {{0, 3},{1, 9}, {2, 6}};
//        int[][]jobs = {{0, 6}, {2, 8}, {3, 7}, {7, 1},{11, 11}, {19, 25}, {30, 15}, {32, 6}, {40, 3}};
        DiskController d = new DiskController();
        assertEquals(9,d.solution(jobs));
//        assertEquals(19,d.solution(jobs));
    }
}