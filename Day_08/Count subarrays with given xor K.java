// Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

// Note: It is guranteed that the total count will fit within a 32-bit integer.

// Examples: 

// Input: arr[] = [4, 2, 2, 6, 4], k = 6
// Output: 4
// Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        long currXr = 0;
        
        long count = 0;
        for(int i = 0; i < arr.length; i++){
            currXr ^= arr[i];
            long rem = currXr ^ k;
            count+= map.getOrDefault(rem, 0L);
            map.put(currXr, map.getOrDefault(currXr, 0L) + 1L);
        }
        return count;
    }
}