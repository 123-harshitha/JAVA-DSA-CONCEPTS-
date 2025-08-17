import java.util.HashMap;
import java.util.Map;

public class Singlenumber {
    public static int singleXor(int[] nums){
        int result = 0;
        for(int num : nums){
            result ^= num;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println(singleXor(nums));
    }

    // singlenumber --III
    public int[] singleNumber(int[] nums) {
        Map < Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num , 0)+1);

        }

        int[] result = new int[2];
        int idx =0;
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                result[idx++] = entry.getKey();
                if(idx == 2) break;
            }
        }
        return result;
        
    }

    
}
    

