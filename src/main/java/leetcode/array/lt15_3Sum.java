package leetcode.array;

import common.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zhangjianwu
 * @Date: 2022/1/22 23:15
 * @Desc:
 * 给你一个包含 n 个整数的数组 nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
* 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class lt15_3Sum {
    public static void main(String[] args) {
        int[] ints = {0,0,0};
        ArrayUtil.print(ints);
        List<List<Integer>> lists = threeSum(ints);
        System.out.println(lists);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        boolean flag=true;
        //特例排除
        if(nums.length<3){
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        if(nums[0]>0){
            return Collections.emptyList();
        }
        int l,r;
        List<List<Integer>> result= new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                break;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            l=i+1;
            r=nums.length-1;
            int tmp;
            while (l<r){
                tmp=nums[i]+nums[l]+nums[r];
                if(tmp==0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    while (l<r&&nums[l]==nums[l+1]) l++;
                    while (l<r&&nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                }else if(tmp<0){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return result;
    }
}






























