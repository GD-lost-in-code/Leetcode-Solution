import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] solution = new int[2];
        for (int i=0; i<nums.length; i++){
            int compliment = target - nums[i];
            if(hashMap.containsKey(compliment)){
                solution[0] = i;
                solution[1] = hashMap.get(compliment);
                break;
            }else{
                hashMap.put(nums[i], i);
            }
        }
        return solution;
    }
}