package net.renfei.base;

import java.util.Arrays;

/**
 * 经典排序算法
 *
 * @author renfei
 */
public class Sort {
    private static final int[] ARRAY = new int[]{
            3, 5, 23, 7, 5, 86, -2, 4, 7, 8, 24, 45, 11
    };

    public static void main(String[] args) {
        System.out.println("排序之前：" + Arrays.toString(ARRAY));
        System.out.println("冒泡排序：" + Arrays.toString(bubbleSort(ARRAY)));
        System.out.println("选择排序：" + Arrays.toString(selectSort(ARRAY)));
        System.out.println("插入排序：" + Arrays.toString(insertSort(ARRAY)));
    }

    /**
     * 冒泡排序实现
     * 每折腾一趟，最大的被换到最右侧
     * 这样就像气泡一样，最大的先浮上水面
     *
     * @param array
     * @return
     */
    private static int[] bubbleSort(int[] array) {
        // 复制一份，不操作原有数组
        int[] arr = Arrays.copyOf(array, array.length);

        for (int i = 0; i < arr.length; i++) {
            // 这里为啥 arr.length - 1 ？
            // 因为 j 要跟后一位 j+1 做比较，不减一，数组越界，这里必须减一
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 与后一个相比，大的往右换
                    // 折腾一趟，最大的泡泡冒到最右侧
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序实现
     * 跑一趟选出最大或最小的，所以叫选择排序
     * 选出最小的或最大的，往左或右放置即可
     *
     * @param array
     * @return
     */
    private static int[] selectSort(int[] array) {
        // 复制一份，不操作原有数组
        int[] arr = Arrays.copyOf(array, array.length);

        for (int i = 0; i < arr.length; i++) {
            // 先假设最小的索引位置是 i
            int minIndex = i;
            // 开启循环开始找
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    // 如果找到了比 minIndex 还小的
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                // 找到比当前 i 位置了更小的，那就交换
                swap(arr, i, minIndex);
            }
        }
        return arr;
    }

    /**
     * 插入排序实现
     * 类似玩扑克牌时你拿起一张
     * 逐个比较寻找合适的位置插入
     *
     * @param array
     * @return
     */
    private static int[] insertSort(int[] array) {
        // 复制一份，不操作原有数组
        int[] arr = Arrays.copyOf(array, array.length);

        // 第一张牌无需比较，第二张开始，所以 i = 1
        for (int i = 1; i < arr.length; i++) {
            // i 是已经排序好的牌
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--) {
                // j 是拿起来的牌，往左开始找能插入的地方
                swap(arr, j, j + 1);
            }
        }
        return arr;
    }

    /**
     * 交换，利用异或交换
     *
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j) {
        if (array[i] != array[j]) {
            array[i] ^= array[j];
            array[j] ^= array[i];
            array[i] ^= array[j];
        }
    }
}