package offer.day18;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/10 16:34
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] abcs = s.permutation("abc");
        for (String abc : abcs) {
            System.out.println(abc);
        }
    }

    public String[] permutation(String s) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i != j) {
                    StringBuilder builder = new StringBuilder(sb);
                    builder.setCharAt(i, s.charAt(j));
                    builder.setCharAt(j, s.charAt(i));
                    set.add(builder.toString());
                }
            }
        }
        String[] res = new String[set.size()];
        Iterator<String> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }
}
