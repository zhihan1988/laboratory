package sort;

/**
 * Created by liuzhihan on 2018/3/8.
 * 参考文档
 * http://blog.csdn.net/vayne_xiao/article/details/53508973
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, 6, 2, 4, 5, 2, 8, 9};
        QuickSort.quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void quickSort(int[] a) {
        if (a == null || a.length == 0) return;
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int i = left, j = right;
            int key = a[left];
            while (i < j) {
                while (i < j && a[j] >= key) {
                    j--;
                }
                if (i < j) {
                    swap(a, i, j);
                    i++;
                }
                while (i < j && a[i] <= key) {
                    i++;
                }
                if (i < j) {
                    swap(a, i, j);
                    j--;
                }
            }
            a[i] = key;
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);
        }
    }

    private static void swap(int a[], int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}
