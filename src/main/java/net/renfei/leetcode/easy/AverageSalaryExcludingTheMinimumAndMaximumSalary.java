package net.renfei.leetcode.easy;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 1491. 去掉最低工资和最高工资后的工资平均值
 * | https://leetcode-cn.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public static void main(String[] args) {
        System.out.println(average(new int[]{4000, 3000, 1000, 2000}));
    }

    public static double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = 0, sum = 0;
        for (int i : salary
        ) {
            min = Math.min(min, i);
            max = Math.max(max, i);
            sum += i;
        }
        sum = sum - min - max;
        return Double.parseDouble(sum + "") / (salary.length - 2);
    }
}
