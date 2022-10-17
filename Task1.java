
///Написать программу вычисления n-ого треугольного числа.
import java.util.Scanner;

///метод нахождения треугольного числа
public class Task1 {
    static int sum(int num) {
        if (num == 1)
            return 1;
        return num + sum(num - 1);
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите n(натуральное число): ");
        int n = iScanner.nextInt();
        int res = sum(n);
        System.out.printf("n = %d треугольное число = %d", n, res);
        iScanner.close();
    }
}
