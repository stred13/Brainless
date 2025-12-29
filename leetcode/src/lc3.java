public  class lc3 {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[1000];
        boolean duplicated = false;
        int right = -1;
        int maxLength = 0;

//sliding windows - two pointers
        for(int left = 0 ; left < s.length(); left++ ){
            while(right +1 < s.length()){
                count[s.charAt(right + 1)]++;
                if(count[s.charAt(right + 1)] == 2){
                    //duplicated = true;
                    count[s.charAt(right + 1)] --;
                    break;
                }
                right++;
            }
            if(maxLength < right - left + 1)
                maxLength = right - left + 1;//3
            count[s.charAt(left)]--;
            //duplicated = false;
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring2String1(String s) {
        boolean[] arr = new boolean[128];
        int maxLen = 0, r = 0, l = 0;

        while (r < s.length()) {
            if (!arr[s.charAt(r)]) {
                arr[s.charAt(r)] = true;
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            } else {
                arr[s.charAt(l)] = false;
                l++;
            }
        }
        return maxLen;
    }
}
