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
        System.out.println("快速排序：" + Arrays.toString(quickSort(ARRAY)));
        System.out.println("归并排序：" + Arrays.toString(mergeSort(ARRAY)));
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
     * 快速排序
     * 选第一个为基准，然后左右两个指针往中间移动，小于基准的往左换，大于基准的往右换
     * 指针重叠时，就是基准应该去的位置，这样就按基准值分为两个部分
     * [5] [6] [4] [2] [6] [8] [9] [2] [1] [4]
     * ^   ^                               ^
     * 基准 low                             high
     *
     * @param array
     * @return
     */
    private static int[] quickSort(int[] array) {
        // 复制一份，不操作原有数组
        int[] arr = Arrays.copyOf(array, array.length);
        qSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void qSort(int[] array, int low, int high) {
        if (low < high) {
            int baseIndex = qSortIndex(array, low, high);
            // 递归，排序基准值左右两侧
            qSort(array, low, baseIndex - 1);
            qSort(array, baseIndex + 1, high);
        }
    }

    private static int qSortIndex(int[] array, int low, int high) {
        // 取第一个为基准
        int base = array[low];
        // 指针不相遇就不停
        while (low < high) {
            // 先找最右侧的
            while (low < high && array[high] >= base) {
                // 如果右侧的比基准大，那么高位指针左移
                high--;
            }
            // 经过上面的循环，可以确定右侧的比左侧的小，把值给小的
            array[low] = array[high];
            while (low < high && array[low] <= base) {
                // 左侧的小于基准值，低位指针右移
                low++;
            }
            // 经过上面的循环，可以确定左侧侧的比右侧的大，把值给大的
            array[high] = array[low];
        }
        // 经过上面的循环，应该指针会相遇，就是基准值应该所在的位置
        array[low] = base;
        return low;
    }

    /**
     * 归并排序
     * 思想是：
     * - 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
     * - 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
     * - 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
     * - 重复步骤 3 直到某一指针到达序列尾；
     * - 将另一序列剩下的所有元素直接复制到合并序列尾。
     *
     * @param array
     * @return
     */
    private static int[] mergeSort(int[] array) {
        // 复制一份，不操作原有数组
        int[] arr = Arrays.copyOf(array, array.length);

        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            // 求中间位置
            // 此处用 (low+high)/2 也行，但可能溢出
            int mid = low + ((high - low) >> 1);
            //递归地对左右两边进行排序
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            // 合并
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        //temp数组用于暂存合并的结果
        int[] temp = new int[high - low + 1];
        //左半边的指针
        int left = low;
        //右半边的指针
        int right = mid + 1;
        //合并后数组的指针
        int mergeIndex = 0;

        //将记录由小到大地放进temp数组
        for (; left <= mid && right <= high; mergeIndex++) {
            // 谁小就先放谁
            if (arr[left] < arr[right]) {
                temp[mergeIndex] = arr[left++];
            } else {
                temp[mergeIndex] = arr[right++];
            }
        }
        // 上面循环以后，由于左右数据可能不平衡，会导致有一侧有剩余
        // 接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while (left <= mid) {
            temp[mergeIndex++] = arr[left++];
        }

        while (right <= high) {
            temp[mergeIndex++] = arr[right++];
        }

        //将temp数组中的元素覆盖到待排数组中
        for (int l = 0; l < temp.length; l++) {
            arr[low + l] = temp[l];
        }
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
