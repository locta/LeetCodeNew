
// Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

// You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

// Example 1:

// Input: "19:34"
// Output: "19:39"
// Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
// Example 2:

// Input: "23:59"
// Output: "22:22"
// Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.


class Solution {
    public String nextClosestTime(String time) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < time.length(); i++) {
            numList.add((int) (time.charAt(i) - '0'));
        }
        
        List<List<Integer>> all = generateALL(numList);

        for (List<Integer> list : all) {
        	if (isGreaterThan(list, numList)) {
        		return buildTime(list);
        	}
        }

        return buildTime(all.get(0));
    }

    private List<List<Integer>> generateAll(List<Integer> numList) {
    	List<List<Integer>> res = new ArrayList<>();
    	Collections.sort(numList);
    	traverse(res, numList, new ArrayList<>(), 0);
    	return res;
    }

    private traverse(List<List<Integer>> res, List<Integer> source, List<Integer> path, int pos) {
    	if (path.size() == 4) {
    		if (isValidTime(path)) {
    			res.add(new ArrayList(path));
    		}
    		return;
    	}

    	for (int i = pos; i < source.size(); i++) {
    		path.add(source.get(pos));
    		traverse(res, source, path, pos);
    		path.remove(path.size() - 1);
    	}
    }

    private boolean isGreaterThan(List<Integer> path, List<Integer> source) {
    	for (int i = 0; i < path.size(); i++) {
    		if (path.get(i) > source.get(i)) {
    			return true;
    		}
    	}
    	return false;
    }
}