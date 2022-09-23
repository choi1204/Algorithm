package algorithm.programmers.level2;

import java.util.Stack;

/**
 * 괄호 회전하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 */
public class Solution_76502 {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String shiftString = shift(s, i);
            if (isCorrect(shiftString) || shiftString.equals("")) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isReverseAlpha(char alpha, char reverseAlpha) {
        if (alpha == '(' && reverseAlpha == ')') {
            return true;
        } else if (alpha == '[' && reverseAlpha == ']') {
            return true;
        } else if (alpha == '{' && reverseAlpha == '}') {
            return true;
        }
        return false;
    }

    public boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char alpha = stack.peek();
                if (!isReverseAlpha(alpha, c)) {
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public String shift(String s, int i) {
        return s.substring(i) + s.substring(0, i);
    }
}
