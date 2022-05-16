package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42746
 * 가장 큰 수
 */
public class Solution_42746 {
    public static String solution(int[] numbers) {
        String[] strings = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(strings,
                (num1, num2) -> (num2 + num1).compareTo(num1 + num2));

        if (strings[0].equals("0"))
            return "0";

        return String.join("", strings);
    }

    public static void main(String[] args) {
        int[] numbers = {0, 0, 0, 0, 0};
        solution(numbers);
    }
}
