package algorithm.programmers.level2;

import java.util.Stack;

/**
 * 주식가격
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 */
public class Solution_42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek();
            stack.pop();
        }
        return answer;
    }
}
