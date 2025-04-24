package groupLargestGroup;

import java.util.HashMap;

class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int number = i;
            int sum = 0;

            if(i<10){
                map.put(i, i);
            }else{
                while (number > 0) {
                    sum += number % 10; // Add the last digit of the number
                    number /= 10;        // Remove the last digit from the number
                }
            }
            // Count how many times this sum has occurred
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // Find the max size of any group
        int maxSize = 0;
        for (int count : map.values()) {
            if (count > maxSize) {
                maxSize = count;
            }
        }

        // Count how many groups have that max size
        int result = 0;
        for (int count : map.values()) {
            if (count == maxSize) {
                result++;
            }
        }

        return result;
    }

}

// Faster solition for small n, n = 9999
// Arrays will be faster than hashmaps for smaller n
// However the code bellow does essentially the same think as the code above

/*
class Solution {
    public int countLargestGroup(int n) {
        int[] arr = new int[36]; // array to store group sizes based on digit sum (covers up to 999999)
        int max = 0;             // holds the size of the biggest group
        int res = 0;             // number of groups that have size == max

        for (int i = 1; i <= n; i++) {
            int num = i;
            int sum = 0;

            // get sum of digits
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            arr[sum]++; // add number to its group (by digit sum)
            if (arr[sum] > max) {
                max = arr[sum]; // update max group size
            }
        }

        // count how many groups match the max size
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max)
                res++;
        }

        return res;
    }
}
 */