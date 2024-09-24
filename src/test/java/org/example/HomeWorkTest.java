package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkTest {
    @Test
    public void shouldReturnNonEmptyList_whenCountIsThreeAndBoundLessThanFive(){
        HomeWork homeWork = new HomeWork();
        homeWork.add(4);
        homeWork.add(5);
        homeWork.add(2);
        homeWork.add(1);
        homeWork.add(3);

        List<Integer> maxDigits = homeWork.findMaxDigits(3, 4);

        assertIterableEquals(Arrays.asList(4, 3 ,2 ), maxDigits);
    }

    @Test
    public void shouldReturnNonEmptyList_whenCountIsThreeAndBoundLessThanSix(){
        HomeWork homeWork = new HomeWork();
        homeWork.add(4);
        homeWork.add(5);
        homeWork.add(2);
        homeWork.add(1);
        homeWork.add(3);

        List<Integer> maxDigits = homeWork.findMaxDigits(3, 5);

        assertIterableEquals(Arrays.asList(5, 4, 3), maxDigits);
    }

    @Test
    public void shouldReturnNonEmptyList_whenCountIsFourAndBoundLessThanSix(){
        HomeWork homeWork = new HomeWork();
        homeWork.add(4);
        homeWork.add(5);
        homeWork.add(2);
        homeWork.add(1);
        homeWork.add(3);

        List<Integer> maxDigits = homeWork.findMaxDigits(4, 5);

        assertIterableEquals(Arrays.asList(5, 4, 3, 2), maxDigits);
    }

    @Test
    public void shouldReturnEmptyList_whenCountIsNegativeAndBoundLessThanFive(){
        HomeWork homeWork = new HomeWork();
        homeWork.add(4);
        homeWork.add(5);
        homeWork.add(2);
        homeWork.add(1);
        homeWork.add(3);

        assertThrows(IllegalArgumentException.class, () -> {
            homeWork.findMaxDigits(-3, 4);
        });
    }
}