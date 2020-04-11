package com.ccy.leetcode.D0407;

import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素3
 * leetcode: 220
 * 难度: 中等
 */
public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length == 0 || k <= 0 || t<0)
            return false;
        int l = t+1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int id = getId(nums[i],l);
            if(map.containsKey(id))
                return true;
            if(map.containsKey(id-1) && Math.abs(map.get(id-1)-nums[i]) < l)
                return true;
            if(map.containsKey(id+1) && Math.abs(map.get(id+1)-nums[i]) < l)
                return true;
            if(i>=k){
                map.remove(getId(nums[i-k],l));
            }
            map.put(id,nums[i]);
        }
        return false;
    }


    private int getId(int num,int l){
        return num >= 0 ? num / l : (num+1) / l -1;
    }
}
