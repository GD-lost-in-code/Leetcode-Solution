package romanToInt;

import java.util.HashMap;

public class Solution {

    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char curr = s.charAt(i);
            int value = map.get(curr);

            if (value < prevValue) {
                total -= value;
            } else {
                total += value;
            }

            prevValue = value;
        }

        return total;
    }

    public static void main(String[] args) {
        //example:
        int test = romanToInt("MCMXCIV");  // Expected: 1994
        System.out.println("Result: " + test);
    }
}
