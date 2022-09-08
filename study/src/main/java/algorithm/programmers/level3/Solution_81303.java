package algorithm.programmers.level3;

import java.util.Stack;

/**
 * 표편집
 * https://school.programmers.co.kr/learn/courses/30/lessons/81303
 */
public class Solution_81303 {
    // StringBuilder
    public String solution_StringBuilder(int n, int k, String[] cmd) {
        Stack<Integer> deleteStack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        int nowN = n;

        for (String command : cmd) {
            if (command.length() > 1) {
                int x = Integer.parseInt(command.substring(2));
                if (command.charAt(0) == 'U') {
                    k -= x;
                } else if(command.charAt(0) == 'D') {
                    k += x;
                }
            } else if (command.charAt(0) == 'C') {
                deleteStack.push(k);
                nowN--;
                if (nowN == k) k--;
            } else if (command.charAt(0) == 'Z') {
                nowN++;
                if (deleteStack.pop() <= k) {
                    k++;
                }
            }
        }

        for (int i = 0; i <  nowN; i++) {
            answer.append("O");
        }
        while (!deleteStack.isEmpty()) {
            int index = deleteStack.pop();
            answer.insert(index, "X");
        }
        return answer.toString();
    }

    //LinkedLlist
    public String solution_LinkedList(int n, int k, String[] cmd) {
        String answer = "";
        return answer;
    }
}
