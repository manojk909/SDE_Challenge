// Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

// Examples:

// Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
// Output: 6
// Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.

// Input: arr[] = [1, 2, 3, 4, 5], k = 9
// Output: 3
// Explanation: Subarrays with sum = 9 are [2, 3, 4] and [4, 5]. The length of the longest subarray with a sum of 9 is 3.


// Approach 1: HashMap
// Time Complexity: O(n)
// Space Complexity: O(n)
// The idea is to use a HashMap to store the cumulative sum of the elements at each index. We iterate through the array and keep adding the current element to the cumulative sum. If the cumulative sum equals k, we update the maximum length of the subarray. If the cumulative sum minus k exists in the HashMap, it means there is a subarray with sum equal to k, and we update the maximum length accordingly. We also store the index of the first occurrence of each cumulative sum in the HashMap to ensure we get the longest subarray.

class Solution {
    public int longestSubarray8(int[] arr, int k) {
        // code here
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int currSum = 0;
        
        while (j < arr.length){
            currSum += arr[j];
            if (currSum == k){
                maxLen = j + 1;
            }
            if (map.containsKey(currSum-k)){
                maxLen = Math.max(maxLen, j-map.get(currSum-k));
            }
            if (!map.containsKey(currSum)){
                map.put(currSum, j);
            }
            j++;
            
        }
        return maxLen;
    }
    

    // Approach 2: Sliding Window (works only for non-negative integers)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Note: This approach assumes that the array contains only non-negative integers. If the array contains negative integers, this approach may not work correctly.
    // The idea is to use two pointers (l and h) to maintain a sliding window. We keep adding elements to the current sum until it exceeds k. If it exceeds k, we move the left pointer (l) to the right until the current sum is less than or equal to k. If the current sum equals k, we update the maximum length of the subarray.
    public int longestSubarray(int[] arr, int k){
        int l = 0, h = 0;
        
        int currSum = 0;
        int maxLen = 0;
        
        while (h < arr.length){
            currSum += arr[h];
            
            while (l < h && currSum > k){
                currSum -= arr[l];
                l++;
            }
            if (currSum == k){
                maxLen = Math.max(maxLen, h-l+1);
            }
            h++;
        }
        return maxLen;
    }
}


