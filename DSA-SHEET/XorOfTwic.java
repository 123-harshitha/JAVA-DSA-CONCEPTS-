import java.util.Map;
import java.util.HashMap;

class XorOfTwice{
    public int duplicateNumbersXOR(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num ,0)+1);
        }

        int xor=0;
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            if(entry.getValue() ==2){
                xor ^=entry.getKey();
            }
        }
        return xor;

        
    }
}