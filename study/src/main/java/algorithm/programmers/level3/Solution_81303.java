package algorithm.programmers.level3;

import java.util.LinkedList;
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
        StringBuilder answer = new StringBuilder("O".repeat(n));
        int[] pre = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n ; i++) {
            pre[i]= i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;
        Stack<Integer> deleteStack = new Stack<>();

        int cursor = k;

        for (String command : cmd) {
            char c = command.charAt(0);
            if (command.length() > 1) {
                int value = Integer.parseInt(command.substring(2));
                if (c == 'U') {
                    while (value-- > 0) {
                        cursor = pre[cursor];
                    }
                } else if (c == 'D') {
                    while (value-- > 0) {
                        cursor = next[cursor];
                    }
                }
            } else if (c == 'Z') {
                int deleteData = deleteStack.pop();
                answer.setCharAt(deleteData, 'O');
                if (pre[deleteData] != -1) {
                    next[pre[deleteData]] = deleteData;
                }
                if (next[deleteData] != -1) {
                    pre[next[deleteData]] = deleteData;
                }
            } else if (c == 'C') {
                deleteStack.push(cursor);
                answer.setCharAt(cursor, 'X');
                if (pre[cursor] != -1) {
                    next[pre[cursor]] = next[cursor];
                }
                if (next[cursor] != -1) {
                    pre[next[cursor]] = pre[cursor];
                    cursor = next[cursor];
                } else {
                    cursor = pre[cursor];
                }
            }
        }
        return answer.toString();
    }
}
