package algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * 소수찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */
public class Solution_12230 {

    public int solution(String numbers) {
        char[] numberArray = numbers.toCharArray();
        boolean visit[] = new boolean[numberArray.length];
        List<Integer> list = new ArrayList<>();
        dfs(numberArray, visit, 0, "", list);
        return list.size();
    }

    public void dfs(char[] array, boolean visit[], int depth, String s, List<Integer> list) {
        if (depth == array.length) {
            if (s.equals(""))
                return;
            int value = Integer.parseInt(s);
            if (isPrime(value) && !list.contains(value)) {
                list.add(value);
            }
            return;
        }
        dfs(array, visit, depth + 1, s, list);
        for (int i = 0; i < array.length; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            dfs(array, visit, depth + 1, s + array[i], list);
            visit[i] = false;
        }
    }
    public boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i<=(int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
