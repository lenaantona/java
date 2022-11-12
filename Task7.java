import java.util.Arrays;

public class Task7 {
    public static void swap (int[] array_input, int i, int j)//меняет местами элементы массива
    {
        int temp = array_input[i];
        array_input[i] = array_input[j];
        array_input[j] = temp;
    }

    public static int sort_part(int[] arr, int first, int last) //сортировка массива относительно опорного элемента(слева опорного меньше, справа больше )
    {
        int pivot = arr[last]; //опорный элемент в массиве
        int tmp_index = first; //индекс первого элемент массива
 
        for (int i = first; i < last; i++) //проходимся по массиву 
        {
            if (arr[i] <= pivot)
            {
                swap(arr, i, tmp_index);
                tmp_index++;
            }
        }
        swap(arr, last, tmp_index); //меняем местами для разделения массива на меньшие элементы опопрного и большие опорного
        return tmp_index; // возращем для определения опорного элемента
    }
 
    public static void quicksort(int[] arr, int first, int last)// выполенение сортировки 
    {
        if (first >= last) { ///для выхода из рекурсии
            return;
        }
        int pivot = sort_part(arr, first, last); //находим новый опорный элемент
        quicksort(arr, first, pivot - 1); //на подмассиве меньше опрного элемента
        quicksort(arr, pivot + 1, last); // на подмассиве больше опорного
    }

    public static void main(String[] args){
        int[] a = { 2, 5, 10, 6, 8, 5, 1, 7 };
        quicksort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
