package common.util;

import java.util.Stack;

/**
 * @Author: zhangjianwu
 * @Date: 2022/1/15 17:25
 * @Desc:
 **/
public class StackUtil {
    public static Stack getStackForInteger() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 10; i > 0; i--) {
            stack.push(i);
        }
        return stack;
    }
}
