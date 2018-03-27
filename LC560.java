// Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

// Example 1:
// Input:nums = [1,1,1], k = 2
// Output: 2
// Note:
// The length of the array is in range [1, 20,000].
// The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].


class Solution {
    public int subarraySum(int[] nums, int k) {
        // hashTable
        int[] sums = new int[nums.length + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
        	sums[i + 1] = sums[i] + nums[i];
            List<Integer> list = map.getOrDefault(sums[i + 1], new ArrayList<>());
        	list.add(i);
            map.put(sums[i + 1], list);
        }

        int res = 0;
        for (int i = 0; i < sums.length; i++) {
        	// assume right - left = k
        	int right = k + sums[i];
        	if (map.containsKey(right)) {
        		for (int pos : map.get(right)) {
        			if (pos >= i) {
        				res++;
        			}
        		}
        	}
        }

        return res;

    }
}