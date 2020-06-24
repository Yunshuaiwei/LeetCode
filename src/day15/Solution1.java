package day15;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/23 14:54
 * @Version
 **/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        List<Integer> list = s.partitionLabels("ababcbacadefegdehijhklij");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            //循环结束可得到每个字符在s中最后一次出现的位置下标
            last[S.charAt(i) - 'a'] = i;
        }
        //记录每个区间的其实下标
        int start = 0;
        //记录每个区间的结束下标
        int j = 0;
        //用于保存结果
        List<Integer> res = new ArrayList();
        for (int i = 0; i < S.length(); i++) {
            //取当前字符在s中出现的最后位置下标，和当前区间结束下标的最大值
            j = Math.max(j, last[S.charAt(i) - 'a']);
            //i==j时说明已经匹配到了最长区间
            if (i == j) {
                //将该区间的长度加入list中
                res.add(i - start + 1);
                //记录下一个区间的起始下标
                start = i + 1;
            }
        }
        return res;
    }
}
