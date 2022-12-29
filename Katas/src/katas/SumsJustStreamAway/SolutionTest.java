package katas.SumsJustStreamAway;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void testExamplesProvided() {
	Assert.assertEquals(10, Solution.sumOfAllNumbers(new int[] { 1, 2, 3, 4 }));
	Assert.assertEquals(6, Solution.sumOfAllEvenNumbers(new int[] { 1, 2, 3, 4, 5 }));
	Assert.assertEquals(9, Solution.sumOfAllOddNumbers(new int[] { 1, 2, 3, 4, 5 }));
	Assert.assertEquals(9, Solution.sumOfAllNumbersGreaterThan(new int[] { 1, 2, 3, 4, 5 }, 3));
	Assert.assertEquals(0, Solution.sumOfAllEvenNegativeNumbers(new int[] { 1, 2, 3, 4, 5 }));
	Assert.assertEquals(-4, Solution.sumOfAllEvenNegativeNumbers(new int[] { -2, -2, 3, -3 }));
	Assert.assertEquals(-7, Solution.sumOfAllOddNegativeNumbers(new int[] { -2, -100, -3, -1, 100, 2, -3 }));
    }

    @Test
    public void passingEmptyArrayZeroIsReturned() {
	Assert.assertEquals(0, Solution.sumOfAllNumbers(new int[0]));
	Assert.assertEquals(0, Solution.sumOfAllEvenNumbers(new int[0]));
	Assert.assertEquals(0, Solution.sumOfAllOddNumbers(new int[0]));
	Assert.assertEquals(0, Solution.sumOfAllNumbersGreaterThan(new int[0], 0));
	Assert.assertEquals(0, Solution.sumOfAllEvenNegativeNumbers(new int[0]));
	Assert.assertEquals(0, Solution.sumOfAllEvenNegativeNumbers(new int[0]));
	Assert.assertEquals(0, Solution.sumOfAllOddNegativeNumbers(new int[0]));
    }

    @Test
    public void randomSumOfAllNumbers() {
	int[] array = createRandomArray();
	int expected = Arrays.stream(array).sum();
	int actual = Solution.sumOfAllNumbers(array);
	Assert.assertEquals(expected, actual);
    }

    @Test
    public void randomSumOfAllEvenNumbers() {
	int[] array = createRandomArray();
	int expected = Arrays.stream(array).filter(i -> i % 2 == 0).sum();
	int actual = Solution.sumOfAllEvenNumbers(array);
	Assert.assertEquals(expected, actual);
    }

    @Test
    public void randomSumOfAllOddNumbers() {
	int[] array = createRandomArray();
	int expected = Arrays.stream(array).filter(i -> i % 2 == 1 || i % 2 == -1).sum();
	int actual = Solution.sumOfAllOddNumbers(array);
	Assert.assertEquals(expected, actual);
    }

    @Test
    public void randomSumOfAllNumbersGreaterThanPositiveValue() {
	int value = 9;
	int[] array = createRandomArray();
	int expected = Arrays.stream(array).filter(i -> i > value).sum();
	int actual = Solution.sumOfAllNumbersGreaterThan(array, value);
	Assert.assertEquals(expected, actual);
    }

    @Test
    public void randomSumOfAllNumbersGreaterThanNegativeValue() {
	int value = -982;
	int[] array = createRandomArray();
	int expected = Arrays.stream(array).filter(i -> i > value).sum();
	int actual = Solution.sumOfAllNumbersGreaterThan(array, value);
	Assert.assertEquals(expected, actual);
    }

    @Test
    public void randomSumOfAllEvenNegativeNumbers() {
	int[] array = createRandomArray();
	int expected = Arrays.stream(array).filter(i -> i % 2 == 0).filter(i -> i < 0).sum();
	int actual = Solution.sumOfAllEvenNegativeNumbers(array);
	Assert.assertEquals(expected, actual);
    }

    @Test
    public void randomSumOfAllOddNegativeNumbers() {
	int[] array = createRandomArray();
	int expected = Arrays.stream(array).filter(i -> i % 2 == -1).sum();
	int actual = Solution.sumOfAllOddNegativeNumbers(array);
	Assert.assertEquals(expected, actual);
    }

    private static int getRandomNumber(int min, int max) {
	return (int) ((Math.random() * (max - min)) + min);
    }

    private static int[] createRandomArray() {
	int[] array = new int[getRandomNumber(0, 5000)];
	return Arrays.stream(array).map(i -> getRandomNumber(-10000, 10000)).toArray();
    }

}
