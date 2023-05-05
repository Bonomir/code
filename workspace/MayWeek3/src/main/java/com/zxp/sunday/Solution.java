package com.zxp.sunday;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 记忆化数组
    Map<Integer, Boolean> memory = new HashMap<>();

    public boolean callWin(int maxChoosableInteger, int desiredTotal) {
        // 当所有数组都选完的时候仍然无法到达 desiredTotal 时，两人都无法获胜，返回false
        if ((1 + maxChoosableInteger) * (maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        // 当所有数字的和大于等于desiredTotal的时候,需要搜索来判断获胜方
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    /**
     * @param maxChoosableInteger : 最大可以选择的数字
     * @param usedNumbers         : 已经被使用的数字集合 从低位到高位，第 i 位为 1 表示数字i已经被使用，为 0 则表示还没有使用
     * @param desiredTotal        ： 累计和
     * @param currentTotal        ： 当前累计和
     * @return 是否能赢
     */
    private boolean dfs(int maxChoosableInteger, int usedNumbers, int desiredTotal, int currentTotal) {
        if (!memory.containsKey(usedNumbers)) {
            boolean res = false;
            // 遍历 [0,maxChoosableInteger] 范围，查看选择其中一个没有被选择过的是否能够赢
            for (int i = 0; i < maxChoosableInteger; i++) {
                if (((usedNumbers >> i) & 1) == 0) { // 没有被选择的话，我们选择这个
                    // 如果当前玩家能获胜，返回true
                    if (i + 1 + currentTotal >= desiredTotal) { //这里 i+1 是因为从0 开始的。 选中累加的值范围是 [0,maxChoosableInteger]
                        res = true;
                        break;
                    }
                    // 如果当前玩家的下一个玩家不能获胜，返回true
                    if (!dfs(maxChoosableInteger, usedNumbers | (1 << i), desiredTotal, currentTotal + i + 1)) {
                        res = true;
                        break;
                    }
                }
            }
            memory.put(usedNumbers, res);
        }
        return memory.get(usedNumbers);
    }
}
