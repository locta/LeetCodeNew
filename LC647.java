// Given a string, your task is to count how many palindromic substrings in this string.

// The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

// Example 1:
// Input: "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".
// Example 2:
// Input: "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// Note:
// The input string length won't exceed 1000.


class Solution {
	int[][] grid;

    public int countSubstrings(String s) {
        if (s.length() == 0) {
        	return 0;
        }

        int len = s.length();
        grid = new int[len][len];

        int res = 0;
        for (int i = 0; i < len; i++) {
        	for (int j = i; j < len; j++) {
        		if (isPalin(s, i, j)) {
        			res++;
        		}
        	}
        }

        return res;
    }

    private boolean isPalin(String s, int i, int j) {
    	if (i >= j) {
    		return true;
    	} else if (grid[i][j] == 1) {
    		return true;
    	} else if (grid[i][j] == -1){
    		return false;
    	}

    	if (s.charAt(i) != s.charAt(j)) {
    		grid[i][j] = -1;
       	} else {
    		grid[i][j] = isPalin(s, i + 1, j - 1) ? 1 : -1;
    	}

    	return grid[i][j]  == 1 ? true : false;
    }
}