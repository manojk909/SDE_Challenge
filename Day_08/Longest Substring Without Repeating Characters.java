
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int maxLen = 0;
        // HashMap<Character, Integer> map = new HashMap<>();
        int[] seen = new int[128];
        Arrays.fill(seen, -1);

        for (int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            if (seen[ch] != -1){
                if (seen[ch] >= l){
                    l = seen[ch] + 1;
                }
            }
            seen[ch] = r;
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
// }





// by hashmap
// class Solution {
    public int lengthOfLongest_Substring(String s) {
        int l = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            if (map.containsKey(ch) && (map.get(ch) >= l)){
                    l = map.get(ch) + 1;
            }
            map.put(ch, r);
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}