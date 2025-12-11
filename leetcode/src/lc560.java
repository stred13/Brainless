import java.util.HashMap;
import java.util.Map;

public class lc560 {
    public int subarraySum2(int[] nums, int k) {
        //op 2
        int[] sums = new int [nums.length] ;
        int count = 0;
        int total = 0;
        for(int i=0; i< nums.length;i++){
            total+=nums[i];
            sums[i] =total;
        }
        for(int i=0; i< nums.length;i++){
            if(sums[i]==k){
                count++;
            }
        }
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(sums[j]-sums[i]==k){
                    count++;
                }
            }
        }
        return count;
    }
    public int subarraySum3(int[] nums, int k) {
                 int total = 0;
         int[] sums = new int [nums.length] ;
         for(int i=0; i< nums.length;i++){
             total+=nums[i];
             sums[i] = total;
         }

         Map<Integer, Integer> map = new HashMap<>();
         int count =0;
         for(int i=0; i< nums.length;i++){
             int sub=sums[i]-k;
             if(sums[i]==k){
                 count++;
             }
             if(map.get(sub) != null){
                 count+=map.get(sub);
             }
             map.put(sums[i],map.getOrDefault(sums[i],0)+1);
         }
        return count;
    }
}
