package offer.day22;

import java.util.HashMap;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/13 8:15
 * @Version
 **/
public class Solution {

    public char firstUniqChar(String s) {
        char res = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                res = s.charAt(i);
                break;
            }
        }
        return res;
    }
}
