package algorithm.programmers.level2;

import java.util.Stack;

/**
 * 올바른 괄호
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class Solution_12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    answer = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}
