package algorithm.programmers.level1;

public class Solution_12977 {

    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = j + 1; k < size; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
