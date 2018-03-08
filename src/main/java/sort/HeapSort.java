package sort;

/**
 * Created by liuzhihan on 2018/2/27.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = new int[]{15, 13, 14, 3, 5, 4, 2, 1, 7, 9, 8};

        HeapSort heap = new HeapSort();
        heap.build(array, array.length - 1);
        heap.print(array);
        System.out.println("end");

    }

    private void print(int[] heapArray) {
        if (heapArray == null || heapArray.length == 0) {
            return;
        }
        for(int i=0;i<heapArray.length;i++) {
            System.out.println(heapArray[i]);
        }
    }

    /**
     *
     * @param array
     * @param n 数组最后一个元素的索引
     * @return
     */
    public void build(int[] array, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            siftDown2(array,i,n);
        }
    }

    private void siftDown(int[] array, int i, int n) {
        int value = array[i];
        int compareIndex = i * 2 + 1;
        if (compareIndex < n) {
            if (compareIndex + 1 <= n && array[compareIndex] > array[compareIndex + 1]) {
                compareIndex++;
            }
            if (array[i] > array[compareIndex]) {
                array[i] = array[compareIndex];
                array[compareIndex] = value;
            }
            siftDown(array, compareIndex, n);
        }
    }

    private void siftDown2 (int[] data, int i, int n) {
        int num = data[i];
        int son = i * 2 + 1;
        while (son <= n) {
            if (son + 1 <= n && data[son+1] < data[son]) {
                son++;
            }
            if (num < data[son]) {
                break;
            }
            data[i] = data[son];
            i = son;
            son = son * 2 + 1;
        }
        data[i] = num;
    }
/*    private void up(int i, int[] heapArray) {

        int curValue = heapArray[i];
        int pIndex = (i-1)/2;
        int pValue = heapArray[pIndex];
        if (pValue > curValue) {
            //交换
            heapArray[i] = heapArray[pIndex];
            heapArray[pIndex] = curValue;
            //递归
            up(pIndex, heapArray);
        }
    }*/


}
