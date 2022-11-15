
/// Прохождение по дереву (есть не более 2 потомков)
import java.util.*;
public class Task5_1 {
    static void print_arr(Map<Integer, Integer> map_in, int n, int i, String space) /// проходим по дереву
    {   if (i <= n){
            int root = i;   //узел
            System.out.println(space + map_in.get(root));
            if (2 * i + 1 < n ) {
                int left = 2 * i + 1; //первый потомок (левый)
                print_arr(map_in, n, left, space + " ");
            }
            if (2 * i + 2 < n) {
                int right = 2 * i + 2; //второй  (правый)
                print_arr(map_in, n, right, space + " "); 
            }
        } 
        else return;
   }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(); //задаем дерево, у которого если нет потомка, то null обязательно
        map.put(0, 5); // корень
        map.put(1, 2); //левый потомок
        map.put(2, 3); //правый потомок
        map.put(3, null); //потомки левого потомка
        map.put(4, 1); //потомки левого потомка
        map.put(5, 6);//потомки правого потомка
        map.put(6, null);//потомки правого потомка
        print_arr(map, map.size(), 0, "");
    }

}
