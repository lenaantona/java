
/// Реализовать алгоритм сортировки вставкой
import java.util.Arrays;

public class Task3 {
    static void sort_insert(int arr[]) { ///метод сортировки
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                int arr_tmp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = arr_tmp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr_sort = new int[] { 5, 2, 3, 4, 1, 6, 1};
        sort_insert(arr_sort);
        System.out.println(Arrays.toString(arr_sort));
    }

}
