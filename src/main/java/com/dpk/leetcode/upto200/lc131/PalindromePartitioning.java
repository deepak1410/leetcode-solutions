package com.dpk.leetcode.upto200.lc131;

import java.util.ArrayList;
import java.util.List;
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(result, temp, s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> temp, String s, int index) {
        if(index == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index+1; i<s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                temp.add(s.substring(index, i));
                backtrack(result, temp, s, i);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s,int start,int end){
        String str = s.substring(start, end);
        String rev = new StringBuilder(str).reverse().toString();
        return str.matches(rev);
    }
}
