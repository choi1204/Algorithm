package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * 큰 수 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 */
public class Solution_42883 {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        int delete = 0;
        StringBuilder answer = new StringBuilder();

        for (char c : number.toCharArray()) {
            int num = c - '0';

            while (!stack.isEmpty() && stack.peek() < num && delete < k) {
                delete++;
                stack.pop();
            }
            stack.add(num);
        }

        for (int i = 0; i < number.length() - k; i++) {
            answer.append(stack.get(i));
        }
        return answer.toString();
    }
}
