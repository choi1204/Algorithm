package algorithm.programmers.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_11446 {

    public static class Number{

        public int v;
        public int n;

        Number(int v, int n) {
            this.v = v;
            this.n = n;
        }

    }

    public static List<Number> getNumberList(int[] arr) {
        List<Number> list = new ArrayList<>();
        Arrays.sort(arr);
        int n = 0;
        int rear = arr[0];
        boolean b = false;
        for (int v : arr) {
            if (v == rear) {
                b = false;
                n++;
                continue;
            }
            b = true;
            list.add(new Number(rear, n));
            rear = v;
            n = 1;
        }
        if (!b) {
            list.add(new Number(rear, n));
        }
        return list;
    }

    public static int getNumberValue(List<Number> numberList, int size) {
        int total = 0;
        int gap = size;
        int answer = 0;
        for (Number number : numberList) {
            total += number.n;
            int back = size - total;
            if (Math.abs(total - back) < gap) {
                gap = Math.abs(total - back);
                answer = number.v + 1;
            }
        }
        return answer;
    }


    public static int solution(int[] arr) {
        List<Number> numberList = getNumberList(arr);
        int size = arr.length;
        int answer = getNumberValue(numberList, size);
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1,52,125,10,25,201,244,192,128,23,203,98,154,255};
        int[] arr2 = {0,0,255,255,0,0,255,255,255};
        int[] arr3 = {100,50,100,200};
        int[] arr4 = {100,100,100,100};
        System.out.println(solution(arr4));
    }
}
