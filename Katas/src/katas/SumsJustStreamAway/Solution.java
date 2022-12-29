package katas.SumsJustStreamAway;

import java.util.Arrays;

public class Solution {

    public static int sumOfAllNumbers(int[] array) {
	return Arrays.stream(array).sum();
    }

    public static int sumOfAllEvenNumbers(int[] array) {
	return Arrays.stream(array).filter(i -> i % 2 == 0).sum();
    }

    public static int sumOfAllOddNumbers(int[] array) {
	return Arrays.stream(array).filter(i -> (i % 2 == 1) || (i % 2 == -1)).sum();
    }

    public static int sumOfAllNumbersGreaterThan(int[] array, int value) {
	return Arrays.stream(array).filter(i -> i > value).sum();
    }

    public static int sumOfAllEvenNegativeNumbers(int[] array) {
	return Arrays.stream(array).filter(i -> i % 2 == 0).filter(i -> i < 0).sum();
    }

    public static int sumOfAllOddNegativeNumbers(int[] array) {
	return Arrays.stream(array).filter(i -> i % 2 == -1).sum();
    }

}
