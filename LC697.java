// Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

// Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

// Example 1:
// Input: [1, 2, 2, 3, 1]
// Output: 2
// Explanation: 
// The input array has a degree of 2 because both elements 1 and 2 appear twice.
// Of the subarrays that have the same degree:
// [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
// The shortest length is 2. So return 2.
// Example 2:
// Input: [1,2,2,3,1,4,2]
// Output: 6
// Note:

// nums.length will be between 1 and 50,000.
// nums[i] will be an integer between 0 and 49,999.


class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] times = new int[50001];
        for (int num : nums) {
            times[num]++;
        }
        
        int count = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i] > count) {
                count = times[i];
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // from left to right
        for (int i = 0; i < nums.length; i++) {
            if (times[nums[i]] == count && !map.containsKey(nums[i])) {
                List<Integer> list = new ArrayList<>();
                map.put(nums[i], list);
                list.add(i);
            }
        }
        // from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            if (times[nums[i]] == count && map.containsKey(nums[i]) && map.get(nums[i]).size() == 1) {
                map.get(nums[i]).add(i);
            }
        }
        
        int res = nums.length;
        for (List<Integer> list : map.values()) {
            int val = list.get(1) - list.get(0) + 1;
            if (val < res) {
                res = val;
            }
        }
        return res;
    }
}