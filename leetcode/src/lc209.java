public class lc209 {
    public int minSubArrayLen(int target, int[] nums) {
        int[] sums = new int[nums.length];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            sums[i] = total;
        }


        int pos = -1;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > target) {
                int k = sums[i] - target;
                int left = 0;
                int right = i - 1;
                if (minLength > i + 1) {
                    minLength = i + 1;
                }
                System.out.println("k = " + k);
                while (left <= right) {
                    int mid = (left + right) / 2;
                    System.out.println("valueS " + sums[mid]);
                    System.out.println("mid = " + mid);
                    System.out.println("left = " + left + " right " + right);
                    if (sums[mid] <= k) {
                        left = mid + 1;
                        pos = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                if (minLength > i - pos && pos != -1) {
                    minLength = i - pos;
                    if (minLength == 1) {
                        return minLength;
                    }
                }
                if (minLength == Integer.MAX_VALUE && sums[sums.length - 1] == target)
                    return sums.length;
            }

        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
