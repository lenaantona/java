import java.util.*;

public class Task6 {
    static void step_lab(Integer[][] arr, int i, int j, List<Integer> pos_i, List<Integer> pos_j) { /// метод заполнения
                                                                                                    /// близлежащих
                                                                                                    /// ячеек, добавляет
                                                                                                    /// в массив из
                                                                                                    /// координаты
                                                                                                    /// след.ячейки
        if (i > 0 && arr[i - 1][j] == 0) { // вверх
            arr[i - 1][j] = arr[i][j] + 1;
            pos_i.add(i - 1);
            pos_j.add(j);
        }
        if (j < arr.length - 1 && arr[i][j + 1] == 0) { // вправо
            arr[i][j + 1] = arr[i][j] + 1;
            pos_i.add(i);
            pos_j.add(j + 1);
        }

        if (i < arr.length - 1 && arr[i + 1][j] == 0) { // вниз
            arr[i + 1][j] = arr[i][j] + 1;
            pos_i.add(i + 1);
            pos_j.add(j);
        }

        if (j > 0 && arr[i][j - 1] == 0) { // влево
            arr[i][j - 1] = arr[i][j] + 1;
            pos_i.add(i);
            pos_j.add(j - 1);
        }
        pos_i.remove(0); // удаление координат ячейки, в позиции
        pos_j.remove(0); // удаление координат ячейки, в позиции
    }

    static void step_rout(Integer[][] arr, int in_i, int in_j, List<Integer> pos_i, List<Integer> pos_j) { /// метод
                                                                                                           /// нахождения
                                                                                                           /// минимального
                                                                                                           /// вокруг
                                                                                                           /// ячейки и
                                                                                                           /// заполненние
                                                                                                           /// ее
                                                                                                           /// координат
                                                                                                           /// массив
        int i = pos_i.get(in_i);
        int j = pos_j.get(in_j);
        int min = arr[i][j];
        int i_min = 0;
        int j_min = 0;
        if (j > 0 && arr[i][j - 1] < min && arr[i][j - 1] != -1) { // влево
            min = arr[i][j - 1];
            i_min = i;
            j_min = j - 1;
        }
        if (i < arr.length - 1 && arr[i + 1][j] < min && arr[i + 1][j] != -1) { // вниз
            min = arr[i + 1][j];
            i_min = i + 1;
            j_min = j;
        }

        if (j < arr.length - 1 && arr[i][j + 1] < min && arr[i][j + 1] != -1) { // вправо
            min = arr[i][j + 1];
            i_min = i;
            j_min = j + 1;
        }

        if (i > 0 && arr[i - 1][j] < min && arr[i - 1][j] != -1) { // вверх
            min = arr[i - 1][j];
            i_min = i - 1;
            j_min = j;
        }
        pos_i.add(i_min);
        pos_j.add(j_min);
    }

    public static void main(String[] args) {
        Integer[][] map = {
                { 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, -1, 0, 0 },
                { 0, -1, 0, -1, 0, -1, 0, 0 },
                { 0, -1, -1, -1, -1, -1, 0, 0 },
                { 1, -1, 0, -1, 0, -1, 0, 0 },
                { 0, -1, 0, -1, 0, -1, -1, 0 },
                { 0, -1, 0, 0, 0, -1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0 },
        };
        Integer[] in_i = { 4 }; // строка входящей ячейки
        Integer[] in_j = { 0 }; // столбец входящей ячейки
        int ex1_lab1 = 1;// координаты ячейки выхода 1 (строка)
        int ex1_lab2 = 7; // координаты ячейки выхода 1 (столбец)
        int ex2_lab1 = 6; // координаты ячейки выхода 2 (строка)
        int ex2_lab2 = 7; // координаты ячейки выхода 2 (столбец)
        List<Integer> pos_i = new ArrayList<>(Arrays.asList(in_i)); // создаем массив для хранения
                                                                    // координаты(строка)заполняемых ячеек(позиции)
        List<Integer> pos_j = new ArrayList<>(Arrays.asList(in_j)); // создаем массив для хранения
                                                                    // координаты(столбец)заполняемых ячеек(позиции)

        while (!(pos_i.isEmpty())) { // выполняем пока есть в массиве позиции
            step_lab(map, pos_i.get(0), pos_j.get(0), pos_i, pos_j);
        }
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        /// ищем путь от 1 входа
        Integer[] ex_i = { ex1_lab1 };
        Integer[] ex_j = { ex1_lab2 };
        List<Integer> rout1_i = new ArrayList<>(Arrays.asList(ex_i));
        List<Integer> rout1_j = new ArrayList<>(Arrays.asList(ex_j));
        for (int i = 0; i < map[ex1_lab1][ex1_lab2]; i++) {
            step_rout(map, rout1_i.size() - 1, rout1_j.size() - 1, rout1_i, rout1_j);
        }
        System.out.printf("Котик доберется к первому выходу за %d шагов:\n", map[ex1_lab1][ex1_lab2]);
        for (int i = 0; i < rout1_i.size() - 1; i++)
            System.out.printf("{%d, %d}; ", rout1_i.get(i), rout1_j.get(i));

        System.out.println("\n");
        // ищем путь от 2 выхода
        ex_i[0] = ex2_lab1;
        ex_j[0] = ex2_lab2;
        List<Integer> rout2_i = new ArrayList<>(Arrays.asList(ex_i));
        List<Integer> rout2_j = new ArrayList<>(Arrays.asList(ex_j));
        for (int i = 0; i < map[ex2_lab1][ex2_lab2]; i++) {
            step_rout(map, rout2_i.size() - 1, rout2_j.size() - 1, rout2_i, rout2_j);
        }
        System.out.printf("Котик доберется ко второму выходу за %d шагов:\n", map[ex2_lab1][ex2_lab2]);
        for (int i = 0; i < rout2_i.size() - 1; i++)
            System.out.printf("{%d, %d}; ", rout2_i.get(i), rout2_j.get(i));

    }

}