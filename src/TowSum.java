import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TowSum {


    public static int[] towSum(int[]nums,int target){

        HashMap<Integer,Integer> hashMap = new HashMap();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(target-nums[i])!=null){
                result[0] = i;
                result[1] = hashMap.get(target-nums[i]);
                return  result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] parameters ={1,6,8,14,5,2,100,56};
        int[] result = towSum(parameters,114);
        System.out.printf(Arrays.toString(result));
    }
}
