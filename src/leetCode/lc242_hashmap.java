package leetCode;

import java.util.HashMap;

public class lc242_hashmap {

    public boolean lc242a( String s, String t){
        if (s.length() != t.length()){
            return  false;
        }
        int[] count = new int[26];
        for (int i = 0 ; i < s.length(); i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for (int num : count){
            if (num != 0 ) {
                return  false;
            }
        }
        return  true;
    }

    public boolean lc242b( String s, String t){
        if (s.length() != t.length()){
            return  false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for ( char c : s.toCharArray()){
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);//如果有记录，则常规+1
            }else {//如果没有记录，则直接初始化
                map.put(c,1);
            }
        }
        for (char c: t.toCharArray()){
            if (map.containsKey(c)) {
                int count = map.get(c);
                if (count ==1 ){
                    map.remove(c);
                }else{
                    map.put(c,count -1);
                }
            }
        }
        return map.isEmpty();
    }
}
