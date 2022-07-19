package com.offer;

import java.util.HashMap;
import java.util.Map;

public class offer48 {
        

    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> dic= new HashMap<>();
        int res = 0,tmp = 0;
        for(int j = 0;j<s.length();j++){
            int i = dic.getOrDefault(s.charAt(j),-1);
            dic.put(s.charAt(j),j);
            tmp = tmp < j -i?tmp+1:j-i;// dp[j - 1] -> dp[j]
            res = Math.max(res, tmp);
        }
        return res;

    }
}
