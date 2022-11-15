
/// Прохождение по дереву (есть не более 2 потомков)
import java.util.*;
public class Task5_2 {
    static void print_arr(Map<String, Integer> map_in, String root, String space) /// проходим по дереву
    {   int j = 0;
        String s_tmp = "0";
         if (map_in.containsKey(root) == true){
            System.out.println(space + map_in.get(root));
            while (map_in.containsKey(String.join("_", root, s_tmp)) == true){
                print_arr(map_in, String.join("_", root, s_tmp), space + " "); //находим потомков
                j = j + 1;
                s_tmp = Integer.toString(j);
            }
        } 
        else return;
   }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(); //задаем дерево, может быть больше 2ух потомков
        map.put("0", 5); //корень
        map.put("0_0", 2); //потомки 1 корня
        map.put("0_1", 3); //потомки 2 корня
        map.put("0_0_0", 4); // потомки потомков1
        map.put("0_0_1", 1); // потомки потомков1
        map.put("0_1_0", 6); // потомки потомков2
        map.put("0_1_1", 3); // потомки потомков2
        map.put("0_1_2", 7); // потомки потомков2
        print_arr(map, "0", " ");
    }

}
