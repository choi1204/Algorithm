package algorithm.programmers.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * 주차 요금 계산
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */
public class Solution_92341 {

    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        int arr[] = new int[10000];
        boolean check[] = new boolean[100000];
        boolean in[] = new boolean[10000];
        int result[] = new int[10000];

        int time = fees[0];
        int charge = fees[1];
        int perTime = fees[2];
        int perCharge = fees[3];

        for (String record : records) {
            String[] split = record.split(" ");
            String[] times = split[0].split(":");
            int hour = Integer.parseInt(times[0]);
            int min = Integer.parseInt(times[1]);
            int carNumber = Integer.parseInt(split[1]);
            String type = split[2];
            int calcTime = hour * 60 + min;
            if (type.equals("IN")) {
                arr[carNumber] = calcTime;
                check[carNumber] = true;
                in[carNumber] = true;
            } else if (type.equals("OUT")) {
                result[carNumber] += calcTime - arr[carNumber];
                in[carNumber] = false;
            }
        }
        for (int i = 0; i <= 9999; i++) {
            if (!in[i]) {
                continue;
            }
            int calcTime = 23 * 60 + 59;
            result[i] += calcTime - arr[i];
        }

        for (int i = 0; i <= 9999; i++) {
            if (!check[i]) {
                continue;
            }
            int sum = 0;
            sum += charge;
            if (result[i] > time) {
                int value = (result[i] - time) / perTime;
                int mod = (result[i] - time) % perTime;
                if (mod != 0) {
                    value++;
                }
                sum += value * perCharge;
            }
            result[i] = sum;
        }
        for (int i = 0; i <= 9999; i++) {
            if (!check[i]) {
                continue;
            }
            answer.add(result[i]);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int fees[] = {180, 5000, 10, 600};
        String records[] = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        Solution_92341 s = new Solution_92341();
        s.solution(fees, records);
    }
}
