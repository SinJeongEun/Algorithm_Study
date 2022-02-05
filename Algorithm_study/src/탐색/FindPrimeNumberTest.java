package com.company.algoritthm_study.Algorithm_study.Algorithm_study.src.탐색;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPrimeNumberTest {

    @Test
    void solution() {
        FindPrimeNumber f = new FindPrimeNumber();
//        String numbers = "17";
        String numbers = "011";

//        assertEquals(3,f.solution(numbers));
        assertEquals(2,f.solution(numbers));
    }
}