
/// Реализовать алгоритм пирамидальной сортировки (HeapSort)
import java.util.Arrays;

public class Task2 {
    static void sort_wood(int arr[], int n, int i) /// сортирует в одной ветке дерева (в корне больший элемент)
    {
        int root = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[root])
            root = left;

        if (right < n && arr[right] > arr[root])
            root = right;

        if (root != i) {
            int a = arr[i];
            arr[i] = arr[root];
            arr[root] = a;
            sort_wood(arr, n, root);
        }
    }

    static void heapsort(int arr[]) /// сортирует массив по всему дереву
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) { /// цикл проходит по всем веткам дерева
            sort_wood(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int a = arr[0];
            arr[0] = arr[i];
            arr[i] = a;
            sort_wood(arr, i, 0);/// сортировка корневого элемента (большое значение в корневой элемент)
        }
    }

    public static void main(String[] args) {
        int[] arr_sort = new int[] { 5, 2, 3, 4, 1, 6 };
        heapsort(arr_sort);
        System.out.println(Arrays.toString(arr_sort));
    }

}
