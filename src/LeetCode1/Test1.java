package LeetCode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {

}
class Solution12 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        int l, r, sum;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) { //枚举第一个元素
            if (i > 0 && nums[i] == nums[i - 1]) continue; //去重，保证第一个元素只使用一轮
            l = i + 1;
            r = nums.length - 1; //确定左右指针的范围，指向i之后的区间
            while (l < r) {
                //去重，保证第二个元素只使用一轮
                while (l > i + 1 && l < nums.length && nums[l] == nums[l - 1]) l++;
                if (l >= r) break; //保证左指针小于右指针
                sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) { //找到指定三元组
                    List<Integer> ans1 = new ArrayList<Integer>();
                    ans1.add(nums[i]);
                    ans1.add(nums[l]);
                    ans1.add(nums[r]);
                    ans.add(ans1);
                    l++; //左指针右移，第一个元素固定，继续找满足条件的元素2和元素3的数对
                } else if (sum > 0) { //三元组偏大，右指针左移
                    r--;
                } else { //三元组偏小，左指针右移
                    l++;
                }
            }
        }
        return ans;



    }
}