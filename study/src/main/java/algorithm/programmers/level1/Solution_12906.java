package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * 같은 숫자는 싫어
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 */
public class Solution_12906 {

    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        int rear = -1;
        for (int num : arr) {
            if (rear == num)    continue;
            rear = num;
            answer.add(rear);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
